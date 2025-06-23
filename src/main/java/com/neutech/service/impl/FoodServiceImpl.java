package com.neutech.service.impl;

import com.neutech.entity.Food;
import com.neutech.mapper.FoodMapper;
import com.neutech.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodByDate(String foodDate) {
        return foodMapper.selectFoodByDate(foodDate);
    }
}