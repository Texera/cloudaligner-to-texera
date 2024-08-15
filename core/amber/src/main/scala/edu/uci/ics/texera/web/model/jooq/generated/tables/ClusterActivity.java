/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated.tables;


import edu.uci.ics.texera.web.model.jooq.generated.Indexes;
import edu.uci.ics.texera.web.model.jooq.generated.Keys;
import edu.uci.ics.texera.web.model.jooq.generated.TexeraDb;
import edu.uci.ics.texera.web.model.jooq.generated.tables.records.ClusterActivityRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClusterActivity extends TableImpl<ClusterActivityRecord> {

    private static final long serialVersionUID = 694474965;

    /**
     * The reference instance of <code>texera_db.cluster_activity</code>
     */
    public static final ClusterActivity CLUSTER_ACTIVITY = new ClusterActivity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClusterActivityRecord> getRecordType() {
        return ClusterActivityRecord.class;
    }

    /**
     * The column <code>texera_db.cluster_activity.id</code>.
     */
    public final TableField<ClusterActivityRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>texera_db.cluster_activity.cluster_id</code>.
     */
    public final TableField<ClusterActivityRecord, Integer> CLUSTER_ID = createField(DSL.name("cluster_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster_activity.start_time</code>.
     */
    public final TableField<ClusterActivityRecord, Timestamp> START_TIME = createField(DSL.name("start_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster_activity.end_time</code>.
     */
    public final TableField<ClusterActivityRecord, Timestamp> END_TIME = createField(DSL.name("end_time"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>texera_db.cluster_activity</code> table reference
     */
    public ClusterActivity() {
        this(DSL.name("cluster_activity"), null);
    }

    /**
     * Create an aliased <code>texera_db.cluster_activity</code> table reference
     */
    public ClusterActivity(String alias) {
        this(DSL.name(alias), CLUSTER_ACTIVITY);
    }

    /**
     * Create an aliased <code>texera_db.cluster_activity</code> table reference
     */
    public ClusterActivity(Name alias) {
        this(alias, CLUSTER_ACTIVITY);
    }

    private ClusterActivity(Name alias, Table<ClusterActivityRecord> aliased) {
        this(alias, aliased, null);
    }

    private ClusterActivity(Name alias, Table<ClusterActivityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ClusterActivity(Table<O> child, ForeignKey<O, ClusterActivityRecord> key) {
        super(child, key, CLUSTER_ACTIVITY);
    }

    @Override
    public Schema getSchema() {
        return TexeraDb.TEXERA_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CLUSTER_ACTIVITY_CLUSTER_ID, Indexes.CLUSTER_ACTIVITY_PRIMARY);
    }

    @Override
    public Identity<ClusterActivityRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CLUSTER_ACTIVITY;
    }

    @Override
    public UniqueKey<ClusterActivityRecord> getPrimaryKey() {
        return Keys.KEY_CLUSTER_ACTIVITY_PRIMARY;
    }

    @Override
    public List<UniqueKey<ClusterActivityRecord>> getKeys() {
        return Arrays.<UniqueKey<ClusterActivityRecord>>asList(Keys.KEY_CLUSTER_ACTIVITY_PRIMARY);
    }

    @Override
    public List<ForeignKey<ClusterActivityRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ClusterActivityRecord, ?>>asList(Keys.CLUSTER_ACTIVITY_IBFK_1);
    }

    public Cluster cluster() {
        return new Cluster(this, Keys.CLUSTER_ACTIVITY_IBFK_1);
    }

    @Override
    public ClusterActivity as(String alias) {
        return new ClusterActivity(DSL.name(alias), this);
    }

    @Override
    public ClusterActivity as(Name alias) {
        return new ClusterActivity(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ClusterActivity rename(String name) {
        return new ClusterActivity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ClusterActivity rename(Name name) {
        return new ClusterActivity(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Timestamp, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
