package com.sparta.week5.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodDto {
//    private Long id;
    private String name;
    private int price;
}