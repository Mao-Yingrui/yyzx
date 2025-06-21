package com.neutech.service.impl;

import com.neutech.entity.User;
import com.neutech.mapper.UserMapper;
import com.neutech.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
