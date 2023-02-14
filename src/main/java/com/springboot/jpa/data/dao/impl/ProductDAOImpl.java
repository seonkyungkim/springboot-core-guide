package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product){
        // Product 엔티티를 데이터베이스에 저장하는 기능

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        // 단건 조회를 위한 기본 메서드 getById(), findById() -> getById는 getReferenceById로 대체

        Product selectedProduct = productRepository.getReferenceById(number);
//        Optional<Product> selectedProduct = productRepository.findById(number);
        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        // Product 데이터의 상품명 업데이트
        Optional<Product> selectedProduct = productRepository.findById(number);
        Product updatedProduct;

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            // JPA 는 값을 갱신할 때 update 대신 영속성 컨텍스트를 활용해 값을 갱신합니다.
            // find()를 통해 DB 에서 데이터를 가져오면 그 객체를 영속성 컨텍스트에 추가합니다.
            // 영속성 컨텍스트가 유지되는 상황에서 객체의 값을 변경하고 다시 save()를 실행하면 더티체크를 통해 변경을 감지합니다.
            updatedProduct = productRepository.save(product);

        }else{
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            // 레코드 삭제를 위해서는 해당 레코드와 매핑된 영속 객체를 영속성 컨텍스트에 가져와야 합니다.
            // findById()로 객체를 가져오고 delete()로 해당 객체의 삭제를 요청합니다.
            productRepository.delete(product);
        }else{
            throw new Exception();
        }
    }
}
