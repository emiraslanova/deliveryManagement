package com.div.controller;

import com.div.dto.OrderDto;
import com.div.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private  final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping

    public OrderDto creatOrder(@RequestBody OrderDto orderDto){

        return orderService.creatOrder(orderDto);
    }

    @GetMapping
    public List<OrderDto> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")

    public OrderDto getOrderById(@PathVariable Long id){

     return    orderService.getOrderById(id);
    }

    @PutMapping("/{id}")

    public  void  updateOrderById(@PathVariable Long id , @RequestBody OrderDto orderDto){

        orderService.updateOrderById(id,orderDto);

    }
    @DeleteMapping("/{id}")

    public  void  deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
