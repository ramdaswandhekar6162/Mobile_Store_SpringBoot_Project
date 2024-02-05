package com.ramdas.diya.mobilestoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.ramdas.diya.mobilestoremanagement.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findByUsername(String username);
}
