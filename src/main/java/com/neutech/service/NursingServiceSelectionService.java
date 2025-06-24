package com.neutech.service;

import com.neutech.dto.NursingServiceSelectionDTO;
import com.neutech.vo.ResultJson;

public interface NursingServiceSelectionService {
    /**
     * 处理护理服务选择
     * @param selectionDTO 选择DTO
     * @param idCard 用户身份证号
     * @return 操作结果
     */
    ResultJson processNursingServiceSelection(NursingServiceSelectionDTO selectionDTO, String idCard);
}