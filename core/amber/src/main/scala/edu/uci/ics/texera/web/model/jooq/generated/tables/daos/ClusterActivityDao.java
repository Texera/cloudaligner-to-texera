/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated.tables.daos;


import edu.uci.ics.texera.web.model.jooq.generated.tables.ClusterActivity;
import edu.uci.ics.texera.web.model.jooq.generated.tables.records.ClusterActivityRecord;

import java.sql.Timestamp;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClusterActivityDao extends DAOImpl<ClusterActivityRecord, edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity, Integer> {

    /**
     * Create a new ClusterActivityDao without any configuration
     */
    public ClusterActivityDao() {
        super(ClusterActivity.CLUSTER_ACTIVITY, edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity.class);
    }

    /**
     * Create a new ClusterActivityDao with an attached configuration
     */
    public ClusterActivityDao(Configuration configuration) {
        super(ClusterActivity.CLUSTER_ACTIVITY, edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity.class, configuration);
    }

    @Override
    public Integer getId(edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(ClusterActivity.CLUSTER_ACTIVITY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchById(Integer... values) {
        return fetch(ClusterActivity.CLUSTER_ACTIVITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity fetchOneById(Integer value) {
        return fetchOne(ClusterActivity.CLUSTER_ACTIVITY.ID, value);
    }

    /**
     * Fetch records that have <code>cluster_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchRangeOfClusterId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(ClusterActivity.CLUSTER_ACTIVITY.CLUSTER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>cluster_id IN (values)</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchByClusterId(Integer... values) {
        return fetch(ClusterActivity.CLUSTER_ACTIVITY.CLUSTER_ID, values);
    }

    /**
     * Fetch records that have <code>start_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchRangeOfStartTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(ClusterActivity.CLUSTER_ACTIVITY.START_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>start_time IN (values)</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchByStartTime(Timestamp... values) {
        return fetch(ClusterActivity.CLUSTER_ACTIVITY.START_TIME, values);
    }

    /**
     * Fetch records that have <code>end_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchRangeOfEndTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(ClusterActivity.CLUSTER_ACTIVITY.END_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>end_time IN (values)</code>
     */
    public List<edu.uci.ics.texera.web.model.jooq.generated.tables.pojos.ClusterActivity> fetchByEndTime(Timestamp... values) {
        return fetch(ClusterActivity.CLUSTER_ACTIVITY.END_TIME, values);
    }
}
