/**
 * Copyright (C) 2015 Ihor Klyufas
 */

package com.gorik.calendar.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gorik.calendar.helper.HTMLUtils;

public class HtmlUtilsTest {

	private HTMLUtils defaultHtml;
	
	@Before
	public void setUp() throws Exception {
		defaultHtml = new HTMLUtils();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateHtmlTitle() {
		String actual = "<HTML><HEAD><TITLE> Hello </TITLE></HEAD><BODY style=\"width:100%;height:100%\">\n";
		String expected = defaultHtml.getHtmlTitle("Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHead() {
		String actual = "<H1 align=\"center\"> Hello </H1>\n";
		String expected = defaultHtml.getHead(1, "Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHtmlFooter() {
		String actual = "<p align=\"center\">Copyright © Ihor Klyufas</p></BODY></HTML>\n";
		String expected = defaultHtml.getHtmlFooter("Copyright © Ihor Klyufas");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTableHead() {
		String actual = "<TABLE align='center' border='10' width='55' cellspacing='7' cellpadding='0'>\n";
		String expected = defaultHtml.getTableHead("center", 10, 55, 7, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTR() {
		String actual = "<TR>";
		String expected = defaultHtml.getTR();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTDStringString() {
		String actual = "<TD align='center'> Hello </TD>\n";
		String expected = defaultHtml.getTD("center", "Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTDIntStringString() {
		String actual = "<TD width='5' align='center'> Hello </TD>\n";
		String expected = defaultHtml.getTD(5, "center", "Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOpenedTD() {
		String actual = "<TD align='center' colspan='7'>";
		String expected = defaultHtml.getOpenedTD("center", 7);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedTR() {
		String actual = "</TR>";
		String expected = defaultHtml.getClosedTR();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedTD() {
		String actual = "</TD>";
		String expected = defaultHtml.getClosedTD();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOpenedForm() {
		String actual = "<form method=\"post\">";
		String expected = defaultHtml.getOpenedForm();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedForm() {
		String actual = "</form>\n";
		String expected = defaultHtml.getClosedForm();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOpenedDivForm() {
		String actual = "<div align=\"center\"><form method=\"post\">";
		String expected = defaultHtml.getOpenedDivForm();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedFormDiv() {
		String actual = "</form></div>\n";
		String expected = defaultHtml.getClosedFormDiv();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetRadioButton() {
		String actual = "<input type=\"radio\" name=\"Button 1\" value=\"Button 1\" checked>Button 1\n<p>";
		String expected = defaultHtml.getRadioButton("Button 1", "Button 1", true, "Button 1");
		assertEquals(expected, actual);
		actual = "<input type=\"radio\" name=\"Button 1\" value=\"Button 1\">Button 1\n<p>";
		expected = defaultHtml.getRadioButton("Button 1", "Button 1", false, "Button 1");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetButtonString() {
		String actual = "<input type=\"submit\" value=\"Hello\"><p>\n";
		String expected = defaultHtml.getButton("Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetButtonStringIntInt() {
		String actual = "<input type=\"submit\" value=\"Hello\" style=\"height: 5px; width: 10px\"></input>\n";
		String expected = defaultHtml.getButton("Hello", 5, 10);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHiddenButtonString() {
		String actual = "<input type=\"hidden\" name=\"Hidden\"></input>\n";
		String expected = defaultHtml.getHiddenButton("Hidden");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetHiddenButtonStringString() {
		String actual = "<input type=\"hidden\" name=\"Button 1\" value=\"Hidden\"></input>\n";
		String expected = defaultHtml.getHiddenButton("Button 1", "Hidden");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetBoldText() {
		String actual = "<p align=\"center\"><b>Bold</b></p>\n";
		String expected = defaultHtml.getBoldText("Bold");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetText() {
		String actual = "<p align=\"center\">Hello</p>\n";
		String expected = defaultHtml.getText("Hello");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedTable() {
		String actual = "</table>\n";
		String expected = defaultHtml.getClosedTable();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSelect() {
		String actual = "<select name=\"Select\">\n";
		String expected = defaultHtml.getSelect("Select");
		assertEquals(expected, actual);
	}

	@Test
	public void testGetClosedSelect() {
		String actual = "</select>\n";
		String expected = defaultHtml.getClosedSelect();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOption() {
		String actual = "<option value=\"1\" selected=\"selected\">Option 1</option>\n";
		String expected = defaultHtml.getOption(1, true, "Option 1");
		assertEquals(expected, actual);
		actual = "<option value=\"2\">Option 2</option>\n";
		expected = defaultHtml.getOption(2, false, "Option 2");
		assertEquals(expected, actual);
	}
}