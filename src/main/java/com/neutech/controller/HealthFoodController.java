package com.neutech.controller;

import com.neutech.entity.Food;
import com.neutech.entity.UserFood;
import com.neutech.service.HealthFoodService;
import com.neutech.service.UserFoodService;
import com.neutech.vo.FoodCalendarVO;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 健康管家膳食管理控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/health/food")
public class HealthFoodController {

    @Autowired
    private HealthFoodService healthFoodService;

    @Autowired
    private UserFoodService userFoodService; // 新增注入

    /**
     * 健康管家查看膳食菜单页面
     * 健康管家传入json格式：
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * 食物ID（food_id）：int
     * 食物名称（food_name）：字符串
     * 食物种类（food_type）（主食/蔬菜/肉类/汤类）
     * 食物口味（food_taste)：字符串
     */
    @GetMapping("/menu")
    public ResultJson listHealthFoodMenu(@RequestParam String foodDate) {
        List<Food> foodList = healthFoodService.getFoodByDate(foodDate);
        return new ResultJson(200, foodList, "查询成功");
    }

    /**
     * 健康管家增加膳食页面
     * 健康管家传入json格式：
     * 食物ID（food_id）：int
     * 食物名称（food_name）：字符串
     * 食物种类（food_type）（主食/蔬菜/肉类/汤类）
     * 食物口味（food_taste)：字符串
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * "添加成功"或"添加失败"
     */
    @PostMapping("/add")
    public ResultJson addHealthFood(@RequestBody Food food) {
        boolean result = healthFoodService.addFood(food);
        return result ? new ResultJson(200, null, "添加成功") : new ResultJson(500, null, "添加失败");
    }

    /**
     * 健康管家删除膳食页面
     * 健康管家传入json格式：
     * 食物ID（food_id）：int
     * 传出json格式：
     * "删除成功"或"删除失败"
     */
    @DeleteMapping("/delete")
    public ResultJson deleteHealthFood(@RequestParam Integer foodId) {
        boolean result = healthFoodService.deleteFood(foodId);
        return result ? new ResultJson(200, null, "删除成功") : new ResultJson(500, null, "删除失败");
    }

    /**
     * 健康管家更改膳食日历页面
     * 健康管家传入json格式：
     * 食物ID（food_id）：int
     * 食物名称（food_name）：字符串
     * 食物种类（food_type）（主食/蔬菜/肉类/汤类）
     * 食物口味（food_taste)：字符串
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * "更新成功"或"更新失败"
     */
    @PutMapping("/update")
    public ResultJson updateHealthFood(@RequestBody Food food) {
        boolean result = healthFoodService.updateFood(food);
        return result ? new ResultJson(200, null, "更新成功") : new ResultJson(500, null, "更新失败");
    }

    /**
     * 健康管家查看膳食日历页面
     * 健康管家传入json格式：
     * 用户ID（user_id）：int
     * 用餐时间（food_date）：字符串
     * 传出json格式：
     * 早餐（breakfast）：字符串
     * 午餐（lunch）：字符串
     * 晚餐（dinner）：字符串
     */
    @GetMapping("/calendar")
    public ResultJson getHealthFoodCalendar(@RequestParam Integer userId, @RequestParam String foodDate) {
        UserFood userFood = userFoodService.getUserFoodByUserIdAndDate(userId, foodDate);
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