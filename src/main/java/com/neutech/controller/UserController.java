package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource//告诉 Spring 自动注入一个 UserService 的实现类。
            //Spring 会自动找到 @Service 注解的类并赋值给这个变量。
    UserService userService;

    @PostMapping("/update") //Post请求接口
    ResultJson updateUserInfo(
        @RequestParam String idCard,
        @RequestParam String name,
        @RequestParam String gender,
        @RequestParam String password,
        @RequestParam String birthDate,
        @RequestParam String familyPhone,
        @RequestParam Integer isIn
    ) {
        // 构造 User 对象用于后续操作
        User user = new User();
        user.setIdCard(idCard);
        user.setName(name);
        user.setGender(gender);
        user.setPassword(password);
        user.setBirthDate(birthDate);
        user.setFamilyPhone(familyPhone);
        user.setIsIn(isIn);

        // 调用服务层更新用户信息
        boolean isUpdated = userService.updateUserInfo(
            user.getIdCard(),
            user.getName(),
            user.getGender(),
            user.getPassword(),
            user.getBirthDate(),
            user.getFamilyPhone(),
            user.getIsIn()
        );

        if (isUpdated) {
            return new ResultJson(200, null, "用户信息更新成功");
        } else {
            return new ResultJson(500, null, "用户信息更新失败");
        }
    }

    @GetMapping("/in_users")
    ResultJson getInUsers() {
        // 调用服务层查询is_in为1的用户信息
        List<User> inUsers = userService.getInUsers();

        if (!inUsers.isEmpty()) {
            return new ResultJson(200, inUsers, "查询成功");
        } else {
            return new ResultJson(500, null, "查询失败");
        }
    }
}