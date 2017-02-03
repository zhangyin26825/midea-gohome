package com.weijuju.iag.mapper;

import com.weijuju.iag.midea.gohome.dataobject.Prize;
import com.weijuju.iag.midea.gohome.dataobject.PrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PrizeMapper {
    int countByExample(PrizeExample example);

    int deleteByExample(PrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prize record);

    int insertSelective(Prize record);

    List<Prize> selectByExampleWithRowbounds(PrizeExample example, RowBounds rowBounds);

    List<Prize> selectByExample(PrizeExample example);

    Prize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prize record, @Param("example") PrizeExample example);

    int updateByExample(@Param("record") Prize record, @Param("example") PrizeExample example);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);
}