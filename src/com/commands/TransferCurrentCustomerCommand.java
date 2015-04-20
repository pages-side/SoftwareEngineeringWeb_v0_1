package com.commands;

import java.util.ArrayList;

import com.beans.LandingPageBean;
import com.command.parameters.CommandParameter;
import com.dataaccess.insert.InsertCurrentCustomer;
import com.dataaccess.update.EndCurrentCustomer;

/**
 * This class transfers a currently playing customer from one game to another
 *
 */
public class TransferCurrentCustomerCommand {
	private String errorMessage = "";
	private String cno;
	private String cname;
	private String game;
	private LandingPageBean results = new LandingPageBean();
	private String forwardingPage = null;
	
	/**!!!This method stops a customer on one game. Customer is still on the current table, but it starts an additional record of 
	 * customer on new game!!!
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
