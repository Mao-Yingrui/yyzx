package com.neutech.service;

import com.neutech.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface AdminService extends IService<Admin> {

    boolean login(String adId, String adPwd);

}
