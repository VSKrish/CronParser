package com.parser.CronParser.validator;

public class DayOfWeekValidator implements CronValidator {

	@Override
	public boolean validate(String expression) {
		return expression.equals("?") || validateDayOfWeekAliases(expression) || CommonValidator.validateRangeOrStep(expression, 0, 6);
	}
	// Validate Day of Week Aliases (SUN-SAT)
    private boolean validateDayOfWeekAliases(String dayOfWeek) {
        return dayOfWeek.matches("(?i)SUN|MON|TUE|WED|THU|FRI|SAT");
    }

}
