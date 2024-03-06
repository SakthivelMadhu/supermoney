package main.java.com.flipkar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	private static final String DATE_FORMAT = "dd-MM hh:mm a";
	
	
	//format a date string
	public static Date parseDate(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.parse(dateString);
	}
	
	// formats a date obj
	public static String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}

}