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

/**
 * test class for demonstration (the same as HorizontalCalendar)
 * @author Ihor Klyufas
 *
 */
public class TestCalendar implements CalendarInterface {

	@Override
	public String showCalendar(Locale locale, MessageSource messageSource,
			CalendarBean calendarBean) throws UnsupportedEncodingException,
			ParseException {
		
		HTMLTemplate template = new HTMLTemplate(locale, messageSource);
		StringBuffer sb = new StringBuffer();
		
		HTMLUtils html = new HTMLUtils();
		sb.append(html.getOpenedDivForm());
		sb.append(html.getClosedFormDiv());
		
		int year = calendarBean.getYear();
		
		sb.append(html.getOpenedDivForm())
				.append(html.getHiddenButton(Constants.PREV_YEAR_BUTTON, Constants.PREV_YEAR_BUTTON))
				.append(html.getButton("<<", 25, 35))
				.append(html.getClosedForm())
				.append(html.getBoldText("" + year))
				.append(html.getOpenedForm())
				.append(html.getHiddenButton(Constants.NEXT_YEAR_BUTTON, Constants.NEXT_YEAR_BUTTON))
				.append(html.getButton(">>", 25, 35))
				.append(html.getClosedFormDiv());
	
		int monthNum = calendarBean.getMonth();
		String month = template.getLocaleMessage(calendarBean.getMonthForInt(monthNum));
		
		sb.append(html.getTableHead(Constants.CENTER_ALIGN,	15, 500, 0, 0))
				.append(html.getTR())
				.append(html.getOpenedTD(Constants.CENTER_ALIGN, 7))
				.append(html.getOpenedDivForm())
				.append(html.getHiddenButton(Constants.PREV_MONTH_BUTTON, Constants.PREV_MONTH_BUTTON))
				.append(html.getButton("<", 25, 35))
				.append(html.getClosedForm())
				.append(html.getBoldText(month))
				.append(html.getOpenedForm())
				.append(html.getHiddenButton(Constants.NEXT_MONTH_BUTTON, Constants.NEXT_MONTH_BUTTON))
				.append(html.getButton(">", 25, 35))
				.append(html.getClosedFormDiv())
				.append(html.getClosedTD())
				.append(html.getClosedTR());
		
		String days[] = calendarBean.getDays(locale);
		
		GregorianCalendar gregCalendar = calendarBean.getGregorianCalendar();
		SimpleDateFormat simpleDateFormat = calendarBean.getSimpleDateFormat();
		gregCalendar.set(Calendar.DAY_OF_MONTH, 1);
	
		Date time = gregCalendar.getTime();
		simpleDateFormat.applyPattern("EEEE");
		int lastMonthDay = gregCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int firstDayPosition;
		for (firstDayPosition = 0; firstDayPosition < days.length; firstDayPosition++) {
			if (days[firstDayPosition].equals(simpleDateFormat.format(time).toString())) {
				break;
			}
		}
		
		int firstColDay = Constants.FIRST_COL_DAY;
		for (int tableRaw = 0; tableRaw < days.length; tableRaw++) {
			int daysCounter = 0, daysMatchCounter = 0;
			sb.append(html.getTR());
			for (int tableCol = 0; tableCol < days.length - 1; tableCol++) {
				int nextFirstCellDay = 1 + daysMatchCounter;
				int nextCellDay = 8 - firstDayPosition + daysCounter + tableRaw;
				String locDay = template.getLocaleMessage(days[tableRaw]);
				if (tableCol == 0) {
					sb.append(html.getTD(Constants.CENTER_ALIGN, locDay));
				} else {
					if (tableRaw != firstDayPosition) {
						if (tableCol == 1) {
							if (tableRaw > firstDayPosition) {
								sb.append(html.getTD(Constants.CENTER_ALIGN, "" + firstColDay));
								firstColDay++;
							} else {
								sb.append(html.getTD(Constants.CENTER_ALIGN, Constants.B_SPACE));
							}
						}
						if (nextCellDay <= lastMonthDay) {
							sb.append(html.getTD(Constants.CENTER_ALIGN, "" + nextCellDay));
							daysCounter += 7;
						} else {
							sb.append(html.getTD(Constants.CENTER_ALIGN, Constants.B_SPACE));
						}
					} else {
						if (nextFirstCellDay <= gregCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
							sb.append(html.getTD(Constants.CENTER_ALIGN, "" + nextFirstCellDay));
							daysMatchCounter += 7;
						} else {
							sb.append(html.getTD(Constants.CENTER_ALIGN, Constants.B_SPACE));
						}
					}
				}
			}
			sb.append(html.getClosedTR());
		}
		sb.append(html.getClosedTable());
		return sb.toString();
	}

}