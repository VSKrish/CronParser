package com.parser.CronParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayOfWeekParser implements CronParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(DayOfWeekParser.class);
	
	@Override
	public String parse(String dayOfWeekField) {
		LOGGER.info("Inside parse method");
		return CommonParser.expandField(dayOfWeekField, 0, 6);
	}

}
