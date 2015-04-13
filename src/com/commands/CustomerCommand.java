package com.commands;

import java.util.ArrayList;

import com.beans.CustomerBean;
import com.business.Customer;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCustomer;
import com.dataaccess.select.SelectCustomer;

public class CustomerCommand {
	
	ArrayList<Customer> resultList = null;
	CustomerBean bean = new CustomerBean();
	SelectCustomer select = null;
	InsertCustomer insert = null;
	private int cno = -1;
	private String cName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String sMemberStatus;
	private String mode;
	
	String forwardingPage = null;
	
	public CustomerCommand(){
		
	}
	public boolean execute(){
		boolean isSuccess = false;
		if("search".equals(mode)){
			select = new SelectCustomer();
			select.setCno(cno);
			select.setcName(cName);
			select.setAddress(address);
			select.setCity(city);
			select.setState(state);
			select.setZip(zip);
			select.setPhone(phone);
			select.setsMemberStatus(sMemberStatus);
			
			if(!select.execute()){
				System.out.println(select.getErrorMessage());
				forwardingPage = "error.jsp";
				return false;
			}else{
				resultList = select.getCustomerList();
				bean.setCustomerList(resultList);
				for(int ii=0; ii<resultList.size(); ii++){
					System.out.println(resultList.get(ii).toString());
				}
				isSuccess = true;
			}
			if(select.isAll()){
				forwardingPage = "showCustomers.jsp";
			}else{
				forwardingPage = "showCustomerSearch.jsp";
			}
		}else{
			insert = new InsertCustomer();
			insert.setCno(cno);
			insert.setcName(cName);
			insert.setMemberStatus(sMemberStatus);
			
			if(!insert.execute()){
				System.out.println(insert.getErrorMessage());
				forwardingPage = "error.jsp";
				return false;
			}else{
				resultList = insert.getCustomerList();
				bean.setCustomerList(resultList);
				for(int ii=0; ii<resultList.size(); ii++){
					System.out.println(resultList.get(ii).toString());
				}
				isSuccess = true;
			}
			
			forwardingPage = "showCustomerSearch.jsp";
			
		}
		return isSuccess;
	}
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){
				if("cno".equals(params.get(ii).getName())){
					cno = Integer.parseInt(params.get(ii).getValue());
				}
				if("cName".equals(params.get(ii).getName())){
					cName = params.get(ii).getValue();
				}
				if("address".equals(params.get(ii).getName())){
					address = params.get(ii).getValue();
				}
				if("city".equals(params.get(ii).getName())){
					city = params.get(ii).getValue();
				}
				if("city".equals(params.get(ii).getName())){
					city = params.get(ii).getValue();
				}
				if("state".equals(params.get(ii).getName())){
					state = params.get(ii).getValue();
				}
				if("zip".equals(params.get(ii).getName())){
					zip = params.get(ii).getValue();
				}
				if("phone".equals(params.get(ii).getName())){
					phone = params.get(ii).getValue();
				}
				if("memberStatus".equals(params.get(ii).getName())){
					sMemberStatus = params.get(ii).getValue();
				}
				if("mode".equals(params.get(ii).getName())){
					mode = params.get(ii).getValue();
				}
			}
		}
	}
	public String getForwardingPage() {
		return forwardingPage;
	}
	public void setForwardingPage(String forwardingPage) {
		this.forwardingPage = forwardingPage;
	}
	public CustomerBean getBean() {
		return bean;
	}
	public void setBean(CustomerBean bean) {
		this.bean = bean;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
}
