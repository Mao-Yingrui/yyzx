package com.neutech.service.impl;

import com.neutech.entity.CareContent;
import com.neutech.entity.UserCareDetails;
import com.neutech.mapper.CareContentMapper;
import com.neutech.mapper.UserCareDetailsMapper;
import com.neutech.service.UserCareDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCareDetailsServiceImpl implements UserCareDetailsService {

    @Autowired
    private CareContentMapper careContentMapper;

    @Autowired
    private UserCareDetailsMapper userCareDetailsMapper;

    @Override
    public String getCareDetails() {
        // 这里直接返回护理内容字符串，实际可能需要从数据库查询
        // 假设护理内容是固定的，或者从其他表查询
        return "基础护理服务内容..."; // 实际项目中应该从数据库查询
    }

    @Override
    public boolean selectCareService(int serviceNumber, String serviceContent, int serviceCount, String idCard) {
        // 首先查询护理内容表，获取护理服务ID和护理详情
        CareContent careContent = null;

        // 根据服务编号查询对应的护理服务
        // 这里简化处理，实际可能需要更复杂的逻辑来确定careId
        // 假设我们有一个方法可以根据服务编号获取careId
        // 这里为了示例，我们假设serviceNumber直接对应careId
        Integer careId = serviceNumber; // 简化处理，实际可能需要查询数据库

        if (careId == null) {
            return false; // 找不到对应的护理服务
        }

        // 查询护理内容详情
        careContent = careContentMapper.selectCareContentById(careId);
        if (careContent == null) {
            return false; // 找不到护理内容
        }

        // 创建用户护理服务对象
        UserCareDetails userCareService = new UserCareDetails();
        userCareService.setIdCard(idCard);
        userCareService.setCareId(careId);
        userCareService.setRemainingSessions("未完成"); // 默认为未完成
        userCareService.setRemainingCount(serviceCount); // 设置剩余次数

        // 插入或更新用户护理服务
        int result = userCareDetailsMapper.insertOrUpdateUserCareService(userCareService);
        return result > 0;
    }

    @Override
    public List<UserCareDetails> getUserCareServices(String idCard) {
        return userCareDetailsMapper.selectUserCareServicesByIdCard(idCard);
    }
}