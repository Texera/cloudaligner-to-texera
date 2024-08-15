/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated;


import edu.uci.ics.texera.web.model.jooq.generated.tables.Cluster;
import edu.uci.ics.texera.web.model.jooq.generated.tables.ClusterActivity;
import edu.uci.ics.texera.web.model.jooq.generated.tables.Dataset;
import edu.uci.ics.texera.web.model.jooq.generated.tables.DatasetUserAccess;
import edu.uci.ics.texera.web.model.jooq.generated.tables.DatasetVersion;
import edu.uci.ics.texera.web.model.jooq.generated.tables.File;
import edu.uci.ics.texera.web.model.jooq.generated.tables.FileOfProject;
import edu.uci.ics.texera.web.model.jooq.generated.tables.FileOfWorkflow;
import edu.uci.ics.texera.web.model.jooq.generated.tables.Project;
import edu.uci.ics.texera.web.model.jooq.generated.tables.ProjectUserAccess;
import edu.uci.ics.texera.web.model.jooq.generated.tables.PublicProject;
import edu.uci.ics.texera.web.model.jooq.generated.tables.User;
import edu.uci.ics.texera.web.model.jooq.generated.tables.UserConfig;
import edu.uci.ics.texera.web.model.jooq.generated.tables.UserFileAccess;
import edu.uci.ics.texera.web.model.jooq.generated.tables.Workflow;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowExecutions;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowOfProject;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowOfUser;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowRuntimeStatistics;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowUserAccess;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TexeraDb extends SchemaImpl {

    private static final long serialVersionUID = 14553964;

    /**
     * The reference instance of <code>texera_db</code>
     */
    public static final TexeraDb TEXERA_DB = new TexeraDb();

    /**
     * The table <code>texera_db.cluster</code>.
     */
    public final Cluster CLUSTER = edu.uci.ics.texera.web.model.jooq.generated.tables.Cluster.CLUSTER;

    /**
     * The table <code>texera_db.cluster_activity</code>.
     */
    public final ClusterActivity CLUSTER_ACTIVITY = edu.uci.ics.texera.web.model.jooq.generated.tables.ClusterActivity.CLUSTER_ACTIVITY;

    /**
     * The table <code>texera_db.dataset</code>.
     */
    public final Dataset DATASET = edu.uci.ics.texera.web.model.jooq.generated.tables.Dataset.DATASET;

    /**
     * The table <code>texera_db.dataset_user_access</code>.
     */
    public final DatasetUserAccess DATASET_USER_ACCESS = edu.uci.ics.texera.web.model.jooq.generated.tables.DatasetUserAccess.DATASET_USER_ACCESS;

    /**
     * The table <code>texera_db.dataset_version</code>.
     */
    public final DatasetVersion DATASET_VERSION = edu.uci.ics.texera.web.model.jooq.generated.tables.DatasetVersion.DATASET_VERSION;

    /**
     * The table <code>texera_db.file</code>.
     */
    public final File FILE = edu.uci.ics.texera.web.model.jooq.generated.tables.File.FILE;

    /**
     * The table <code>texera_db.file_of_project</code>.
     */
    public final FileOfProject FILE_OF_PROJECT = edu.uci.ics.texera.web.model.jooq.generated.tables.FileOfProject.FILE_OF_PROJECT;

    /**
     * The table <code>texera_db.file_of_workflow</code>.
     */
    public final FileOfWorkflow FILE_OF_WORKFLOW = edu.uci.ics.texera.web.model.jooq.generated.tables.FileOfWorkflow.FILE_OF_WORKFLOW;

    /**
     * The table <code>texera_db.project</code>.
     */
    public final Project PROJECT = edu.uci.ics.texera.web.model.jooq.generated.tables.Project.PROJECT;

    /**
     * The table <code>texera_db.project_user_access</code>.
     */
    public final ProjectUserAccess PROJECT_USER_ACCESS = edu.uci.ics.texera.web.model.jooq.generated.tables.ProjectUserAccess.PROJECT_USER_ACCESS;

    /**
     * The table <code>texera_db.public_project</code>.
     */
    public final PublicProject PUBLIC_PROJECT = edu.uci.ics.texera.web.model.jooq.generated.tables.PublicProject.PUBLIC_PROJECT;

    /**
     * The table <code>texera_db.user</code>.
     */
    public final User USER = edu.uci.ics.texera.web.model.jooq.generated.tables.User.USER;

    /**
     * The table <code>texera_db.user_config</code>.
     */
    public final UserConfig USER_CONFIG = edu.uci.ics.texera.web.model.jooq.generated.tables.UserConfig.USER_CONFIG;

    /**
     * The table <code>texera_db.user_file_access</code>.
     */
    public final UserFileAccess USER_FILE_ACCESS = edu.uci.ics.texera.web.model.jooq.generated.tables.UserFileAccess.USER_FILE_ACCESS;

    /**
     * The table <code>texera_db.workflow</code>.
     */
    public final Workflow WORKFLOW = edu.uci.ics.texera.web.model.jooq.generated.tables.Workflow.WORKFLOW;

    /**
     * The table <code>texera_db.workflow_executions</code>.
     */
    public final WorkflowExecutions WORKFLOW_EXECUTIONS = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowExecutions.WORKFLOW_EXECUTIONS;

    /**
     * The table <code>texera_db.workflow_of_project</code>.
     */
    public final WorkflowOfProject WORKFLOW_OF_PROJECT = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowOfProject.WORKFLOW_OF_PROJECT;

    /**
     * The table <code>texera_db.workflow_of_user</code>.
     */
    public final WorkflowOfUser WORKFLOW_OF_USER = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowOfUser.WORKFLOW_OF_USER;

    /**
     * The table <code>texera_db.workflow_runtime_statistics</code>.
     */
    public final WorkflowRuntimeStatistics WORKFLOW_RUNTIME_STATISTICS = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowRuntimeStatistics.WORKFLOW_RUNTIME_STATISTICS;

    /**
     * The table <code>texera_db.workflow_user_access</code>.
     */
    public final WorkflowUserAccess WORKFLOW_USER_ACCESS = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowUserAccess.WORKFLOW_USER_ACCESS;

    /**
     * The table <code>texera_db.workflow_version</code>.
     */
    public final WorkflowVersion WORKFLOW_VERSION = edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowVersion.WORKFLOW_VERSION;

    /**
     * No further instances allowed
     */
    private TexeraDb() {
        super("texera_db", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Cluster.CLUSTER,
            ClusterActivity.CLUSTER_ACTIVITY,
            Dataset.DATASET,
            DatasetUserAccess.DATASET_USER_ACCESS,
            DatasetVersion.DATASET_VERSION,
            File.FILE,
            FileOfProject.FILE_OF_PROJECT,
            FileOfWorkflow.FILE_OF_WORKFLOW,
            Project.PROJECT,
            ProjectUserAccess.PROJECT_USER_ACCESS,
            PublicProject.PUBLIC_PROJECT,
            User.USER,
            UserConfig.USER_CONFIG,
            UserFileAccess.USER_FILE_ACCESS,
            Workflow.WORKFLOW,
            WorkflowExecutions.WORKFLOW_EXECUTIONS,
            WorkflowOfProject.WORKFLOW_OF_PROJECT,
            WorkflowOfUser.WORKFLOW_OF_USER,
            WorkflowRuntimeStatistics.WORKFLOW_RUNTIME_STATISTICS,
            WorkflowUserAccess.WORKFLOW_USER_ACCESS,
            WorkflowVersion.WORKFLOW_VERSION);
    }
}
