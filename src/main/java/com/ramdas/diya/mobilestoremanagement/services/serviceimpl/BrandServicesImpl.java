package com.ramdas.diya.mobilestoremanagement.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Brand;
import com.ramdas.diya.mobilestoremanagement.repository.BrandRepository;
import com.ramdas.diya.mobilestoremanagement.services.BrandServices;

import com.ramdas.diya.mobilestoremanagement.exception.CustomeException;

@Service
public class BrandServicesImpl implements BrandServices {
		
	@Autowired
	private BrandRepository brandRepo;

	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandRepo.findAll();
	}

	@Override
	public Brand saveBrand(Brand brand) {
		// TODO Auto-generated method stub
		
		return this.brandRepo.save(brand);
	}

	@Override
	public Brand findById(Long bId) {
		// TODO Auto-generated method stub
		
		
		return brandRepo.findById(bId).orElseThrow(() -> new CustomeException("brand not found" + bId));
	}

	@Override
	public void deleteBrandById(long bId) {
		// TODO Auto-generated method stub
		
		brandRepo.deleteById(bId);
		
	}
	
}
