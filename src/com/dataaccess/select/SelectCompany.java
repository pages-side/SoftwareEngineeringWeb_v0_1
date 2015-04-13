package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Company;
import com.dataaccess.DbAccessor;

public class SelectCompany extends DbAccessor {
	ArrayList<Company> companyList = new ArrayList<Company>();
	public SelectCompany(){	}
	
	public SelectCompany(String query){
		super.setQuery(query);
	}
	
	@Override
	public boolean execute(){
		return super.execute();
	}
	
	public boolean processResult(ResultSet rs) throws SQLException{
		boolean isSuccess = false;
		while(rs.next()){
			Company company = new Company();
			company.setCompanyNo(rs.getString("COMPANY_NO"));
			company.setCompanyName(rs.getString("COMPANY_NAME"));
			company.setStreet(rs.getString("STREET"));
			company.setCity("CITY");
			company.setCompanyState(rs.getString("COMPANY_STATE"));
			company.setZip(rs.getString("ZIP"));
			company.setPhone(rs.getString("PHONE"));
			companyList.add(company);
			isSuccess = true;
		}
		return isSuccess;
	}

	public ArrayList<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}
	
}
