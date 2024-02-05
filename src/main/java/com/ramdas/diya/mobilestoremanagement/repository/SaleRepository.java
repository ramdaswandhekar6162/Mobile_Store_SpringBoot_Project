package com.ramdas.diya.mobilestoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	public List<Sale> findByCustomer(Customer uId);

}
