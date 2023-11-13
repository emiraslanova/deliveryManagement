package com.div.service;

import com.div.dto.FoodDto;
import com.div.entity.Food;
import com.div.mapper.FoodMapper;
import com.div.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private  final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodDto creatFood(FoodDto foodDto) {
     Food food =  foodMapper.toFood(foodDto);
     Food savedFood = foodRepository.save(food);

        return foodMapper.toFoodDto(savedFood);
    }

    public List<FoodDto> getAllFood() {

        List<Food>all = foodRepository.findAll();
        List<FoodDto>foodDtoList = all.stream()
                .map(foodMapper::toFoodDto)
                .collect(Collectors.toList());
        return foodDtoList;
    }

    public FoodDto getFoodById(Long id) {

        Food food =  foodRepository.findById(id).orElse(null);

        return foodMapper.toFoodDto(food);
    }

    public void updateFoodById(Long id, FoodDto foodDto) {
        Optional<Food>optionalFood = foodRepository.findById(id);
        if(optionalFood.isPresent()){
            Food oldFood = optionalFood.get();
            oldFood.setName(foodDto.getName());
            oldFood.setDesc(foodDto.getDesc());
            oldFood.setAmount(foodDto.getAmount());
            oldFood.setFoodDetails(foodDto.getFoodDetails());
            oldFood.setImage(foodDto.getImage());
            foodRepository.save(oldFood);
        }

    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);

    }
}
