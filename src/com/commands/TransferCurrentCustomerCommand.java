package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCurrentCustomer;
import com.dataaccess.update.EndCurrentCustomer;

public class TransferCurrentCustomerCommand {
	private String errorMessage = "";
	private String cno;
	private String cname;
	private String game;
	private LandingPageBean results = new LandingPageBean();
	private String forwardingPage = null;
	public boolean execute(){
		boolean isSuccess = false;
		EndCurrentCustomer da = new EndCurrentCustomer();
		da.setCno(this.cno);
		if(!da.execute()){
			this.errorMessage = "Unable to insert customer";
		}else{
			isSuccess = true;
		}InsertCurrentCustomer da1 = new InsertCurrentCustomer();
		da1.setCno(this.cno);
		da1.setCname(this.cname);
		da1.setGame(this.game);
		if(!da1.execute()){
			this.errorMessage = "Unable to insert customer";
		}else{
			isSuccess = true;
		}
		
		LandingPageCommand cmd = new LandingPageCommand();
		if(!cmd.execute()){
			this.errorMessage = this.errorMessage + "/n" + "Error loading landing page";
			forwardingPage = "errorPage";
		}else{
			results.setCurrentCustomerList(cmd.getCurrentCustomerList());
			results.setFinishedCustomerList(cmd.getFinishedCustomerList());
			forwardingPage = "landingPage.jsp";
		}
		return isSuccess;
	}
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){
				if("cno".equals(params.get(ii).getName())){
					this.cno = params.get(ii).getValue();
				}
			}
		}
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public LandingPageBean getResults() {
		return results;
	}
	public void setResults(LandingPageBean results) {
		this.results = results;
	}
	public String getForwardingPage() {
		return forwardingPage;
	}
	public void setFowardingPage(String fowardingPage) {
		this.forwardingPage = fowardingPage;
	}
	
}
