package com.ibm.coke.Request;

import java.math.BigInteger;

public class MemberDetails {

	private BigInteger memberId;
	private String firstName;
	private String lastName;
	private double normalBalance;
	private double CashBackBalance;
	private String serverPort; 
	
	
	
	public String getServerPort() {
		return serverPort;
	}


	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}


	public MemberDetails() {
		
	}
	
	
	public MemberDetails(BigInteger memberId, String firstName, String lastName, double normalBalance,
			double cashBackBalance,String serverPort) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.normalBalance = normalBalance;
		this.CashBackBalance = cashBackBalance;
		this.serverPort= serverPort;
		
	}
	public BigInteger getMemberId() {
		return memberId;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getNormalBalance() {
		return normalBalance;
	}
	public void setNormalBalance(double normalBalance) {
		this.normalBalance = normalBalance;
	}
	public double getCashBackBalance() {
		return CashBackBalance;
	}
	public void setCashBackBalance(double cashBackBalance) {
		CashBackBalance = cashBackBalance;
	}


	@Override
	public String toString() {
		return "MemberDetails [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", normalBalance=" + normalBalance + ", CashBackBalance=" + CashBackBalance + "]";
	}
	
	
	
	
}
