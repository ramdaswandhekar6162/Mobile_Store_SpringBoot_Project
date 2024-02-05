package com.ramdas.diya.mobilestoremanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramdas.diya.mobilestoremanagement.entity.Brand;
import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;
import com.ramdas.diya.mobilestoremanagement.repository.BrandRepository;
import com.ramdas.diya.mobilestoremanagement.repository.CustomerRepository;
import com.ramdas.diya.mobilestoremanagement.repository.MobilePhoneRepository;
import com.ramdas.diya.mobilestoremanagement.repository.SaleRepository;

@RestController
@RequestMapping("apitest")
public class ApiControl {
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private MobilePhoneRepository mobilephoneRepo;
	
	@Autowired 
	private SaleRepository saleRepo;
	
	@PostMapping("/brandsave")
	public String brandSave(@RequestBody Brand mb) {
		
		this.brandRepo.save(mb);
		
		return "Save into databse";
	}
	
	@PostMapping("/customersave")
	public ResponseEntity<String> customerSave(@RequestBody Customer cus){
		this.customerRepo.save(cus);
		
		return ResponseEntity.ok("Save Customer data");
	}
	
	@PostMapping("/mobilephonesave")
	public ResponseEntity<String> mobilephoneSave(@RequestBody MobilePhone mp){
		
		this.mobilephoneRepo.save(mp);
		
		return ResponseEntity.ok("Moblile phone save done");
	}
	
	@PostMapping("/salesave")
	public ResponseEntity<String> sale(@RequestBody Sale sl ){
		
		this.saleRepo.save(sl);
		
		return ResponseEntity.ok("Sale Details are save");
	}
}