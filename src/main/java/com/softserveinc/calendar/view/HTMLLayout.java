package com.softserveinc.calendar.view;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.softserveinc.calendar.controller.interfaces.CalendarInterface;
import com.softserveinc.calendar.helper.Constants;
import com.softserveinc.calendar.helper.HTMLTemplate;
import com.softserveinc.calendar.helper.HTMLUtils;

public class HTMLLayout {

	private String body;
	private Locale locale;
	private MessageSource messageSource;
	private Map<String, CalendarInterface> map;
	private String viewName;


	public HTMLLayout(Locale locale, MessageSource messageSource, Map<String, CalendarInterface> map, String viewName) {
		this.locale = locale;
		this.messageSource = messageSource;
		this.map = map;
		this.viewName = viewName;
	}
	
	public String getPage() throws UnsupportedEncodingException {
		
		StringBuffer sb = new StringBuffer();
		
		HTMLUtils html = new HTMLUtils();
		HTMLTemplate template = new HTMLTemplate(locale, messageSource);
		sb.append(html.getHtmlTitle());
		
		sb.append(html.getTableHead(Constants.CENTER_ALIGN, 0, 0, 0));
		sb.append(html.getTR());
		sb.append(html.getOpenedTD(2));
		
		//Header
		sb.append(template.getPageHeader());
			
		sb.append(html.getClosedTD());
		sb.append(html.getClosedTR());
		sb.append(html.getTR());
		sb.append(html.getTD());

		//Menu
		sb.append(template.getRadioButtons(map, viewName, html));
		sb.append(html.getButton(template.getLocaleMessage(Constants.SELECT)));
		
		sb.append(html.getClosedTD());
		sb.append(html.getTD());
		
		//Body
		sb.append(body);
	
		sb.append(html.getClosedTD());
		sb.append(html.getClosedTR());
		sb.append(html.getTR());
		sb.append(html.getOpenedTD(2));
		
		//Footer
		sb.append(html.getNewLine());
		sb.append(template.getPageFooter());
		
		sb.append(html.getClosedTD());
		sb.append(html.getClosedTR());
		sb.append(html.getClosedTable());
		sb.append(html.getClosedBodyHtml());
		return sb.toString();
	}

	public void addBody(String body) {
		this.body = body;
	}

}
