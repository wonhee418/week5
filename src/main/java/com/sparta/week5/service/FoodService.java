package com.sparta.week5.service;

import com.sparta.week5.dto.FoodDto;
import com.sparta.week5.model.Food;
import com.sparta.week5.model.Restaurant;
import com.sparta.week5.repository.FoodRepository;
import com.sparta.week5.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;

    //음식점 메뉴판 조회
    @Transactional
    public List<Food> readFood(Long restaurantId) {
        Restaurant restaurant = restaurantsRepository.findById(restaurantId)
                .orElseThrow( () -> new NullPointerException("레스토랑이 없습니다."));
        return foodRepository.findAllByRestaurant(restaurant);
    }

    @Transactional
    public void createfoods(List<Food> foodrequestDto, Restaurant restaurant) {

        for (Food foodInfo : foodrequestDto) {
            String name = foodInfo.getName();
            int price = foodInfo.getPrice();

            // 가격 유효성 검사
            if (100 > price) {
                throw new IllegalStateException("100원 이상으로 등록 가능합니다.");
            } else if (1_000_000 < price) {
                throw new IllegalStateException("1,000,000원 이하로 등록 가능합니다.");
            } else if (price % 100 != 0) {
                throw new IllegalStateException("100원 단위로 등록 가능합니다.");
            }

            // 기존 저장된 음식과 중복 검사
            Long thisRestaurntId = restaurant.getId();
//            System.out.println("레스토랑 아이디 값 " + thisRestaurntId);
            //foodRepository중에서 레스토랑 아이디값이 thisRestaurntId을 가지고 있는 Food들을 리스트에 담기?
            List<Food> thisFoodList = foodRepository.findAllByRestaurantId(thisRestaurntId);
//            System.out.println("음식 이름들 ? "+ thisFoodList);

            // thisFoodList의 리스트를 NameChk에 하나씩 대입하여 for문을 돌린다.
            for( Food NameChk : thisFoodList){
                String name2 = NameChk.getName();
                //새로 등록하려는 음식이름.equals(해당 레스토랑에 있는 음식이름)
                if(name.equals(name2)){
                    throw new IllegalStateException("기존에 등록되어있는 음식입니다.");
                }
            }
            Food food = new Food(name, price, restaurant);
            foodRepository.save(food);
        }
    }

}
