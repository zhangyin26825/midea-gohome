package com.weijuju.iag.midea.gohome.async;/**
 * Created by zhangyin on 2016/12/26.
 */

import com.weijuju.iag.common.redis.JedisCallable;
import com.weijuju.iag.common.redis.RedisExecutor;
import com.weijuju.iag.common.service.RedisLockService;
import com.weijuju.iag.midea.gohome.cache.CityCache;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.util.IPQuery;
import com.weijuju.iag.midea.gohome.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author zhangyin
 * @create 2016-12-26
 */
@Component
public class QueryIP {

    private static Logger LOGGER = LoggerFactory.getLogger(QueryIP.class);

    private  static String key="midea:ips:";

    @Autowired
    RedisExecutor redisExecutor;

    @Autowired
    RedisLockService redisLockService;
    @Autowired
    CityCache cityCache;

    @Async
    public void query(String ip){
        try {
            City cityByIp = getCityByIp(ip);
            if(cityByIp!=null){
                return;
            }
            boolean b = redisLockService.tryLock(ip);
            if(!b){
                return;
            }
            try {
                String s = IPQuery.queryIPCity(ip);
                if(StringUtils.equals(ip,"127.0.0.1")){
                    s="深圳市";
                }
                save(ip,s);
                City cityByCityName = cityCache.getCityByCityName(s);
                LOGGER.info("ip为"+ip+"       IP对应城市为"+s+"    天气对应城市为"+cityByCityName);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisLockService.unLock(ip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(final String ip,final String city){
        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    instance.set(key+ip,city);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        redisExecutor.doInRedis(callable);
    }

    public City  getCityByIp(final String ip){
        JedisCallable<String> callable = new JedisCallable<String>() {
            @Override
            public String call(Jedis instance) throws Exception {
                try {
                     return instance.get(key+ip);
                } catch (Exception e) {
                    return null;
                }
            }
        };
        String s= redisExecutor.doInRedis(callable);
        City cityByCityName = cityCache.getCityByCityName(s);
        return cityByCityName;
    }

}
