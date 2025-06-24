package com.neutech.mapper;

import com.neutech.entity.User;
import com.neutech.entity.Bed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HealthManagerUserMapper {
    /**
     * 查询健康管家管理的用户列表(包含用户信息和位置信息)
     * @param healthHomeId 健康管家ID
     * @return 用户列表(包含用户信息和位置信息)
     */
    List<User> selectManagedUsersWithLocation(@Param("healthHomeId") String healthHomeId);

    // 注意：由于User实体类没有location字段，我们需要使用Bed实体类来获取位置信息
    // 可能需要返回一个包含User和Bed信息的组合对象
    // 这里简化处理，先定义接口，具体实现可以在Service层组合

    /**
     * 查询健康管家管理的用户身份证号列表
     * @param healthHomeId 健康管家ID
     * @return 用户身份证号列表
     */
    List<String> selectManagedUserIds(@Param("healthHomeId") String healthHomeId);
}