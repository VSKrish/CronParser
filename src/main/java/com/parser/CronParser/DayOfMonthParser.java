package com.parser.CronParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayOfMonthParser implements CronParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(DayOfMonthParser.class);
	
	@Override
	public String parse(String dayOfMonthField) {
		LOGGER.info("Inside parse method");
		return CommonParser.expandField(dayOfMonthField, 1, 31);
	}

}
