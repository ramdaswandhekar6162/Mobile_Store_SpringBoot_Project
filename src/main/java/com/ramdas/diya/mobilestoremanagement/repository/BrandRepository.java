package com.ramdas.diya.mobilestoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramdas.diya.mobilestoremanagement.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
