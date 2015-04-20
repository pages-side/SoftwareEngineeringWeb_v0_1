package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Customer;
import com.constants.GlobalConstants;
import com.dataaccess.DbAccessor;

/**
 * This class selects all customers who are currently playing.
 * It is used to populate the currently playing screen
 *
 */
public class SelectCurrentCustomers extends DbAccessor {
	private ArrayList<Customer> currentCustomerList = new ArrayList<Customer>();
	private ArrayList<Customer> finishedCustomerList = new ArrayList<Customer>();
	private int cno = -1;
	private String cName;
	private String phone;
	private String sMemberStatus;
	private boolean memberStatus = false;
	private boolean isAll = false;
	private String timeStarted ="";
	private String timeEnded = "";
	public SelectCurrentCustomers(){
	}


	/**
	 * For developer usage
	 */
	public void buildQuery(){		
			StringBuilder sb = new StringBuilder("SELECT ");
			sb.append("CNO,");
			sb.append("CNAME,");
			sb.append("GAME_PLAYING,");
			sb.append("TIME_STARTED,");
			sb.append("TIME_ENDED,");
			sb.append("STATUS");
			sb.append(" FROM s_current");
			sb.append(" WHERE STATUS='");
			sb.append(GlobalConstants.ACTIVE_STATUS);
			sb.append("' OR STATUS='");
			sb.append(GlobalConstants.INACTIVE_STATUS);
			sb.append("';");
			System.out.println(sb.toString());
			super.setQuery(sb.toString());		
	}
	
	/* (non-Javadoc)
	 * @see com.dataaccess.DbAccessor#execute()
	 */
	@Override
	public boolean execute(){
		buildQuery();
		return super.execute();
	}

	/* (non-Javadoc)
	 * @see com.dataaccess.DbAccessor#processResult(java.sql.ResultSet)
	 * Returns every CurrentCustomer object
	 */
	public boolean processResult(ResultSet rs) throws SQLException{
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCno(rs.getInt("CNO"));
			customer.setCname(rs.getString("CNAME"));
			customer.setStartTime(rs.getString("TIME_STARTED"));
			customer.setEndTime(rs.getString("TIME_ENDED"));
			customer.setCurrentStatus(rs.getString("STATUS"));
			customer.setCurrentGame(rs.getString("GAME_PLAYING"));
			if(GlobalConstants.ACTIVE_STATUS.equals(customer.getCurrentStatus())){
				currentCustomerList.add(customer);	
			}else{
				finishedCustomerList.add(customer);
			}
			
		}
		return true;
	}


	/**
	 * @return the currentCustomerList
	 */
	public ArrayList<Customer> getCurrentCustomerList() {
		return currentCustomerList;
	}
	/**
	 * @param currentCustomerList the currentCustomerList to set
	 */
	public void setCurrentCustomerList(ArrayList<Customer> currentCustomerList) {
		this.currentCustomerList = currentCustomerList;
	}
	/**
	 * @return the finishedCustomerList
	 */
	public ArrayList<Customer> getFinishedCustomerList() {
		return finishedCustomerList;
	}
	/**
	 * @param finishedCustomerList the finishedCustomerList to set
	 */
	public void setFinishedCustomerList(ArrayList<Customer> finishedCustomerList) {
		this.finishedCustomerList = finishedCustomerList;
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
	 * @return the isAll
	 */
	public boolean isAll() {
		return isAll;
	}
	/**
	 * @param isAll the isAll to set
	 */
	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}
	/**
	 * @return the timeStarted
	 */
	public String getTimeStarted() {
		return timeStarted;
	}
	/**
	 * @param timeStarted the timeStarted to set
	 */
	public void setTimeStarted(String timeStarted) {
		this.timeStarted = timeStarted;
	}
	/**
	 * @return the timeEnded
	 */
	public String getTimeEnded() {
		return timeEnded;
	}
	/**
	 * @param timeEnded the timeEnded to set
	 */
	public void setTimeEnded(String timeEnded) {
		this.timeEnded = timeEnded;
	
	}
}
