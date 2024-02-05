package com.ramdas.diya.mobilestoremanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.entity.Sale;
import com.ramdas.diya.mobilestoremanagement.services.CustomerServices;
import com.ramdas.diya.mobilestoremanagement.services.MobilePhoneServices;
import com.ramdas.diya.mobilestoremanagement.services.SellServices;


@Controller
@RequestMapping("/home")
public class Home {
	//return "redirect:/home/product";
	@Autowired(required = true)
	private MobilePhoneServices mobilePhoneSer;
	
	@Autowired(required = true)
	private CustomerServices customerSer;
	
	@Autowired
	private SellServices sellSer;
	
	@GetMapping("/product")
    public String showProductPage(Model model, HttpSession session) {
        // Retrieve user from the session
        Customer loggedInUser = (Customer) session.getAttribute("user");

        // Check if the user is logged in
        if (loggedInUser != null) {
            // Add user data to the model
            model.addAttribute("user", loggedInUser);
            
            model.addAttribute("product", mobilePhoneSer.getAllProduct());
            
            session.setAttribute("user", loggedInUser);

            // Display the product page
            
            
            return "home";
        } else {
            // If user is not logged in, redirect to login page
            return "redirect:/mobile/signin";
        }
    }
	//"@{/order/{pId}/{uId}
	@GetMapping("/order/{pId}/{uId}")
	public String orderPage(@PathVariable("pId") Long pId, @PathVariable("uId") Long uId, Model mod, HttpSession session) {
		
		//session.setAttribute("user", customerSer.findByUserId(uId));
		//session.setAttribute("product", mobilePhoneSer.findByProductId(pId));
		
		session.setAttribute("user", customerSer.findByUserId(uId));
		session.setAttribute("product", mobilePhoneSer.findByProductId(pId));
		
		return "redirect:/sell/order";
	}
	
	///home/orderinfo/{cId}
	
	@GetMapping("/orderinfo/{cId}")
	public String orderInfo(@PathVariable("cId") Long cId,Model mod, HttpSession session) {
		
		Customer loggedUser = (Customer) session.getAttribute("user");
		
		if(loggedUser != null) {
			List<Sale> orders = sellSer.getAllOrders(loggedUser);	
			
			mod.addAttribute("orders", orders);
			
			return "orderinfo";
			
		}
		
		return "signin";
	}
	
	// /orders/cancel/{orderId}
	@GetMapping("/orders/cancel/{orderId}")
	public String orderCancel(@PathVariable("orderId") Long orderId,HttpSession session) {
		
		if(session.getAttribute("user") != null) {
			sellSer.cancelOrder(orderId);
			
			return "redirect:/home/product";
		}
		
		return "mobile/signin";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/mobile/signin";
	}
	
}
