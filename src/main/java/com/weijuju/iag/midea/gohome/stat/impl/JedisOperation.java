package com.weijuju.iag.midea.gohome.stat.impl;/**
 * Created by zhangyin on 2016/11/21.
 */


import com.weijuju.iag.common.redis.JedisCallable;
import com.weijuju.iag.common.redis.RedisExecutor;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.stat.BaseRedisOperation;
import com.weijuju.iag.midea.gohome.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author zhangyin
 * @create 2016-11-21
 */
@Component
public class JedisOperation implements BaseRedisOperation {


    @Autowired
    RedisExecutor redisExecutor;

//    @Autowired
//    Jedis jedis;

    @Override
    public void incrementLong(final String key) {
//        jedis.incr(key);

        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    instance.incr(key);
                     return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
         redisExecutor.doInRedis(callable);
    }

    @Override
    public long getLong(final String key) {
//        String s = jedis.get(key);
//        if(StringUtils.isEmpty(s)){
//            return  0;
//        }
//        return Long.parseLong(s);

        JedisCallable<Long> callable = new JedisCallable<Long>() {
            @Override
            public Long call(Jedis instance) throws Exception {
                try {
                    String s =instance.get(key);
                    if(StringUtils.isEmpty(s)){
                      return  0l;
                     }
                    return Long.parseLong(s);
                } catch (Exception e) {
                    return 0l;
                }
            }
        };
         return   redisExecutor.doInRedis(callable);
    }

    @Override
    public void removeLong(final String key) {
//        jedis.del(key);

        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    instance.del(key);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        redisExecutor.doInRedis(callable);
    }

    @Override
    public void removeSet(final String key) {
//        jedis.del(key);

        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    instance.del(key);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        redisExecutor.doInRedis(callable);
    }

    @Override
    public void addToSet(final String key,final  String uniqueValue) {
//        jedis.sadd(key,uniqueValue);

        JedisCallable<Object> callable = new JedisCallable<Object>() {
            @Override
            public Object call(Jedis instance) throws Exception {
                try {
                    instance.sadd(key,uniqueValue);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        redisExecutor.doInRedis(callable);

    }

    @Override
    public long getSizeOfSet(final String key) {
//        return jedis.scard(key);
        JedisCallable<Long> callable = new JedisCallable<Long>() {
            @Override
            public Long call(Jedis instance) throws Exception {
                try {
                    return  instance.scard(key);
                } catch (Exception e) {
                    return null;
                }
            }
        };
       return  redisExecutor.doInRedis(callable);
    }


    @Override
    public Set<String> getSet(final String key) {
//        return jedis.smembers(key);

        JedisCallable< Set<String>> callable = new JedisCallable< Set<String>>() {
            @Override
            public  Set<String> call(Jedis instance) throws Exception {
                try {
                    Set<String> smembers = instance.smembers(key);
                    return smembers;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        return  redisExecutor.doInRedis(callable);

    }

    @Override
    public void incrementToMap(String key, String mapKey) {
//        jedis.hincrBy(key,mapKey,1);
    }

    @Override
    public long getMapLong(String key, String mapKey) {
//        String s = jedis.hget(key, mapKey);
//        if(StringUtils.isEmpty(s)){
//            return  0;
//        }
//        return Long.parseLong(s);
        return  0l;
    }

    @Override
    public void removeMap(String key) {
//        jedis.del(key);
    }
}
