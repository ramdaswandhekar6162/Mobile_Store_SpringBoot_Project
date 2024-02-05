package com.ramdas.diya.mobilestoremanagement.entity;

import java.util.Date;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sale_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name ="phone_id")
	private MobilePhone mobilephone;
	
	@Column(name = "sale_date")
	private Date date;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name ="total_amount")
	private Double totalAmount;
	
	

	public Sale() {
	}

	public Sale(Long id, Customer customer, MobilePhone mobilephone, Date date, Integer quantity, Double totalAmount) {
		super();
		this.id = id;
		this.customer = customer;
		this.mobilephone = mobilephone;
		this.date = date;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MobilePhone getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(MobilePhone mobilephone) {
		this.mobilephone = mobilephone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
}
