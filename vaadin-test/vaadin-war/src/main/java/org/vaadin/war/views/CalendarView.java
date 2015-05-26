package org.vaadin.war.views;

import static org.vaadin.war.MyUI.CALENDAR_VIEW;
import static org.vaadin.war.MyUI.LOGIN_VIEW;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.stuff.ejb.service.UserServiceImpl;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@CDIView(CALENDAR_VIEW)
public class CalendarView extends VerticalLayout implements View {

	//@EJB(lookup="java:global/stuff-ear/stuff-ejb/UserServiceImpl!org.stuff.ejb.service.UserServiceImpl")
	@EJB
	private UserServiceImpl userService; 

	Button logoutButton;
	Button weekViewButton;
	Button monthlyViewButton;
	Panel calendarPanel;
	Label userLabel;
	HorizontalLayout calendarButtonLayout;
	
	private Calendar calendarObject;
	
	
	@PostConstruct
	private void initCalendarView() {
		String label = null;
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		if (userService != null) {
			label = userService.getUserName();
		}
		
		
		userLabel = new Label();
		userLabel.setValue(label);
		
		logoutButton = new Button("Logout");
		logoutButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(LOGIN_VIEW);

			}
		});

		
		
		addComponent(userLabel);
		addComponent(logoutButton);
		
		calendarButtonLayout = new HorizontalLayout();
		
		monthlyViewButton = new Button("Month view");
		monthlyViewButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				initToMonthCalendar();
				
			}
		});
		
		weekViewButton = new Button("Week view");
		weekViewButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				initToWeekCalendar();
				
			}
		});
		
		calendarButtonLayout.addComponent(monthlyViewButton);
		calendarButtonLayout.addComponent(weekViewButton);

		
		addComponent(calendarButtonLayout);
		
		calendarPanel = new Panel();
		
		addComponent(calendarPanel);
		
	}

	/**
	 * Costruttore della vista per il calendario
	 * 
	 * 
	 */
	public CalendarView() {
		

	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (event.getParameters() != null) {
			calendarPanel.setContent(new CalendarViewer());
		}

	}

	class CalendarViewer extends VerticalLayout {

		public CalendarViewer() {
			
			if (calendarObject == null) {
				calendarObject = new Calendar("timeSheetCalendar");
			}
			

			initToMonthCalendar();
			addComponent(calendarObject);

		}

	}
	
	
	/**
	 * Inizializza l'oggetto calendario per la view
	 * alla visualizzazione su mese
	 * 
	 * 
	 * 
	 */
	private void initToMonthCalendar() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);

		calendarObject.setStartDate(calendar.getTime());

		calendar.set(GregorianCalendar.DAY_OF_MONTH,
				calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));

		calendarObject.setEndDate(calendar.getTime());
		
	}

	
	private void initToWeekCalendar() {
		GregorianCalendar calendar = new GregorianCalendar();
		
		
		calendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		
		int today = calendar.get(GregorianCalendar.DAY_OF_WEEK);
		
		calendar.add(GregorianCalendar.DAY_OF_WEEK, (-today + GregorianCalendar.MONDAY));

		calendarObject.setStartDate(calendar.getTime());
		
		calendar.add(GregorianCalendar.DAY_OF_WEEK, 6);
		
		
		calendarObject.setEndDate(calendar.getTime());
		
		
	}
	
}
