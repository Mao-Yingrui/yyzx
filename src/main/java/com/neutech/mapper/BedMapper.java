package com.neutech.mapper;

import com.neutech.entity.Bed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BedMapper {
    /**
     * 根据身份证号查询床位信息(位置)
     * @param idCard 身份证号
     * @return 床位对象
     */
    Bed selectBedByIdCard(String idCard);
}