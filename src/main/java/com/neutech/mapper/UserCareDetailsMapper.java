package com.neutech.mapper;

import com.neutech.entity.UserCareDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCareDetailsMapper {
    /**
     * 查询护理内容
     * @return 护理内容字符串
     */
    String selectCareDetails();

    /**
     * 插入或更新用户护理服务
     * @param userCareDetails 用户护理服务对象
     * @return 影响的行数
     */
    int insertOrUpdateUserCareService(UserCareDetails userCareDetails);

    /**
     * 查询用户护理服务
     * @param idCard 用户ID(身份证号)
     * @return 用户护理服务列表
     */
    List<UserCareDetails> selectUserCareServicesByIdCard(String idCard);
}