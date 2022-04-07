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
    // Dto를 받아와서 registeredRestaurants에 dto를 인자로 넣어주고
    // registeredRestaurants에서 dto를 받아서 dto의 내용을 불러와 변수로 설정해주고
    // 그 변수들로 유효성검사를 진행한후
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {
        return restaurantsService.registeredRestaurants(requestDto);
    }


    //
//    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
//    @PostMapping("/restaurant/register")
//    public Restaurants createRestaurant(@RequestBody RestaurantDto requestDto) {
//        // requestDto 는, 생성 요청을 의미합니다.
//        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
//        // 그 정보를 가져오는 녀석입니다.
//
//        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
//        // 잠시 뒤 새로운 생성자를 만듭니다.
//        Restaurants restaurants = new Restaurants(requestDto);
//
//        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
//        return restaurantsRepository.save(restaurants);
//    }



}



