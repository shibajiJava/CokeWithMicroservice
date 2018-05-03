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
public class MemBalanceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private BigInteger transactionId;
	
	@Column(name="member_id")
	private BigInteger memberId;
	@Column(name="balance")
	private double normalBalance;
	@Column(name="cash_bac_balance")
	private double cashBackBalance;
	
	
}
