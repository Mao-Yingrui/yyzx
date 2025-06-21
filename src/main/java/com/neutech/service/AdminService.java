package com.neutech.service;

import com.neutech.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminService extends IService<Admin> {

    boolean login(String adId, String adPwd);

}
