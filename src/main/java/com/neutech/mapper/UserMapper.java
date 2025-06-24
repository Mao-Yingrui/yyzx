package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据身份证号查询用户
     * @param idCard 身份证号
     * @return 用户对象
     */
    User selectByIdCard(@Param("idCard") String idCard);

    /**
     * 自定义更新方法
     * @param user 用户对象
     * @return 是否成功
     */
    boolean updateUserCustom(@Param("et") User user);
}