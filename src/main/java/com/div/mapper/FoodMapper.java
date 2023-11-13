package com.div.mapper;

import com.div.dto.FoodDto;
import com.div.entity.Food;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {


    Food toFood (FoodDto foodDto);
    FoodDto toFoodDto(Food food);
}
