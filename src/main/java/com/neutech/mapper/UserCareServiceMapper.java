package com.neutech.mapper;

import com.neutech.entity.UserCareServiceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCareServiceMapper {
    /**
     * 根据用户身份证号查询用户护理服务
     * @param idCard 用户身份证号
     * @return 护理服务列表
     */
    List<UserCareServiceVO> selectUserCareServices(@Param("idCard") String idCard);

    /**
     * 更新用户护理服务剩余次数
     * @param careId 护理服务ID
     * @param remainingCount 剩余次数
     * @return 影响的行数
     */
    int updateUserCareServiceRemainingCount(@Param("careId") Integer careId, @Param("remainingCount") Integer remainingCount);
}