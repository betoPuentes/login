package com.worldmediahd.services.impl;

import com.worldmediahd.services.SecurityService;

/**
 * Basic Shiro Security service. This is where authentication of subjects should
 * happen. Anything more complicated should be done in the
 * com.worldmediahd.security package (e.g. page security).
 * 
 * @author Mo
 */

public class ShiroSecurityServiceImpl implements SecurityService {
	
	public ShiroSecurityServiceImpl() {
		System.err.println("interceptor catch it");
	}
	
}
