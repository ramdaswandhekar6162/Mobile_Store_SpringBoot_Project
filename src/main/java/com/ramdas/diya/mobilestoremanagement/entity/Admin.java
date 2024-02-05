package com.ramdas.diya.mobilestoremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="username")
	private String username;
	@Column(name="password")
	String password;
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	Admin(){
		
	}
	public Admin(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
	
	
	
	
}
