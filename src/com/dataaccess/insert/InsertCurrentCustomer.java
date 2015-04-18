package com.dataaccess.insert;

import java.sql.Timestamp;
import java.util.Calendar;

import com.constants.GlobalConstants;
import com.dataaccess.DbAccessor;

public class InsertCurrentCustomer extends DbAccessor{
	private String cno;
	private String cname;
	private String game;
	
	public InsertCurrentCustomer(){
		setUpdate(true);
	}
	
	public boolean execute(){
		StringBuilder sb = new StringBuilder("");
		sb.append("INSERT INTO s_current");
		sb.append(" (");
		sb.append("cno,");
		sb.append("cname,");
		sb.append("game_playing,");
		sb.append("status,");
		sb.append("time_started");
		sb.append(") VALUES (");
		sb.append(this.cno);
		sb.append(",'");
		sb.append(this.cname);
		sb.append("','");
		sb.append(this.game);
		sb.append("','");
		sb.append(GlobalConstants.ACTIVE_STATUS);
		sb.append("','");
		sb.append(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		sb.append("');");
		setQuery(sb.toString());
		System.out.println(sb.toString());
		return super.execute();
		
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
	
	public static void main(String [] args){
		InsertCurrentCustomer da = new InsertCurrentCustomer();
		da.setCno("850123145");
		da.setCname("pages");
		da.setGame("pool2");
		da.execute();
	}
}
