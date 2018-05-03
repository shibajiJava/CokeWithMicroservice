package com.ibm.coke.Request;

import java.math.BigInteger;

import javax.ws.rs.QueryParam;

public class MemberRequest {
	
	@QueryParam("FirstName")
	private String first_name;
	@QueryParam("LastName")
	private String last_name;
	
	private BigInteger member_id= new BigInteger("0");
	
	
	public MemberRequest() {
		
	}
	
	
	
	
	public MemberRequest(String first_name, String last_name, BigInteger member_id) {
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
		return "MemberRequest [first_name=" + first_name + ", last_name=" + last_name + ", member_id=" + member_id
				+ "]";
	}
	
	
	
	

}
