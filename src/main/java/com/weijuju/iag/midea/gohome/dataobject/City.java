package com.weijuju.iag.midea.gohome.dataobject;

import java.io.Serializable;
import lombok.Data;

/**
 * Table: midea_city
 */
@Data
public class City implements Serializable {
    /**
     * Table:     midea_city
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * Table:     midea_city
     * Column:    province
     * Nullable:  true
     */
    private String province;

    /**
     * Table:     midea_city
     * Column:    city
     * Nullable:  true
     */
    private String city;

    /**
     * Table:     midea_city
     * Column:    city_id
     * Nullable:  true
     */
    private String cityId;

    /**
     * Table:     midea_city
     * Column:    longitude
     * Nullable:  true
     */
    private Double longitude;

    /**
     * Table:     midea_city
     * Column:    latitude
     * Nullable:  true
     */
    private Double latitude;

    /**
     * Table:     midea_city
     * Column:    temp
     * Nullable:  true
     */
    private Integer temp;

    private static final long serialVersionUID = 1L;
}