package com.parser.CronParser;

public class DayOfWeekParser implements CronParser {

	@Override
	public String parse(String dayOfWeekField) {
		return CommonParser.expandField(dayOfWeekField, 0, 6);
	}

}
