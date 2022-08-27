package com.example.entity.repository;

import com.example.entity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByType(String Type);
    List<Product> findByCategoryAndSector(String Category, String Sector);
}