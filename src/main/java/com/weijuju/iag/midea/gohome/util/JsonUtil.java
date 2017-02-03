package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/19.
 */


import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
public class JsonUtil {

    public static String  getJson(Object obj){
        JSONObject json=JSONObject.fromObject(obj);
        return json.toString();
    }

    public static <T>T  getObject(Class<T> t,String json){
        JSONObject obj=JSONObject.fromObject(json);
        T o = (T)JSONObject.toBean(obj, t);
        return o;
    }
}
