package com.neutech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.User;
import com.neutech.mapper.UserMapper;
import com.neutech.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean updateUserInfo(User user) {
        // 根据身份证号查询用户
        User existingUser = this.getById(user.getIdCard());
        if (existingUser == null) {
            return false; // 用户不存在
        }

        // 更新除余额外的其他信息
        existingUser.setName(user.getName());
        existingUser.setGender(user.getGender());
        existingUser.setPassword(user.getPassword());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setFamilyPhone(user.getFamilyPhone());
        existingUser.setIsIn(user.getIsIn());
        
        // 不更新余额：existingUser.setBalance(user.getBalance());

        // 更新用户信息
        return this.baseMapper.updateUserCustom(existingUser);
    }
}
