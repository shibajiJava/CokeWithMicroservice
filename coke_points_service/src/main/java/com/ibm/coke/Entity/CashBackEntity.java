package com.ibm.coke.Entity;

import java.math.BigInteger;

public class CashBackEntity {

	
	public BigInteger transactionId;
	public BigInteger tansId;
	public BigInteger memberId;
	public double  cashBackAmt;
	public String memberType;
	
	public CashBackEntity() {
		
	}
	
	
	
	
	public CashBackEntity(BigInteger transactionId, BigInteger tansId, BigInteger memberId, double cashBackAmt,
			String memberType) {
		super();
		this.transactionId = transactionId;
		this.tansId = tansId;
		this.memberId = memberId;
		this.cashBackAmt = cashBackAmt;
		this.memberType = memberType;
	}
	
	
	public BigInteger getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	public BigInteger getTansId() {
		return tansId;
	}
	public void setTansId(BigInteger tansId) {
		this.tansId = tansId;
	}
	public BigInteger getMemberId() {
		return memberId;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}
	public double getCashBackAmt() {
		return cashBackAmt;
	}
	public void setCashBackAmt(double cashBackAmt) {
		this.cashBackAmt = cashBackAmt;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
	
	
}
