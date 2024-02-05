package com.ramdas.diya.mobilestoremanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;

@Service
public interface CustomerServices {
	
	public Customer CustomerSave(Customer cus);
	
	public Customer findByUserEmail(String email);
	
	public Customer findByUserId(Long id);
	
	public List<Customer> allCustomers();
}
