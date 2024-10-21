package com.parser.CronParser;

public class HourParser implements CronParser {

	@Override
	public String parse(String hourField) {
		return CommonParser.expandField(hourField, 0, 23);
	}

}
