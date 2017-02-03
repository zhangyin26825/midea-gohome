package com.weijuju.iag.midea.gohome.cache;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.common.redis.JedisCallable;
import com.weijuju.iag.common.redis.RedisExecutor;
import com.weijuju.iag.mapper.CityMapper;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.dataobject.CityExample;
import com.weijuju.iag.midea.gohome.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;


/**
 * @author zhangyin
 * @create 2016-12-19
 */
@Component
public class CityCache {

    private static String key="mideagohome:city:";

    @Autowired
    RedisExecutor  redisExecutor;

    @Autowired
    CityMapper cityMapper;

    public City getCityByCityName(final String cityName){
        JedisCallable<City> callable = new JedisCallable<City>() {
            @Override
            public City call(Jedis instance) throws Exception {
                try {
                    City city=null;
                    String s = instance.get(key + cityName);
                    city = JsonUtil.getObject(City.class, s);
                    return city;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        return redisExecutor.doInRedis(callable);
    }
    public void  put(final City c){
        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    String json = JsonUtil.getJson(c);
                    instance.set(key + c.getCity(),json);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        redisExecutor.doInRedis(callable);
    }

    public void initAll(){
        CityExample example=new CityExample();
        example.createCriteria();
        List<City> cities = cityMapper.selectByExample(example);
        for (City city : cities) {
            put(city);
        }
    }
}
