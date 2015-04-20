package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Company;
import com.business.Customer;
import com.dataaccess.DbAccessor;
import com.mysql.jdbc.StringUtils;

/**
 * This class builds the query for the database.
 *
 */
public class SelectCustomer extends DbAccessor {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	private int cno = -1;
	private String cName;
	private String phone;
	private String sMemberStatus;
	private boolean memberStatus = false;
	private boolean isAll = false;

	public SelectCustomer(){
	}

	/**Puts the query into the DbAccessor.
	 * @param query
	 */
	public SelectCustomer(String query){
		super.setQuery(query);
	}
	
	/**This is where we build our query.
	 * 
	 */
	public void buildQuery(){
		if(StringUtils.isNullOrEmpty(super.getQuery())){
			StringBuilder sb = new StringBuilder("SELECT ");
			sb.append("CNO,");
			sb.append("CNAME,");
			sb.append("PHONE,");
			sb.append("MEMBER_STATUS");
			sb.append(" FROM S_CUSTOMER");

			if(hasWhere()){
				boolean isFirst = true;
				sb.append(" WHERE ");
				if(cno > -1){
					sb.append("CNO=");
					sb.append(cno);
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(cName)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("CNAME='");
					sb.append(cName);
					sb.append("'");
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(phone)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("PHONE='");
					sb.append(phone);
					sb.append("'");
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(sMemberStatus)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("MEMBER_STATUS=");
					if("TRUE".equalsIgnoreCase(sMemberStatus)){
						sb.append("1");
					}else{
						sb.append("0");
					}
					isFirst = false;
				}
			}


			super.setQuery(sb.toString());		
		}
	}
	/* (non-Javadoc)
	 * @see com.dataaccess.DbAccessor#execute()
	 * Uses DbAccessor to execute
	 */
	@Override
	public boolean execute(){
		buildQuery();
		return super.execute();
	}

	/* (non-Javadoc)
	 * @see com.dataaccess.DbAccessor#processResult(java.sql.ResultSet)
	 * Adds Customer object to a customerList that meets the query.
	 */
	public boolean processResult(ResultSet rs) throws SQLException{
		boolean isSuccess = false;
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCno(rs.getInt("CNO"));
			customer.setCname(rs.getString("CNAME"));
			customer.setPhone(rs.getString("PHONE"));
			customer.setMemberStatus(rs.getBoolean("MEMBER_STATUS"));
			customerList.add(customer);
			isSuccess = true;
		}
		return isSuccess;
	}

	/**An override if there is not a cno
	 * @return
	 */
	public boolean hasWhere(){
		if((cno > -1) 
				|| !StringUtils.isNullOrEmpty(cName)
				|| !StringUtils.isNullOrEmpty(phone)
				|| !StringUtils.isNullOrEmpty(sMemberStatus)
				){
			return true;
		}else{
			isAll = true;
			return false;
		}
	}

	
	/**
	 * @return the cno
	 */
	public int getCno() {
		return cno;
	}
	/**
	 * @param cno the cno to set
	 */
	public void setCno(int cno) {
		this.cno = cno;
	}
	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the sMemberStatus
	 */
	public String getsMemberStatus() {
		return sMemberStatus;
	}
	/**
	 * @param sMemberStatus the sMemberStatus to set
	 */
	public void setsMemberStatus(String sMemberStatus) {
		this.sMemberStatus = sMemberStatus;
	}
	/**
	 * @return the memberStatus
	 */
	public boolean isMemberStatus() {
		return memberStatus;
	}
	/**
	 * @param memberStatus the memberStatus to set
	 */
	public void setMemberStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	/**
	 * @return if list is complete
	 */
	public boolean isAll() {
		return isAll;
	}

	/**Tells when the list is complete
	 * @param isAll
	 */
	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}



}
