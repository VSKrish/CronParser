package com.parser.CronParser.validator;

public class DayOfMonthValidator implements CronValidator {

	@Override
	public boolean validate(String expression) {
		return CommonValidator.validateRangeOrStep(expression, 0, 31);
	}

}
