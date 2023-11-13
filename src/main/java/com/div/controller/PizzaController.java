package com.div.controller;

import com.div.dto.PizzaDto;

import com.div.response.BaseResponse;
import com.div.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public BaseResponse<PizzaDto> creatPizza(@RequestBody PizzaDto pizzaDto) {
        try {
            return BaseResponse.success( pizzaService.creatPizza(pizzaDto));
        } catch (Exception ex) {
            return BaseResponse.fail();
        }

    }

    @GetMapping
    public List<PizzaDto> getAllPizza() {
        return pizzaService.getAllPizza();

    }

    @GetMapping("/{id}")
    public BaseResponse<PizzaDto> getPizzaById(@PathVariable long id) {
        try {
            return BaseResponse.success( pizzaService.getPizzaById(id));

        } catch (Exception ex) {
            return BaseResponse.fail();

        }

    }

    @PutMapping("/{id}")
    public  void  updatePizza(@PathVariable long id,@RequestBody PizzaDto pizzaDto){
        pizzaService.updatePizza(id, pizzaDto);
    }
    @DeleteMapping
    public  void deletePizza(@PathVariable long id){
        pizzaService.deletePizza(id);
    }
}


