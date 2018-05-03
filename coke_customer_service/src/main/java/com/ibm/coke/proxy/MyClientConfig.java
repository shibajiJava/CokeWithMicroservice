package com.ibm.coke.proxy;

import com.netflix.client.config.DefaultClientConfigImpl;

public class MyClientConfig extends DefaultClientConfigImpl  {

	@Override
	public int getDefaultConnectTimeout() {
		return 15000;
	}
	
	@Override
	public int getDefaultReadTimeout() {
		return 15000;
	}
	
}
