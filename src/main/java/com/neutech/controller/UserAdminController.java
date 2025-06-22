package com.neutech.controller;

import com.neutech.entity.User;
import com.neutech.service.UserAdminService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员 - 用户信息管理控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    /**
     * 查询所有用户
     *
     * @return ResultJson 包含用户列表及操作状态
     */
    @GetMapping("/list")
    public ResultJson listUsers() {
        return new ResultJson(200, userAdminService.listUsers(), "查询成功");
    }

    /**
     * 根据身份证号查询用户
     *
     * @param idCard 身份证号码
     * @return ResultJson 包含用户信息或错误提示
     */
    @GetMapping("/{idCard}")
    public ResultJson getUserById(@PathVariable String idCard) {
        User user = userAdminService.getUserById(idCard);
        if (user == null) {
            return new ResultJson(500, null, "用户不存在");
        }
        return new ResultJson(200, user, "查询成功");
    }

    /**
     * 添加用户
     *
     * @param user 用户实体对象
     * @return ResultJson 操作结果
     */
    @PostMapping("/add")
    public ResultJson addUser(@RequestBody User user) {
        boolean result = userAdminService.addUser(user);
        return result ? new ResultJson(200, null, "添加成功") : new ResultJson(500, null, "添加失败");
    }

    /**
     * 删除用户
     *
     * @param idCard 身份证号码
     * @return ResultJson 操作结果
     */
    @DeleteMapping("/{idCard}")
    public ResultJson deleteUser(@PathVariable String idCard) {
        boolean result = userAdminService.deleteUser(idCard);
        return result ? new ResultJson(200, null, "删除成功") : new ResultJson(500, null, "删除失败");
    }

    /**
     * 修改用户信息
     *
     * @param user 用户实体对象
     * @return ResultJson 操作结果
     */
    @PutMapping("/update")
    public ResultJson updateUser(@RequestBody User user) {
        boolean result = userAdminService.updateUser(user);
        return result ? new ResultJson(200, null, "更新成功") : new ResultJson(500, null, "更新失败");
    }
}