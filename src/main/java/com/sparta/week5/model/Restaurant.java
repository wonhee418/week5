package com.sparta.week5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Entity // DB 테이블 역할을 합니다.
public class Restaurant {
        // ID가 자동으로 생성 및 증가합니다.
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private int minOrderPrice;

        @Column(nullable = false)
        private int deliveryFee;

        public Restaurant(String name, int minOrderPrice, int deliveryFee) {
            this.name = name;
            this.minOrderPrice = minOrderPrice;
            this.deliveryFee = deliveryFee;
        }

//        // 생성
//        public Restaurant(RestaurantDto requstdto) {
//            this.name = requstdto.getName();
//            this.minOrderPrice = requstdto.getMinOrderPrice();
//            this.deliveryFee = requstdto.getDeliveryFee();
//        }

//        // 수정
//        public void Restaurants(RestaurantDto requestDto) {
//            this.name = requestDto.getName();
//            this.minOrderPrice = requestDto.getMinOrderPrice();
//            this.deliveryFee = requestDto.getDeliveryFee();
//        }

}
