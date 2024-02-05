package com.ramdas.diya.mobilestoremanagement.services;

import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Admin;

@Service
public interface AdminServices {
	
	Admin findByAdminEmail(String username);
}
