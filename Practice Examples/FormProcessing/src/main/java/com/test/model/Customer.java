package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	@Size(min = 3, max = 20, message = "Customer Name must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Customer Name must be Alphabetic")
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Size(min = 3, max = 20, message = "Customer State must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Customer State must be Alphabetic")
	@Column(name="CUSTOMER_STATE")
	private String customerState;
	
	public Customer() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerState="
				+ customerState + "]";
	}

}
