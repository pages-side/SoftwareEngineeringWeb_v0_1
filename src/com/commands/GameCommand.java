package com.commands;

import java.util.ArrayList;

import com.beans.GameBean;
import com.business.Game;
import com.dataaccess.select.SelectGame;

public class GameCommand {
	GameBean bean = new GameBean();
	ArrayList<Game> resultList = null;
	String forwardingPage = null;
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
	public void setParameters(ArrayList<Object>params){

	}
	public String getForwardingPage() {
		return forwardingPage;
	}
	public void setForwardingPage(String forwardingPage) {
		this.forwardingPage = forwardingPage;
	}
	public GameBean getBean() {
		return bean;
	}
	public void setBean(GameBean gameBean) {
		bean = gameBean;
	}
	
	
}
