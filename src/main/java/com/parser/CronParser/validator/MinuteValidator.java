package com.parser.CronParser.validator;

public class MinuteValidator implements CronValidator {

	@Override
	public boolean validate(String expression) {
		return CommonValidator.validateRangeOrStep(expression, 0, 59);
	}

}
