package com.weijuju.iag.midea.gohome.controller;

import com.weijuju.iag.baseweb.controller.BaseController;
import com.weijuju.iag.common.util.HttpClientUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * jsshare服务
 *
 * @author HUFENG
 * @create 2016-12-31
 */
@Controller
@RequestMapping("/jsShare")
public class JsShareController extends BaseController{

    @RequestMapping("/getJsShareInfo")
    @ResponseBody
    public Result getJsShareInfo(){
        Map<String,Object> map = new HashMap<>();
        String url = "http://www.weijuju.com/mobile/jsShare";
        String result = HttpClientUtil.getInstance().sendHttpPost(url);
        JSONObject jsShareJson = JSONObject.fromObject(result);
        boolean success = jsShareJson.getBoolean("success");
        String appId = jsShareJson.getString("appId");
        String japiTicket = jsShareJson.getString("japiTicket");
        map.put("success",success);
        map.put("appId",appId);
        map.put("japiTicket",japiTicket);
        return successResponse(map);
    }
}
