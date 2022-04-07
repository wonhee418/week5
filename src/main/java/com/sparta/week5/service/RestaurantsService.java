package com.sparta.week5.service;

import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    @Transactional
    public Restaurant registeredRestaurants(RestaurantDto requestDto) {
        //컨트롤러에서 dto를 매게변수로 전달받는다.
        //전달받은 dto를 가공한다.
        Long id = requestDto.getId();
        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        //최소 주문금액 유효성 검사
        if (1_000 > minOrderPrice) {
            throw new IllegalStateException("1,000원 이상으로 입력해주세요.");
        } else if (100_000 < minOrderPrice) {
            throw new IllegalStateException("100,000원 이하로 입력해주세요");
        } else if (minOrderPrice % 100 != 0) {
            throw new IllegalStateException("100원 단위로 입력해주세요");
        }

        //기본 배달비 유효성 검사
        if (10_000 < deliveryFee) {
            throw new IllegalStateException("10,000원 이하로 입력해주세요");
        } else if (deliveryFee % 1_000 != 0) {
            throw new IllegalStateException("1,000원 단위로 입력해주세요");
        } else if (deliveryFee % 500 != 0) {
            throw new IllegalStateException("500원 단위로 입력해주세요");
        }

        Restaurant restaurants = new Restaurant(name, minOrderPrice, deliveryFee);
        restaurantsRepository.save(restaurants);
        return restaurants;


    }


}
