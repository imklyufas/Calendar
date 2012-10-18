package com.softserveinc.calendar.model;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.softserveinc.calendar.helper.Constants;

public class CalendarBean {

	private GregorianCalendar gregorianCalendar;
	private SimpleDateFormat simpleDateFormat;

	private String calendarType;

	private int year;
	private int month;

	public CalendarBean() {
		gregorianCalendar = new GregorianCalendar();
		simpleDateFormat = new SimpleDateFormat();
		year = gregorianCalendar.get(Calendar.YEAR);
		month = gregorianCalendar.get(Calendar.MONTH);
		calendarType = Constants.DEFAULT_CALENDAR_TYPE;
	}

	public GregorianCalendar getGregorianCalendar() {
		return gregorianCalendar;
	}

	public void setGregorianCalendar(GregorianCalendar gregorianCalendar) {
		this.gregorianCalendar = gregorianCalendar;
	}

	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		gregorianCalendar.set(Calendar.YEAR, year);
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws ParseException {
		if (month < 0) {
			month = 11;
			setYear(year - 1);
		} else if (month > 11) {
			month = 0;
			setYear(year + 1);
		}
		gregorianCalendar.set(Calendar.MONTH, month);
		this.month = month;
	}

	public String getCalendarType() {
		return calendarType;
	}

	public void setCalendarType(String calendarType) {
		this.calendarType = calendarType;
	}

	public String[] getDays(Locale locale) {
		Calendar cal = Calendar.getInstance(locale);
		DateFormatSymbols dfs = new DateFormatSymbols();
		String weekdays[] = dfs.getWeekdays();
		int firstDayOfWeek = cal.getFirstDayOfWeek();
		List<String> days = new ArrayList<String>();
		for (int i = firstDayOfWeek; i < weekdays.length; i++) {
			days.add(weekdays[i]);
		}
		if (firstDayOfWeek != 1) {
			for (int i = 1; i < firstDayOfWeek; i++) {
				days.add(weekdays[i]);
			}
		}
		return days.toArray(new String[days.size()]);
	}

	public String getDayForInt(int d) {
		String day = "Incorect number of day";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] days = dfs.getWeekdays();
		if (d >= 0 && d <= 6) {
			day = days[d + 1];
		}
		return day;
	}

	public String getMonthForInt(int m) {
		String month = "Incorect number of month";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (m >= 0 && m <= 11) {
			month = months[m];
		}
		return month;
	}

	public int getIntForMonth(String month) throws ParseException {
		Date date = new SimpleDateFormat("MMM").parse(month);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int intMonth = cal.get(Calendar.MONTH);
		return intMonth;
	}

	public void setCalendarButtons(String prevYearButton, String nextYearButton, String prevMonthButton, String nextMonthButton, String selectedMonth, String selectedYear) throws ParseException {
		if (prevYearButton != null) {
			setYear(year - 1);
		} else if (nextYearButton != null) {
			setYear(year + 1);
		}
		if (prevMonthButton != null) {
			setMonth(month - 1);
		} else if (nextMonthButton != null) {
			setMonth(month + 1);
		}
		if (selectedMonth != null) {
			month = Integer.parseInt(selectedMonth);
			setMonth(month);
		}
		if (selectedYear != null) {
			year = Integer.parseInt(selectedYear);
			setYear(year);
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(gregorianCalendar)
				.append(simpleDateFormat).append(calendarType).append(year)
				.append(month).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
