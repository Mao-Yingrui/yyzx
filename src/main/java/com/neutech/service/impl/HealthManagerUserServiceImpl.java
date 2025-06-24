package com.neutech.service.impl;

import com.neutech.entity.User;
import com.neutech.entity.Bed;
import com.neutech.mapper.HealthManagerUserMapper;
import com.neutech.mapper.BedMapper;
import com.neutech.mapper.UserMapper;
import com.neutech.service.HealthManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HealthManagerUserServiceImpl implements HealthManagerUserService {

    @Autowired
    private HealthManagerUserMapper healthManagerUserMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private UserMapper userMapper; // 新增注入

    @Override
    public List<Map<String, Object>> getManagedUsersWithLocation(String healthHomeId) {
        // 1. 获取健康管家管理的用户身份证号列表
        List<String> userIds = healthManagerUserMapper.selectManagedUserIds(healthHomeId);

        // 2. 构建结果列表
        List<Map<String, Object>> result = new ArrayList<>();

        // 3. 遍历用户身份证号，查询用户信息和位置信息
        for (String userId : userIds) {
            // 查询用户基本信息
            User user = userMapper.selectByIdCard(userId);

            // 查询用户位置信息
            Bed bed = bedMapper.selectBedByIdCard(userId);
            String location = bed != null ? bed.getLocation() : "未知";

            // 构建包含用户信息和位置信息的Map
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("idCard", userId);
            userInfo.put("name", user.getName());
            userInfo.put("gender", user.getGender());
            userInfo.put("location", location);

            // 添加到结果列表
            result.add(userInfo);
        }

        return result;
    }
}