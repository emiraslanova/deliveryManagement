package com.div.controller;

import com.div.dto.FoodDto;
import com.div.entity.Food;
import com.div.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private  final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

     @PostMapping
     public FoodDto creatFood(@RequestBody FoodDto foodDto){
        return foodService.creatFood(foodDto);
     }
     @GetMapping
     public List<FoodDto> getAllFood(){
        return  foodService.getAllFood();
     }
    @GetMapping("/{id}")
    public FoodDto getFoodById(@PathVariable Long id){
       return foodService.getFoodById(id);
    }
    @PutMapping("/{id}")
    public  void  updateFoodById(@PathVariable Long id,@RequestBody FoodDto foodDto){
        foodService.updateFoodById(id,foodDto);
    }
    @DeleteMapping("/{id}")
    public  void  deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
    }

}
