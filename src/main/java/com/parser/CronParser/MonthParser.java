package com.parser.CronParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonthParser implements CronParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(MonthParser.class);

	@Override
	public String parse(String monthField) {
		LOGGER.info("Inside parse method");
		return CommonParser.expandField(monthField, 1, 12);
	}

}
