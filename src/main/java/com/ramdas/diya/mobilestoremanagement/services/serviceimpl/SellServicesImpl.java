package com.ramdas.diya.mobilestoremanagement.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
//import com.ramdas.diya.mobilestoremanagement.entity.Customer;
//import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;
import com.ramdas.diya.mobilestoremanagement.repository.SaleRepository;
import com.ramdas.diya.mobilestoremanagement.services.SellServices;

@Service
public class SellServicesImpl implements SellServices{
	
	@Autowired
	private SaleRepository sellRepo;
	
	@Override
	public Sale orderSave(Sale sell) {
		// TODO Auto-generated method stub
		
		
		
		return this.sellRepo.save(sell);
	}

	@Override
	public List<Sale> getAllOrders(Customer uId) {
		// TODO Auto-generated method stub
		List<Sale> orders = sellRepo.findByCustomer(uId);
		
		
		return orders;
	}

	@Override
	public void cancelOrder(Long orderId) {
		// TODO Auto-generated method stub
		
		sellRepo.deleteById(orderId);
		
	}

	@Override
	public List<Sale> allOrders() {
		// TODO Auto-generated method stub
		
		
		return sellRepo.findAll();
	}

}
