package com.ibm.coke.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	
	private String first_name;
	private String last_name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger member_id;
	
	
	public Member() {
		
	}
	
	public Member(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		
	}
	  
	  
	public Member(String first_name, String last_name, BigInteger member_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.member_id = member_id;
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public BigInteger getMember_id() {
		return member_id;
	}
	public void setMember_id(BigInteger member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "Member [first_name=" + first_name + ", last_name=" + last_name + ", member_id=" + member_id + "]";
	}
	  
	  
	  
	  
	  

}
