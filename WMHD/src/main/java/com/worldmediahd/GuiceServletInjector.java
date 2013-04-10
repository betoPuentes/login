package com.worldmediahd;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.shiro.guice.aop.ShiroAopModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.worldmediahd.modules.GuiceServletModule;
import com.worldmediahd.modules.ShiroConfigurationModule;

/**
 * This class is the starting point of the application. It only forwards
 * 'requests' to other classes so things can start working!
 * 
 * @author Mo
 */

public class GuiceServletInjector extends GuiceServletContextListener {
	private ServletContext servletContext;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContext = servletContextEvent.getServletContext();
		super.contextInitialized(servletContextEvent);
	}
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ShiroConfigurationModule(servletContext), new GuiceServletModule());
	}
}
