package com.weijuju.iag.midea.gohome.dataobject;

import java.io.Serializable;
import lombok.Data;

/**
 * Table: midea_stat
 */
@Data
public class StatObject implements Serializable {
    /**
     * Table:     midea_stat
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * Table:     midea_stat
     * Column:    stat_date
     * Nullable:  true
     */
    private String statDate;

    /**
     * Table:     midea_stat
     * Column:    pv
     * Nullable:  true
     */
    private Integer pv;

    /**
     * Table:     midea_stat
     * Column:    uv
     * Nullable:  true
     */
    private Integer uv;

    /**
     * Table:     midea_stat
     * Column:    immediatelygeneratepv
     * Nullable:  true
     */
    private Integer immediatelygeneratepv;

    /**
     * Table:     midea_stat
     * Column:    immediatelygenerateuv
     * Nullable:  true
     */
    private Integer immediatelygenerateuv;

    /**
     * Table:     midea_stat
     * Column:    helppv
     * Nullable:  true
     */
    private Integer helppv;

    /**
     * Table:     midea_stat
     * Column:    helpuv
     * Nullable:  true
     */
    private Integer helpuv;

    /**
     * Table:     midea_stat
     * Column:    openpackagepv
     * Nullable:  true
     */
    private Integer openpackagepv;

    /**
     * Table:     midea_stat
     * Column:    openpackageuv
     * Nullable:  true
     */
    private Integer openpackageuv;

    /**
     * Table:     midea_stat
     * Column:    activitysharepv
     * Nullable:  true
     */
    private Integer activitysharepv;

    /**
     * Table:     midea_stat
     * Column:    activityshareuv
     * Nullable:  true
     */
    private Integer activityshareuv;

    /**
     * Table:     midea_stat
     * Column:    numberofwinners
     * Nullable:  true
     */
    private Integer numberofwinners;

    /**
     * 新增访客
     *
     * Table:     midea_stat
     * Column:    newuser
     * Nullable:  true
     */
    private Integer newuser;

    /**
     * Table:     midea_stat
     * Column:    qudao
     * Nullable:  true
     */
    private String qudao;

    private static final long serialVersionUID = 1L;
}