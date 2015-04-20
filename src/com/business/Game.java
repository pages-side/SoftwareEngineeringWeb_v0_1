package com.business;

/**
 * creates the game object
 *
 */
public class Game {

	public Game(){}

	
	private String pno;
	private String name;
	private String platform;
	private String broken;
	private String totalTimePlayed;

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * A string builder for developers use
	 */
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


	/**
	 * @return the pno
	 */
	public String getPno() {
		return pno;
	}


	/**
	 * @param pno the pno to set
	 */
	public void setPno(String pno) {
		this.pno = pno;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}


	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}


	/**
	 * @return the broken
	 */
	public String getBroken() {
		return broken;
	}


	/**
	 * @param broken the broken to set
	 */
	public void setBroken(String broken) {
		this.broken = broken;
	}


	/**
	 * @return the totalTimePlayed
	 */
	public String getTotalTimePlayed() {
		return totalTimePlayed;
	}


	/**
	 * @param totalTimePlayed the totalTimePlayed to set
	 */
	public void setTotalTimePlayed(String totalTimePlayed) {
		this.totalTimePlayed = totalTimePlayed;
	}
	
	
}
