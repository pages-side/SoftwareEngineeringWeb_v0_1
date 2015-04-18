package com.beans;

import java.util.ArrayList;

import com.business.Customer;

public class LandingPageBean {
	private ArrayList<Customer>currentCustomerList = null;
	private ArrayList<Customer>finishedCustomerList = null;
	private String errorMessage;
	public LandingPageBean(){}

	public ArrayList<Customer> getCurrentCustomerList() {
		return currentCustomerList;
	}

	public void setCurrentCustomerList(ArrayList<Customer> currentCustomerList) {
		this.currentCustomerList = currentCustomerList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ArrayList<Customer> getFinishedCustomerList() {
		return finishedCustomerList;
	}

	public void setFinishedCustomerList(ArrayList<Customer> finishedCustomerList) {
		this.finishedCustomerList = finishedCustomerList;
	}
	
	
}
