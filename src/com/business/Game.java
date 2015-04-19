package com.business;

public class Game {

	public Game(){}

	
	private String pno;
	private String name;
	private String platform;
	private String broken;
	private String totalTimePlayed;

	public String getPno() {
		return pno;
	}

	public void setPno(String Pno) {
		this.pno = Pno;
	}

	public String getPname() {
		return name;
	}

	public void setPname(String PName) {
		this.name = PName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String Platform) {
		this.platform = Platform;
	}

	public String getBroken() {
		return broken;
	}

	public void setBroken(String Broken) {
		this.broken = Broken;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productNo=");
		builder.append(pno);
		builder.append(", Product Name=");
		builder.append(name);
		builder.append(", platform=");
		builder.append(platform);
		builder.append(", total time played=");
		builder.append(totalTimePlayed);
		builder.append(", broken status=");
		builder.append(broken);
		builder.append("]");
		return builder.toString();
	}
	
	
}
