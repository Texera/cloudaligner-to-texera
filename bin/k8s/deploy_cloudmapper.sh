#!/usr/bin/env bash
#
# deploy_cloudmapper.sh — (re)deploy cloudmapper to k8s. Idempotent: updates an
# existing deployment in place (no duplicate) and rolls the pod to pull the image.
#
# Interactive only: it prompts for the namespace and the image repository + tag
# (the image must be typed — no default — and it must be run from a terminal). It
# does NOT build the image — pick one already pushed from the image repo's CI.
#
# Set AWS creds in the environment first (never prompted / never hardcoded):
#   export AWS_ACCESS_KEY_ID=...        # a FRESH, rotated key for the target account
#   export AWS_SECRET_ACCESS_KEY=...
#   ./deploy_cloudmapper.sh
#
# Overridable env (with defaults; namespace + image are prompted, not env):
#   AWS_DEFAULT_REGION=us-west-1   SSH_KEY=$HOME/.ssh/id_rsa   TEMPLATES_DIR=bin/k8s/templates
#
set -euo pipefail

AWS_DEFAULT_REGION="${AWS_DEFAULT_REGION:-us-west-1}"
SSH_KEY="${SSH_KEY:-$HOME/.ssh/id_rsa}"
TEMPLATES_DIR="${TEMPLATES_DIR:-bin/k8s/templates}"
[ -f "$TEMPLATES_DIR/cloudmapper.yaml" ] || TEMPLATES_DIR="."   # support a flat layout

# ---- validate prerequisites (fail fast, before prompting) ----
: "${AWS_ACCESS_KEY_ID:?export AWS_ACCESS_KEY_ID (use a freshly rotated key)}"
: "${AWS_SECRET_ACCESS_KEY:?export AWS_SECRET_ACCESS_KEY}"
[ -f "$SSH_KEY" ] && [ -f "$SSH_KEY.pub" ] || { echo "missing SSH keypair at $SSH_KEY[.pub]" >&2; exit 1; }
[ -f "$TEMPLATES_DIR/cloudmapper.yaml" ] || { echo "cloudmapper.yaml not found (set TEMPLATES_DIR)" >&2; exit 1; }
[ -t 0 ] || { echo "run this from a terminal — it prompts for the image to deploy." >&2; exit 1; }
command -v kubectl >/dev/null 2>&1 || { echo "kubectl not found on PATH" >&2; exit 1; }
KCTX="$(kubectl config current-context 2>/dev/null || true)"
[ -n "$KCTX" ] || { echo "no kubectl context set — run: kubectl config use-context <ctx>" >&2; exit 1; }

# ---- prompt for namespace + image (terminal required) ----
read -rp "Namespace [texera]: " NS || { echo; echo "aborted."; exit 1; }
NS="${NS:-texera}"

# image is required; the example is a placeholder, not a default
repo=""
while [ -z "$repo" ]; do
  read -rp "Image repository (e.g. kunwp1/cloudmapper): " repo || { echo; echo "aborted."; exit 1; }
done
case "$repo" in
  *:*|*@*) IMAGE="$repo" ;;                              # already a full ref (tag/digest)
  *)
    tag=""
    while [ -z "$tag" ]; do
      read -rp "Image tag (e.g. latest): " tag || { echo; echo "aborted."; exit 1; }
    done
    IMAGE="${repo}:${tag}"
    ;;
esac

# ---- confirm ----
echo
echo "About to deploy:"
echo "  cluster:   $KCTX"           # the kubectl context — check this is the right cluster!
echo "  namespace: $NS"
echo "  image:     $IMAGE"
echo "  region:    $AWS_DEFAULT_REGION"
echo "  ssh key:   $SSH_KEY"
read -rp "Proceed? [y/N]: " ans || { echo; echo "aborted."; exit 1; }
case "$ans" in y|Y|yes|Yes|YES) ;; *) echo "aborted."; exit 1 ;; esac

echo "==> namespace $NS"
kubectl create namespace "$NS" --dry-run=client -o yaml | kubectl apply -f -

echo "==> PVC"
kubectl apply -n "$NS" -f "$TEMPLATES_DIR/cloudmapper-pvc.yaml"

echo "==> secrets (idempotent upsert; values come from env/files, not the file)"
# Pass the AWS values via stdin (env-file), NOT --from-literal, so they never
# appear in this process's argv (i.e. not visible in `ps` to other users).
kubectl create secret generic aws-secret -n "$NS" --from-env-file=/dev/stdin \
  --dry-run=client -o yaml <<EOF | kubectl apply -f -
AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID
AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY
AWS_DEFAULT_REGION=$AWS_DEFAULT_REGION
EOF
kubectl create secret generic ssh-key -n "$NS" \
  --from-file=id_rsa="$SSH_KEY" \
  --from-file=id_rsa.pub="$SSH_KEY.pub" \
  --dry-run=client -o yaml | kubectl apply -f -

echo "==> deployment + service"
kubectl apply -n "$NS" -f "$TEMPLATES_DIR/cloudmapper.yaml"

echo "==> set image: $IMAGE"
kubectl set image deployment/cloudmapper cloudmapper="$IMAGE" -n "$NS"

echo "==> roll to $IMAGE + wait"
# rollout restart forces a re-pull even when the tag is unchanged (e.g. :latest).
kubectl rollout restart deployment/cloudmapper -n "$NS"
kubectl rollout status  deployment/cloudmapper -n "$NS" --timeout=180s

echo "==> done. pod:"
kubectl get pods -n "$NS" -l app=cloudmapper -o wide
