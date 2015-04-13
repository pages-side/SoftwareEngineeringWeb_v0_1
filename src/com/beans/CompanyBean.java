package com.beans;

import java.util.ArrayList;

import com.business.Company;

public class CompanyBean {
	ArrayList<Company> companyList = null;
	public CompanyBean(){
		
	}
	public ArrayList<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}
	
	
	
}
