package com.practice.springPractice.repositories.mysqlRepo;

import com.practice.springPractice.entity.mysqlEntities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}