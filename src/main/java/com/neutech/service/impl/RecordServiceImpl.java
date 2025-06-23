package com.neutech.service.impl;

import com.neutech.entity.Record;
import com.neutech.mapper.RecordMapper;
import com.neutech.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public boolean addRecord(Record record) {
        if (record.getTime() == null) {
            // 使用当前时间作为默认值，并将其转换为字符串
            record.setTime(String.valueOf(new java.sql.Date(new java.util.Date().getTime())));
        }
        int result = recordMapper.insert(record);
        return result > 0;
    }
}