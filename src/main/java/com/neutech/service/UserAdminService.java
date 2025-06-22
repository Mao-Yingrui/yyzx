package com.neutech.service;

import com.neutech.entity.User;
import java.util.List;

/**
 * <p>
 * 管理员 - 用户信息管理服务接口
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface UserAdminService {
    List<User> listUsers();
    User getUserById(String idCard);
    boolean addUser(User user);
    boolean deleteUser(String idCard);
    boolean updateUser(User user);
}