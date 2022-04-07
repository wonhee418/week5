package com.sparta.week5.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sparta.week5.dto.FoodDto;
import lombok.*;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    public Food(String name, int price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

//    // 생성
//    public Food(FoodDto requstdto, Restaurant restaurant) {
//        this.name = requstdto.getName();
//        this.price = requstdto.getPrice();
//        this.restaurant = restaurant;
//    }

}