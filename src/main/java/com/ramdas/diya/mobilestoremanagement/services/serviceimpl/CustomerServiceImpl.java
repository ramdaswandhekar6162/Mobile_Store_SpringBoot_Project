package com.ramdas.diya.mobilestoremanagement.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.exception.CustomeException;
import com.ramdas.diya.mobilestoremanagement.repository.CustomerRepository;
import com.ramdas.diya.mobilestoremanagement.services.CustomerServices;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer CustomerSave(Customer cus) {
		// TODO Auto-generated method stub
		this.customerRepo.save(cus);
		
		return this.customerRepo.findById(cus.getId()).get();
		
	}

	@Override
	public Customer findByUserEmail(String email) {
		// TODO Auto-generated method stub
		
		return this.customerRepo.findByEmail(email);
	}

	@Override
	public Customer findByUserId(Long id) {
		// TODO Auto-generated method stub
		System.out.println(customerRepo.findById(id));
		return this.customerRepo.findById(id).orElseThrow(() -> new CustomeException("User not Found" + id));
	}

	@Override
	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
