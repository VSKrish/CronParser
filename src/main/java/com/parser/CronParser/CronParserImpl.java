package com.parser.CronParser;

import java.util.ArrayList;

import com.parser.CronParser.validator.CronValidator;
import com.parser.CronParser.validator.CronValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CronParserImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(CronParserImpl.class);
	
	static List<String> parse(String input) throws Exception{
		LOGGER.info("Inside parse method");
		String[] parts = input.split(" ");
        if (parts.length != 6) {
        	LOGGER.warn("Invalid cron expression. Must have 5 fields followed by a command.");
            throw new Exception();
        }
        
        String[] strs = {"minute","hour","day of month","month","day of week"};
        for(int i = 0; i < 5; i++) {
        	CronValidator validator = CronValidatorFactory.getCronValidator(strs[i]);
        	boolean isValid = validator.validate(parts[i]);
        	if(!isValid)
        		throw new Exception(strs[i]+" given is in invalid format");
        }
        
        List<String> result = new ArrayList<>();
        int i=0;
        for(i = 0; i < 5; i++) {
        	CronParser parser = CronParserFactory.getCronParser(strs[i]);
        	String res = parser.parse(parts[i]);
        	result.add("\n "+strs[i]+" "+res);
        }
        result.add("\n "+"command"+" "+parts[i]);
        LOGGER.info("End of parse method");
        return result;
	}

}
