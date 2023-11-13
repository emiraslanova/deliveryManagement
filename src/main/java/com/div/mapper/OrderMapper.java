package com.div.mapper;

import com.div.dto.OrderDto;
import com.div.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {



    Order toOrder(OrderDto orderDto);
    OrderDto toOrderDto(Order order);






}
