package com.weijuju.iag.mapper;

import com.weijuju.iag.midea.gohome.dataobject.User;
import com.weijuju.iag.midea.gohome.dataobject.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String shareId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String shareId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}