package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.midea.gohome.dataobject.City;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
public class LocationUtils {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    private static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }

    public static long distance(double lat1, double lng1, double lat2,
                                  double lng2){
        double distance = getDistance(lat1, lng1, lat2, lng2);
        long round = Math.round(distance);
        long l = round / 1000;
        return l;
    }

    public static long distance(City c1,City c2){
        return distance(c1.getLatitude(),c1.getLongitude(),c2.getLatitude(),c2.getLongitude());
    }


}
