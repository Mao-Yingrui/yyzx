package com.neutech.mapper;

import com.neutech.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FoodMapper {
    /**
     * 根据用餐时间查询食物列表
     * @param foodDate 用餐时间
     * @return 食物列表
     */
    List<Food> selectFoodByDate(String foodDate);
}