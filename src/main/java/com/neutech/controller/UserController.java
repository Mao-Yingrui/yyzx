package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource//告诉 Spring 自动注入一个 UserService 的实现类。
            //Spring 会自动找到 @Service 注解的类并赋值给这个变量。
    UserService userService;

    @PostMapping("/update") //Post请求接口
    ResultJson updateUserInfo(@RequestBody User user) {//@RequestBody 告诉 Spring 这个参数是从 HTTP 请求体中解析出来的 JSON 数据。
        // 调用服务层更新用户信息
        boolean isUpdated = userService.updateUserInfo(user);
        
        if (isUpdated) {
            return new ResultJson(200, null, "用户信息更新成功");
        } else {
            return new ResultJson(500, null, "用户信息更新失败");
        }
    }
}
