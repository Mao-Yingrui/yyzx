package com.neutech.service;

import com.neutech.entity.Food;
import java.util.List;

public interface FoodService {
    /**
     * 根据用餐时间查询食物列表
     * @param foodDate 用餐时间
     * @return 食物列表
     */
    List<Food> getFoodByDate(String foodDate);
}