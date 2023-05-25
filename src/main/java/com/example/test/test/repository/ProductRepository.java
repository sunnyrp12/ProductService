package com.example.test.test.repository;

import com.example.test.test.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductMaster, UUID> {

    ProductMaster findByProductId(Integer productId);


}
