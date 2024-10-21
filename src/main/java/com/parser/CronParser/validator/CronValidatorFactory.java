package com.parser.CronParser.validator;

public class CronValidatorFactory {
	public static CronValidator getCronValidator(String type) {
		if("minute".equals(type))
			return new MinuteValidator();
		else if("hour".equals(type))
			return new HourValidator();
		else if("day of month".equals(type))
			return new DayOfMonthValidator();
		else if("month".equals(type))
			return new MonthValidator();
		else if("day of week".equals(type))
			return new DayOfWeekValidator();
		else 
			return null;
	}
}
