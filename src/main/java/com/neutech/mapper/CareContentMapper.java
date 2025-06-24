package com.neutech.mapper;

import com.neutech.entity.CareContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareContentMapper {
    /**
     * 根据护理服务ID查询护理内容
     * @param careId 护理服务ID
     * @return 护理内容对象
     */
    CareContent selectCareContentById(Integer careId);

    /**
     * 查询所有护理内容
     * @return 护理内容列表
     */
    List<CareContent> selectAllCareContents();
}