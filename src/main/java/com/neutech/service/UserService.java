package com.neutech.service;

import com.neutech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


public interface UserService extends IService<User> {
    boolean updateUserInfo(User user);
}
