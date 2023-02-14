package com.springboot.jpa.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")  // 클래스의 이름과 테이블의 이름을 다르게 지정해야 하는 경우에 사용한다.
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Id 어노테이션과 함게 사용됨. 해당 필드의 값을 어떤 방식으로 자동 생성할지 결정할 때 사용. IDENTITY 는 데이터베이스의 AUTO_INCREMENT 를 기본값으로 사용
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
