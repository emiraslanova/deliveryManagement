package com.div.mapper;

import com.div.dto.CartDto;
import com.div.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toCart(CartDto cartDto);
    CartDto toCartDto(Cart cart);
}
