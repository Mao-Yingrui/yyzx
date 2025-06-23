package com.neutech.service.impl;

import com.neutech.entity.UserFood;
import com.neutech.mapper.UserFoodMapper;
import com.neutech.service.UserFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFoodServiceImpl implements UserFoodService {

    @Autowired
    private UserFoodMapper userFoodMapper;

    @Override
    public boolean saveOrUpdateUserFood(UserFood userFood) {
        return userFoodMapper.insertOrUpdateUserFood(userFood) > 0;
    }

    @Override
    public UserFood getUserFoodByUserIdAndDate(Integer userId, String foodDate) {
        return userFoodMapper.selectUserFoodByUserIdAndDate(userId, foodDate);
    }
}