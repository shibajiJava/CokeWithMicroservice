package com.ibm.coke.pintsController;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cok.DAO.PointsTransDAO;
import com.ibm.cok.proxy.CokeConfigurationBean;
import com.ibm.cok.proxy.GetConfiguration;
import com.ibm.coke.Entity.BalanceEntiry;
import com.ibm.coke.Entity.PointsTransEntiry;
import com.ibm.coke.pointsBean.MemBalance;
import com.ibm.coke.pointsBean.PointsRequest;

@RestController
public class PointsServiceController {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	PointsTransDAO pointsTransDAO;
	
	@Autowired
	private GetConfiguration proxy;
	
	@PostMapping("/points/transac")
	public BigInteger PointsDebot(@RequestBody PointsRequest points)
	{
		
		try 
		{
			System.out.println("Started for points debit=================");
			PointsTransEntiry pointsTransEntiry =  new PointsTransEntiry(points.getMemberId(),points.getProductId(),points.getPoints(),points.getTransactionFlg());
			
			CokeConfigurationBean cokeConfigurationBean = getConfig();
			
			pointsTransDAO.pointsDebit(pointsTransEntiry,cokeConfigurationBean);
			
			
			
			
			System.out.println("end  for points debit=================");
			
			logger.info("{}", "Log for Poins_service_test 1");
		}
		catch(Exception exx)
		{
			exx.printStackTrace();
			logger.info(exx.getMessage());
			
		}
		return new BigInteger("1"); 
	}

	@GetMapping("coke/confing")
	public CokeConfigurationBean getConfig()
	{
		CokeConfigurationBean response = proxy.retiveCokeConfiguration();
		logger.info("{}", "Log for Poins_service_test"+response);
		return response;
	}
	
	
	@GetMapping("/balance/{member_id}")
	public MemBalance getMemberBalance(@PathVariable BigInteger member_id)
	{
		String serverPort = environment.getProperty("local.server.port");
		BalanceEntiry balanceEntiry =  pointsTransDAO.getBalanceAPI(member_id);
		MemBalance memBalance = new MemBalance(balanceEntiry.getMemberID(),balanceEntiry.getBalance(),balanceEntiry.getCashBacBalance(),serverPort);
		
		logger.info("{}", "Log for Poins_service_test"+memBalance);
		return memBalance;
		
	}
	
}
