package com.ibm.coke.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coke_micro.points_tracsac")
public class BalanceEntiry {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private BigInteger transactionId;
	
	@Column(name="member_id")
	private BigInteger memberID;
	
	@Column(name="balance")
	private Double balance;
	@Column(name="cash_bac_balance")
	private Double cashBacBalance;
	
	




	public BigInteger getMemberID() {
		return memberID;
	}




	public void setMemberID(BigInteger memberID) {
		this.memberID = memberID;
	}




	public BigInteger getTransactionId() {
		return transactionId;
	}




	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}


	
	
	public BalanceEntiry() {
		
	}

	
	

	



	public BalanceEntiry(BigInteger transactionId, Double balance, Double cashBacBalance) {
		super();
		this.transactionId = transactionId;
		this.balance = balance;
		this.cashBacBalance = cashBacBalance;
	}




	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Double getCashBacBalance() {
		return cashBacBalance;
	}


	public void setCashBacBalance(Double cashBacBalance) {
		this.cashBacBalance = cashBacBalance;
	}
	
	
	
	
	
	
}
