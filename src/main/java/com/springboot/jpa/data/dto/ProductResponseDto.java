package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

}
