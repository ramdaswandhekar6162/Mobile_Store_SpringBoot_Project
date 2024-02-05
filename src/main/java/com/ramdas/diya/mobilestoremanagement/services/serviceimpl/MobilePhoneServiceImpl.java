package com.ramdas.diya.mobilestoremanagement.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.MobilePhone;
import com.ramdas.diya.mobilestoremanagement.repository.MobilePhoneRepository;
import com.ramdas.diya.mobilestoremanagement.services.MobilePhoneServices;


@Service
public class MobilePhoneServiceImpl implements MobilePhoneServices {
	
	@Autowired
	private MobilePhoneRepository mobilePhoneRepo;
	
	@Override
	public List<MobilePhone> getAllProduct() {
		// TODO Auto-generated method stub
		List<MobilePhone> list = mobilePhoneRepo.findAll();
		
		return list;
	}

	@Override
	public MobilePhone findByProductId(Long id) {
		// TODO Auto-generated method stub
		return mobilePhoneRepo.findById(id).get();
	}

	@Override
	public void saveMobilePhone(MobilePhone mobile) {
		// TODO Auto-generated method stub
		mobilePhoneRepo.save(mobile);
		
	}

	@Override
	public void deleteMobilePhone(Long mId) {
		// TODO Auto-generated method stub
		
		mobilePhoneRepo.deleteById(mId);
		
	}

}
