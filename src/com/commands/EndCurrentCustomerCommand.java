package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCurrentCustomer;
import com.dataaccess.update.EndCurrentCustomer;

public class EndCurrentCustomerCommand {
	private String errorMessage = "";
	private String cno;
	private LandingPageBean results = new LandingPageBean();
	private String forwardingPage = null;
	
	/**Stops charging a customer, but does not cash them out
	 * @return a value telling the program its ok to move on
	 */
	public boolean execute(){
		boolean isSuccess = false;
		EndCurrentCustomer da = new EndCurrentCustomer();
		da.setCno(this.cno);
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
	/**This method uses a for loop and the CommandParameter to get needed attributes from the database
	 * @param params
	 */
	public void setParameters(ArrayList<CommandParameter>params){
		if(params != null && !params.isEmpty()){
			for(int ii=0; ii< params.size(); ii++){
				if("cno".equals(params.get(ii).getName())){
					this.cno = params.get(ii).getValue();
				}
			}
		}
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * @param cno the cno to set
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * @return the results
	 */
	public LandingPageBean getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(LandingPageBean results) {
		this.results = results;
	}
	/**
	 * @return the forwardingPage
	 */
	public String getForwardingPage() {
		return forwardingPage;
	}
	/**
	 * @param forwardingPage the forwardingPage to set
	 */
	public void setForwardingPage(String forwardingPage) {
		this.forwardingPage = forwardingPage;
	}
	
}
