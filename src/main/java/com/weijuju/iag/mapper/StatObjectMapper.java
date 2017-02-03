package com.weijuju.iag.mapper;

import com.weijuju.iag.midea.gohome.dataobject.StatObject;
import com.weijuju.iag.midea.gohome.dataobject.StatObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StatObjectMapper {
    int countByExample(StatObjectExample example);

    int deleteByExample(StatObjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatObject record);

    int insertSelective(StatObject record);

    List<StatObject> selectByExampleWithRowbounds(StatObjectExample example, RowBounds rowBounds);

    List<StatObject> selectByExample(StatObjectExample example);

    StatObject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatObject record, @Param("example") StatObjectExample example);

    int updateByExample(@Param("record") StatObject record, @Param("example") StatObjectExample example);

    int updateByPrimaryKeySelective(StatObject record);

    int updateByPrimaryKey(StatObject record);
}