package com.sparta.week5.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
public class FoodOrderRequestDto {
    Long id;
    int quantity;
}
