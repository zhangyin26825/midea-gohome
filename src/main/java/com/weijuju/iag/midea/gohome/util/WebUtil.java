package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/9/27.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
 * @author zhangyin
 * @create 2016-09-27
 */
public class WebUtil {

    public static String OPENID="_openid";

    private Logger log = LoggerFactory.getLogger(WebUtil.class);

    public static HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    public static HttpServletResponse getResponse(){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return  response;
    }


    public static void saveMobile(String openid){
        HttpServletResponse response = getResponse();
        Cookie c=new Cookie(OPENID,openid);
        c.setPath("/");
        response.addCookie(c);
    }

    public static  void addCookie(String name,String value){
        HttpServletResponse response = getResponse();
        Cookie c=new Cookie(name,value);
        c.setPath("/");
        response.addCookie(c);
    }

    public static String  getMobile(){
        HttpServletRequest  request= getRequest();
        HttpServletResponse response=getResponse();
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(OPENID)){
                   return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static String  getWeiXinOPenId(){
        HttpServletRequest  request= getRequest();
        HttpServletResponse response=getResponse();
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("weixin_openid")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }




}
