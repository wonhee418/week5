package com.sparta.week5.controller;

import com.sparta.week5.dto.RestaurantDto;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.RestaurantsRepository;
import com.sparta.week5.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantsService restaurantsService;
    private final RestaurantsRepository restaurantsRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        //레스토랑레포지토리에있는 모든것을 불러오라
        return restaurantsRepository.findAll();
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {
        return restaurantsService.registeredRestaurants(requestDto);
    }


}



