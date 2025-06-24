package com.neutech.service;

import com.neutech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 更新用户信息
     * @param idCard 身份证号
     * @param name 姓名
     * @param gender 性别
     * @param password 密码
     * @param birthDate 出生日期
     * @param familyPhone 家庭电话
     * @param isIn 是否在库
     * @return 更新操作是否成功
     */
    boolean updateUserInfo(
            String idCard,
            String name,
            String gender,
            String password,
            String birthDate,
            String familyPhone,
            String isIn
    );

    List<User> getInUsers();
}