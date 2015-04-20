package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCurrentCustomer;

/**
 * This class adds customers to the currently playing table
 *
 */
public class AddCurrentCustomerCommand {
	private String errorMessage = "";
	private String cno;
	private String cname;
	private String game;
	private LandingPageBean results = new LandingPageBean();
	private String forwardingPage = null;
	
	
	/**This method adds customers to the currently playing database
	 * @return
	 */
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
	/**This method uses a for loop and the CommandParameter to get needed attributes from the database
	 * @param params
	 */
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
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the game
	 */
	public String getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(String game) {
		this.game = game;
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
