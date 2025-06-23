package com.neutech.mapper;

import com.neutech.entity.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordMapper {
    int insert(@Param("et") Record record);
}