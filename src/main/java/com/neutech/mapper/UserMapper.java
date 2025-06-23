package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    boolean updateUserCustom(@Param("et") User user);

    /**
     * 查询 is_in 为 1 并且其 id_card 在 record 表中不存在记录的用户
     */
    List<User> selectInUsersNotInRecord();
}