package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserAdminService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;
    @PostMapping("/add")
    public ResultJson addUser(
            @RequestParam String idCard,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String password,
            @RequestParam LocalDate birthDate,
            @RequestParam String familyPhone,
            @RequestParam String isIn,
            @RequestParam float balance
    ) {
        User user = new User();
        user.setIdCard(idCard);
        user.setName(name);
        user.setGender(gender);
        user.setPassword(password);
        user.setBirthDate(birthDate);
        user.setFamilyPhone(familyPhone);
        user.setIsIn(isIn);
        user.setBalance(balance);

        boolean result = userAdminService.addUser(user);
        return result ? new ResultJson(200, null, "添加成功") : new ResultJson(500, null, "添加失败");
    }

    @DeleteMapping("/{idCard}")
    public ResultJson deleteUser(@PathVariable String idCard) {
        boolean result = userAdminService.deleteUser(idCard);
        return result ? new ResultJson(200, null, "删除成功") : new ResultJson(500, null, "删除失败");
    }
    @PutMapping("/update")
    public ResultJson updateUser(
            @RequestParam String idCard,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String password,
            @RequestParam LocalDate birthDate,
            @RequestParam String familyPhone,
            @RequestParam String isIn,
            @RequestParam Float balance
    ) {
        User user = new User();
        user.setIdCard(idCard);
        user.setName(name);
        user.setGender(gender);
        user.setPassword(password);
        user.setBirthDate(birthDate);
        user.setFamilyPhone(familyPhone);
        user.setIsIn(isIn);
        user.setBalance(balance);

        boolean result = userAdminService.updateUser(user);
        return result ? new ResultJson(200, null, "更新成功") : new ResultJson(500, null, "更新失败");
    }
}