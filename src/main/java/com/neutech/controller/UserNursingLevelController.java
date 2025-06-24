package com.neutech.controller;

import com.neutech.entity.UserNursingLevel;
import com.neutech.service.UserNursingLevelService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neutech.dto.NursingScoreDTO;

@RestController
@RequestMapping("/user/nursing")
public class UserNursingLevelController {

    @Autowired
    private UserNursingLevelService userNursingLevelService;

    /**
     * 用户查看护理级别页面
     * 用户传入json格式：
     * 用户ID（user_id）：int (实际使用身份证号)
     * 传出json格式：
     * 护理级别（nursing_level）：无依赖/轻度依赖/中度依赖/重度依赖/无级别
     */
    @GetMapping("/level")
    public ResultJson getNursingLevel(@RequestParam String idCard) {
        UserNursingLevel userNursingLevel = userNursingLevelService.getNursingLevelByIdCard(idCard);
        if (userNursingLevel != null) {
            return new ResultJson(200, userNursingLevel.getNursingLevel(), "查询成功");
        } else {
            return new ResultJson(404, null, "未找到护理级别记录");
        }
    }

    /**
     * 用户填表确认护理级别页面
     * 用户传入json格式：
     * 用户ID（user_id）：int (实际使用身份证号)
     * 项目1（one）：int
     * 项目2（two）：int
     * 项目3（three）：int
     * 项目4（four）：int
     * 项目5（five）：int
     * 项目6（six）：int
     * 项目7（seven）：int
     * 项目8（eight）：int
     * 项目9（nine）：int
     * 项目10（ten）：int
     * 传出json格式：
     * 护理级别（nursing_level）：无依赖/轻度依赖/中度依赖/重度依赖/无级别
     */
    @PostMapping("/confirm-level")
    public ResultJson confirmNursingLevel(@RequestBody NursingScoreDTO scores, @RequestParam String idCard) {
        String nursingLevel = userNursingLevelService.calculateAndUpdateNursingLevel(
                new int[]{scores.getOne(), scores.getTwo(), scores.getThree(),
                        scores.getFour(), scores.getFive(), scores.getSix(),
                        scores.getSeven(), scores.getEight(), scores.getNine(),
                        scores.getTen()}, idCard);
        return new ResultJson(200, nursingLevel, "计算成功");
    }
}