package com.ibm.coke.pointsBean;

import java.math.BigInteger;

public class PointsRequest {

	private double points;
	private BigInteger memberId;
	private String transactionFlg;
	private double transactionAmount;
	private BigInteger productId;
	private double cashBack;
	
	
	



	public double getTransactionAmount() {
		return transactionAmount;
	}



	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}



	public PointsRequest() {
		
	}
	
	
	
	public PointsRequest(double points, BigInteger memberId,double transactionAmount, String transactionFlg, BigInteger productId,
			double cashBack) {
		super();
		this.points = points;
		this.memberId = memberId;
		this.transactionAmount=transactionAmount;
		this.transactionFlg = transactionFlg;
		this.productId = productId;
		this.cashBack = cashBack;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public BigInteger getMemberId() {
		return memberId;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}
	public double getCashBack() {
		return cashBack;
	}
	public void setCashBack(double cashBack) {
		this.cashBack = cashBack;
	}
	public String getTransactionFlg() {
		return transactionFlg;
	}
	public void setTransactionFlg(String transactionFlg) {
		this.transactionFlg = transactionFlg;
	}
	public BigInteger getProductId() {
		return productId;
	}
	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}



	@Override
	public String toString() {
		return "PointsRequest [points=" + points + ", memberId=" + memberId + ", transactionFlg=" + transactionFlg
				+ ", transactionAmount=" + transactionAmount + ", productId=" + productId + ", cashBack=" + cashBack
				+ "]";
	}
	
	
	
	
}
