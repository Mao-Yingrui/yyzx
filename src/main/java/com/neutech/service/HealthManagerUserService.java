package com.neutech.service;

import com.neutech.entity.User;
import com.neutech.entity.Bed;

import java.util.List;
import java.util.Map;

public interface HealthManagerUserService {
    /**
     * 查询健康管家管理的用户列表(包含用户信息和位置信息)
     * @param healthHomeId 健康管家ID
     * @return 用户列表(包含用户信息和位置信息)
     */
    List<Map<String, Object>> getManagedUsersWithLocation(String healthHomeId);
}