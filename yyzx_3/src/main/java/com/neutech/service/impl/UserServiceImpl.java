package com.neutech.service.impl;

import com.neutech.entity.User;
import com.neutech.mapper.UserMapper;
import com.neutech.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean register(String idCard, String name, String gender, String password, LocalDate birthDate, String familyPhone) {
        // 检查用户是否已经存在
        User existingUser = this.getById(idCard);
        if (existingUser != null) {
            // 如果用户已存在，返回false表示注册失败
            return false;
        }

        // 创建新用户
        User newUser = new User();
        newUser.setIdCard(idCard);
        newUser.setName(name);
        newUser.setGender(gender); // 确保是“男”或“女”
        newUser.setPassword(password);
        newUser.setBirthDate(birthDate);
        newUser.setFamilyPhone(familyPhone);
        newUser.setIsIn("0"); // 默认不申请入住
        newUser.setBalance(0); // 默认账户余额为0

        System.out.println(newUser.getIdCard());
        System.out.println(newUser.getName());
        System.out.println(newUser.getGender());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getBirthDate());
        System.out.println(newUser.getFamilyPhone());
        System.out.println(newUser.getIsIn());
        System.out.println(newUser.getBalance());

        // 保存用户到数据库
        return this.save(newUser);
    }

    @Override
    public boolean login(String idCard, String password) {
        // 根据身份证号查询用户
        User user = this.getById(idCard);
        return user != null && user.getPassword().equals(password);
    }

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
