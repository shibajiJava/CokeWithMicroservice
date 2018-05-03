package com.ibm.cok.DAO;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.ibm.cok.proxy.CokeConfigurationBean;
import com.ibm.coke.Entity.PointsTransEntiry;
@Component
public interface IPointsTransDAO {
	
  BigInteger pointsDebit(PointsTransEntiry pointsTransEntiry,CokeConfigurationBean cokeConfigurationBean);
	
}
