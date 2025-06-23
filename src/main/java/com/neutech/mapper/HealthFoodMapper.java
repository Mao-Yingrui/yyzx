package com.neutech.mapper;

import com.neutech.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HealthFoodMapper {
    /**
     * 根据用餐时间查询食物列表
     * @param foodDate 用餐时间
     * @return 食物列表
     */
    List<Food> selectFoodByDate(String foodDate);

    /**
     * 添加食物
     * @param food 食物对象
     * @return 影响的行数
     */
    int insertFood(Food food);

    /**
     * 删除食物
     * @param foodId 食物ID
     * @return 影响的行数
     */
    int deleteFoodById(Integer foodId);

    /**
     * 更新食物
     * @param food 食物对象
     * @return 影响的行数
     */
    int updateFood(Food food);
}