package com.ibm.coke.proxy;

import java.math.BigInteger;

public class MemberBalance {

	private BigInteger memberId;
	private double normalBalance;
	private double cashBackBalance;
	
	private String serverPort;
	
	
	
	public String getServerPort() {
		return serverPort;
	}




	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
	
	public MemberBalance() {
		
	}
	
	
	
	public MemberBalance(BigInteger memberId, double normalBalance, double cashBackBalance,String serverPort) {
		super();
		this.memberId = memberId;
		this.normalBalance = normalBalance;
		this.cashBackBalance = cashBackBalance;
		this.serverPort=serverPort;
	}
	
	
	public BigInteger getMemberId() {
		return memberId;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}
	public double getNormalBalance() {
		return normalBalance;
	}
	public void setNormalBalance(double normalBalance) {
		this.normalBalance = normalBalance;
	}
	public double getCashBackBalance() {
		return cashBackBalance;
	}
	public void setCashBackBalance(double cashBackBalance) {
		this.cashBackBalance = cashBackBalance;
	}



	@Override
	public String toString() {
		return "MemberBalance [memberId=" + memberId + ", normalBalance=" + normalBalance + ", cashBackBalance="
				+ cashBackBalance + "]";
	}
	
	
	
}
