package com.ibm.coke.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.coke.CokeJpaRepository.CokeCustomerMemberRepository;
import com.ibm.coke.CokeJpaRepository.CokeRepositoryDAOInterface;
import com.ibm.coke.Request.MemberDetails;
import com.ibm.coke.Request.MemberRequest;
import com.ibm.coke.entity.Member;
import com.ibm.coke.proxy.MemberBalance;
import com.ibm.coke.proxy.PointsServiceProxy;


@RestController
public class MemberServiceController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceController.class);
	
	@Autowired
	CokeCustomerMemberRepository cokeCustomerMemberRepository;
	@Autowired
	PointsServiceProxy pointsServiceProxy;
	
	@Autowired
	private CokeRepositoryDAOInterface DAO;
	
	
	
	@PostMapping("/insertMember")
	public BigInteger createMember(@RequestBody MemberRequest memberRequest)
	{
		LOGGER.info("=====================================::: Request Received ====================");
		Member mem =  new Member(memberRequest.getFirst_name(),memberRequest.getLast_name());
		mem = cokeCustomerMemberRepository.saveAndFlush(mem);
		LOGGER.info("=====================================::: Request Received doen ====================");
		LOGGER.info("{}", mem);
		return mem.getMember_id();
	}
	
	@GetMapping("/getMember")
	public List<Member> createMember(@RequestParam String name)
	{
		LOGGER.info("=====================================::: Request Received ====================: "+name);
		
		 List<Member> memList  = DAO.searechByFName(name);
		LOGGER.info("=====================================::: Request Received doen ====================");
		LOGGER.info("{}", "Member List");
		return memList;
	}
	
	@GetMapping("getMemberDetails/{id}")
	private MemberDetails getMemberDetails(@PathVariable BigInteger id)
	{
		Member member  = DAO.getMemberDetails(id);
		MemberBalance memBal  = pointsServiceProxy.getMemberBalance(id);
		MemberDetails memDtl =  new MemberDetails(member.getMember_id(),member.getFirst_name(),member.getLast_name(),memBal.getNormalBalance(),memBal.getCashBackBalance(),memBal.getServerPort());
		LOGGER.info("{}", "Log from Customer_Service_test"+memDtl);
		return memDtl;
	}
	
}
