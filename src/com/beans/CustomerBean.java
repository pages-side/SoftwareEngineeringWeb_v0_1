package com.beans;

import java.util.ArrayList;

import com.business.Customer;

/**
 * This returns an array list of all customers who fulfill the paramaters of a query
 *
 */
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
