package com.weijuju.iag.midea.gohome.controller;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.baseweb.utils.WebUtil;
import com.weijuju.iag.midea.gohome.async.QueryIP;
import com.weijuju.iag.midea.gohome.cache.CityCache;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.dataobject.User;
import com.weijuju.iag.midea.gohome.service.UserService;
import com.weijuju.iag.midea.gohome.stat.Stat;
import com.weijuju.iag.midea.gohome.time.DayTime;
import com.weijuju.iag.midea.gohome.util.IPQuery;
import com.weijuju.iag.midea.gohome.util.LocationUtils;
import com.weijuju.iag.midea.gohome.util.UserIdUtil;
import com.weijuju.iag.wxapi.entity.OpenUser;
import com.weijuju.iag.youyu.baseweb.service.MideaAuthService;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
@Controller
@RequestMapping("/city")
public class CityController {

    private static Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    CityCache cityCache;
    @Autowired
    QueryIP queryIP;
    @Autowired
    DayTime dayTime;
    @Autowired
    UserService userService;
    @Autowired
    Stat stat;

    @Autowired
    private MideaAuthService mideaAuthService;

    @RequestMapping("/info")
    @ResponseBody
    public ModelMap info(String  cityname1,String cityname2,HttpServletRequest request, HttpServletResponse response){
        ModelMap map=new ModelMap();
        if(StringUtils.isEmpty(cityname1)||StringUtils.isEmpty(cityname2)){
            map.put("success",0);
            map.put("message","cityname1    cityname2 不能为空 ");
            return map;
        }
        City cityByCityName = cityCache.getCityByCityName(cityname1);
        City cityByCityName1 = cityCache.getCityByCityName(cityname2);
        Long distance = LocationUtils.distance(cityByCityName, cityByCityName1);
        map.put("distance",distance);
        map.put("temp",Math.abs(cityByCityName.getTemp()-cityByCityName1.getTemp()));
        map.put("cityname1",pinyin(cityname1));
        map.put("cityname2",pinyin(cityname2));



        try {
            String userId = UserIdUtil.getUserId();
            if(StringUtils.isEmpty(userId)){
                OpenUser systemOpenUser = mideaAuthService.getSystemOpenUser(request,response);
                userId = systemOpenUser.getOpenid();
                if(StringUtils.isEmpty(userId)){
                    userId= com.weijuju.iag.midea.gohome.util.WebUtil.getWeiXinOPenId();
                }
            }
            stat.addImmediatelyGenerate(userId);
            LOGGER.info("city/info接口 获取到的userId 为 "+userId);
            if(StringUtils.isNotEmpty(userId)) {
                User userByUserId = userService.getUserByUserId(userId);
                userByUserId.setStartCity(cityname1);
                userByUserId.setEndCity(cityname2);

                int temp = Math.abs(cityByCityName.getTemp() - cityByCityName1.getTemp());
                userByUserId.setDistance(distance.intValue());
                userByUserId.setStartCityTemp(temp);
                userByUserId.setEndCityTemp(temp);
                userService.updateUser(userByUserId);
                com.weijuju.iag.midea.gohome.util.WebUtil.addCookie("shareId", userByUserId.getShareId());
            }
        } catch (Throwable e) {
//            e.printStackTrace();
        }
        map.put("success",1);
        map.put("message","");
        return map;
    }

    public String pinyin(String cityname){
        if(cityname.contains("重庆")){
            return "CHONGQING";
        }
        String s = cityname.replaceAll("市", "").replaceAll("地区", "");
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuffer sb=new StringBuffer();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            try {
                String[] strings = PinyinHelper.toHanyuPinyinStringArray(aChar, outputFormat);
                sb.append(strings[0]);
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
        }
        return sb.toString();
    }

    @RequestMapping("/ipcity")
    @ResponseBody
    public ModelMap getCity(HttpServletRequest request){
//        String city,
        ModelMap map=new ModelMap();
        String clientRealIp = WebUtil.getClientRealIp(request);
        try {
//            String clientRealIp = "113.99.103.219";
//            String s = IPQuery.queryIPCity(clientRealIp);
            City cityByIp = queryIP.getCityByIp(clientRealIp);
            map.put("city",cityByIp.getCity());
//            City cityByCityName = cityCache.getCityByCityName(s);
            map.put("temp",cityByIp.getTemp());
//            City cityByCityName = cityCache.getCityByCityName(city);
//            if(cityByCityName==null){
//                map.put("temp",20);
//            }else{
//                map.put("temp",cityByCityName.getTemp());
//           }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",0);
            map.put("message","查询不到IP对应的城市");
            return map;
        } finally {
        }
        map.put("success",1);
        map.put("message","");
        return map;
    }

    @RequestMapping("/init")
    @ResponseBody
    public ModelMap init(HttpServletRequest request){
        ModelMap map=new ModelMap();
        dayTime.start();
        map.put("success",1);
        map.put("message","");
        return map;
    }







}
