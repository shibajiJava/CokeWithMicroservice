package com.ibm.coke.CokeJpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.coke.entity.Member;

public interface CokeCustomerMemberRepository  extends JpaRepository<Member, Long> {
	 
	

}
