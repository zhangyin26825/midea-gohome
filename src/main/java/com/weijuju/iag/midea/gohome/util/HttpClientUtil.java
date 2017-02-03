package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/16.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.DecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zhangyin
 * @create 2016-12-16
 */
public class HttpClientUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    public static PoolingHttpClientConnectionManager cm = null;

    public static void init() {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", new PlainConnectionSocketFactory())
                .build();
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(20);
    }
    static {
        init();
    }

    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
        return httpClient;
    }

    public static   String  get(String url){
        HttpGet httpGet=new HttpGet(url);
        try {
            HttpResponse response= getHttpClient().execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String message = EntityUtils.toString(entity, "utf-8");
                return  message;
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public static   String  getDecomperssingEntity(String url){
        HttpGet httpGet=new HttpGet(url);
        try {
            HttpResponse response= getHttpClient().execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200) {
//                DecomperssingEntity entity=response.getEntity();
//                HttpEntity entity = response.getEntity();
//                String message = EntityUtils.toString(entity, "utf-8");
                DecompressingEntity resEntity = (DecompressingEntity)response.getEntity();

                InputStream inputStream = resEntity.getContent();

                InputStreamReader reader = new InputStreamReader(inputStream , "UTF-8");

                char[] buff = new char[1024];

                int length = 0;

                while ((length = reader.read(buff)) != -1) {

                    String x = new String(buff, 0, length);

                    System.out.println(x);

                }

            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }



}
