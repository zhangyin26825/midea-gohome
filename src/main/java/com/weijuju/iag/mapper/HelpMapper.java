package com.weijuju.iag.mapper;

import com.weijuju.iag.midea.gohome.dataobject.Help;
import com.weijuju.iag.midea.gohome.dataobject.HelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface HelpMapper {
    int countByExample(HelpExample example);

    int deleteByExample(HelpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Help record);

    int insertSelective(Help record);

    List<Help> selectByExampleWithRowbounds(HelpExample example, RowBounds rowBounds);

    List<Help> selectByExample(HelpExample example);

    Help selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByExample(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByPrimaryKeySelective(Help record);

    int updateByPrimaryKey(Help record);
}