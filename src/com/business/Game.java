package com.business;

public class Game {

	public Game(){}

	
	private int pno;
	private String pname;
	private String platform;
	private String purchase_date;
	private int total_time_played;
	private boolean broken;

	public int getPno() {
		return pno;
	}

	public void setPno(int Pno) {
		this.pno = Pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String PName) {
		this.pname = PName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String Platform) {
		this.platform = Platform;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String Purchase_date) {
		this.purchase_date = Purchase_date;
	}

	public int getTotal_time_played() {
		return total_time_played;
	}

	public void setTotal_time_played(int Total_time_played) {
		this.total_time_played = Total_time_played;
	}

	public boolean getBroken() {
		return broken;
	}

	public void setBroken(boolean Broken) {
		this.broken = Broken;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productNo=");
		builder.append(pno);
		builder.append(", Product Name=");
		builder.append(pname);
		builder.append(", platform=");
		builder.append(platform);
		builder.append(", purchase date=");
		builder.append(purchase_date);
		builder.append(", total time played=");
		builder.append(total_time_played);
		builder.append(", broken status=");
		builder.append(broken);
		builder.append("]");
		return builder.toString();
	}
	
	
}
