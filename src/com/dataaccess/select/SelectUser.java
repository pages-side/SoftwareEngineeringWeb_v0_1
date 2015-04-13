package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.command.parameters.CommandParameter;
import com.dataaccess.DbAccessor;

public class SelectUser extends DbAccessor {
	private String userName = null;
	private String password = null;
	
	public SelectUser(){}
	
	public SelectUser(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	
	
	public boolean execute(){
		boolean isSuccess = false;
		StringBuilder sb = new StringBuilder("");
		sb.append("Select USER_NAME, PASSWORD ");
		sb.append(" from S_USERS");
		sb.append(" where");
		sb.append(" USER_NAME='");
		sb.append(this.userName);
		sb.append("'");
		sb.append(" and PASSWORD='");
		sb.append(this.password);
		sb.append("'");
		
		return isSuccess;
	}
	
	public boolean processResult(ResultSet rs){
		try {
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
