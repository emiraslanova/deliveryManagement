package com.div.controller;

import com.div.dto.CartDto;
import com.div.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private  final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public CartDto creatCart(@RequestBody CartDto cartDto){
        return cartService.creatCart(cartDto);
    }

    @GetMapping
    public List<CartDto> getAllCart(){
        return cartService.getAllCart();
    }

    @GetMapping("/{id}")
    public CartDto getCartById(@PathVariable Long id){
        return cartService.getCartById(id);
    }

    @PutMapping("/{id}")
    public void updateCart(@PathVariable Long id, @RequestBody CartDto cartDto){
        cartService.updateCart(id,cartDto);

    }

    @DeleteMapping("/{id}")
    public  void  deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }
}


