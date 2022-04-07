package com.sparta.week5.repository;

import com.sparta.week5.model.Food;
import com.sparta.week5.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
    List<Food> findAllByRestaurant(Restaurant restaurant);
    List<Food> findAllByRestaurantId(Long thisRestaurntId);
    Optional<Food> findByname(String name);

//    Optional<Food> findById(Long restaurantId);

}