package com.parser.CronParser;

public class MinuteParser implements CronParser {

	@Override
	public String parse(String minuteField) {
		return CommonParser.expandField(minuteField, 0, 59);
	}
}
