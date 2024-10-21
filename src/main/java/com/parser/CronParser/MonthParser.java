package com.parser.CronParser;

public class MonthParser implements CronParser {

	@Override
	public String parse(String monthField) {
		return CommonParser.expandField(monthField, 1, 12);
	}

}
