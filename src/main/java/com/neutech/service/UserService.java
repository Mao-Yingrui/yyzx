package com.neutech.service;

import com.neutech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    boolean updateUserInfo(
        String idCard,
        String name,
        String gender,
        String password,
        String birthDate,
        String familyPhone,
        Integer isIn
    );

    List<User> getInUsers();
}