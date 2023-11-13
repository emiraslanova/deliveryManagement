package com.div.service;

import com.div.dto.OrderDto;
import com.div.entity.Order;
import com.div.mapper.OrderMapper;
import com.div.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

     private  final  OrderRepository orderRepository;
     private  final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto creatOrder(OrderDto orderDto) {

        Order order = orderMapper.toOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderDto(savedOrder);
    }

    public List<OrderDto> getAllOrder() {
        List<Order> all =  orderRepository.findAll();
        List<OrderDto>orderDtoList = all.stream()
        .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
        return orderDtoList;
    }

    public OrderDto getOrderById(Long id) {
        Order order =  orderRepository.findById(id).orElse(null);
        return orderMapper.toOrderDto(order);
    }

    public void updateOrderById(Long id, OrderDto orderDto) {
        Optional<Order>optionalOrder = orderRepository.findById(id);
       if (optionalOrder.isPresent()){
           Order oldOrder = optionalOrder.get();
           oldOrder.setPlace(orderDto.getPlace());
           oldOrder.setStatus(orderDto.isStatus());
           orderRepository.save(oldOrder);
        }

    }

    public void deleteOrder(Long id) {
       orderRepository.deleteById(id);
    }
}
