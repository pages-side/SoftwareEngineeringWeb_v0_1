package com.beans;

import java.util.ArrayList;

import com.business.Customer;

public class CustomerBean {
	ArrayList<Customer> customerList = null;
	public CustomerBean(){
		
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	
	
	
}
