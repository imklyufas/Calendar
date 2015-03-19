package com.softserveinc.calendar.controller.interfaces;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.softserveinc.calendar.model.CalendarBean;

public interface CalendarInterface {

	String showCalendar(Locale locale, MessageSource messageSource, CalendarBean calendar) throws UnsupportedEncodingException, ParseException;
}
