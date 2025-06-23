package com.neutech.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodCalendarVO {
    private String breakfast;
    private String lunch;
    private String dinner;
}