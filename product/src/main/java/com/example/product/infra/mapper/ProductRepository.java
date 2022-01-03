package com.example.product.infra.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.infra.po.ProductPO;

public interface ProductRepository extends JpaRepository<ProductPO, Long> {

}
