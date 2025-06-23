package com.neutech.entity;

import lombok.Data;

@Data
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodType; // 主食/蔬菜/肉类/汤类
    private String foodTaste;
    private String foodDate;
}