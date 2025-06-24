package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.UserFood;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户膳食选择管理 Mapper 接口
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
public interface UserFoodMapper extends BaseMapper<UserFood> {
    /**
     * 插入或更新用户膳食选择
     * @param userFood 用户膳食信息
     * @return 影响的行数
     */
    int insertOrUpdateUserFood(@Param("et") UserFood userFood);

    /**
     * 根据用户ID和用餐时间查询膳食选择
     * @param idCard 用户ID
     * @param foodDate 用餐时间
     * @return 用户膳食信息
     */
    UserFood selectUserFoodByUserIdAndDate(@Param("idCard") String idCard, @Param("foodDate") String foodDate);
}