package com.neutech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.User;
import com.neutech.mapper.UserMapper;
import com.neutech.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean updateUserInfo(
            String idCard,
            String name,
            String gender,
            String password,
            String birthDate,
            String familyPhone,
            String isIn
    ) {
        // 查询用户是否存在
        User existingUser = userMapper.selectById(idCard);
        if (existingUser == null) {
            return false;
        }

        // 设置新数据
        existingUser.setName(name);
        existingUser.setGender(gender);
        existingUser.setPassword(password);
        existingUser.setBirthDate(LocalDate.parse(birthDate)); // 转换为 LocalDate
        existingUser.setFamilyPhone(familyPhone);
        existingUser.setIsIn(isIn);

        // 执行更新
        return userMapper.updateUserCustom(existingUser);
    }

    @Override
    public List<User> getInUsers() {
        try {
            return userMapper.selectInUsersNotInRecord().stream()
                    .map(user -> {
                        User dto = new User();
                        dto.setIdCard(user.getIdCard());
                        dto.setName(user.getName());
                        dto.setGender(user.getGender());
                        dto.setFamilyPhone(user.getFamilyPhone());
                        return dto;
                    })
                    .toList();
        } catch (Exception e) {
            System.err.println("查询 in_users 出现异常：" + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }
}