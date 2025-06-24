package com.neutech.service.impl;

import com.neutech.entity.UserCareServiceVO;
import com.neutech.mapper.UserCareServiceMapper;
import com.neutech.service.UserCareServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCareServiceServiceImpl implements UserCareServiceService {

    @Autowired
    private UserCareServiceMapper userCareServiceMapper;

    @Override
    public List<UserCareServiceVO> getUserCareServices(String idCard) {
        return userCareServiceMapper.selectUserCareServices(idCard);
    }

    @Override
    public boolean updateUserCareServiceRemainingCount(Integer careId, Integer remainingCount) {
        int result = userCareServiceMapper.updateUserCareServiceRemainingCount(careId, remainingCount);
        return result > 0;
    }
}