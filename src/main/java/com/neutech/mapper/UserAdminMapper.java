package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 管理员 - 用户信息管理 Mapper 接口
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface UserAdminMapper extends BaseMapper<User> {
    List<User> selectAllUsers();
    User selectUserById(@Param("idCard") String idCard);
    int insertUser(@Param("et") User user);
    int deleteUserById(@Param("idCard") String idCard);
    int updateUser(@Param("et") User user);
}