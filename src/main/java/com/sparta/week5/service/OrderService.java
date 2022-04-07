package com.sparta.week5.service;

import com.sparta.week5.dto.FoodOrderRequestDto;
import com.sparta.week5.dto.OrderDto;
import com.sparta.week5.dto.OrderRequestDto;
import com.sparta.week5.model.FoodOrder;
import com.sparta.week5.model.Order;
import com.sparta.week5.repository.FoodOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final FoodOrderRepository foodOrderRepository;


    // 주문하기
    public void quantityChk(FoodOrderRequestDto foodOrderRequestDto , OrderRequestDto orderRequestDto) {
        int quantity = foodOrderRequestDto.getQuantity();

        if(quantity < 0){
            throw new IllegalStateException("최소 주문수량은 1개 이상입니다.");
        } else if(quantity > 100){
            throw new IllegalStateException("최대 주문수량은 100개 이하입니다.");
        }

        FoodOrder foodOrder = new FoodOrder(quantity);
        foodOrderRepository.save(foodOrder);
    }


    //주문 조회하기
    public List<Order> orders(OrderDto orderDto) {

        return null;
    }
}
