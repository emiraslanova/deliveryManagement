package com.div.service;


import com.div.dto.OrderDto;
import com.div.entity.Order;
import com.div.mapper.OrderMapper;
import com.div.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

//import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @InjectMocks
private OrderService orderService;
    private MockMvc mockMvc;
    @Mock
    private OrderMapper orderMapper;

    @Mock
    private OrderRepository orderRepository;

    @Test
    void creatOrder() throws Exception {
        String requestJason =  "{ \"place\": \"baki\", \"status\": true}";
         mockMvc.perform(MockMvcRequestBuilders
                 .post("/order")
                 .contentType("application/json")
                 .content(requestJason))
                 .andExpect(status().isOk());



//        OrderDto orderDto = new OrderDto();
//        orderDto.setPlace("Baki");
//        orderDto.setStatus(true);
//        OrderDto createdOrderDto = orderService.creatOrder(orderDto);
//        assertNotNull(createdOrderDto);


    }

    @Test
    void getAllOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/order")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))


                .andExpect(jsonPath("[0].place").exists())
                .andExpect(jsonPath("[0].status").exists())

                .andExpect(jsonPath("[1].place").exists())
                .andExpect(jsonPath("[1].status").exists());

    }

    @Test
    void getOrderById() throws Exception {
        Long orderId = 1L;

        mockMvc.perform(MockMvcRequestBuilders
                .get("/order",orderId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect( jsonPath("[1]").exists());;

    }

    @Test
    void updateOrderById() {
        Long orderId = 1L;

        OrderDto updateOrderDto =  new OrderDto();
        updateOrderDto.setPlace("new place");
        updateOrderDto.setStatus(true);

        Order numuneOrder = new Order();
        numuneOrder.setId(orderId);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(numuneOrder));
        orderService.updateOrderById(orderId,updateOrderDto);
    verify(orderRepository,times(1)).save(numuneOrder);


    assertEquals(updateOrderDto.getPlace(),numuneOrder.getPlace());
    assertEquals(updateOrderDto.isStatus(),numuneOrder.isStatus());

    }

    @Test
    void deleteOrder() {
        Long orderId =  1L;
        doNothing().when(orderRepository).deleteById(any());
       orderService.deleteOrder(orderId);
       verify(orderRepository,times(1)).deleteById(1L);
    }

}