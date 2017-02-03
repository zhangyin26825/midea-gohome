package com.weijuju.iag.midea.gohome.controller;/**
 * Created by zhangyin on 2016/12/16.
 */


import com.weijuju.iag.activity.core.entity.LotteryResult;
import com.weijuju.iag.activity.core.entity.UserEntity;
import com.weijuju.iag.activity.core.service.LotteryService;
import com.weijuju.iag.common.service.RedisLockService;
import com.weijuju.iag.midea.gohome.cache.CityCache;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.dataobject.Help;
import com.weijuju.iag.midea.gohome.dataobject.Prize;
import com.weijuju.iag.midea.gohome.dataobject.User;
import com.weijuju.iag.midea.gohome.service.UserService;
import com.weijuju.iag.midea.gohome.stat.Stat;
import com.weijuju.iag.midea.gohome.util.LocationUtils;
import com.weijuju.iag.midea.gohome.util.UserIdUtil;
import com.weijuju.iag.midea.gohome.util.WebUtil;
import com.weijuju.iag.wxapi.entity.OpenUser;
import com.weijuju.iag.youyu.baseweb.service.MideaAuthService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author zhangyin
 * @create 2016-12-16
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {

    @Value("${aid}")
    String aid;

    @Autowired
    UserService userService;

    @Autowired
    RedisLockService redisLockService;
    @Autowired
    LotteryService lotteryService;

    @Autowired
    CityCache cityCache;


    @Autowired
    Stat stat;

    @Autowired
    private MideaAuthService mideaAuthService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,String shareId){
        ModelAndView map=new ModelAndView();
        OpenUser systemOpenUser = mideaAuthService.getSystemOpenUser(request,response);
        User user = userService.addUser(systemOpenUser);
        map.getModel().put("MyShareId",user.getShareId());
        if(StringUtils.isEmpty(shareId)){
            map.getModel().put("isShare",false);
            if(StringUtils.isEmpty(user.getStartCity())){
                map.getModel().put("hasTicket",false);
            }else{
                map.getModel().put("hasTicket",true);
            }
        }else{
            map.getModel().put("isShare",true);
            map.getModel().put("shareId",shareId);
            boolean b = userService.hasHelped(shareId, systemOpenUser.getOpenid());
            map.getModel().put("helped",b);
        }
        try {
            User userByShareId = userService.getUserByShareId(shareId);
            if(StringUtils.equals(systemOpenUser.getOpenid(),userByShareId.getUserid())){
                map.getModelMap().put("isself",true);
            }else{
                map.getModelMap().put("isself",false);
            }
        } catch (Exception e) {
            map.getModelMap().put("isself",false);
        }

        map.getModel().put("openId",systemOpenUser.getOpenid());
        WebUtil.addCookie("weixin_openid",systemOpenUser.getOpenid());
        WebUtil.addCookie("qudao","weixin");
        map.setViewName("Wechat/index.jsp");
        return map;
    }

    @RequestMapping("/app")
    public ModelAndView index(){
        ModelAndView map=new ModelAndView();
        WebUtil.addCookie("applogin","false");
        map.setViewName("index.jsp");
        return map;
    }

    @RequestMapping("/appregister")
    @ResponseBody
    public ModelMap  appregister(String mobile){
        ModelMap map=new ModelMap();
        if(StringUtils.isEmpty(mobile)){
            map.put("success",0);
            map.put("message","mobile不能为空 ");
            return map;
        }
        if(mobile.length()!=11){
            map.put("success",0);
            map.put("message","mobile长度不对 ");
            return map;
        }
        User user = userService.addUser(mobile);
        WebUtil.addCookie("applogin","true");
        WebUtil.saveMobile(mobile);
        WebUtil.addCookie("luckdraw",user.getLuckdraw().toString());
        WebUtil.addCookie("prize",user.getWinning().toString());
        map.put("luckdraw",user.getLuckdraw().toString());
        map.put("prize",user.getWinning().toString());
        map.put("success",1);
        map.put("message","");
        return map;
    }



    @RequestMapping("/getShareInfo")
    @ResponseBody
    public ModelMap  getHelpInfo(String shareId,HttpServletRequest request){
        ModelMap map=new ModelMap();
        if(StringUtils.isEmpty(shareId)){
            String uniqueOpenid = mideaAuthService.getUniqueOpenid(request);;
            shareId = userService.getUserByUserId(uniqueOpenid).getShareId();
        }
        User userById = userService.getUserByShareId(shareId);
        List<Help> helpList = userService.getHelpList(shareId);
        /* helpList = new ArrayList<>();
        for(int i=0;i<20;i++){
            Help help = new Help();
            help.setNickname("昵称"+i);
            help.setHeadimage("http://wx.qlogo.cn/mmopen/zbbWS9ft5hUvEthjvCG261hDkgx40NUhibZ7r9a6M3cTaNgwhpY3xW1DrcDDeslRhwmfiaM84FF0SsMQNZynooqWHlvVhuYuzb/0");
            help.setCreateTime(new Date());
            helpList.add(help);
        }*/
        /*map.addAttribute("user",userById);
        map.addAttribute("help",helpList);
        map.addAttribute("count",helpList.size());*/
        map.put("user",userById);
        map.put("help",helpList);
        map.put("count",helpList.size());
        map.put("success",1);
        map.put("message","");
        return map;
    }

    @RequestMapping("/help")
    @ResponseBody
    public ModelMap  help(String shareId,HttpServletRequest request){
        ModelMap map=new ModelMap();
        String uniqueOpenid = mideaAuthService.getUniqueOpenid(request);
        User userByShareId = userService.getUserByShareId(shareId);
        if(StringUtils.equals(userByShareId.getUserid(),uniqueOpenid)){
            map.put("success",1);
            map.put("message","");
            return map;
        }
        try {
            stat.addHelp(uniqueOpenid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean b = userService.hasHelped(shareId, uniqueOpenid);
        if(!b) {
            userService.help(shareId, uniqueOpenid);
        }
        map.put("success",1);
        map.put("message","");
        return map;
    }

    @RequestMapping("/saveTicket")
    @ResponseBody
    public ModelMap  ticket(String  cityname1,String cityname2,HttpServletRequest request){
        ModelMap map=new ModelMap();
        String uniqueOpenid = UserIdUtil.getUserId();
        if(StringUtils.isEmpty(cityname1)||StringUtils.isEmpty(cityname2)){
            map.put("success",0);
            map.put("message","cityname1    cityname2 不能为空 ");
            return map;
        }
        User userByUserId = userService.getUserByUserId(uniqueOpenid);
        userByUserId.setStartCity(cityname1);
        userByUserId.setEndCity(cityname2);
        City cityByCityName = cityCache.getCityByCityName(cityname1);
        City cityByCityName1 = cityCache.getCityByCityName(cityname2);
        Long distance = LocationUtils.distance(cityByCityName, cityByCityName1);
        int temp=Math.abs(cityByCityName.getTemp()-cityByCityName1.getTemp());
        userByUserId.setDistance(distance.intValue());
        userByUserId.setStartCityTemp(temp);
        userByUserId.setEndCityTemp(temp);
        userService.updateUser(userByUserId);
        WebUtil.addCookie("shareId",userByUserId.getShareId());
        map.put("success",1);
        map.put("message","");
        return map;
    }




    @RequestMapping("/luckdraw")
    @ResponseBody
    public ModelMap  luckdraw(HttpServletRequest request){
        ModelMap map=new ModelMap();
        map.put("prize",false);
        String uniqueOpenid = UserIdUtil.getUserId();
        User userByUserId = userService.getUserByUserId(uniqueOpenid);
        List<Help> helpList = userService.getHelpList(userByUserId.getShareId());
        Prize prizeByUserId = userService.getPrizeByUserId(uniqueOpenid);
        boolean lock = redisLockService.lock(uniqueOpenid);
        if(!lock){
            map.put("success",0);
            map.put("message","抽奖被锁定");
            return map;
        }
        try {
            if(!userByUserId.getLuckdraw()&&((uniqueOpenid.length()==11)||(uniqueOpenid.length()==28&&helpList.size()>=26))){
//            if((helpList.size()>=26&&!userByUserId.getLuckdraw())||prizeByUserId==null){
                //TODO  抽奖
                //抽奖
                UserEntity  userEntity=new UserEntity();
                userEntity.setUserId(uniqueOpenid);
                LotteryResult lottery = lotteryService.lottery(aid, userEntity);

                if(  lottery.getCode()==1){
                    //中奖了
                    userByUserId.setWinning(true);
                    //中了什么奖
                    userByUserId.setPrizeType(lottery.getAwardEntity().getPrizeName());
                    Prize prize=new Prize();
                    prize.setUserid(uniqueOpenid);
                    prize.setCreateTime(new Date());
                    prize.setPrizename(lottery.getAwardEntity().getPrizeName());
                    prize.setCouponCode(lottery.getAwardEntity().getSnCode());
                    prize.setAwardid(lottery.getAwardEntity().getAwardId());
                    userService.insertPrize(prize);
                    map.put("prize",true);
                }else{
                    //没中奖
                    userByUserId.setWinning(false);
                }
                userByUserId.setLuckdraw(true);
                userByUserId.setLuckdrawtime(new Date());
                userService.updateUser(userByUserId);
            }else {
                map.put("success",0);
                map.put("message","不满足抽奖条件");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",0);
            map.put("message","抽奖出现异常");
            return map;
        } finally {
            redisLockService.unLock(uniqueOpenid);
        }
        map.put("success",1);
        map.put("message","");
        return map;
    }


    @RequestMapping("/fillprizeInfo")
    @ResponseBody
    public ModelMap fillprizeInfo(String username,String mobile,String address,HttpServletRequest request){
        ModelMap map=new ModelMap();
        String uniqueOpenid = UserIdUtil.getUserId();
        if(StringUtils.isEmpty(username)
                ||StringUtils.isEmpty(mobile)
                  ||StringUtils.isEmpty(address)) {
            map.put("success", 0);
            map.put("message", "username,mobile,address 不能为空");
            return map;
        }
        try {
            //TODO 填写中奖信息
            if(uniqueOpenid.length()==11){
                if(!StringUtils.equals(uniqueOpenid,mobile)){
                    map.put("success", 0);
                    map.put("message", "注册手机号跟 中奖手机号，信息必须一样");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Prize prizeByUserId = userService.getPrizeByUserId(uniqueOpenid);
        if (prizeByUserId == null) {
            map.put("success", 0);
            map.put("message", "你没有中奖");
            return map;
        }
        prizeByUserId.setUsername(username);
        prizeByUserId.setMobile(mobile);
        prizeByUserId.setAddress(address);
        userService.updatePrize(prizeByUserId);
//        lotteryService.fillAwardInfo();
        map.put("success",1);
        map.put("message","");
        return map;
    }


    @RequestMapping("/appluckdraw")
    @ResponseBody
    public ModelMap  appluckdraw(String mobile){
        WebUtil.saveMobile(mobile);
        ModelMap map=new ModelMap();
        User user=null;
        if(StringUtils.isNotEmpty(mobile)) {
             user = userService.addUser(mobile);
        }else{
            String userId = UserIdUtil.getUserId();
            mobile=userId;
            user = userService.getUserByUserId(userId);
        }
        boolean lock = redisLockService.lock(mobile);
        if(!lock){
            map.put("success",0);
            map.put("message","抽奖被锁定");
            return map;
        }
        try {
            stat.addOpenPackage(mobile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int status=0;
        try {
            if(user.getLuckdraw()){
                //已经抽过奖了
                if(user.getWinning()){
                    Prize prizeByUserId = userService.getPrizeByUserId(mobile);
                    map.put("prizeIndex", prizeByUserId.getCouponCode());
                    if(StringUtils.isEmpty(prizeByUserId.getUsername())) {
                        status = 1;  //中奖了  没有填中奖信息
                    }else{
                        status=0;  //中奖了  已经填过中奖信息
                        map.put("prize",prizeByUserId);
                    }

                }else{
                    status=2; //没中奖
                }
            }else{
                //没有抽过奖
                UserEntity  userEntity=new UserEntity();
                userEntity.setUserId(mobile);
                LotteryResult lottery = lotteryService.lottery(aid, userEntity);
                if(  lottery.getCode()==1){
                    //中奖了
                    user.setWinning(true);
                    //中了什么奖
                    user.setPrizeType(lottery.getAwardEntity().getPrizeName());
                    Prize prize=new Prize();
                    prize.setUserid(mobile);
                    prize.setCreateTime(new Date());
                    prize.setPrizename(lottery.getAwardEntity().getPrizeName());
                    prize.setCouponCode(lottery.getAwardEntity().getPrizeIndex().toString());
                    prize.setAwardid(lottery.getAwardEntity().getAwardId());
                    userService.insertPrize(prize);
                    map.put("prizeIndex", lottery.getAwardEntity().getPrizeIndex().toString());
                    map.put("prize",true);

                    try {
                        stat.addNumberOfWinners();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    status=3;
                }else{
                    //没中奖
                    user.setWinning(false);
                    status=4;
                }
                user.setLuckdraw(true);
                user.setLuckdrawtime(new Date());
                userService.updateUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",0);
            map.put("message","抽奖出现异常");
            return map;
        } finally {
            redisLockService.unLock(mobile);
        }
        map.put("status",status);
        map.put("success",1);
        map.put("message","");
        return map;
    }

    @RequestMapping("/prize")
    @ResponseBody
    public ModelMap prize(){
        ModelMap map=new ModelMap();
        String mobile = WebUtil.getMobile();
        Prize prizeByUserId = userService.getPrizeByUserId(mobile);
        map.put("prize",prizeByUserId);
        map.put("success",1);
        map.put("message","");
        return map;
        
    }


    @RequestMapping("/helpList")
    @ResponseBody
    public ModelMap helpList(String shareId,Integer page,Integer pageSize){
        ModelMap map=new ModelMap();
//        List<Help> getHelpList(String shareId);
        if(page==null){
            page=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        List<Help> helps= userService.getHelpList(shareId,page,pageSize);
        Integer count=userService.getHelpCount(shareId);
        map.put("helps",helps);
        map.put("count",count);
        map.put("success",1);
        map.put("message","");
        return map;
    }




}
