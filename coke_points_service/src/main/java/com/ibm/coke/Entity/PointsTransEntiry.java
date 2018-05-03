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
public class PointsTransEntiry {

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private BigInteger transactionId;
	

	@Column(name="member_id")
	private BigInteger memberId;
	
	@Column(name="product_id")
	private BigInteger productId;
	
	
	@Column(name="transaction_amout")
	private double transactionAmout;
	
	@Column(name="transaction_flg")
	private String transaction_flg;
	
	
	public PointsTransEntiry( BigInteger memberId, BigInteger productId,
			double transactionAmout, String transaction_flg) {
		super();
		
		this.memberId = memberId;
		this.productId = productId;
		this.transactionAmout = transactionAmout;
		this.transaction_flg = transaction_flg;
	}
	
	public PointsTransEntiry() {
		
	}
	
	
	public PointsTransEntiry(BigInteger transactionId, BigInteger memberId, BigInteger productId,
			double transactionAmout, String transaction_flg) {
		super();
		this.transactionId = transactionId;
		this.memberId = memberId;
		this.productId = productId;
		this.transactionAmout = transactionAmout;
		this.transaction_flg = transaction_flg;
	}
	

	public BigInteger getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}

	public BigInteger getMemberId() {
		return memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public double getTransactionAmout() {
		return transactionAmout;
	}

	public void setTransactionAmout(double transactionAmout) {
		this.transactionAmout = transactionAmout;
	}

	public String getTransaction_flg() {
		return transaction_flg;
	}

	public void setTransaction_flg(String transaction_flg) {
		this.transaction_flg = transaction_flg;
	}
}
