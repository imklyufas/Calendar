package com.softserveinc.calendar.helper;


public class HTMLUtils {

	public String getHtmlTitle() {
		String htmlHeader = null;
		htmlHeader = "<HTML><BODY style=\"width:100%;height:100%\">\n";
		return htmlHeader;
	}
	
	public String getHtmlTitle(String title) {
		String htmlHeader = null;
		htmlHeader = "<HTML><HEAD><TITLE> " + title + " </TITLE></HEAD><BODY style=\"width:100%;height:100%\">\n";
		return htmlHeader;
	}

	public String getHead(int level, String header) {
		String head = "<H" + level + " align=\"center\"> " + header + " </H" + level + ">\n";
		return head;
	}
	
	public String getClosedBodyHtml() {
		String htmlFooter = "</BODY></HTML>\n";
		return htmlFooter;
	}
	
	public String getHtmlFooter(String footerName) {
		String htmlFooter = "<p align=\"center\">" + footerName + "</p></BODY></HTML>\n";
		return htmlFooter;
	}
	
	public String getTableHead(String align, int border, int width, int cellspacing, int cellpadding) {
		String tableHeader = "<TABLE align='" + align + "' border='" + border + "' width='" + width + "' cellspacing='" + cellspacing + "' cellpadding='" + cellpadding + "'>\n";
		return tableHeader;
	}
	
	public String getTableHead(String align, int border, int cellspacing, int cellpadding) {
		String tableHeader = "<TABLE align='" + align + "' border='" + border + "' cellspacing='" + cellspacing + "' cellpadding='" + cellpadding + "'>\n";
		return tableHeader;
	}

	public String getTR() {
		String trCell = "<TR>";
		return trCell;
	}
	
	public String getTD() {
		String trCell = "<TD>";
		return trCell;
	}

	public String getTD(String align, String value) {
		String tdCell = "<TD align='" + align + "'> " + value + " </TD>\n";
		return tdCell;
	}
	
	public String getTD(int width, String align, String value) {
		String tdCell = "<TD width='" + width + "' align='" + align + "'> " + value + " </TD>\n";
		return tdCell;
	}
	
	public String getOpenedTD(String align, int colspan) {
		String tdCell = "<TD align='" + align + "' colspan='" + colspan + "'>";
		return tdCell;
	}
	
	public String getOpenedTD(int colspan) {
		String tdCell = "<TD colspan='" + colspan + "'>";
		return tdCell;
	}

	public String getClosedTR() {
		String trCell = "</TR>";
		return trCell;
	}

	public String getClosedTD() {
		String tdCell = "</TD>";
		return tdCell;
	}

	public String getOpenedForm() {
		String form = "<form method=\"post\">";
		return form;
	}
	
	public String getClosedForm() {
		String form = "</form>\n";
		return form;
	}
	
	public String getOpenedDivForm() {
		String form = "<div align=\"center\"><form method=\"post\">";
		return form;
	}
	
	public String getClosedFormDiv() {
		String form = "</form></div>\n";
		return form;
	}

	public String getRadioButton (String name, String value, boolean checked, String buttonName) {
		String c = "";
		if (checked) {
			c = " checked";
		}
		String radio = "<input type=\"radio\" name=\"" + name + "\" value=\"" + value + "\"" + c + ">" + buttonName + "\n<p>";
		return radio;
	}
	
	public String getButton(String buttonName) {
		String button = "<input type=\"submit\" value=\"" + buttonName + "\"><p>\n";
		return button;
	}
	
	public String getButton(String buttonValue, int height, int wight) {
		String button = "<input type=\"submit\" value=\"" + buttonValue + "\" style=\"height: " + height + "px; width: " + wight + "px\"></input>\n";
		return button;
	}
	
	public String getHiddenButton(String name) {
		String hidButton = "<input type=\"hidden\" name=\"" + name + "\"></input>\n";
		return hidButton;
	}
	
	public String getHiddenButton(String name, String value) {
		String hidButton = "<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"></input>\n";
		return hidButton;
	}
	
	public String getBoldText(String text) {
		String boldText = "<p align=\"center\"><b>" + text + "</b></p>\n";
		return boldText;
	}
	
	public String getText(String text) {
		String boldText = "<p align=\"center\">" + text + "</p>\n";
		return boldText;
	}
	
	public String getNewLine() {
		String boldText = "<br>\n";
		return boldText;
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
		String option = "<option value=\"" + i + "\"" + s + ">" + name + "</option>\n";
		return option;
	}

}
