package com.neutech.service;

import com.neutech.entity.UserCareServiceVO;

import java.util.List;

public interface UserCareServiceService {
    /**
     * 查询用户护理服务
     * @param idCard 用户身份证号
     * @return 护理服务列表
     */
    List<UserCareServiceVO> getUserCareServices(String idCard);

    /**
     * 更新用户护理服务剩余次数
     * @param careId 护理服务ID
     * @param remainingCount 剩余次数
     * @return 是否成功
     */
    boolean updateUserCareServiceRemainingCount(Integer careId, Integer remainingCount);
}