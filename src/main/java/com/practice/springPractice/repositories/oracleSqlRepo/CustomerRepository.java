package com.practice.springPractice.repositories.oracleSqlRepo;

import com.practice.springPractice.entity.oracleSqlEntities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}