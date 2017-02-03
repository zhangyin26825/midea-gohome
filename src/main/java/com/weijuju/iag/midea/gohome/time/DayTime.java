package com.weijuju.iag.midea.gohome.time;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.common.service.RedisLockService;
import com.weijuju.iag.mapper.CityMapper;
import com.weijuju.iag.midea.gohome.cache.CityCache;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.dataobject.CityExample;
import com.weijuju.iag.midea.gohome.util.WeatherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
@Component("DayTime")
public class DayTime {

    private final Logger logger = LoggerFactory.getLogger(DayTime.class);
    private static String redisLocks="mideagohome:weather";
    @Autowired
    RedisLockService redisLockService;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    CityCache cityCache;

    @Scheduled(cron = "0 00 5 * * ?")
    public void  start(){

        boolean lock = redisLockService .tryLock(redisLocks);
        if(!lock){
            return;
        }
        try {
            CityExample example=new CityExample();
            example.createCriteria();
            List<City> cities = cityMapper.selectByExample(example);
            for (City city : cities) {
                String cityId = city.getCityId();
                Integer weather = WeatherUtil.weather(cityId);
                if(weather!=null) {
                    city.setTemp(weather);
                    cityMapper.updateByPrimaryKey(city);
                    cityCache.put(city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisLockService.unLock(redisLocks);
        }
    }

}
