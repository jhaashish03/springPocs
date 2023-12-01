package com.practice.springPractice.repositories.oracleSqlRepo;

import com.practice.springPractice.entity.oracleSqlEntities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}