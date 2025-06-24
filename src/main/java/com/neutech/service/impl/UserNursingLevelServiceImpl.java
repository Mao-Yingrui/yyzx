package com.neutech.service.impl;

import com.neutech.dto.NursingScoreDTO;
import com.neutech.entity.UserNursingLevel;
import com.neutech.mapper.UserNursingLevelMapper;
import com.neutech.service.UserNursingLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNursingLevelServiceImpl implements UserNursingLevelService {

    @Autowired
    private UserNursingLevelMapper userNursingLevelMapper;

    @Override
    public UserNursingLevel getNursingLevelByIdCard(String idCard) {
        return userNursingLevelMapper.selectNursingLevelByIdCard(idCard);
    }

    @Override
    public String calculateAndUpdateNursingLevel(int[] scores, String idCard) {
        // 计算总分
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        // 根据总分确定护理级别
        String nursingLevel;
        if (totalScore == 100) {
            nursingLevel = "无依赖";
        } else if (totalScore >= 61 && totalScore <= 99) {
            nursingLevel = "轻度依赖";
        } else if (totalScore >= 41 && totalScore <= 60) {
            nursingLevel = "中度依赖";
        } else if (totalScore >= 1 && totalScore <= 40) {
            nursingLevel = "重度依赖";
        } else {
            nursingLevel = "无级别"; // 默认值，理论上不会发生
        }

        // 更新用户护理级别
        UserNursingLevel userNursingLevel = new UserNursingLevel();
        userNursingLevel.setIdCard(idCard);
        userNursingLevel.setNursingLevel(nursingLevel);

        int result = userNursingLevelMapper.updateNursingLevel(userNursingLevel);
        if (result > 0) {
            return nursingLevel;
        } else {
            return "计算失败"; // 实际项目中应该抛出异常或返回更详细的错误信息
        }
    }

    // 新增方法：使用NursingScoreDTO作为参数
    public String calculateAndUpdateNursingLevel(NursingScoreDTO scoreDTO, String idCard) {
        // 从DTO中获取10个分数
        int[] scores = {
                scoreDTO.getOne(),
                scoreDTO.getTwo(),
                scoreDTO.getThree(),
                scoreDTO.getFour(),
                scoreDTO.getFive(),
                scoreDTO.getSix(),
                scoreDTO.getSeven(),
                scoreDTO.getEight(),
                scoreDTO.getNine(),
                scoreDTO.getTen()
        };

        // 调用原有的计算方法
        return calculateAndUpdateNursingLevel(scores, idCard);
    }
}