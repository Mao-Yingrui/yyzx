package com.neutech.service.impl;

import com.neutech.entity.Admin;
import com.neutech.mapper.AdminMapper;
import com.neutech.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public boolean login(String adId, String adPwd) {
        // 根据 adId 查询管理员
        Admin admin = this.getById(adId);
        return admin != null && admin.getAdPwd().equals(adPwd);
    }
}
