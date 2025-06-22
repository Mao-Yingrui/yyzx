package com.neutech.controller;

import com.neutech.service.AdminService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    ResultJson login(
            @RequestParam String adId,
            @RequestParam String adPwd
    ) {
        boolean isValid = adminService.login(adId, adPwd);
        if (isValid) {
            return new ResultJson(200, null, "登录成功");
        } else {
            return new ResultJson(500, null, "账号或密码错误");
        }
    }
}
