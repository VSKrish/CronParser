package com.parser.CronParser.validator;

public class CommonValidator{

	static boolean validateRangeOrStep(String field, int minValue, int maxValue) {
        try {
            if (field.contains(",")) {
                String[] parts = field.split(",");
                for (String part : parts) {
                    if (!validateRangeOrStep(part, minValue, maxValue)) {
                        return false;
                    }
                }
                return true;
            } else if (field.contains("/")) {
                String[] parts = field.split("/");
                if (parts.length != 2) return false;
                return validateRangeOrStep(parts[0], minValue, maxValue) && Integer.parseInt(parts[1]) > 0;
            } else if (field.contains("-")) {
                String[] parts = field.split("-");
                if (parts.length != 2) return false;
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                return (start >= minValue && start <= maxValue) && (end >= minValue && end <= maxValue);
            } else if (field.equals("*")) {
                return true;
            } else {
                int value = Integer.parseInt(field);
                return value >= minValue && value <= maxValue;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
