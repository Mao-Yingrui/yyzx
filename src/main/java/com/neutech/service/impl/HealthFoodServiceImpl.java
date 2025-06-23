package com.neutech.service.impl;

import com.neutech.entity.Food;
import com.neutech.mapper.HealthFoodMapper;
import com.neutech.service.HealthFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthFoodServiceImpl implements HealthFoodService {

    @Autowired
    private HealthFoodMapper healthFoodMapper;

    @Override
    public List<Food> getFoodByDate(String foodDate) {
        return healthFoodMapper.selectFoodByDate(foodDate);
    }

    @Override
    public boolean addFood(Food food) {
        return healthFoodMapper.insertFood(food) > 0;
    }

    @Override
    public boolean deleteFood(Integer foodId) {
        return healthFoodMapper.deleteFoodById(foodId) > 0;
    }

    @Override
    public boolean updateFood(Food food) {
        return healthFoodMapper.updateFood(food) > 0;
    }
}