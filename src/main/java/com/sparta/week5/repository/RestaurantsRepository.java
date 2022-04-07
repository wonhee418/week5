package com.sparta.week5.repository;

import com.sparta.week5.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAll();
//    Restaurant findById(Long restaurantId);
}
