package com.parser.CronParser;

public class DayOfMonthParser implements CronParser {

	@Override
	public String parse(String dayOfMonthField) {
		return CommonParser.expandField(dayOfMonthField, 1, 31);
	}

}
