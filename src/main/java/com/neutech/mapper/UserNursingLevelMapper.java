package com.neutech.mapper;

import com.neutech.entity.UserNursingLevel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserNursingLevelMapper {
    /**
     * 根据用户ID查询护理级别
     * @param idCard 用户ID(身份证号)
     * @return 护理级别对象
     */
    UserNursingLevel selectNursingLevelByIdCard(String idCard);

    /**
     * 更新用户护理级别
     * @param userNursingLevel 护理级别对象
     * @return 影响的行数
     */
    int updateNursingLevel(UserNursingLevel userNursingLevel);
}