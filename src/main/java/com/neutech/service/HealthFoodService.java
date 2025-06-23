package com.neutech.service;

import com.neutech.entity.Food;
import java.util.List;

public interface HealthFoodService {
    /**
     * 根据用餐时间查询食物列表
     * @param foodDate 用餐时间
     * @return 食物列表
     */
    List<Food> getFoodByDate(String foodDate);

    /**
     * 添加食物
     * @param food 食物对象
     * @return 是否成功
     */
    boolean addFood(Food food);

    /**
     * 删除食物
     * @param foodId 食物ID
     * @return 是否成功
     */
    boolean deleteFood(Integer foodId);

    /**
     * 更新食物
     * @param food 食物对象
     * @return 是否成功
     */
    boolean updateFood(Food food);
}