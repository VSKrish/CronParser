package com.parser.CronParser;


public class CronParserFactory {
	static CronParser getCronParser(String type) {
		if("minute".equals(type))
			return new MinuteParser();
		else if("hour".equals(type))
			return new HourParser();
		else if("day of month".equals(type))
			return new DayOfMonthParser();
		else if("month".equals(type))
			return new MonthParser();
		else if("day of week".equals(type))
			return new DayOfWeekParser();
		else 
			return null;
	}
}
