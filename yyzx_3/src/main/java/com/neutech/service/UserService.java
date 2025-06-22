package com.neutech.service;

import com.neutech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface UserService extends IService<User> {

    boolean register(String idCard, String name, String gender, String password, LocalDate birthDate, String familyPhone);

    boolean login(String idCard, String password);

    boolean updateUserInfo(User user);
}
