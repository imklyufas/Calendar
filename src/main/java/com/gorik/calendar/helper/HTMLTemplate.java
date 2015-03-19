package com.softserveinc.calendar.helper;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.context.MessageSource;

import com.softserveinc.calendar.controller.interfaces.CalendarInterface;

public class HTMLTemplate {
	
	private HTMLUtils html = new HTMLUtils();
	private MessageSource messageSource;
	private Locale locale;
	
	public HTMLTemplate() {
	}

	public HTMLTemplate(Locale locale, MessageSource messageSource) {
		this.locale = locale;
		this.messageSource = messageSource;
	}
	
	public String getPageHeader() throws UnsupportedEncodingException {
		String title = getLocaleMessage(Constants.TITLE);
		String header = getLocaleMessage(Constants.HEADER);
		String locale = getLocaleMessage(Constants.LOCALE);
		StringBuffer sb = new StringBuffer(); 
		sb.append(html.getHtmlTitle(title))
			.append(html.getHead(1, header))
			.append(html.getText(locale))
			.append(html.getOpenedDivForm())
			.append(html.getNewLine());
		return sb.toString();
	}
	
	public String getPageFooter() throws UnsupportedEncodingException {
		String footerName = getLocaleMessage(Constants.FOOTER);
		String footer = html.getHtmlFooter(footerName);
		return footer;
	}
	
	public StringBuffer getRadioButtons(Map<String, CalendarInterface> map, String viewName, HTMLUtils html) {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, CalendarInterface> entry : map.entrySet()) {
			String radioButtonName;
			try {
				radioButtonName = getLocaleMessage(entry.getKey());
			} catch (Exception e) {
				radioButtonName = entry.getKey();
			}
			boolean check = false;
			if (viewName.equals(entry.getKey())) {
				check = true;
			}
			sb.append(html.getRadioButton(Constants.RADIO, entry.getKey(), check, radioButtonName));
		}
		return sb;
	}
	
	public String getLocaleMessage(String message) {
		return messageSource.getMessage(message, null, locale);
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(html)
			.append(messageSource)
			.append(locale)
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
