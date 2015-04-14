package com.commands;

import java.util.ArrayList;

import com.beans.CompanyBean;
import com.business.Company;
import com.command.parameters.CommandParameter;
import com.dataaccess.select.SelectCompany;
import com.dataaccess.select.SelectUser;

public class LoginCommand {
	String userName = null;
	String password = null;
	String forwardingPage = null;
	public boolean execute(){
		SelectUser da = new SelectUser();
		//pass it the query you would from the command line (this is specific to the da)
		da.setUserName(this.userName);
		da.setPassword(this.password);
		if(!da.execute()){
			forwardingPage = "/failedLogin.jsp";
		}else{
			forwardingPage = "/landingPage.jsp";	
		}
		
		return true;
	}
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){
				if("username".equals(params.get(ii).getName())){
					this.userName = params.get(ii).getValue();
				}
				if("password".equals(params.get(ii).getName())){
					this.password = params.get(ii).getValue();
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
