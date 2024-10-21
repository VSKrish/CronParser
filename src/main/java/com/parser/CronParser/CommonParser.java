package com.parser.CronParser;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonParser.class);
	
	static String expandField(String fieldContent, int minValue, int maxValue) {
		LOGGER.info("Inside expandField method");
        List<Integer> values = new ArrayList<>();
        
        if (fieldContent.equals("*")) {
            for (int i = minValue; i <= maxValue; i++) {
                values.add(i);
            }
        } else if (fieldContent.contains("/")) {
            String[] parts = fieldContent.split("/");
            int step = Integer.parseInt(parts[1]);
            String base = parts[0].equals("*") ? String.valueOf(minValue) : parts[0];
            values.addAll(expandSkipRange(minValue, maxValue, step));
        } 
        else {
        	String[] subFields = fieldContent.split(",");
            for(String subField : subFields)
            	values.addAll(expandRange(subField, minValue, maxValue, 1));
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Expanded value is {}", values.isEmpty() ? "empty list" : values);
        }
        return valuesToString(values);
    }

    private static List<Integer> expandRange(String range, int minValue, int maxValue, int step) {
        List<Integer> values = new ArrayList<>();
        String[] rangeParts = range.split("-");
        int start = Integer.parseInt(rangeParts[0]);
        int end = rangeParts.length > 1 ? Integer.parseInt(rangeParts[1]) : start;

        for (int i = start; i <= end; i += step) {
            if (i >= minValue && i <= maxValue) {
                values.add(i);
            }
        }

        return values;
    }
    private static String valuesToString(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (int value : values) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
    private static List<Integer> expandSkipRange(int minValue, int maxValue, int step) {
    	List<Integer> values = new ArrayList<>();

        for (int i = minValue; i <= maxValue; i += step) {
            if (i >= minValue && i <= maxValue)
                values.add(i);
        }

        return values;
    }
}
