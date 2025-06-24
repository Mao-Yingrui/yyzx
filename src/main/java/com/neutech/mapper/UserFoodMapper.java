package com.neutech.mapper;

import com.neutech.entity.UserFood;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFoodMapper {
    /**
     * 插入或更新用户膳食选择
     * @param userFood 用户膳食信息
     * @return 影响的行数
     */
    int insertOrUpdateUserFood(UserFood userFood);

    /**
     * 根据用户ID和用餐时间查询膳食选择
     * @param idCard 用户ID
     * @param foodDate 用餐时间
     * @return 用户膳食信息
     */
    UserFood selectUserFoodByUserIdAndDate(String idCard, String foodDate);
}