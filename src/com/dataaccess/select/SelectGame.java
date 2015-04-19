package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Game;
import com.dataaccess.DbAccessor;

public class SelectGame extends DbAccessor {
	ArrayList<Game> gameList = new ArrayList<Game>();
	public SelectGame(){	}
	
	public SelectGame(String query){
		super.setQuery(query);
	}
	
	@Override
	public boolean execute(){
		return super.execute();
	}
	
	public boolean processResult(ResultSet rs) throws SQLException{
		boolean isSuccess = false;
		while(rs.next()){
			Game game = new Game();
			game.setPno(rs.getString("PRODUCT_NO"));
			game.setPname(rs.getString("PRODUCT_NAME"));
			game.setPlatform(rs.getString("PLATFORM"));
			game.setPurchase_date(rs.getString("PURCHASE_DATE"));
			game.setTotal_time_played(rs.getInt("TIME_PLAYED"));
			game.setBroken(rs.getBoolean("BROKEN"));
			gameList.add(game);
			isSuccess = true;
		}
		return isSuccess;
	}

	public ArrayList<Game> getGameList() {
		return gameList;
	}

	public void setGameList(ArrayList<Game> gamesList) {
		gameList = gamesList;
	}
	
}
