package com.neutech.controller;

import com.neutech.dto.NursingServiceSelectionDTO;
import com.neutech.service.NursingServiceSelectionService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/nursing-service")
public class NursingServiceSelectionController {

    @Autowired
    private NursingServiceSelectionService nursingServiceSelectionService;

    /**
     * 用户选择护理内容1页面
     */
    @PostMapping("/select-service1")
    public ResultJson selectService1(@RequestBody NursingServiceSelectionDTO selectionDTO, @RequestParam String idCard) {
        return nursingServiceSelectionService.processNursingServiceSelection(selectionDTO, idCard);
    }

    /**
     * 用户选择护理内容2页面
     */
    @PostMapping("/select-service2")
    public ResultJson selectService2(@RequestBody NursingServiceSelectionDTO selectionDTO, @RequestParam String idCard) {
        return nursingServiceSelectionService.processNursingServiceSelection(selectionDTO, idCard);
    }

    /**
     * 用户选择护理内容3页面
     */
    @PostMapping("/select-service3")
    public ResultJson selectService3(@RequestBody NursingServiceSelectionDTO selectionDTO, @RequestParam String idCard) {
        return nursingServiceSelectionService.processNursingServiceSelection(selectionDTO, idCard);
    }

    /**
     * 用户选择护理内容4页面
     */
    @PostMapping("/select-service4")
    public ResultJson selectService4(@RequestBody NursingServiceSelectionDTO selectionDTO, @RequestParam String idCard) {
        return nursingServiceSelectionService.processNursingServiceSelection(selectionDTO, idCard);
    }

    /**
     * 用户选择护理内容5页面
     */
    @PostMapping("/select-service5")
    public ResultJson selectService5(@RequestBody NursingServiceSelectionDTO selectionDTO, @RequestParam String idCard) {
        return nursingServiceSelectionService.processNursingServiceSelection(selectionDTO, idCard);
    }
}