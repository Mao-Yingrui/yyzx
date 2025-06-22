package com.neutech.controller;
import com.neutech.entity.User;
import com.neutech.service.UserService;
import com.neutech.util.JwtUtils;
import com.neutech.util.UserContext;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @PostMapping("/register")
    ResultJson register(
            @RequestParam String idCard,
            @RequestParam String name,
            @RequestParam String gender, // 如 "male" 或 "female"
            @RequestParam String password,
            @RequestParam String birthDate, // 如 "2025-06-21T22:35:18.920+08:00"
            @RequestParam String familyPhone
    ) {
        logger.info("Received registration request with ID Card: {}", idCard);
        try {
            // 将前端传入的 gender 转换为 “男” / “女”
            String normalizedGender = "male".equalsIgnoreCase(gender) ? "男" : "女";

            // 提取日期部分（兼容 ISO 时间格式）
            LocalDate parsedBirthDate = LocalDate.parse(birthDate.split("T")[0]);

            boolean isRegistered = userService.register(idCard, name, normalizedGender, password, parsedBirthDate, familyPhone);
            if (isRegistered) {
                return new ResultJson(200, null, "注册成功");
            } else {
                return new ResultJson(500, null, "注册失败");
            }
        } catch (Exception e) {
            logger.error("请求处理失败", e);
            return new ResultJson(500, null, "请求数据格式错误，请检查输入");
        }
    }

    @PostMapping("/login")
    ResultJson login(
            @RequestParam String idCard,
            @RequestParam String password
    ) {
        boolean isValid = userService.login(idCard, password);
        if (isValid) {
            String token = JwtUtils.generateToken(idCard); // 生成 Token
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token); // 设置响应头
            return new ResultJson(200, Map.of("token", token), "登录成功");
        } else {
            return new ResultJson(500, null, "身份证号或密码错误");
        }
    }

    @GetMapping("/profile")
    ResultJson getProfile() {
        String idCard = UserContext.getCurrentIdCard(); // 从上下文中获取 idCard
        if (idCard == null) {
            return new ResultJson(401, null, "未登录");
        }

        User user = userService.getById(idCard);
        if (user == null) {
            return new ResultJson(500, null, "用户不存在");
        }

        return new ResultJson(200, Map.of(
                "idCard", user.getIdCard(),
                "name", user.getName(),
                "gender", user.getGender(),
                "birthDate", user.getBirthDate(),
                "balance", user.getBalance()
        ), "获取信息成功");
    }

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
