package com.worldmediahd.services.impl;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.worldmediahd.services.UIControllerService;

/**
 * Implementation of the UIControllerService.
 * Extend this if you need to use complicated actions.
 * @author Mo
 *
 */

public class GenericUIControllerServiceImpl implements UIControllerService {
	
	public GenericUIControllerServiceImpl() {}
	
	@Override
	@RequiresPermissions(value = { "admin" })
	public void buttonClicked() {
		System.err.println("button clicked, through injection, through listeners. Hurry Guice!");
	}
}
