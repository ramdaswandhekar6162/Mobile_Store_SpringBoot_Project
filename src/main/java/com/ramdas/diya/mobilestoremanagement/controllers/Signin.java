package com.ramdas.diya.mobilestoremanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramdas.diya.mobilestoremanagement.entity.Admin;
import com.ramdas.diya.mobilestoremanagement.entity.Customer;
import com.ramdas.diya.mobilestoremanagement.services.AdminServices;
import com.ramdas.diya.mobilestoremanagement.services.CustomerServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mobile")
public class Signin {
	
	@Autowired(required = true)
	private CustomerServices customerService;
	
	@Autowired(required = true)
	private AdminServices adminService;
	
	@GetMapping("/signin")
	public String singIn(Model mod) {
		
		mod.addAttribute("user", new Customer());
		
		return "Signin";
	}
	
	@GetMapping("/register")
	public String register(Model mod) {
		
		mod.addAttribute("user", new Customer());
		
		return "registration";
		
	}
	
	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user") Customer user) {
		
		customerService.CustomerSave(user);
		return "redirect:/mobile/signin";
	}
	
	@PostMapping("/login")
	public String userLogin(@ModelAttribute("user") Customer user, Model mod, HttpSession session) {
		
		Customer foundCustomer = customerService.findByUserEmail(user.getEmail());
		
		if(foundCustomer != null && foundCustomer.getPhoneNumber().equals(user.getPhoneNumber())) {
			
			session.setAttribute("user", foundCustomer);
			return "redirect:/home/product";
		} else {
		
		return "redirect:/mobile/signin";
		}
	}
	
	@PostMapping("/adminlogin")
	public String adminLogin(@RequestParam("adminUsername") String username, @RequestParam("adminPassword") String password ,HttpSession session) {
		
		System.out.println(username);
		
		Admin admin = adminService.findByAdminEmail(username);
		if(admin != null && admin.getPassword().equals(password)) {
			session.setAttribute("admin", admin);
			
			return "redirect:/admin/dashboard";
		} else {
			return "redirect:/mobile/signin";
		}
	}
	
}

