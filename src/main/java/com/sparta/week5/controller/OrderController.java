package com.sparta.week5.controller;


import com.sparta.week5.dto.FoodOrderRequestDto;
import com.sparta.week5.dto.OrderDto;
import com.sparta.week5.dto.OrderRequestDto;
import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.model.Order;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.FoodOrderRepository;
import com.sparta.week5.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    public final OrderService orderService;

    @PostMapping("/order/request")
    public void createRestaurant(
            @RequestBody FoodOrderRequestDto foodOrderRequestDto,
            @RequestBody OrderRequestDto orderRequestDto
    ) {
        orderService.quantityChk(foodOrderRequestDto, orderRequestDto);
    }

    @GetMapping("/orders")
    public List<Order> order(@RequestBody OrderDto orderDto){

        return orderService.orders(orderDto);
    }


}
