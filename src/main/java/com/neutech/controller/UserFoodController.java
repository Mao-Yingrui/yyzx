package com.neutech.controller;

import com.neutech.entity.Food;
import com.neutech.entity.UserFood;
import com.neutech.service.FoodService;
import com.neutech.service.UserFoodService;
import com.neutech.vo.FoodCalendarVO;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户膳食管理控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/user/food")
public class UserFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserFoodService userFoodService;

    /**
     * 用户查看膳食菜单页面
     * 用户传入json格式：
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * 食物ID（food_id）：int
     * 食物名称（food_name）：字符串
     * 食物种类（food_type）（主食/蔬菜/肉类/汤类）
     * 食物口味（food_taste)：字符串
     */
    @GetMapping("/menu")
    public ResultJson listFoodMenu(@RequestParam String foodDate) {
        List<Food> foodList = foodService.getFoodByDate(foodDate);
        return new ResultJson(200, foodList, "查询成功");
    }

    /**
     * 用户选择膳食页面
     * 用户传入json格式：
     * 用户ID（user_id）：int
     * 用餐时间（food_date）：字符串
     * 早餐（breakfast）：字符串
     * 午餐（lunch）：字符串
     * 晚餐（dinner）：字符串
     * 传出json格式：
     * "选择成功！"
     */
    @PostMapping("/select")
    public ResultJson selectFood(@RequestBody UserFood userFood) {
        boolean result = userFoodService.saveOrUpdateUserFood(userFood);
        return result ? new ResultJson(200, null, "选择成功！") : new ResultJson(500, null, "选择失败");
    }

    /**
     * 用户查看膳食日历页面
     * 用户传入json格式：
     * 用户ID（user_id）：int
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * 早餐（breakfast）：字符串
     * 午餐（lunch）：字符串
     * 晚餐（dinner）：字符串
     */
    @GetMapping("/calendar")
    public ResultJson getFoodCalendar(@RequestParam String idCard, @RequestParam String foodDate) {
        UserFood userFood = userFoodService.getUserFoodByUserIdAndDate(idCard, foodDate);
        if (userFood != null) {
            FoodCalendarVO response = new FoodCalendarVO(
                    userFood.getBreakfast(),
                    userFood.getLunch(),
                    userFood.getDinner()
            );
            return new ResultJson(200, response, "查询成功");
        } else {
            return new ResultJson(404, null, "未找到膳食记录");
        }
    }
}