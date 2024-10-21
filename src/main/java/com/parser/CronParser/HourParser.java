package com.parser.CronParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HourParser implements CronParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(HourParser.class);
	
	@Override
	public String parse(String hourField) {
		LOGGER.info("Inside parse method");
		return CommonParser.expandField(hourField, 0, 23);
	}

}
