package com.ramdas.diya.mobilestoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
		
	Customer findByEmail(String email);
}
