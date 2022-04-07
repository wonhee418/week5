package com.sparta.week5.controller;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.repository.RestaurantsRepository;
import com.sparta.week5.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
//@ResponseStatus(HttpStatus.OK)
public class FoodController {

    private final FoodService foodService;
    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;


    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void addfoods(
            @PathVariable Long restaurantId,
            @RequestBody List<Food> foodrequestDto
    ) {
        Restaurant restaurant = restaurantsRepository.getById(restaurantId);
        foodService.createfoods(foodrequestDto, restaurant);
    }

    // 음식 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> readFood(@PathVariable Long restaurantId) {
        return foodService.readFood(restaurantId);
    }

}