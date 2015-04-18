package com.dataaccess.update;

import java.sql.Timestamp;
import java.util.Calendar;

import com.constants.GlobalConstants;
import com.dataaccess.DbAccessor;

public class EndCurrentCustomer extends DbAccessor{
	private String cno;
	
	public EndCurrentCustomer(){
		setUpdate(true);
	}
	
	public boolean execute(){
		StringBuilder sb = new StringBuilder("");
		sb.append("UPDATE s_current SET ");
		sb.append("STATUS='");
		sb.append(GlobalConstants.INACTIVE_STATUS);
		sb.append("',");
		sb.append(" TIME_ENDED='");
		sb.append(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		sb.append("'");
		sb.append(" WHERE CNO=");
		sb.append(this.cno);
		sb.append(" AND STATUS='");
		sb.append(GlobalConstants.ACTIVE_STATUS);
		sb.append("'");
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

	
	public static void main(String [] args){
		EndCurrentCustomer da = new EndCurrentCustomer();
		da.setCno("850123145");
		da.execute();
	}
}
