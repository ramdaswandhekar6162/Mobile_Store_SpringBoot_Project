package com.ramdas.diya.mobilestoremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="mobile_phone")
public class MobilePhone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="phone_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "storage_capacity")
	private Integer storageCapacity;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "img_url", length = 10000)
	private String img;
	
	
	public MobilePhone() {
		
	}
	public MobilePhone(Long id, Brand brand, String modelName, Integer storageCapacity, Double price, String img) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelName = modelName;
		this.storageCapacity = storageCapacity;
		this.price = price;
		this.img = img;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(Integer storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
