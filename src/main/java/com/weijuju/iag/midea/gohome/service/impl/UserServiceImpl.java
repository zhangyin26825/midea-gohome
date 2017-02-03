package com.weijuju.iag.midea.gohome.service.impl;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.mapper.HelpMapper;
import com.weijuju.iag.mapper.PrizeMapper;
import com.weijuju.iag.mapper.UserMapper;
import com.weijuju.iag.midea.gohome.dataobject.*;
import com.weijuju.iag.midea.gohome.service.UserService;
import com.weijuju.iag.midea.gohome.stat.Stat;
import com.weijuju.iag.midea.gohome.util.UUIDGenerator;
import com.weijuju.iag.wxapi.entity.OpenUser;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    HelpMapper helpMapper;
    @Autowired
    PrizeMapper prizeMapper;

    @Autowired
    Stat stat;

    @Override
    public User addUser(OpenUser systemOpenUser) {
        String openid = systemOpenUser.getOpenid();
        User userByUserId = getUserByUserId(openid);
        if(userByUserId==null){
            stat.addNewUser();
            User u=new User();
            u.setUserid(openid);
            u.setCreateTime(new Date());
            u.setHeadimage(systemOpenUser.getHeadimgurl());
            u.setNickname(systemOpenUser.getNickname());
            u.setLuckdraw(false);
            u.setWinning(false);
            u.setUserWeixin(true);
            u.setShareId(UUIDGenerator.uuid());
            userMapper.insert(u);
            return u;
        }else{
            return userByUserId;
        }
    }

    @Override
    public User addUser(String mobile) {
        User userByUserId = getUserByUserId(mobile);
        if (userByUserId == null) {
            stat.addNewUser();
            User u=new User();
            u.setUserid(mobile);
            u.setCreateTime(new Date());
//            u.setHeadimage(systemOpenUser.getHeadimgurl());
//            u.setNickname(systemOpenUser.getNickname());
            u.setLuckdraw(false);
            u.setWinning(false);
            u.setUserWeixin(false);
            u.setShareId(UUIDGenerator.uuid());
            userMapper.insert(u);
            return u;
        }
        return userByUserId;
    }

    public User getUserByUserId(String userId){
        UserExample example=new UserExample();
        example.createCriteria().andUseridEqualTo(userId);
        List<User> users =  userMapper.selectByExample(example);
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByShareId(String shareId) {
        return userMapper.selectByPrimaryKey(shareId);
    }

    @Override
    public List<Help> getHelpList(String shareId) {
        HelpExample exampel=new HelpExample();
        exampel.createCriteria().andShareIdEqualTo(shareId);
        List<Help> helps = helpMapper.selectByExample(exampel);
        return helps;
    }

    @Override
    public void help(String shareId, String userId) {
        Help h=new Help();
        h.setShareId(shareId);
        h.setHelpOpenid(userId);
        h.setCreateTime(new Date());
        User userByUserId = getUserByUserId(userId);
        h.setNickname(userByUserId.getNickname());
        h.setHeadimage(userByUserId.getHeadimage());
        helpMapper.insert(h);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public boolean hasHelped(String shareId, String userId) {
        HelpExample exampel=new HelpExample();
        exampel.createCriteria().andShareIdEqualTo(shareId).andHelpOpenidEqualTo(userId);
        List<Help> helps = helpMapper.selectByExample(exampel);
        if(helps.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public void insertPrize(Prize p) {
        prizeMapper.insert(p);
    }

    @Override
    public Prize getPrizeByUserId(String userId) {
        PrizeExample example=new PrizeExample();
        example.createCriteria().andUseridEqualTo(userId);
        List<Prize> prizes = prizeMapper.selectByExample(example);
        if(prizes.isEmpty()){
            return null;
        }
        return prizes.get(0);
    }
    @Override
    public void updatePrize(Prize prizeByUserId) {
        prizeMapper.updateByPrimaryKey(prizeByUserId);
    }


    @Override
    public List<Help> getHelpList(String shareId, Integer page, Integer pageSize) {
        HelpExample exampel=new HelpExample();
        exampel.createCriteria().andShareIdEqualTo(shareId);
        int offset=(page-1)*pageSize;
        RowBounds row=new RowBounds(offset,pageSize);
        exampel.setOrderByClause("create_time desc");
        List<Help> helps = helpMapper.selectByExampleWithRowbounds(exampel,row);
        return helps;
    }

    @Override
    public Integer getHelpCount(String shareId) {
        HelpExample exampel=new HelpExample();
        exampel.createCriteria().andShareIdEqualTo(shareId);
        int i = helpMapper.countByExample(exampel);
        return i;
    }
}
