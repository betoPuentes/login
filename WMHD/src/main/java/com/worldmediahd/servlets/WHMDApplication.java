package com.worldmediahd.servlets;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Provider;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

/**
 * This is where Guice will store/acquire the Vaadin Application that it has
 * bootstrapped. All the basic web requests will come here first through
 * Guice-Servlet extension, and Vaadin takes care of it then.
 * 
 * @author Mo
 */

@SuppressWarnings("serial")
@Singleton
public class WHMDApplication extends AbstractApplicationServlet {
	
	protected Provider<Application> applicationProvider;
	
	@Inject
	public WHMDApplication(Provider<Application> applicationProvider) {
		super();
		this.applicationProvider = applicationProvider;
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	protected Application getNewApplication(HttpServletRequest request) throws ServletException {
		return applicationProvider.get();
	}
	
	@Override
	protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
		return Application.class;
	}
}
