package com.neutech.controller;

import com.neutech.entity.Admin;
import com.neutech.service.AdminService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @PostMapping("/login")
    ResultJson login(@RequestBody Admin admin) {
        boolean isValid = adminService.login(admin.getAdId(), admin.getAdPwd());
        if (isValid) {
            return new ResultJson(200, null, "登录成功");
        } else {
            return new ResultJson(500, null, "账号或密码错误");
        }
    }


}
