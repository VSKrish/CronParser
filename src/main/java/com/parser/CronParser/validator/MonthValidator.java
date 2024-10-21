package com.parser.CronParser.validator;

public class MonthValidator implements CronValidator {

	@Override
	public boolean validate(String expression) {
		return expression.equals("?") || validateMonthAliases(expression) || 
				CommonValidator.validateRangeOrStep(expression, 1, 12);	
		}
	private boolean validateMonthAliases(String month) {
        return month.matches("(?i)JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC");
    }
}
