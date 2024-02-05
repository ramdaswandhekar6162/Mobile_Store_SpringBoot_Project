package com.ramdas.diya.mobilestoremanagement.services;

import java.util.List;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
//import com.ramdas.diya.mobilestoremanagement.entity.Customer;
//import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;

public interface SellServices {
	
	public Sale orderSave(Sale sell);
	
	public List<Sale> getAllOrders(Customer  uId);

	public void cancelOrder(Long orderId);
	
	public List<Sale> allOrders();
}
