package com.commands;

import java.util.ArrayList;

import com.beans.CompanyBean;
import com.business.Company;
import com.dataaccess.select.SelectCompany;

public class CompanyCommand {
	CompanyBean bean = new CompanyBean();
	ArrayList<Company> resultList = null;
	String forwardingPage = null;
	public boolean execute(){
		boolean isSuccess = false;
		SelectCompany da = new SelectCompany();
		//pass it the query you would from the command line (this is specific to the da)
		da.setQuery("Select * from Company");
		if(!da.execute()){
			System.out.println(da.getErrorMessage());
		}else{
			
			resultList = da.getCompanyList();
			bean.setCompanyList(resultList);
			for(int ii=0; ii<resultList.size(); ii++){
				System.out.println(resultList.get(ii).toString());
			}
			isSuccess = true;
		}
		forwardingPage = "showCompanies.jsp";
		return isSuccess;
	}
	public void setParameters(ArrayList<Object>params){

	}
	public String getForwardingPage() {
		return forwardingPage;
	}
	public void setForwardingPage(String forwardingPage) {
		this.forwardingPage = forwardingPage;
	}
	public CompanyBean getBean() {
		return bean;
	}
	public void setBean(CompanyBean bean) {
		this.bean = bean;
	}
	
	
}
