package com.dataaccess.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.Company;
import com.business.Customer;
import com.dataaccess.DbAccessor;
import com.mysql.jdbc.StringUtils;

public class SelectCustomer extends DbAccessor {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
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

	public SelectCustomer(){
	}

	public SelectCustomer(String query){
		super.setQuery(query);
	}
	public void buildQuery(){
		if(StringUtils.isNullOrEmpty(super.getQuery())){
			StringBuilder sb = new StringBuilder("SELECT ");
			sb.append("CNO,");
			sb.append("CNAME,");
			sb.append("ADDRESS,");
			sb.append("CITY,");
			sb.append("STATE,");
			sb.append("ZIP,");
			sb.append("STATE,");
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
				if(!StringUtils.isNullOrEmpty(address)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("ADDRESS=");
					sb.append(address);
					sb.append("'");
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(city)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("CITY=");
					sb.append(city);
					sb.append("'");
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(state)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("STATE='");
					sb.append(state);
					sb.append("'");
					isFirst = false;
				}
				if(!StringUtils.isNullOrEmpty(zip)){
					if(!isFirst){
						sb.append(" AND ");
					}
					sb.append("ZIP='");
					sb.append(zip);
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
	@Override
	public boolean execute(){
		buildQuery();
		return super.execute();
	}

	public boolean processResult(ResultSet rs) throws SQLException{
		boolean isSuccess = false;
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCNo(rs.getInt("CNO"));
			customer.setCName(rs.getString("CNAME"));
			customer.setStreet(rs.getString("ADDRESS"));
			customer.setCity(rs.getString("CITY"));
			customer.setState(rs.getString("STATE"));
			customer.setZip(rs.getString("ZIP"));
			customer.setPhone(rs.getString("PHONE"));
			customer.setMemberStatus(rs.getBoolean("MEMBER_STATUS"));
			customerList.add(customer);
			isSuccess = true;
		}
		return isSuccess;
	}

	public boolean hasWhere(){
		if((cno > -1) 
				|| !StringUtils.isNullOrEmpty(cName)
				|| !StringUtils.isNullOrEmpty(city)
				|| !StringUtils.isNullOrEmpty(state)
				|| !StringUtils.isNullOrEmpty(zip)
				|| !StringUtils.isNullOrEmpty(phone)
				|| !StringUtils.isNullOrEmpty(sMemberStatus)
				){
			return true;
		}else{
			isAll = true;
			return false;
		}
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
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



}
