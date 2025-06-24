package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.HealthManagerUserService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/health-manager/user")
public class HealthManagerUserController {

    @Autowired
    private HealthManagerUserService healthManagerUserService;

    /**
     * 健康管家查看自己管理的用户页面
     * 传出json格式：
     * 姓名 (name)：字符串
     * 身份证号（id_card）：字符串
     * 性别 (gender)：男/女
     * 位置 (location)：字符串
     */
    @GetMapping("/managed-users")
    public ResultJson getManagedUsers(@RequestParam String healthHomeId) {
        List<Map<String, Object>> users = healthManagerUserService.getManagedUsersWithLocation(healthHomeId);
        return new ResultJson(200, users, "查询成功");
    }
}