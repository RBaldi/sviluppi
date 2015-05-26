package org.vaadin.war;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("valo")
@Widgetset("org.vaadin.war.MyAppWidgetset")
@CDIUI("")
//@URLMapping("myCdiUiServlet")
public class MyUI extends UI {

	public static final String LOGIN_VIEW = "loginView";
	public static final String CALENDAR_VIEW = "calendarView";
	
	@Inject
    CDIViewProvider viewProvider;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	getPage().setTitle("Navigation Page");

    	
    	Navigator navigator = new Navigator(this,this);
    	
    	navigator.addProvider(viewProvider);
    	//navigator.addView(LOGIN_VIEW, LoginView.class);
    	//navigator.addView(CALENDAR_VIEW, CalendarView.class);
    	
    	
    	//setNavigator(navigator);
    	
    	navigator.navigateTo(LOGIN_VIEW);
    	
      }
    
    

//    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
//    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//    }
}
