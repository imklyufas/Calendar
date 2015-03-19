package com.softserveinc.calendar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.softserveinc.calendar.controller.interfaces.CalendarInterface;
import com.softserveinc.calendar.helper.Constants;
import com.softserveinc.calendar.model.CalendarBean;
import com.softserveinc.calendar.view.HTMLLayout;

@Controller
@RequestMapping("/")
public class ViewMapController extends HttpServlet implements ServletContextAware, MessageSourceAware {
	
	private static final long serialVersionUID = 1L;
	private String viewName = Constants.DEFAULT_CALENDAR_TYPE;
	private CalendarBean calendarBean = new CalendarBean();
	private ServletContext servletContext;
	private MessageSource messageSource;
	private HTMLLayout layout;
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		//set initial values of control buttons
		setCalendarButtons(request);
		
		Locale locale = request.getLocale();
		String view = request.getParameter(Constants.RADIO);
		if (view != null) {
			viewName = view;
		}
		
		String htmlPage = null;
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		if (context != null) {
			Map<String, CalendarInterface> map = context.getBeansOfType(CalendarInterface.class);
			CalendarInterface calendar = (CalendarInterface) context.getBean(viewName);
			layout = new HTMLLayout(locale, messageSource, map, viewName);
			try {
				String calendarBody = calendar.showCalendar(locale, messageSource, calendarBean);
				layout.addBody(calendarBody);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		htmlPage = layout.getPage();
		out.println(htmlPage);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * set buttons into the calendar model
	 * @param request
	 */
	private void setCalendarButtons(HttpServletRequest request) {
		String prevYearButton = request.getParameter(Constants.PREV_YEAR_BUTTON);
		String nextYearButton = request.getParameter(Constants.NEXT_YEAR_BUTTON);
		String prevMonthButton = request.getParameter(Constants.PREV_MONTH_BUTTON);
		String nextMonthButton = request.getParameter(Constants.NEXT_MONTH_BUTTON);
		String selectedMonth = request.getParameter(Constants.MONTH);
		String selectedYear = request.getParameter(Constants.YEAR);
		try {
			calendarBean.setCalendarButtons(prevYearButton, nextYearButton, prevMonthButton, nextMonthButton, selectedMonth, selectedYear);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
