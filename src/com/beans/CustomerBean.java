package com.beans;

import java.util.ArrayList;

import com.business.Customer;
import com.business.Game;

public class CustomerBean {
	ArrayList<Game> gameList = null;
	public CustomerBean(){
		
	}
	public ArrayList<Game> getGameList() {
		return gameList;
	}
	public void setGameList(ArrayList<Game> games) {
		gameList = games;
	}
	public void setCustomerList(ArrayList<Customer> resultList) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
