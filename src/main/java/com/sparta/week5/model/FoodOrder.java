package com.sparta.week5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class FoodOrder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private int quantity;

    public FoodOrder(int quantity) {
        this.quantity = quantity;
    }

}
