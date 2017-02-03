package com.weijuju.iag.midea.gohome.dataobject;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * Table: midea_help
 */
@Data
public class Help implements Serializable {
    /**
     * Table:     midea_help
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * 被助力的用户表ID
     *
     * Table:     midea_help
     * Column:    share_id
     * Nullable:  false
     */
    private String shareId;

    /**
     * 助力者的openId
     *
     * Table:     midea_help
     * Column:    help_openid
     * Nullable:  false
     */
    private String helpOpenid;

    /**
     * Table:     midea_help
     * Column:    create_time
     * Nullable:  true
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    /**
     * Table:     midea_help
     * Column:    nickname
     * Nullable:  true
     */
    private String nickname;

    /**
     * Table:     midea_help
     * Column:    headimage
     * Nullable:  true
     */
    private String headimage;

    private static final long serialVersionUID = 1L;
}