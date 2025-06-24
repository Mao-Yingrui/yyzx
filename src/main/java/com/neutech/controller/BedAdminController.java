package com.neutech.controller;

import com.neutech.entity.Bed;
import com.neutech.service.BedAdminService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员 - 床位信息管理控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/admin/bed")
public class BedAdminController {
    @Autowired
    private BedAdminService bedAdminService;

    /**
     * 查看空闲床位信息
     *
     * @return ResultJson 包含空闲床位列表及操作状态
     */
    @GetMapping("/list/free")
    public ResultJson listFreeBeds() {
        List<Bed> freeBeds = bedAdminService.listFreeBeds();
        return new ResultJson(200, freeBeds, "查询成功");
    }

    /**
     * 分配床位
     *
     * @param userId 用户身份证号
     * @param bedId  床位ID
     * @return ResultJson 操作结果
     */
    @PostMapping("/assign")
    public ResultJson assignBed(
            @RequestParam String userId,
            @RequestParam Integer bedId
    ) {
        boolean result = bedAdminService.assignBed(bedId, userId);
        return result ? new ResultJson(200, null, "分配成功") : new ResultJson(500, null, "分配失败");
    }

    /**
     * 查看已占床位信息
     *
     * @return ResultJson 包含已占床位列表及操作状态
     */
    @GetMapping("/list/occupied")
    public ResultJson listOccupiedBeds() {
        List<Bed> occupiedBeds = bedAdminService.listOccupiedBeds();
        return new ResultJson(200, occupiedBeds, "查询成功");
    }
}