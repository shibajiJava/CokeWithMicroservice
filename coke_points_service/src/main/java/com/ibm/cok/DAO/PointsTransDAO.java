package com.ibm.cok.DAO;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibm.cok.proxy.CokeConfigurationBean;
import com.ibm.coke.Entity.BalanceEntiry;
import com.ibm.coke.Entity.PointsTransEntiry;
import com.ibm.coke.pointsBean.MemberStatus;


@Repository
@Component
public class PointsTransDAO implements IPointsTransDAO {

	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public BigInteger pointsDebit(PointsTransEntiry pointsTransEntiry,CokeConfigurationBean cokeConfigurationBean) {
		
		
		/*String InsertSQL = "INSERT INTO points_tracsac( member_id, product_id, transaction_amout, "
				+ "transaction_flg,insert_dtm, update_dtm)  VALUES "
				+ " ( "+pointsTransEntiry.getMemberId()+", "+ pointsTransEntiry.getProductId()   +", "+ pointsTransEntiry.getTransactionAmout() +", '"+ pointsTransEntiry.getTransaction_flg() +"', clock_timestamp(), clock_timestamp())"; 
		*/
		
		System.out.println("Balance for this member is  ===== ");
		MemberStatus memberStatus   = getBalance(pointsTransEntiry.getMemberId());
		System.out.println("Balance for this member is  ===== "+memberStatus.getBalanceAMT());
		System.out.println("Balance for this member is  ===== "+memberStatus.getTransactionAMT());
		
		boolean cashBackFlg = false;
		
		if(new Double(cokeConfigurationBean.getCashBackDimondBalance()).doubleValue()<=memberStatus.getBalanceAMT() && new BigInteger(cokeConfigurationBean.getCashBackDimondTransaction()).intValue()<=memberStatus.getTransactionAMT().intValue())
		{
			cashBackFlg =  true;
			memberStatus.setMemType(cokeConfigurationBean.getCashBackDimondMemberType());
			memberStatus.setCashBack(new Double(cokeConfigurationBean.getCashBackDimondAmt()));
		}
		if(new Double(cokeConfigurationBean.getCashBackGoldBalance()).doubleValue()<=memberStatus.getBalanceAMT() && new BigInteger(cokeConfigurationBean.getCashBackGoldTransaction()).intValue()<=memberStatus.getTransactionAMT().intValue())
		{
			cashBackFlg =  true;
			memberStatus.setMemType(cokeConfigurationBean.getCashBackGoldMemberType());
			memberStatus.setCashBack(new Double(cokeConfigurationBean.getCashBackGoldAmt()));
		}
		if(new Double(cokeConfigurationBean.getCashBackPlatinumBalance()).doubleValue()<=memberStatus.getBalanceAMT() && new BigInteger(cokeConfigurationBean.getCashBackGoldTransaction()).intValue()<=memberStatus.getTransactionAMT().intValue())
		{
			cashBackFlg =  true;
			memberStatus.setMemType(cokeConfigurationBean.getCashBackPlatinumMemberType());
			memberStatus.setCashBack(new Double(cokeConfigurationBean.getCashBackPlatinumAmt()));
		}
		
		if(new Double(cokeConfigurationBean.getCashBackSuperBalance()).doubleValue()<=memberStatus.getBalanceAMT() && new BigInteger(cokeConfigurationBean.getCashBackPlatinumTransaction()).intValue()<=memberStatus.getTransactionAMT().intValue())
		{
			cashBackFlg =  true;
			memberStatus.setMemType(cokeConfigurationBean.getCashBackPlatinumMemberType());
			memberStatus.setCashBack(new Double(cokeConfigurationBean.getCashBackPlatinumAmt()));
		}
		
		
		/*String InsertSQL ="INSERT INTO points_tracsac( "
				+ " member_id, product_id, transaction_amout, transaction_flg, insert_dtm, update_dtm,balance) VALUES ( ?, ?, ?, ?, clock_timestamp(), clock_timestamp(),?)";*/
		
		
		// Insert into points trans 
		
		String InsertSQL = "INSERT INTO points_tracsac( member_id, product_id, transaction_amout, transaction_flg,"
				+ "insert_dtm, update_dtm, balance, cash_bac_amt, cash_bac_balance) VALUES "
				+ "(?, ?, ?, ?, clock_timestamp(), clock_timestamp(), ?, ?, ?)";
		
		System.out.println("SQL is : "+InsertSQL);
		
		Query query = entityManager.createNativeQuery(InsertSQL);
		query.setParameter(1, pointsTransEntiry.getMemberId());
		query.setParameter(2, pointsTransEntiry.getProductId());
		query.setParameter(3, pointsTransEntiry.getTransactionAmout());
		query.setParameter(4, pointsTransEntiry.getTransaction_flg());
		
		
		if(null != pointsTransEntiry.getTransaction_flg() && pointsTransEntiry.getTransaction_flg().equalsIgnoreCase("D"))
		{
			query.setParameter(5, (memberStatus.getBalanceAMT() +pointsTransEntiry.getTransactionAmout()));
		}
		else if(null != pointsTransEntiry.getTransaction_flg() && pointsTransEntiry.getTransaction_flg().equalsIgnoreCase("C"))
		{
			query.setParameter(5, (memberStatus.getBalanceAMT()-pointsTransEntiry.getTransactionAmout()));
		}
		
		query.setParameter(6, memberStatus.getCashBack());
		
		if(null != pointsTransEntiry.getTransaction_flg() && pointsTransEntiry.getTransaction_flg().equalsIgnoreCase("D"))
		{
			//query.setParameter(5, (memberStatus.getBalanceAMT() +pointsTransEntiry.getTransactionAmout()));
			query.setParameter(7, (memberStatus.getBalanceCashBackAMT()+memberStatus.getCashBack()));
		}
		if(null == pointsTransEntiry.getTransaction_flg() ||  pointsTransEntiry.getTransaction_flg().equalsIgnoreCase("C"))
		{
			//query.setParameter(5, (memberStatus.getBalanceAMT() +pointsTransEntiry.getTransactionAmout()));
			query.setParameter(7, 0);
		}
		
		
		query.executeUpdate();
		
		
		
		/*// insert into cash back 
		
		String InsertSQLCashBack = "INSERT INTO cash_back_trans(tans_id, member_id, cash_back_amt, member_type)VALUES (?, ?, ?, ?, ?);";
		
		System.out.println("SQL is : "+InsertSQL);
		
		Query queryCashBack = entityManager.createNativeQuery(InsertSQLCashBack);
		queryCashBack.setParameter(position, value)
		
		queryCashBack.executeUpdate();*/
		
		
		
		
		return new BigInteger("0");
	}
	
	public MemberStatus getBalance(BigInteger memberid)
	{
		MemberStatus memStat =  new MemberStatus();
		Double balance = new Double("0");
		Double balanceCashBack = new Double("0");
		String InsertSQL = "select transaction_id,member_id,balance,cash_bac_balance from points_tracsac where member_id="+ memberid +" and insert_dtm=(select max(insert_dtm) from points_tracsac where member_id="+memberid+")";
		System.out.println("balance SQL : "+InsertSQL);
		Query query = entityManager.createNativeQuery(InsertSQL,BalanceEntiry.class);
		
		List resultList = null; 
		BalanceEntiry balanceEntiry=null;
		if(query.getResultList()!=null)
		{
			resultList = query.getResultList();
			balanceEntiry =(BalanceEntiry)resultList.get(0);
		}
		
		if(null!=balanceEntiry.getBalance())
		{
			balance  = balanceEntiry.getBalance() ;
			//resultList.get(0);
		}
		else
		{
			balance=new Double("0");
		}
		
		if(null!=balanceEntiry.getCashBacBalance())
		{
			balanceCashBack  = balanceEntiry.getCashBacBalance() ;
		}
		else
		{
			balanceCashBack=new Double("0");
		}
		
		memStat.setBalanceAMT(balance);
		memStat.setBalanceCashBackAMT(balanceCashBack);
		
		InsertSQL = "select count(transaction_id) from points_tracsac where member_id="+ memberid +" and insert_dtm<=CURRENT_DATE and insert_dtm>=(CURRENT_DATE - INTERVAL '30 day')";
		System.out.println("balance SQL : "+InsertSQL);
		query = entityManager.createNativeQuery(InsertSQL);
		
		if(null!=query.getSingleResult())
		{
			memStat.setTransactionAMT((BigInteger)query.getSingleResult());
		}
		else
		{
			memStat.setTransactionAMT(new BigInteger("0"));
		}
		
		memStat.setCashBack(0);
		memStat.setMemType("None");
		return memStat;
	}
	
	
	
	public BalanceEntiry getBalanceAPI(BigInteger memberid)
	{
		/*BalanceEntiry balanceEntiry = new BalanceEntiry(new BigInteger("100"), new Double("100"), new Double("100"));
		return balanceEntiry;*/
		
		MemberStatus memStat =  new MemberStatus();
		Double balance = new Double("0");
		Double balanceCashBack = new Double("0");
		String InsertSQL = "select transaction_id,balance,cash_bac_balance,member_id from points_tracsac where member_id="+ memberid +" and insert_dtm=(select max(insert_dtm) from points_tracsac where member_id="+memberid+")";
		System.out.println("balance SQL : "+InsertSQL);
		Query query = entityManager.createNativeQuery(InsertSQL,BalanceEntiry.class);
		
		List resultList = null; 
		BalanceEntiry balanceEntiry=null;
		if(query.getResultList()!=null)
		{
			resultList = query.getResultList();
			balanceEntiry =(BalanceEntiry)resultList.get(0);
		}
		
		balanceEntiry.setMemberID(memberid);
		return balanceEntiry;
		
	}

}
