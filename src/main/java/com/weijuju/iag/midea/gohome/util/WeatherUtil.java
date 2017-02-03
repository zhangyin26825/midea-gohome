package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/19.
 */

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
public class WeatherUtil {


    public static Integer weather(String cityId){
//        String url ="http://www.weather.com.cn/data/sk/"+cityId+".html";
//        String s = HttpClientUtil.getDecomperssingEntity(url);
//
//        JSONObject jsonObject=JSONObject.fromObject(s);
//        String  temp=jsonObject.getJSONObject("weatherinfo").getString("temp");
        int i = 0;
        try {
            String httpArg = "city=CN"+cityId+"&key=b61609c41d60459fbbb16c0d2a31a99e";
            String request = request(httpArg);
            System.out.println("天气    "+cityId+"     "+request);
            JSONObject jsonObject1 = JSONObject.fromObject(request)
                    .getJSONArray("HeWeather5").getJSONObject(0)
                    .getJSONArray("daily_forecast").getJSONObject(0).getJSONObject("tmp");
            String max = jsonObject1.getString("max");
            String min = jsonObject1.getString("min");
            i = Integer.parseInt(max) + Integer.parseInt(min);
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        } finally {
        }
        return i/2;
    }

    public static void main(String[] args) {
        int weather = WeatherUtil.weather("101280601");

//        String weather = WeatherUtil.baiduweather("101280601");

        System.out.println(weather);
    }



    /**
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpArg) {

        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String  httpUrl = "https://free-api.heweather.com/v5/forecast" + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey","b61609c41d60459fbbb16c0d2a31a99e");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public static  String baiduweather(String name){
//        String encode = null;
//        try {
//            encode = URLEncoder.encode(name, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String httpArg="cityname="+encode;
//        String urladdress="http://apis.baidu.com/apistore/weatherservice/citylist";
//        BufferedReader reader = null;
//        String result = null;
//        StringBuffer sbf = new StringBuffer();
//        httpUrl = urladdress + "?" + httpArg;
//
//        try {
//            URL url = new URL(httpUrl);
//            HttpURLConnection connection = (HttpURLConnection) url
//                    .openConnection();
//            connection.setRequestMethod("GET");
//            // 填入apikey到HTTP header
//            connection.setRequestProperty("apikey","528f2651109d3105554c20505a0d21a5");
//            connection.connect();
//            InputStream is = connection.getInputStream();
//            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            String strRead = null;
//            while ((strRead = reader.readLine()) != null) {
//                sbf.append(strRead);
//                sbf.append("\r\n");
//            }
//            reader.close();
//            result = sbf.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//
//
//    }

}
