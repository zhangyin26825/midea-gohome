package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/17.
 */

import com.weijuju.iag.midea.gohome.dataobject.City;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyin
 * @create 2016-12-17
 */
public class CityInit {

    public static void main(String[] args) {


        try {
            List<City> citys=new ArrayList<>(2556);
            Pattern p=Pattern.compile("<d\\s*d1=\"(\\d*)\"\\s*d2=\"([\\u4e00-\\u9fa5]+)\"\\s*d3=\"([a-z]+)\"\\s+d4=\"([\\u4e00-\\u9fa5]+)\"/>");
            File f=new File("C:\\Users\\Administrator\\Desktop\\citylist.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"GB2312"));
            String temp;
            while((temp=br.readLine())!=null){
                City c=new City();
                temp=temp.replaceAll( "\"", "");
                temp=temp.replaceAll( "<d", "");
                temp=temp.replaceAll( "/>", "");
                String[] split = temp.split(" ");
                assert split.length==4;
               if(split.length==5) {
                   c.setProvince(getValue(split[4]));
                   c.setCity(getValue(split[2]));
                   c.setCityId(getValue(split[1]));
                   citys.add(c);
               }else {
                   throw new IllegalStateException();
               }
            }
            JSONArray s= JSONArray.fromObject(citys);
            System.out.println(s.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static String getValue(String s){
        return s.split("=")[1];
    }

    public static  List<City>  getCitys(){
        List<City> citys=new ArrayList<>(2556);
        try {
            Pattern p=Pattern.compile("<d\\s*d1=\"(\\d*)\"\\s*d2=\"([\\u4e00-\\u9fa5]+)\"\\s*d3=\"([a-z]+)\"\\s+d4=\"([\\u4e00-\\u9fa5]+)\"/>");
            File f=new File("C:\\Users\\Administrator\\Desktop\\citylist.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"GB2312"));
            String temp;
            while((temp=br.readLine())!=null){
                City c=new City();
                temp=temp.replaceAll( "\"", "");
                temp=temp.replaceAll( "<d", "");
                temp=temp.replaceAll( "/>", "");
                String[] split = temp.split(" ");
                assert split.length==4;
                if(split.length==5) {
                    c.setProvince(getValue(split[4]));
                    c.setCity(getValue(split[2]));
                    c.setCityId(getValue(split[1]));
                    citys.add(c);
                }else {
                    throw new IllegalStateException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return citys;
    }
}
