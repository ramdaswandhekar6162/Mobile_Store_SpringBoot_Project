package com.ramdas.diya.mobilestoremanagement.services.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Admin;
import com.ramdas.diya.mobilestoremanagement.repository.AdminRepository;
import com.ramdas.diya.mobilestoremanagement.services.AdminServices;

@Service
public class AdminServiceImpl implements AdminServices{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Admin findByAdminEmail(String username) {
		// TODO Auto-generated method stub
		return this.adminRepo.findByUsername(username);
	}

}
