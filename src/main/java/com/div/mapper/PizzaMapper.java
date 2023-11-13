package com.div.mapper;

import com.div.dto.PizzaDto;
import com.div.entity.Pizza;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    Pizza toPizza(PizzaDto pizzaDto);

    PizzaDto toPizzaDto(Pizza pizza);






    List<PizzaDto> toPizzaDtoList(List<Pizza> pizzas);
}
