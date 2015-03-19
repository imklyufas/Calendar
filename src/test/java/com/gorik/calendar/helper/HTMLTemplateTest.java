/**
 * Copyright (C) 2015 Ihor Klyufas
 */

package com.gorik.calendar.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;

import com.gorik.calendar.helper.HTMLTemplate;

public class HTMLTemplateTest {

	private HTMLTemplate defaultHTML;
	private HTMLTemplate paramHTML;
	private Locale locale;
    private MessageSource messageSource;
	
	@Before
	public void setUp() throws Exception {
		messageSource = mock(MessageSource.class);
		locale = new Locale("en");
		defaultHTML = new HTMLTemplate();
		paramHTML = new HTMLTemplate(locale, messageSource);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetPageHeader() throws UnsupportedEncodingException {
		String actual = "<HTML><HEAD><TITLE> null </TITLE></HEAD><BODY style=\"width:100%;height:100%\">\n"
				+ "<H1 align=\"center\"> null </H1>\n"
				+ "<p align=\"center\">null</p>\n"
				+ "<div align=\"center\">"
				+ "<form method=\"post\"><br>\n";
		String expected = paramHTML.getPageHeader();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPageFooter() throws UnsupportedEncodingException {
		String actual = "<p align=\"center\">null</p></BODY></HTML>\n";
		String expected = paramHTML.getPageFooter();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHashCode() {
		Integer actual = defaultHTML.hashCode();
		Integer expected = defaultHTML.hashCode();
		boolean equal = actual.equals(expected);
		assertTrue(equal);
	}
	
	@Test
	public void testEqualsObject() {
		assertFalse(defaultHTML.equals(new Object()));
		assertFalse(defaultHTML.equals(null));
	}
}