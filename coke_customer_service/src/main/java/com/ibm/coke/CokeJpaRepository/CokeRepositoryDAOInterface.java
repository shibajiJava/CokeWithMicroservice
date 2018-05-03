package com.ibm.coke.CokeJpaRepository;

import java.math.BigInteger;
import java.util.List;

import com.ibm.coke.entity.Member;

public interface CokeRepositoryDAOInterface {
	List<Member> searechByFName(String name);
	Member getMemberDetails(BigInteger memberId);
}
