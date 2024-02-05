package com.ramdas.diya.mobilestoremanagement.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;
//import com.ramdas.diya.mobilestoremanagement.services.CustomerServices;
//import com.ramdas.diya.mobilestoremanagement.services.MobilePhoneServices;
import com.ramdas.diya.mobilestoremanagement.services.SellServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sell")
public class Order {
	
	@Autowired(required = true)
	private SellServices sellSer;
	
	@GetMapping("/order")
	public String orderInfo(Model mod,HttpSession session) {
		System.out.println("this is session info"+session.getAttribute("user"));
		System.out.println(session.getAttribute("product"));
		
		Customer user = (Customer)session.getAttribute("user");
		MobilePhone product = (MobilePhone) session.getAttribute("product");
		System.out.println(product.getPrice());
		
		
		
		mod.addAttribute("user",user);
		mod.addAttribute("product",product);
		
		session.setAttribute("user",user);
		session.setAttribute("product", product);
		
		return "order";
	}
	@PostMapping("/order/place")
	public String orderPlaced(@RequestParam("customerId") long id,@RequestParam("productId") long productId,@RequestParam("quantity") int quantity, HttpSession session) {
		
		Sale order = new Sale();
		Date date = new Date();
		
		Customer user = (Customer) session.getAttribute("user");
		MobilePhone product = (MobilePhone)session.getAttribute("product");
		
		order.setCustomer(user);
		order.setMobilephone(product);
		order.setDate(date);
		order.setQuantity(quantity);
		order.setTotalAmount(product.getPrice() * quantity);
		
		sellSer.orderSave(order);
		
		session.setAttribute("user", user);
		
		return "redirect:/home/product";
	}
	
//	@GetMapping("/order/place")
//	public String orderPlaced(Model mod, HttpSession session) {
//		
//		Customer user = (Customer) session.getAttribute("user");
//		MobilePhone product = (MobilePhone)session.getAttribute("product");
//		
//		Sale order = new Sale();
//		Date date = new Date();
//		
//		order.setCustomer(user);
//		order.setMobilephone(product);
//		order.setQuantity(1);
//		order.setTotalAmount(product.getPrice() * 1);
//		order.setDate(date);
//		//System.out.println(quntity);
//		
//		sellSer.orderSave(order);
//		
//		mod.addAttribute("user",user);
//		//mod.addAttribute("product", product);
//		
//		session.setAttribute("user", session.getAttribute("user"));
//		//session.setAttribute("product", session.getAttribute("product"));
//		
//		
//		return "redirect:/home/product";
//	}
}
