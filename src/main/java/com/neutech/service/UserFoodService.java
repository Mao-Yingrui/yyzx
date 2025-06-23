package com.neutech.service;

import com.neutech.entity.UserFood;

public interface UserFoodService {
    /**
     * 保存或更新用户膳食选择
     * @param userFood 用户膳食信息
     * @return 是否成功
     */
    boolean saveOrUpdateUserFood(UserFood userFood);

    /**
     * 根据用户ID和用餐时间查询膳食选择
     * @param userId 用户ID
     * @param foodDate 用餐时间
     * @return 用户膳食信息
     */
    UserFood getUserFoodByUserIdAndDate(Integer userId, String foodDate);
}