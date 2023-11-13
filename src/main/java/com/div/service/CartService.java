package com.div.service;

import com.div.dto.CartDto;
import com.div.entity.Cart;
import com.div.mapper.CartMapper;
import com.div.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    private  final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public CartDto creatCart(CartDto cartDto) {
        Cart cart = cartMapper.toCart(cartDto);
        Cart  savedCart = cartRepository.save(cart);
        return cartMapper.toCartDto(cart);
    }

    public List<CartDto> getAllCart() {
        List<Cart> all = cartRepository.findAll();
        List<CartDto>cartDtoList = all.stream()
                .map(cartMapper::toCartDto)
                .collect(Collectors.toList());
        return cartDtoList;
    }

    public CartDto getCartById(Long id) {
        Cart cart =  cartRepository.findById(id).orElse(null);
        return cartMapper.toCartDto(cart);
    }

    public void updateCart(Long id, CartDto cartDto) {
        Optional<Cart>cartOptional = cartRepository.findById(id);
        if (cartOptional.isPresent()){
            Cart oldcart = cartOptional.get();
            oldcart.setCount(cartDto.getCount());
            oldcart.setTotalAmount(cartDto.getTotalAmount());
            cartRepository.save(oldcart);
        }

    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);

    }
}
