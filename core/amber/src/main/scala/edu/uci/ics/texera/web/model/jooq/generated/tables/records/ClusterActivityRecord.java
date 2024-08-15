/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated.tables.records;


import edu.uci.ics.texera.web.model.jooq.generated.tables.ClusterActivity;
import edu.uci.ics.texera.web.model.jooq.generated.tables.interfaces.IClusterActivity;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClusterActivityRecord extends UpdatableRecordImpl<ClusterActivityRecord> implements Record4<Integer, Integer, Timestamp, Timestamp>, IClusterActivity {

    private static final long serialVersionUID = 578263242;

    /**
     * Setter for <code>texera_db.cluster_activity.id</code>.
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>texera_db.cluster_activity.id</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>texera_db.cluster_activity.cluster_id</code>.
     */
    @Override
    public void setClusterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>texera_db.cluster_activity.cluster_id</code>.
     */
    @Override
    public Integer getClusterId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>texera_db.cluster_activity.start_time</code>.
     */
    @Override
    public void setStartTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>texera_db.cluster_activity.start_time</code>.
     */
    @Override
    public Timestamp getStartTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>texera_db.cluster_activity.end_time</code>.
     */
    @Override
    public void setEndTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>texera_db.cluster_activity.end_time</code>.
     */
    @Override
    public Timestamp getEndTime() {
        return (Timestamp) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Timestamp, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, Integer, Timestamp, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return ClusterActivity.CLUSTER_ACTIVITY.ID;
    }

    @Override
    public Field<Integer> field2() {
        return ClusterActivity.CLUSTER_ACTIVITY.CLUSTER_ID;
    }

    @Override
    public Field<Timestamp> field3() {
        return ClusterActivity.CLUSTER_ACTIVITY.START_TIME;
    }

    @Override
    public Field<Timestamp> field4() {
        return ClusterActivity.CLUSTER_ACTIVITY.END_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getClusterId();
    }

    @Override
    public Timestamp component3() {
        return getStartTime();
    }

    @Override
    public Timestamp component4() {
        return getEndTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getClusterId();
    }

    @Override
    public Timestamp value3() {
        return getStartTime();
    }

    @Override
    public Timestamp value4() {
        return getEndTime();
    }

    @Override
    public ClusterActivityRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ClusterActivityRecord value2(Integer value) {
        setClusterId(value);
        return this;
    }

    @Override
    public ClusterActivityRecord value3(Timestamp value) {
        setStartTime(value);
        return this;
    }

    @Override
    public ClusterActivityRecord value4(Timestamp value) {
        setEndTime(value);
        return this;
    }

    @Override
    public ClusterActivityRecord values(Integer value1, Integer value2, Timestamp value3, Timestamp value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IClusterActivity from) {
        setId(from.getId());
        setClusterId(from.getClusterId());
        setStartTime(from.getStartTime());
        setEndTime(from.getEndTime());
    }

    @Override
    public <E extends IClusterActivity> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ClusterActivityRecord
     */
    public ClusterActivityRecord() {
        super(ClusterActivity.CLUSTER_ACTIVITY);
    }

    /**
     * Create a detached, initialised ClusterActivityRecord
     */
    public ClusterActivityRecord(Integer id, Integer clusterId, Timestamp startTime, Timestamp endTime) {
        super(ClusterActivity.CLUSTER_ACTIVITY);

        set(0, id);
        set(1, clusterId);
        set(2, startTime);
        set(3, endTime);
    }
}
