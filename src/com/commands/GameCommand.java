package com.commands;

import java.util.ArrayList;

import com.beans.GameBean;
import com.business.Game;
import com.dataaccess.select.SelectGame;

public class GameCommand {
	GameBean bean = new GameBean();
	ArrayList<Game> resultList = null;
	String forwardingPage = null;
	
	/**Uses GameBean to return all games 
	 * @return a value telling the program its ok to move on  
	 */
	public boolean execute(){
		boolean isSuccess = false;
		SelectGame da = new SelectGame();
		//pass it the query you would from the command line (this is specific to the da)
		da.setQuery("Select * from s_games");
		if(!da.execute()){
			System.out.println(da.getErrorMessage());
		}else{
			
			resultList = da.getGameList();
			bean.setGameList(resultList);
			for(int i=0; i<resultList.size(); i++){
				System.out.println(resultList.get(i).toString());
			}
			isSuccess = true;
		}
		forwardingPage = "showGames.jsp";
		return isSuccess;
	}
	
	
	//Getters & Setters
	/**not needed yet
	 * @param params
	 */
	public void setParameters(ArrayList<Object>params){

	}
	/**
	 * @return the bean
	 */
	public GameBean getBean() {
		return bean;
	}
	/**
	 * @param bean the bean to set
	 */
	public void setBean(GameBean bean) {
		this.bean = bean;
	}
	/**
	 * @return the resultList
	 */
	public ArrayList<Game> getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(ArrayList<Game> resultList) {
		this.resultList = resultList;
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
