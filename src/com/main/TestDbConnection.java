package com.main;

import java.util.ArrayList;

import com.business.Company;
import com.dataaccess.select.SelectCompany;

public class TestDbConnection {

	public static void main(String[] args) {
		ArrayList<Company> resultList = null;
		//Create a data accessor to select something from the DB
		SelectCompany da = new SelectCompany();
		//pass it the query you would from the command line (this is specific to the da)
		da.setQuery("Select * from Company");
		if(!da.execute()){
			System.out.println(da.getErrorMessage());
		}else{
			resultList = da.getCompanyList();
			for(int ii=0; ii<resultList.size(); ii++){
				System.out.println(resultList.get(ii).toString());
			}
		}
		//do it again to make sure all connections are closed and we don't get a binding exception for port in use
		da = new SelectCompany();
		da.setQuery("Select * from Company");
		if(!da.execute()){
			System.out.println(da.getErrorMessage());
		}else{
			resultList = da.getCompanyList();
			for(int ii=0; ii<resultList.size(); ii++){
				System.out.println(resultList.get(ii).toString());
			}
		}
		System.out.println("TEST COMPLETE;");
		System.exit(0);
	}
}
