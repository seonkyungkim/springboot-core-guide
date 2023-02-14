package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository 는 엔티티가 생성한 데이터베이스에 접근하는데 사용됨
// JpaRepository 를 상속받을 때는 대상 엔티티와 기본값 타입을 지정해야 함
// 여기서는 entity 패키지 아래의 Product 파일을 엔티티로 사용할 것이므로 Product, 그리고 해당 엔티티의 Id 필드타입인 Long 설정
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository 를 상속받으면서 별도의 메서드 구현 없이도 많은 기능을 사용할 수 있음
}
