package com.weijuju.iag.midea.gohome.stat;/**
 * Created by zhangyin on 2016/11/21.
 */

import java.util.Set;

/**
 * @author zhangyin
 * @create 2016-11-21
 */
public interface BaseRedisOperation {

     // 把某个整形的字段自增1
     void incrementLong(String key);
    //  获取到某个整形的值
    long getLong(String key);
    //  移除掉某个整形的值
     void  removeLong(String key);

    //移除掉某个集合
     void removeSet(String key);
    //把某个唯一的值，加入到集合中取
     void addToSet(String key, String uniqueValue);
    //获取集合的基数
    long getSizeOfSet(String key);
    //获取整个集合
    Set<String> getSet(String key);


    //根据key找到Map  把Map中mapKey的值自增
    void incrementToMap(String key, String mapKey);
    //根据key找到Map  获取Map中Key的值
    long getMapLong(String key, String mapKey);
    //删除掉某个Map
    void removeMap(String key);
}
