package com.neutech.service;

import com.neutech.entity.UserNursingLevel;

public interface UserNursingLevelService {
    /**
     * 查询用户护理级别
     * @param idCard 用户ID(身份证号)
     * @return 护理级别对象
     */
    UserNursingLevel getNursingLevelByIdCard(String idCard);

    /**
     * 计算并更新用户护理级别
     * @param scores 十个项目分数
     * @param idCard 用户ID(身份证号)
     * @return 护理级别字符串
     */
    String calculateAndUpdateNursingLevel(int[] scores, String idCard);
}