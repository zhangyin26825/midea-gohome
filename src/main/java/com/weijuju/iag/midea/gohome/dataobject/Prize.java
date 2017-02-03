package com.weijuju.iag.midea.gohome.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: midea_prize
 */
@Data
public class Prize implements Serializable {
    /**
     * Table:     midea_prize
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * Table:     midea_prize
     * Column:    userId
     * Nullable:  true
     */
    private String userid;

    /**
     * Table:     midea_prize
     * Column:    prizename
     * Nullable:  true
     */
    private String prizename;

    /**
     * Table:     midea_prize
     * Column:    coupon_code
     * Nullable:  true
     */
    private String couponCode;

    /**
     * Table:     midea_prize
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * Table:     midea_prize
     * Column:    username
     * Nullable:  true
     */
    private String username;

    /**
     * Table:     midea_prize
     * Column:    mobile
     * Nullable:  true
     */
    private String mobile;

    /**
     * Table:     midea_prize
     * Column:    address
     * Nullable:  true
     */
    private String address;

    /**
     * Table:     midea_prize
     * Column:    awardId
     * Nullable:  true
     */
    private String awardid;

    private static final long serialVersionUID = 1L;
}