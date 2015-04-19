package com.business;

/**
 * Stores the customer as an object
 *
 */
public class Customer {

	private int cno;
	private String cname;
	private String phone;
	private String currentGame;
	private String startTime;
	private String endTime;
	private String currentStatus;
	private boolean memberStatus;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * A string builder for developers use
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [Customer ID=");
		builder.append(cno);
		builder.append(", Customer's name=");
		builder.append(cname);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", member status=");
		builder.append(memberStatus);
		builder.append("]");
		return builder.toString();
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
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
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
	 * @return the currentGame
	 */
	public String getCurrentGame() {
		return currentGame;
	}

	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(String currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
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
}
