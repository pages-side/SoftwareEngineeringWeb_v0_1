package com.beans;

import java.util.ArrayList;

import com.business.Game;

public class GameBean {
	ArrayList<Game> gameList = null;
	public GameBean(){
		
	}
	public ArrayList<Game> getGameList() {
		return gameList;
	}
	public void setGameList(ArrayList<Game> games) {
		gameList = games;
	}
	
	
	
}
