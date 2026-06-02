#!/usr/bin/env bash
#
# deploy_cloudmapper.sh — build, push, and (re)deploy cloudmapper to k8s in one shot.
#
# Run it from the cloudmapper BUILD CONTEXT (the dir with the Dockerfile + the
# source, whose config/config.yaml gets baked into the image). Set the AWS creds
# in the environment first — they are NEVER hardcoded here:
#
#   export AWS_ACCESS_KEY_ID=...        # a FRESH, rotated key for the target account
#   export AWS_SECRET_ACCESS_KEY=...
#   ./deploy_cloudmapper.sh
#
# Overridable env (with defaults):
#   IMAGE=kunwp1/cloudmapper:latest
#   NS=texera
#   AWS_DEFAULT_REGION=us-west-1        # MUST match where your /gfs EFS + VPC live
#   SSH_KEY=$HOME/.ssh/id_rsa           # private key (… .pub must sit next to it)
#   TEMPLATES_DIR=bin/k8s/templates     # falls back to CWD if the yamls aren't there
#   BUILD_CONTEXT=.                     # dir containing the Dockerfile + config.yaml
#
set -euo pipefail

IMAGE="${IMAGE:-kunwp1/cloudmapper:latest}"
NS="${NS:-texera}"
AWS_DEFAULT_REGION="${AWS_DEFAULT_REGION:-us-west-1}"
SSH_KEY="${SSH_KEY:-$HOME/.ssh/id_rsa}"
BUILD_CONTEXT="${BUILD_CONTEXT:-.}"
TEMPLATES_DIR="${TEMPLATES_DIR:-bin/k8s/templates}"
[ -f "$TEMPLATES_DIR/cloudmapper.yaml" ] || TEMPLATES_DIR="."   # support a flat layout

: "${AWS_ACCESS_KEY_ID:?export AWS_ACCESS_KEY_ID (use a freshly rotated key)}"
: "${AWS_SECRET_ACCESS_KEY:?export AWS_SECRET_ACCESS_KEY}"
[ -f "$SSH_KEY" ] && [ -f "$SSH_KEY.pub" ] || { echo "missing SSH keypair at $SSH_KEY[.pub]" >&2; exit 1; }
[ -f "$TEMPLATES_DIR/cloudmapper.yaml" ] || { echo "cloudmapper.yaml not found (set TEMPLATES_DIR)" >&2; exit 1; }

echo "==> build + push $IMAGE"
docker build "$BUILD_CONTEXT" -t "$IMAGE" --no-cache
docker push "$IMAGE"

echo "==> namespace $NS"
kubectl create namespace "$NS" --dry-run=client -o yaml | kubectl apply -f -

echo "==> PVC"
kubectl apply -f "$TEMPLATES_DIR/cloudmapper-pvc.yaml"

echo "==> secrets (idempotent upsert; values come from env/files, not the file)"
kubectl create secret generic aws-secret -n "$NS" \
  --from-literal=AWS_ACCESS_KEY_ID="$AWS_ACCESS_KEY_ID" \
  --from-literal=AWS_SECRET_ACCESS_KEY="$AWS_SECRET_ACCESS_KEY" \
  --from-literal=AWS_DEFAULT_REGION="$AWS_DEFAULT_REGION" \
  --dry-run=client -o yaml | kubectl apply -f -
kubectl create secret generic ssh-key -n "$NS" \
  --from-file=id_rsa="$SSH_KEY" \
  --from-file=id_rsa.pub="$SSH_KEY.pub" \
  --dry-run=client -o yaml | kubectl apply -f -

echo "==> deployment + service"
kubectl apply -f "$TEMPLATES_DIR/cloudmapper.yaml"

echo "==> roll to the freshly pushed image + wait"
kubectl rollout restart deployment/cloudmapper -n "$NS"
kubectl rollout status  deployment/cloudmapper -n "$NS" --timeout=180s

echo "==> done. pod:"
kubectl get pods -n "$NS" -l app=cloudmapper -o wide
