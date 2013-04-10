package com.worldmediahd.ui;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class AuthenticatedScreen extends VerticalLayout
{
	private static final long serialVersionUID = 1L;
	private MyVaadinApplication app;

	
	public AuthenticatedScreen(MyVaadinApplication app)
    {
        super();
        this.app = app;

        Subject currentUser = SecurityUtils.getSubject();
        Label label = new Label("Logged in as " +  currentUser.getPrincipal().toString());
        
        Button admin = new Button("For administrators only");
        Button user  = new Button("For users only");
        
        if (!currentUser.hasRole("admin")){
        	admin.setEnabled(false);
        }else if (!currentUser.hasRole("user")){
        	user.setEnabled(false);
        }
        
        
        Button perm = new Button("For all with permission 'permission_2' only");
        if(!currentUser.isPermitted("permission_2")){
        	perm.setEnabled(false);
        }
        
        Button service = new Button("call service");
        service.addListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				AuthenticatedScreen.this.app.service.buttonClicked();
			}
		});
        
        Button logout = new Button("logout");
        logout.addListener(new MyVaadinApplication.LogoutListener(this.app));

        this.addComponent(label);
        this.addComponent(service);
        this.addComponent(admin);
        this.addComponent(user);
        this.addComponent(perm);
        this.addComponent(logout);
    
    }
}
