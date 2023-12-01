package com.practice.springPractice.repositories.mysqlRepo;

import com.practice.springPractice.entity.mysqlEntities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}