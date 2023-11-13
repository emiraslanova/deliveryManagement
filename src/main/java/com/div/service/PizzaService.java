package com.div.service;

import com.div.dto.PizzaDto;
import com.div.entity.Pizza;
import com.div.mapper.PizzaMapper;
import com.div.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private  final PizzaRepository pizzaRepository;
    private  final PizzaMapper pizzaMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    public PizzaDto creatPizza(PizzaDto pizzaDto) {
        Pizza pizza = pizzaMapper.toPizza(pizzaDto);
        Pizza savedPizza = pizzaRepository.save(pizza);
        PizzaDto savedPizzaDto = pizzaMapper.toPizzaDto(savedPizza);
        return savedPizzaDto;
    }

    public List<PizzaDto> getAllPizza() {
        List<Pizza>pizzas = pizzaRepository.findAll();
        return pizzaMapper.toPizzaDtoList(pizzas);
    }

    public PizzaDto getPizzaById(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        return pizzaMapper.toPizzaDto(pizza) ;
    }

    public void updatePizza(Long id, PizzaDto pizzaDto) {
        Optional<Pizza>optionalPizza = pizzaRepository.findById(id);
        if (optionalPizza.isPresent()){
            Pizza oldPizza = optionalPizza.get();
            oldPizza.setName(pizzaDto.getName());
        }

    }


    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);

    }
}
