package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/16.
 */


import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangyin
 * @create 2016-12-16
 */
public class IPQuery {

    private static Logger LOGGER = LoggerFactory.getLogger(IPQuery.class);

    public static String   queryIPCity(String ip){
        String o="";
        String url="http://ip.taobao.com/service/getIpInfo.php?ip="+ip;
        LOGGER.info("查询淘宝IP库");
        String s = HttpClientUtil.get(url);
        if(StringUtils.isEmpty(s)){
            return o;
        }
        JSONObject jsonObject= JSONObject.fromObject(s);
        if(jsonObject.getInt("code")==0){
            o = jsonObject.getJSONObject("data").getString("city");
            return o;
        }
        return s;
    }

    public static void main(String[] args) {
        String s = IPQuery.queryIPCity("113.99.100.11");
        System.out.println(s);
    }

}
