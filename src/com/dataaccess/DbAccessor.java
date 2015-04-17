package com.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessor extends DbConn {

	private String query = null;
	private String errorMessage = null;
	private boolean isUpdate = false;
	
	//private DbAccessor(){}

	protected boolean execute(){
		boolean isSuccess = false;
		Statement statement = null;
		try {
			//DbConn dbconn = new DbConn();
			
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(!processResult(rs)){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e ) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} finally {
			if (statement != null) { 
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			session.disconnect();
			session = null;
		}

		return isSuccess;
	}
	/*THIS MUST BE OVERRIDDEN IN ALL INHERITING CLASSES*/
	protected boolean processResult(ResultSet rs) throws SQLException{
		return false;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	};
	
}
