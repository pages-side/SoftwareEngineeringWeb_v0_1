package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Customer;
import com.constants.GlobalConstants;
import com.dataaccess.DbAccessor;

public class SelectCurrentCustomers extends DbAccessor {
	private ArrayList<Customer> currentCustomerList = new ArrayList<Customer>();
	private ArrayList<Customer> finishedCustomerList = new ArrayList<Customer>();
	private int cno = -1;
	private String cName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String sMemberStatus;
	private boolean memberStatus = false;
	private boolean isAll = false;
	private String timeStarted ="";
	private String timeEnded = "";
	public SelectCurrentCustomers(){
	}


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
	@Override
	public boolean execute(){
		buildQuery();
		return super.execute();
	}

	public boolean processResult(ResultSet rs) throws SQLException{
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCNo(rs.getInt("CNO"));
			customer.setCName(rs.getString("CNAME"));
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


	public ArrayList<Customer> getCustomerList() {
		return currentCustomerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.currentCustomerList = customerList;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getsMemberStatus() {
		return sMemberStatus;
	}

	public void setsMemberStatus(String sMemberStatus) {
		this.sMemberStatus = sMemberStatus;
	}

	public boolean isAll() {
		return isAll;
	}

	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}


	public String getTimeStarted() {
		return timeStarted;
	}


	public void setTimeStarted(String timeStarted) {
		this.timeStarted = timeStarted;
	}


	public String getTimeEnded() {
		return timeEnded;
	}


	public void setTimeEnded(String timeEnded) {
		this.timeEnded = timeEnded;
	}


	public ArrayList<Customer> getCurrentCustomerList() {
		return currentCustomerList;
	}


	public void setCurrentCustomerList(ArrayList<Customer> currentCustomerList) {
		this.currentCustomerList = currentCustomerList;
	}


	public ArrayList<Customer> getFinishedCustomerList() {
		return finishedCustomerList;
	}


	public void setFinishedCustomerList(ArrayList<Customer> finishedCustomerList) {
		this.finishedCustomerList = finishedCustomerList;
	}





}
