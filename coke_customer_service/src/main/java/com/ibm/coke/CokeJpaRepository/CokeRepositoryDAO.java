package com.ibm.coke.CokeJpaRepository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ibm.coke.entity.Member;


@Repository
public class CokeRepositoryDAO implements CokeRepositoryDAOInterface {

	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> searechByFName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Member where first_name = '"+ name +"'";
		return (List<Member>) entityManager.createQuery(hql).getResultList();
	}

	

	public Member getMemberDetails(BigInteger memberId)
	{
		
		
		String InsertSQL = "SELECT first_name, last_name, member_id FROM member where member_id="+ memberId +"";
		System.out.println("balance SQL : "+InsertSQL);
		Query query = entityManager.createNativeQuery(InsertSQL,Member.class);
		
		Member member = (Member)query.getSingleResult();
		return member;
	}
	 

}
