/**
 * Copyright (C) 2015 Ihor Klyufas
 */

package com.gorik.calendar.helper;

public class HTMLUtils {

	public String getHtmlTitle() {
		return "<HTML><BODY style=\"width:100%;height:100%\">\n";
	}

	public String getHtmlTitle(String title) {
		String htmlHeader = "<HTML><HEAD><TITLE> " + title
				+ " </TITLE></HEAD><BODY style=\"width:100%;height:100%\">\n";
		return htmlHeader;
	}

	public String getHead(int level, String header) {
		String head = "<H" + level + " align=\"center\"> " + header + " </H"
				+ level + ">\n";
		return head;
	}

	public String getClosedBodyHtml() {
		return "</BODY></HTML>\n";
	}

	public String getHtmlFooter(String footerName) {
		String htmlFooter = "<p align=\"center\">" + footerName
				+ "</p></BODY></HTML>\n";
		return htmlFooter;
	}

	public String getTableHead(String align, int border, int width,
			int cellspacing, int cellpadding) {
		String tableHeader = "<TABLE align='" + align + "' border='" + border
				+ "' width='" + width + "' cellspacing='" + cellspacing
				+ "' cellpadding='" + cellpadding + "'>\n";
		return tableHeader;
	}

	public String getTableHead(String align, int border, int cellspacing,
			int cellpadding) {
		String tableHeader = "<TABLE align='" + align + "' border='" + border
				+ "' cellspacing='" + cellspacing + "' cellpadding='"
				+ cellpadding + "'>\n";
		return tableHeader;
	}

	public String getTR() {
		return "<TR>";
	}

	public String getTD() {
		return "<TD>";
	}

	public String getTD(String align, String value) {
		String tdCell = "<TD align='" + align + "'> " + value + " </TD>\n";
		return tdCell;
	}

	public String getTD(int width, String align, String value) {
		String tdCell = "<TD width='" + width + "' align='" + align + "'> "
				+ value + " </TD>\n";
		return tdCell;
	}

	public String getOpenedTD(String align, int colspan) {
		String tdCell = "<TD align='" + align + "' colspan='" + colspan + "'>";
		return tdCell;
	}

	public String getOpenedTD(int colspan) {
		return "<TD colspan='" + colspan + "'>";
	}

	public String getClosedTR() {
		return "</TR>";
	}

	public String getClosedTD() {
		return "</TD>";
	}

	public String getOpenedForm() {
		return "<form method=\"post\">";
	}

	public String getClosedForm() {
		return "</form>\n";
	}

	public String getOpenedDivForm() {
		return "<div align=\"center\"><form method=\"post\">";
	}

	public String getClosedFormDiv() {
		return "</form></div>\n";
	}

	public String getRadioButton(String name, String value, boolean checked,
			String buttonName) {
		String c = "";
		if (checked) {
			c = " checked";
		}
		String radio = "<input type=\"radio\" name=\"" + name + "\" value=\""
				+ value + "\"" + c + ">" + buttonName + "\n<p>";
		return radio;
	}

	public String getButton(String buttonName) {
		String button = "<input type=\"submit\" value=\"" + buttonName
				+ "\"><p>\n";
		return button;
	}

	public String getButton(String buttonValue, int height, int wight) {
		String button = "<input type=\"submit\" value=\"" + buttonValue
				+ "\" style=\"height: " + height + "px; width: " + wight
				+ "px\"></input>\n";
		return button;
	}

	public String getHiddenButton(String name) {
		String hidButton = "<input type=\"hidden\" name=\"" + name
				+ "\"></input>\n";
		return hidButton;
	}

	public String getHiddenButton(String name, String value) {
		String hidButton = "<input type=\"hidden\" name=\"" + name
				+ "\" value=\"" + value + "\"></input>\n";
		return hidButton;
	}

	public String getBoldText(String text) {
		return "<p align=\"center\"><b>" + text + "</b></p>\n";
	}

	public String getText(String text) {
		return "<p align=\"center\">" + text + "</p>\n";
	}

	public String getNewLine() {
		return "<br>\n";
	}

	public String getClosedTable() {
		return "</table>\n";
	}

	public String getSelect(String name) {
		return "<select name=\"" + name + "\">\n";
	}

	public String getClosedSelect() {
		return "</select>\n";
	}

	public String getOption(int i, boolean checked, String name) {
		String s = "";
		if (checked) {
			s = " selected=\"selected\"";
		}
		String option = "<option value=\"" + i + "\"" + s + ">" + name
				+ "</option>\n";
		return option;
	}
}