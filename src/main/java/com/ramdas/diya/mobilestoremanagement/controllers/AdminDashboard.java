package com.ramdas.diya.mobilestoremanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ramdas.diya.mobilestoremanagement.entity.Admin;
import com.ramdas.diya.mobilestoremanagement.entity.Brand;
import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.services.BrandServices;
import com.ramdas.diya.mobilestoremanagement.services.CustomerServices;
import com.ramdas.diya.mobilestoremanagement.services.MobilePhoneServices;
import com.ramdas.diya.mobilestoremanagement.services.SellServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminDashboard {
	
	@Autowired
	private BrandServices brandService;
	@Autowired
	private MobilePhoneServices mobilePhoneService;
	
	@Autowired
	private SellServices sellservice;
	
	@Autowired
	private CustomerServices customerservice;
	
	@GetMapping("/dashboard")
	public String adminDashboard(Model mod, HttpSession session) {
		
		Admin foundAdmin = (Admin) session.getAttribute("admin");
		
		if(foundAdmin != null) {
			
			Brand brand = new Brand();
			MobilePhone product = new MobilePhone();
			mod.addAttribute("brand",brand);
			mod.addAttribute("product",product);
			
			mod.addAttribute("brandInfo", brandService.getAllBrand());
			mod.addAttribute("productInfo", mobilePhoneService.getAllProduct());
			
			session.setAttribute("admin", foundAdmin);
			return "dashboard";
		} else {
			return "redirect:/mobile/signin";
		}
	}
	
	//@{/admin/addbrand}
	@PostMapping("/addbrand")
	public String addBrand(@ModelAttribute("brand") Brand brand, HttpSession session) {
		
		if(session.getAttribute("admin") != null) {
			
			//System.out.println("brandName");
			System.out.println("object" + brand.getName());
			
			brandService.saveBrand(brand);
			session.setAttribute("admin", session.getAttribute("admin"));
			
			return "redirect:/admin/dashboard";
		} else {
			return "redirect:/mobile/signin";
		}
	}
	//@{/update/{bId}
	@GetMapping("/update/{bId}")
	public String updateBrand(@RequestParam("bId") Long bId, HttpSession session, Model mod) {
		
		Admin foundUser = (Admin) session.getAttribute("admin");
		
		if(foundUser != null) {
		Brand brand = (Brand) brandService.findById(bId);
		System.out.print(brand.getName());
		mod.addAttribute("brand", brand);
		session.setAttribute("admin", foundUser);
		return "update";
		} else {
			return "dashboard";
		}
	}
	@PostMapping("/update/save")
	public String updateBrandSave(@ModelAttribute("brand") Brand brand, Model mod, HttpSession session) {
		if(session.getAttribute("admin") != null) {
			
			brandService.saveBrand(brand);
		return "redirect:/admin/dashboard";
		} else {
			return "signin";
		}
	}
	
	@GetMapping("/delete/{bId}")
	public String deleteBrand(@PathVariable("bId") Long bId, HttpSession session, RedirectAttributes redirectAttributes) {

	    if (session.getAttribute("admin") != null) {
	        try {
	            brandService.deleteBrandById(bId);
	            return "redirect:/admin/dashboard";
	        } catch (Exception ex) {
	            // Check if the exception is due to a foreign key constraint violation
	            if (ex.getMessage().contains("violates foreign key constraint")) {
	                redirectAttributes.addFlashAttribute("error", "Cannot delete. This brand is still referenced in other tables.");
	            } else {
	                redirectAttributes.addFlashAttribute("error", "Error deleting brand");
	            }
	            return "redirect:/admin/dashboard";
	        }
	    } else {
	        return "redirect:/mobile/signin";
	    }
	}

	
//	@GetMapping("/delete/{bId}")
//	public String deleteBrand(@PathVariable("bId") Long bId, HttpSession session) {
//		
//		if(session.getAttribute("admin") != null) {
//		
//		brandService.deleteBrandById(bId);
//		
//		return "redirect:/admin/dashboard";
//		} else {
//			return "/mobile/signin";
//		}
//		
//	}
	
	@PostMapping("/addmobile")
	public String addMobile(@ModelAttribute("product") MobilePhone mobile, HttpSession session) {
		
		if(session.getAttribute("admin") != null) {
			mobilePhoneService.saveMobilePhone(mobile);
			return "redirect:/admin/dashboard";
		} else {
			return "/mobile/signin";
		}
	}
	//@{/admin/mobileupdate/{mId}
	@GetMapping("/mobileupdate/{mId}")
	public String updateMobileInfo(@PathVariable("mId") long mId, HttpSession session, Model mod) {
		if(session.getAttribute("admin") != null) {
			
			MobilePhone product = (MobilePhone) mobilePhoneService.findByProductId(mId);
			mod.addAttribute("product",product);
			session.setAttribute("admin", session.getAttribute("admin"));
			
			return "updatemobileinto";
		} else {
			return "/mobile/signin";
		}
	}
	
	// updatemobile
	
	@PostMapping("/updatemobile")
	public String updateMobile(@ModelAttribute("product") MobilePhone updatedProduct, HttpSession session) {
	    
	    if (session.getAttribute("admin") != null) {
	        MobilePhone existingProduct = mobilePhoneService.findByProductId(updatedProduct.getId());
	        existingProduct.setId(updatedProduct.getId());
	        existingProduct.setBrand(updatedProduct.getBrand());
	        existingProduct.setModelName(updatedProduct.getModelName());
	        existingProduct.setPrice(updatedProduct.getPrice());
	        existingProduct.setStorageCapacity(updatedProduct.getStorageCapacity());

	        mobilePhoneService.saveMobilePhone(existingProduct);

	        return "redirect:/admin/dashboard";
	    }

	    return "redirect:/mobile/signin";
	}

	
	///admin/mobiledelete/{mId}
	@GetMapping("/mobiledelete/{mId}")
	public String deleteMobileInfo(@PathVariable("mId") Long mId, HttpSession session) {
		
		if(session.getAttribute("admin") != null) {
			mobilePhoneService.deleteMobilePhone(mId);
			
			return "redirect:/admin/dashboard";
		} else {
			return "/mobile/signin";
		}
	}
	
	// nav bar feature for admin
	
	@GetMapping("admin/orders")
	public String showOrders(Model mod,HttpSession session) {
		
		if(session.getAttribute("admin") != null) {
			mod.addAttribute("orders",sellservice.allOrders());
			
			return "adminOrders";
		}
		
		
		return "redirect:/mobile/signin";
	}
	
	//admin/customers
	@GetMapping("admin/customers")
	public String showCustomers(Model mod, HttpSession session) {
		if(session.getAttribute("admin") != null) {
		mod.addAttribute("customers", customerservice.allCustomers() );
		return "adminCustomer";
		}
		return "mobile/signin";
	}
	
	
}
