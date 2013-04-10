// Created on Dec 27, 2011 by mo

package com.worldmediahd.modules;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;

import com.google.inject.Provides;
import com.worldmediahd.security.ShiroBaseRealm;

public class ShiroConfigurationModule extends ShiroWebModule {
	
	@Inject
	public ShiroConfigurationModule(ServletContext servletContext) {
		super(servletContext);
	}
	
//	@Override
//	protected void configureShiroWeb() {
//		try {
//			bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Provides
//    Ini loadShiroIni() {
//        return Ini.fromResourcePath("classpath:shiro.ini");
//    }
	
	@Override
	protected void configureShiroWeb() {
		try {
			bindRealm().to(ShiroBaseRealm.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}