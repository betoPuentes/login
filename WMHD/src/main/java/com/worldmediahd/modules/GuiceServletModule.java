// Created on Jan 2, 2012 by mo

package com.worldmediahd.modules;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.GuestAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.PermissionAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.RoleAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.UserAnnotationMethodInterceptor;
import org.apache.shiro.guice.web.GuiceShiroFilter;

import com.worldmediahd.security.ShiroMethodInterceptor;
import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.ServletModule;
import com.google.inject.servlet.ServletScopes;
import com.vaadin.Application;
import com.worldmediahd.services.SecurityService;
import com.worldmediahd.services.UIControllerService;
import com.worldmediahd.services.impl.GenericUIControllerServiceImpl;
import com.worldmediahd.services.impl.ShiroSecurityServiceImpl;
import com.worldmediahd.servlets.WHMDApplication;
import com.worldmediahd.ui.MyVaadinApplication;

/**
 * All basic binding should be done in here prior to starting any tasks.
 * 
 * @author mo
 */

public class GuiceServletModule extends ServletModule {
	@Override
	protected void configureServlets() {
		super.configureServlets();
		filter("/*").through(GuiceShiroFilter.class);

		// bind to database....
		
		// live throughout the life of the server application...
		bind(SecurityService.class).to(ShiroSecurityServiceImpl.class);
		// once per session...
		bind(UIControllerService.class).to(GenericUIControllerServiceImpl.class).in(ServletScopes.SESSION);
		bind(Application.class).to(MyVaadinApplication.class).in(ServletScopes.SESSION);
		
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresRoles.class),
                new ShiroMethodInterceptor(new RoleAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresUser.class),
                new ShiroMethodInterceptor(new UserAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresPermissions.class),
                new ShiroMethodInterceptor(new PermissionAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresGuest.class),
                new ShiroMethodInterceptor(new GuestAnnotationMethodInterceptor()));
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(RequiresAuthentication.class),
                new ShiroMethodInterceptor(new AuthenticatedAnnotationMethodInterceptor()));
		
		serve("/*").with(WHMDApplication.class);
		
	}
}
