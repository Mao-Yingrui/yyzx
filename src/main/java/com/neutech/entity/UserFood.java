package com.neutech.entity;

import lombok.Data;

@Data
public class UserFood {
    private Integer userId;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String foodDate;
}