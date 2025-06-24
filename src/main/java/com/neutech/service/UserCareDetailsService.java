package com.neutech.service;

import com.neutech.entity.UserCareDetails;

import java.util.List;

public interface UserCareDetailsService {
    /**
     * 查询护理内容
     * @return 护理内容字符串
     */
    String getCareDetails();

    /**
     * 选择护理服务
     * @param serviceNumber 服务编号(1-5)
     * @param serviceContent 服务内容(服务2-5使用)
     * @param serviceCount 服务次数
     * @param idCard 用户ID(身份证号)
     * @return 是否成功
     */
    boolean selectCareService(int serviceNumber, String serviceContent, int serviceCount, String idCard);

    /**
     * 查询用户护理服务
     * @param idCard 用户ID(身份证号)
     * @return 用户护理服务列表
     */
    List<UserCareDetails> getUserCareServices(String idCard);
}