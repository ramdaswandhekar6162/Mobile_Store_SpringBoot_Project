package com.ramdas.diya.mobilestoremanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Brand;

@Service
public interface BrandServices {
	
	List<Brand> getAllBrand();
	
	Brand saveBrand(Brand brand);

	Brand findById(Long bId);

	void deleteBrandById(long bId);
}
