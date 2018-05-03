package com.ibm.coke.pointsBean;

import java.math.BigInteger;

public class MemberStatus {

	private BigInteger transactionAMT;
	private double balanceAMT;
	private double balanceCashBackAMT;
	private String memType;
	private double cashBack;
	
	public MemberStatus() {
		
	}
	
	
	
	
	
	public MemberStatus(BigInteger transactionAMT, double balanceAMT, double balanceCashBackAMT, String memType, double cashBack) {
		super();
		this.transactionAMT = transactionAMT;
		this.balanceAMT = balanceAMT;
		this.memType = memType;
		this.cashBack = cashBack;
	}
	
	
	public double getBalanceCashBackAMT() {
		return balanceCashBackAMT;
	}

	public void setBalanceCashBackAMT(double balanceCashBackAMT) {
		this.balanceCashBackAMT = balanceCashBackAMT;
	}
	public BigInteger getTransactionAMT() {
		return transactionAMT;
	}
	public void setTransactionAMT(BigInteger transactionAMT) {
		this.transactionAMT = transactionAMT;
	}
	public double getBalanceAMT() {
		return balanceAMT;
	}
	public void setBalanceAMT(double balanceAMT) {
		this.balanceAMT = balanceAMT;
	}
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	public double getCashBack() {
		return cashBack;
	}
	public void setCashBack(double cashBack) {
		this.cashBack = cashBack;
	}





	@Override
	public String toString() {
		return "MemberStatus [transactionAMT=" + transactionAMT + ", balanceAMT=" + balanceAMT + ", balanceCashBackAMT="
				+ balanceCashBackAMT + ", memType=" + memType + ", cashBack=" + cashBack + "]";
	}
	
	
	
	
	
}
