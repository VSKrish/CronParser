package com.parser.CronParser.validator;

public class HourValidator implements CronValidator {

	@Override
	public boolean validate(String expression) {
		return CommonValidator.validateRangeOrStep(expression, 0, 23);
	}

}
