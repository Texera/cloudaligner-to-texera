/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated.tables;


import edu.uci.ics.texera.web.model.jooq.generated.Indexes;
import edu.uci.ics.texera.web.model.jooq.generated.Keys;
import edu.uci.ics.texera.web.model.jooq.generated.TexeraDb;
import edu.uci.ics.texera.web.model.jooq.generated.tables.records.ClusterRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Cluster extends TableImpl<ClusterRecord> {

    private static final long serialVersionUID = -1382267729;

    /**
     * The reference instance of <code>texera_db.cluster</code>
     */
    public static final Cluster CLUSTER = new Cluster();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClusterRecord> getRecordType() {
        return ClusterRecord.class;
    }

    /**
     * The column <code>texera_db.cluster.id</code>.
     */
    public final TableField<ClusterRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>texera_db.cluster.name</code>.
     */
    public final TableField<ClusterRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster.owner_id</code>.
     */
    public final TableField<ClusterRecord, UInteger> OWNER_ID = createField(DSL.name("owner_id"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster.machine_type</code>.
     */
    public final TableField<ClusterRecord, String> MACHINE_TYPE = createField(DSL.name("machine_type"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster.number_of_machines</code>.
     */
    public final TableField<ClusterRecord, Integer> NUMBER_OF_MACHINES = createField(DSL.name("number_of_machines"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>texera_db.cluster.creation_time</code>.
     */
    public final TableField<ClusterRecord, Timestamp> CREATION_TIME = createField(DSL.name("creation_time"), org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>texera_db.cluster.deletion_time</code>.
     */
    public final TableField<ClusterRecord, Timestamp> DELETION_TIME = createField(DSL.name("deletion_time"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>texera_db.cluster.total_bill</code>.
     */
    public final TableField<ClusterRecord, BigDecimal> TOTAL_BILL = createField(DSL.name("total_bill"), org.jooq.impl.SQLDataType.DECIMAL(10, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * Create a <code>texera_db.cluster</code> table reference
     */
    public Cluster() {
        this(DSL.name("cluster"), null);
    }

    /**
     * Create an aliased <code>texera_db.cluster</code> table reference
     */
    public Cluster(String alias) {
        this(DSL.name(alias), CLUSTER);
    }

    /**
     * Create an aliased <code>texera_db.cluster</code> table reference
     */
    public Cluster(Name alias) {
        this(alias, CLUSTER);
    }

    private Cluster(Name alias, Table<ClusterRecord> aliased) {
        this(alias, aliased, null);
    }

    private Cluster(Name alias, Table<ClusterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Cluster(Table<O> child, ForeignKey<O, ClusterRecord> key) {
        super(child, key, CLUSTER);
    }

    @Override
    public Schema getSchema() {
        return TexeraDb.TEXERA_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CLUSTER_OWNER_ID, Indexes.CLUSTER_PRIMARY);
    }

    @Override
    public Identity<ClusterRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CLUSTER;
    }

    @Override
    public UniqueKey<ClusterRecord> getPrimaryKey() {
        return Keys.KEY_CLUSTER_PRIMARY;
    }

    @Override
    public List<UniqueKey<ClusterRecord>> getKeys() {
        return Arrays.<UniqueKey<ClusterRecord>>asList(Keys.KEY_CLUSTER_PRIMARY);
    }

    @Override
    public List<ForeignKey<ClusterRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ClusterRecord, ?>>asList(Keys.CLUSTER_IBFK_1);
    }

    public User user() {
        return new User(this, Keys.CLUSTER_IBFK_1);
    }

    @Override
    public Cluster as(String alias) {
        return new Cluster(DSL.name(alias), this);
    }

    @Override
    public Cluster as(Name alias) {
        return new Cluster(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Cluster rename(String name) {
        return new Cluster(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Cluster rename(Name name) {
        return new Cluster(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, UInteger, String, Integer, Timestamp, Timestamp, BigDecimal> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
