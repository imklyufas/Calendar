package com.softserveinc.calendar.view;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.softserveinc.calendar.controller.interfaces.CalendarInterface;
import com.softserveinc.calendar.helper.Constants;
import com.softserveinc.calendar.helper.HTMLTemplate;
import com.softserveinc.calendar.helper.HTMLUtils;
import com.softserveinc.calendar.model.CalendarBean;

public class VerticalCalendar implements CalendarInterface {

	@Override
	public String showCalendar(Locale locale, MessageSource messageSource,
			CalendarBean calendarBean) throws UnsupportedEncodingException,
			ParseException {

		HTMLTemplate template = new HTMLTemplate(locale, messageSource);
		StringBuffer sb = new StringBuffer();
		
		int selectedMonth = calendarBean.getMonth();
		int selectedYear = calendarBean.getYear();
		
		HTMLUtils html = new HTMLUtils();
		sb.append(html.getOpenedDivForm());
		
		sb.append(html.getClosedFormDiv())
				.append(html.getOpenedDivForm())
				.append(html.getSelect(Constants.MONTH));
		for (int i = 0; i < 12; i++) {
			String locMonth = template.getLocaleMessage(calendarBean.getMonthForInt(i));
			if (selectedMonth != 0 && i == selectedMonth) {
				sb.append(html.getOption(i, true, locMonth));
			} else {
				sb.append(html.getOption(i, false, locMonth));
			}
		}
		sb.append(html.getClosedSelect());
				
		sb.append(html.getSelect(Constants.YEAR));
		for (int i = 2030; i > 1980; i--) {
			if (i == selectedYear) {
				sb.append(html.getOption(i, true, "" + i));
			} else {
				sb.append(html.getOption(i, false, "" + i));
			}
		}
		sb.append(html.getClosedSelect())
				.append(html.getHiddenButton(Constants.MONTH + "\";\"" + Constants.YEAR))
				.append(html.getButton(template.getLocaleMessage(Constants.SELECT), 25, 85))
				.append(html.getClosedFormDiv());
		
		String currentMonth = template.getLocaleMessage(calendarBean.getMonthForInt(calendarBean.getMonth()));
		sb.append(html.getBoldText("" + selectedYear))
				.append(html.getTableHead(Constants.CENTER_ALIGN, 5, 500, 0, 0))
				.append(html.getTR())
				.append(html.getOpenedTD(Constants.CENTER_ALIGN, 7))
				.append(html.getBoldText(currentMonth))
				.append(html.getClosedTD())
				.append(html.getClosedTR());

		String days[] = calendarBean.getDays(locale);
		String locDay;
		sb.append(html.getTR());
		for (int i = 0; i < days.length; i++) {
			locDay = template.getLocaleMessage(days[i]);
			sb.append(html.getTD(175, Constants.CENTER_ALIGN, locDay));
		}
		sb.append(html.getClosedTR());
		
		GregorianCalendar gregCalendar = calendarBean.getGregorianCalendar();
		SimpleDateFormat simpleDateFormat = calendarBean.getSimpleDateFormat();
		gregCalendar.set(Calendar.DAY_OF_MONTH, 1);
		boolean finish = false;

		for (;;) {
			sb.append(html.getTR());
			for (int i = 0; i < days.length; i++) {
				Date time = gregCalendar.getTime();
				simpleDateFormat.applyPattern("EEEE");
				if (days[i].equals(simpleDateFormat.format(time).toString())) {
					simpleDateFormat.applyPattern("d");
					sb.append(html.getTD(Constants.CENTER_ALIGN, simpleDateFormat.format(time).toString()));
					if (gregCalendar.get(Calendar.DAY_OF_MONTH) == gregCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
						finish = true;
						break;
					}
					gregCalendar.roll(Calendar.DAY_OF_MONTH, true);
				} else {
					sb.append(html.getTD(Constants.CENTER_ALIGN, Constants.B_SPACE));
				}
			}
			sb.append(html.getClosedTR());
			if (finish)
				break;
		}
		sb.append(html.getClosedTable());
		return sb.toString();
	}
}