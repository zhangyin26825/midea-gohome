package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/17.
 */

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zhangyin
 * @create 2016-12-17
 */
public class LongLatBaidu {

    public static class  LongLat{
        private double lng;
        private double lat;

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }

    public static LongLat getLongLat(String cityname){
        try {
            String encode = URLEncoder.encode(cityname, "UTF-8");
            String url="http://api.map.baidu.com/geocoder/v2/?address="+encode+"&output=json&ak=8c6ad56eb773f03cceced5aa40c537ba";
            System.out.println(url);
            String s = HttpClientUtil.get(url);
            System.out.println(s);
            JSONObject jsonObject=JSONObject.fromObject(s);
            if(jsonObject.getInt("status")==0){
                JSONObject location = jsonObject.getJSONObject("result").getJSONObject("location");
                double lng = Double.valueOf(location.get("lng").toString());
                double lat = Double.valueOf(location.get("lat").toString());

                LongLat l=new LongLat();
                l.setLng(lng);
                l.setLat(lat);
                return l;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        getLongLat("北京市");
    }

}
