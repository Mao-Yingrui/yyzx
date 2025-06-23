package com.neutech.controller;

import com.neutech.entity.Record;
import com.neutech.service.RecordService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Resource
    RecordService recordService;

    @PostMapping("/add")
    ResultJson addRecord(@RequestParam String id_card) {
        // 构造Record对象用于后续操作
        Record record = new Record();
        record.setUserId(id_card);
        // 调用服务层添加登记记录
        boolean isAdded = recordService.addRecord(record);

        if (isAdded) {
            return new ResultJson(200, null, "登记记录添加成功");
        } else {
            return new ResultJson(500, null, "登记记录添加失败");
        }
    }
}