package com.ramdas.diya.mobilestoremanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;

@Service
public interface MobilePhoneServices {

	public List<MobilePhone> getAllProduct();
	
	public MobilePhone findByProductId(Long id);

	public void saveMobilePhone(MobilePhone mobile);

	public void deleteMobilePhone(Long mId);
}
