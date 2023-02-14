package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 예제 6.28
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeProductNameDto {

    private Long number;

    private String name;
}
