package org.vaadin.war.views;

import static org.vaadin.war.MyUI.CALENDAR_VIEW;
import static org.vaadin.war.MyUI.LOGIN_VIEW;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
@CDIView(LOGIN_VIEW)
public class LoginView extends VerticalLayout implements View {
	
	
	public LoginView() {
		setSizeFull();
		
		Button loginButton = new Button("Login");
		
		loginButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(CALENDAR_VIEW);
				
			}
		});
		
		addComponent(loginButton);
		setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
		
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to this test!");

	}

}
