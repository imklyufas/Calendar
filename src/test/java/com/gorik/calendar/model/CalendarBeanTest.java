/**
 * Copyright (C) 2015 Ihor Klyufas
 */

package com.gorik.calendar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gorik.calendar.model.CalendarBean;

public class CalendarBeanTest {

	private CalendarBean defaultCalendar;
	
	@Before
	public void setUp() throws Exception {
		defaultCalendar = new CalendarBean();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetGregorianCalendar() {
		GregorianCalendar expected = new GregorianCalendar();
		defaultCalendar.setGregorianCalendar(new GregorianCalendar());
		GregorianCalendar actual = defaultCalendar.getGregorianCalendar();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSimpleDateFormat() {
		SimpleDateFormat expected = new SimpleDateFormat();
		SimpleDateFormat actual = defaultCalendar.getSimpleDateFormat();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetSimpleDateFormat() {
		SimpleDateFormat expected = new SimpleDateFormat();
		defaultCalendar.setSimpleDateFormat(new SimpleDateFormat());
		SimpleDateFormat actual = defaultCalendar.getSimpleDateFormat();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetYear() {
		int expected = Calendar.getInstance().get(Calendar.YEAR);
		int actual = defaultCalendar.getYear();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetYear() {
		int expected = 2013;
		defaultCalendar.setYear(2013);
		int actual = defaultCalendar.getYear();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetMonth() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int expected = gregorianCalendar.get(Calendar.MONTH);
		int actual = defaultCalendar.getMonth();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMonth() throws ParseException {
		int expected = 9;
		defaultCalendar.setMonth(9);
		int actual = defaultCalendar.getMonth();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCalendarType() {
		String expected = "horizontal";
		String actual = defaultCalendar.getCalendarType();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCalendarType() {
		String expected = "vertical";
		defaultCalendar.setCalendarType("vertical");
		String actual = defaultCalendar.getCalendarType();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDays() {
		String language = "uk";
		Locale locale = new Locale(language);
		
		Calendar cal = Calendar.getInstance(locale);
	    int firstDayOfWeek = cal.getFirstDayOfWeek();
	    assertEquals(firstDayOfWeek, 2);
	    
		String[] expected = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String[] actual = defaultCalendar.getDays(locale);
		List<String> ex = Arrays.asList(expected);
		List<String> ac = Arrays.asList(actual);
		assertEquals(ex, ac);
	}

	@Test
	public void testGetDayForInt() {
		String actual = "Wednesday";
		String expected = defaultCalendar.getDayForInt(3);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetMonthForInt() {
		String actual = "October";
		String expected = defaultCalendar.getMonthForInt(9);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetIntForMonth() throws ParseException {
		int actual = 1;
		int expected = defaultCalendar.getIntForMonth("February");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHashCode() {
		Integer actual = defaultCalendar.hashCode();
		Integer expected = defaultCalendar.hashCode();
		boolean equal = actual.equals(expected);
		assertTrue(equal);
	}
	
	@Test
	public void testEqualsObject() {
		assertFalse(defaultCalendar.equals(new Object()));
		assertFalse(defaultCalendar.equals(null));
	}
}