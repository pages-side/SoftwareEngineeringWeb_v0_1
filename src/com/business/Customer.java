package com.business;

public class Customer {

	private int cno;
	private String cname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private boolean memberStatus;
	public int getCompanyNo() {
		return cno;
	}
	public void setCNo(int i) {
		this.cno = i;
	}
	public String getCName() {
		return cname;
	}
	public void setCName(String companyName) {
		this.cname = companyName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public void setState(String companyState) {
		this.state = companyState;
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
	public boolean getMemberStatus(){
		return memberStatus;
	}
	public void setMemberStatus(boolean member){
		this.memberStatus = member;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [Customer ID=");
		builder.append(cno);
		builder.append(", Customer's name=");
		builder.append(cname);
		builder.append(", street=");
		builder.append(street);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zip=");
		builder.append(zip);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", member status=");
		builder.append(memberStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
}
