package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.business.Customer;
import com.command.parameters.CommandParameter;
import com.dataaccess.select.SelectCurrentCustomers;

public class LandingPageCommand {
	private LandingPageBean results = new LandingPageBean();
	private ArrayList<Customer> currentCustomerList = new ArrayList<Customer>();
	private ArrayList<Customer> finishedCustomerList = new ArrayList<Customer>();
	private String forwardingPage = null;
	public LandingPageCommand(){}
	
	public boolean execute(){
		boolean isSuccess = false;
		
		SelectCurrentCustomers da = new SelectCurrentCustomers();
		if(!da.execute()){
			results.setErrorMessage("Unable to get current customers");
		}else{
			currentCustomerList = da.getCustomerList();
			results.setCurrentCustomerList(currentCustomerList);
			finishedCustomerList = da.getFinishedCustomerList();
			results.setFinishedCustomerList(finishedCustomerList);
			isSuccess = true;
		}
		return isSuccess;
	}
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){

			}
		}
	}
	public String getForwardingPage() {
		return forwardingPage;
	}
	public void setForwardingPage(String forwardingPage) {
		this.forwardingPage = forwardingPage;
	}


	public ArrayList<Customer> getCurrentCustomerList() {
		return currentCustomerList;
	}


	public void setCurrentCustomerList(ArrayList<Customer> currentCustomerList) {
		this.currentCustomerList = currentCustomerList;
	}

	public ArrayList<Customer> getFinishedCustomerList() {
		return finishedCustomerList;
	}

	public void setFinishedCustomerList(ArrayList<Customer> finishedCustomerList) {
		this.finishedCustomerList = finishedCustomerList;
	}

	public LandingPageBean getResults() {
		return results;
	}

	public void setResults(LandingPageBean results) {
		this.results = results;
	}
	
}
