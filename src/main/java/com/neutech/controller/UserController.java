package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @GetMapping("/list")
    ResultJson list() {
        List<User> users = userService.list();
        return new ResultJson(200, users, "成功");
    }


}
