package com.neutech.mapper;

import com.neutech.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface UserMapper extends BaseMapper<User> {

    boolean updateUserCustom(User existingUser);
}
