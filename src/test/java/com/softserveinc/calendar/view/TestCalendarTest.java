package com.softserveinc.calendar.view;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;

import com.softserveinc.calendar.controller.interfaces.CalendarInterface;
import com.softserveinc.calendar.model.CalendarBean;

public class TestCalendarTest {

	private HorizontalCalendar calendar;
	private MessageSource messageSource;

    @Before
    public void setUp() {
        calendar = new HorizontalCalendar();
        messageSource = mock(MessageSource.class);
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowCalendar() throws UnsupportedEncodingException, ParseException {
		Map<String, CalendarInterface> map = new HashMap<String, CalendarInterface>();
		TestCalendar hor = new TestCalendar();
		map.put("test", hor);
		CalendarBean calendarBean = new CalendarBean();
		Locale locale = new Locale("en");
		String expected = calendar.showCalendar(locale, messageSource, calendarBean);
		assertTrue(expected.contains("<div align=\"center\"><form method=\"post\"><input type=\"hidden\" name=\"prevYearButton\" value=\"prevYearButton\"></input>"));
	}

}
