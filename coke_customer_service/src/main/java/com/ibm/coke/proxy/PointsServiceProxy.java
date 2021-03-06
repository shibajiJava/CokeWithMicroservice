package com.ibm.coke.proxy;

import java.math.BigInteger;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="CokeApplicationConfig")
@FeignClient(name="coke-api-gateway-server")

//@FeignClient(name="cokepointsservice")
@RibbonClient(name="coke_points_service",configuration=MyClientConfig.class)
public interface  PointsServiceProxy {

	@GetMapping("/balance/{member_id}")
	public MemberBalance getMemberBalance(@PathVariable("member_id") BigInteger member_id);
}
