package com.neutech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.User;
import com.neutech.mapper.UserAdminMapper;
import com.neutech.service.UserAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员 - 用户信息管理服务实现类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@Service
public class UserAdminServiceImpl extends ServiceImpl<UserAdminMapper, User> implements UserAdminService {

    private final UserAdminMapper userAdminMapper;

    public UserAdminServiceImpl(UserAdminMapper userAdminMapper) {
        this.userAdminMapper = userAdminMapper;
    }

    @Override
    public List<User> listUsers() {
        return this.userAdminMapper.selectAllUsers();
    }

    @Override
    public User getUserById(String idCard) {
        return this.userAdminMapper.selectUserById(idCard);
    }

    @Override
    public boolean addUser(User user) {
        return this.userAdminMapper.insertUser(user) > 0;
    }

    @Override
    public boolean deleteUser(String idCard) {
        return this.userAdminMapper.deleteUserById(idCard) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return this.userAdminMapper.updateUser(user) > 0;
    }

    // 可以添加更多基于业务需求的方法声明与实现
}