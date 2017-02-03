package com.weijuju.iag.midea.gohome.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: midea_user
 */
@Data
public class User implements Serializable {
    /**
     * 主键ID
     *
     * Table:     midea_user
     * Column:    share_id
     * Nullable:  false
     */
    private String shareId;

    /**
     * openId 或者手机号
     *
     * Table:     midea_user
     * Column:    userId
     * Nullable:  false
     */
    private String userid;

    /**
     * 是不是微信用户
     *
     * Table:     midea_user
     * Column:    user_weixin
     * Nullable:  false
     */
    private Boolean userWeixin;

    /**
     * 出发城市
     *
     * Table:     midea_user
     * Column:    start_city
     * Nullable:  true
     */
    private String startCity;

    /**
     * 结束城市
     *
     * Table:     midea_user
     * Column:    end_city
     * Nullable:  true
     */
    private String endCity;

    /**
     * 出发城市温度
     *
     * Table:     midea_user
     * Column:    start_city_temp
     * Nullable:  true
     */
    private Integer startCityTemp;

    /**
     * 结束城市温度
     *
     * Table:     midea_user
     * Column:    end_city_temp
     * Nullable:  true
     */
    private Integer endCityTemp;

    /**
     * 两个城市的距离
     *
     * Table:     midea_user
     * Column:    distance
     * Nullable:  true
     */
    private Integer distance;

    /**
     * 创建时间
     *
     * Table:     midea_user
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 抽奖时间
     *
     * Table:     midea_user
     * Column:    luckdrawtime
     * Nullable:  true
     */
    private Date luckdrawtime;

    /**
     * 是否抽奖
     *
     * Table:     midea_user
     * Column:    luckdraw
     * Nullable:  true
     */
    private Boolean luckdraw;

    /**
     * 是否中奖
     *
     * Table:     midea_user
     * Column:    winning
     * Nullable:  true
     */
    private Boolean winning;

    /**
     * Table:     midea_user
     * Column:    nickname
     * Nullable:  true
     */
    private String nickname;

    /**
     * Table:     midea_user
     * Column:    headImage
     * Nullable:  true
     */
    private String headimage;

    /**
     * Table:     midea_user
     * Column:    prize_type
     * Nullable:  true
     */
    private String prizeType;

    private static final long serialVersionUID = 1L;
}