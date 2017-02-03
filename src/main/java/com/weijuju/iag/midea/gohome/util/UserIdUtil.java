package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/20.
 */

import com.weijuju.iag.youyu.baseweb.service.UnionUserSystem;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyin
 * @create 2016-12-20
 */
public class UserIdUtil {


    public static String   getUserId(){
        String s = WebUtil.getMobile();
        if(StringUtils.isNotEmpty(s)){
            return s;
        }
        String s1 = WebUtil.getWeiXinOPenId();
        if(StringUtils.isNotEmpty(s1)){
            return s1;
        }
        String uniqueOpenid = UnionUserSystem.getUniqueOpenid(WebUtil.getRequest());
        if(StringUtils.isNotEmpty(uniqueOpenid)){
            return uniqueOpenid;
        }

        throw new IllegalStateException();
    }

    public static String  getUserId( HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("weixin_openid")||cookie.getName().equals("_openid")){
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

}
