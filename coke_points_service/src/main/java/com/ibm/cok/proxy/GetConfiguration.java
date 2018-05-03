package com.ibm.cok.proxy;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="CokeApplicationConfig", configuration = FooConfiguration.class)
@FeignClient(name="CokeApplicationConfig")
//@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="CokeApplicationConfig")
public interface GetConfiguration {
	
	//@GetMapping("/getConfiguration")
	
	//@RequestMapping(method = RequestMethod.POST, value="/getConfiguration")
	@GetMapping("/getConfiguration")
	public CokeConfigurationBean retiveCokeConfiguration();
	
}
