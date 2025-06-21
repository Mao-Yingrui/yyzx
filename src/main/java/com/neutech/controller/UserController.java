package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/update")
    ResultJson updateUserInfo(@RequestBody User user) {
        // 调用服务层更新用户信息
        boolean isUpdated = userService.updateUserInfo(user);
        
        if (isUpdated) {
            return new ResultJson(200, null, "用户信息更新成功");
        } else {
            return new ResultJson(500, null, "用户信息更新失败");
        }
    }
}
