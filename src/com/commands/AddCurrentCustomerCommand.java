package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCurrentCustomer;

public class AddCurrentCustomerCommand {
	private String errorMessage = "";
	private String cno;
	private String cname;
	private String game;
	private LandingPageBean results = new LandingPageBean();
	private String forwardingPage = null;
	
	
	public boolean execute(){
		boolean isSuccess = false;
		InsertCurrentCustomer da = new InsertCurrentCustomer();
		da.setCno(this.cno);
		da.setCname(this.cname);
		da.setGame(this.game);
		if(!da.execute()){
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
				if("customerNo".equals(params.get(ii).getName())){
					this.cno = params.get(ii).getValue();
				}
				if("customerName".equals(params.get(ii).getName())){
					this.cname = params.get(ii).getValue();
				}
				if("customergameadd".equals(params.get(ii).getName())){
					this.game = params.get(ii).getValue();
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
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
