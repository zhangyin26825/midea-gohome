package com.weijuju.iag.midea.gohome.filter;

/**
 * Created by zhangyin on 2016/8/6.
 */

import com.alibaba.dubbo.common.utils.StringUtils;
import com.weijuju.iag.baseweb.utils.WebUtil;
import com.weijuju.iag.midea.gohome.async.QueryIP;
import com.weijuju.iag.midea.gohome.stat.Stat;
import com.weijuju.iag.midea.gohome.util.UserIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;


public class SimpleCORSFilter implements Filter {

    public  static ThreadLocal<String> qudao=new ThreadLocal<>();

    private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

    public SimpleCORSFilter() {
        log.info("SimpleCORSFilter init");
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if(request.getServletPath().contains("version")){
            req.getServletContext().setAttribute("version", new Random().nextInt());
        }
        String qudao = getCookieByname(request, "qudao");
        if(StringUtils.isNotEmpty(qudao)){
            SimpleCORSFilter.qudao.set(qudao);
        }else{
            if(request.getServletPath().contains("Media")||request.getServletPath().contains("Others")){
                SimpleCORSFilter.qudao.set("app");
                addCookie(response,"qudao","app");
            }else if(request.getServletPath().contains("weixin/index")){
                SimpleCORSFilter.qudao.set("weixin");
                addCookie(response,"qudao","weixin");
            }else {
                SimpleCORSFilter.qudao.set("app");
                addCookie(response,"qudao","app");
            }
        }



        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        QueryIP ip = context.getBean(QueryIP.class);
        ip.query(WebUtil.getClientRealIp(request));
        try {
            Stat bean = context.getBean(Stat.class);
            String userId = UserIdUtil.getUserId(request);
            if(StringUtils.isEmpty(userId)){
                userId="";
            }
            bean.addPVUV(userId);
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
        }

//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        InputStream resourceAsStream = SimpleCORSFilter.class.getClassLoader().getResourceAsStream("cmb-sports.properties");
        Properties p=new Properties();
        try {
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filterConfig.getServletContext().setAttribute("StaticResourcesUrl", p.getProperty("StaticResourcesUrl"));
        filterConfig.getServletContext().setAttribute("version",new Random().nextInt());
        filterConfig.getServletContext().setAttribute("urlDomain", p.getProperty("url_domain"));
        System.out.println("初始化spring ApplicationContext ");
    }

    @Override
    public void destroy() {
    }

    public   void addCookie(HttpServletResponse response,String name,String value){
        Cookie c=new Cookie(name,value);
        c.setPath("/");
        response.addCookie(c);
    }
    public  String  getCookieByname( HttpServletRequest  request,String name){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
