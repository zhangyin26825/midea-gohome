package com.weijuju.iag.midea.gohome.controller;/**
 * Created by zhangyin on 2016/12/15.
 */

import com.weijuju.iag.mapper.StatObjectMapper;
import com.weijuju.iag.midea.gohome.dataobject.StatObject;
import com.weijuju.iag.midea.gohome.dataobject.StatObjectExample;
import com.weijuju.iag.midea.gohome.dataobject.User;
import com.weijuju.iag.midea.gohome.dataobject.UserExample;
import com.weijuju.iag.midea.gohome.stat.ExcelUtil;
import com.weijuju.iag.midea.gohome.stat.Stat;
import com.weijuju.iag.midea.gohome.util.UserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangyin
 * @create 2016-12-15
 */
@Controller
@RequestMapping("/stat")
public class IndexController {
    @Autowired
    StatObjectMapper statObjectMapper;
    @Autowired
    Stat stat;

    @RequestMapping("/excel")
    public void stat(HttpServletResponse response){

        StatObjectExample example=new StatObjectExample();
        example.createCriteria();
        List<StatObject> list = statObjectMapper.selectByExample(example);

        ExcelUtil excelUtil=new ExcelUtil();
        excelUtil.generateSheet("美的回家",list,
                new String[]{"日期","类型","PV","UV","立即生成 按钮点击次数","立即生成 按钮点击人数","助力总次数","助力总人数","开启礼包 按钮点击次数","开启礼包 按钮点击人数","活动分享总次数","活动分享总人数","中奖人数","新增访客数"
                },
                new String[]{"statDate","qudao","pv","uv","immediatelygeneratepv","immediatelygenerateuv","helppv","helpuv","openpackagepv","openpackageuv","activitysharepv","activityshareuv","numberofwinners","newuser"
                });

        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            String downFileName = "dataFile.xlsx";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + downFileName + "\"");
            excelUtil.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/time")
    @ResponseBody
    public ModelMap stattime(HttpServletResponse response){
          ModelMap map=new ModelMap();
        stat.daystat();
        return map;
    }
    @RequestMapping("/share")
    @ResponseBody
    public ModelMap share(HttpServletResponse response){
        ModelMap map=new ModelMap();
        try {
            String userId = UserIdUtil.getUserId();
            stat.addActivityShare(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/today")
    @ResponseBody
    public ModelMap today(HttpServletResponse response){
        ModelMap map=new ModelMap();
        List<StatObject> todayStat = stat.getTodayStat();
        map.put("stat",todayStat);
        return map;
    }


}
