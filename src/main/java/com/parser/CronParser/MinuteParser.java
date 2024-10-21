package com.parser.CronParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinuteParser implements CronParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(MinuteParser.class);

	@Override
	public String parse(String minuteField) {
		LOGGER.info("Inside parse method");
		return CommonParser.expandField(minuteField, 0, 59);
	}
}
