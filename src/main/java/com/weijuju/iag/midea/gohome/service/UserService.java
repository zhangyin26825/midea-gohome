package com.weijuju.iag.midea.gohome.service;/**
 * Created by zhangyin on 2016/12/19.
 */

import com.weijuju.iag.midea.gohome.dataobject.Help;
import com.weijuju.iag.midea.gohome.dataobject.Prize;
import com.weijuju.iag.midea.gohome.dataobject.User;
import com.weijuju.iag.wxapi.entity.OpenUser;

import java.util.List;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
public interface UserService {

    User  addUser(OpenUser systemOpenUser);

    User  addUser(String mobile);

     User getUserByUserId(String userId);

    User  getUserByShareId(String shareId);

    List<Help> getHelpList(String shareId);

    void help(String shareId,String userId);

    void updateUser(User user);

    boolean  hasHelped(String shareId,String userId);

    void insertPrize(Prize p);

    Prize  getPrizeByUserId(String userId);

    void updatePrize(Prize prizeByUserId);

    List<Help> getHelpList(String shareId, Integer page, Integer pageSize);

    Integer getHelpCount(String shareId);
}
