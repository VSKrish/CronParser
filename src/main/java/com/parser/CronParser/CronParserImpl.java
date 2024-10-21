package com.parser.CronParser;

import java.util.ArrayList;

import com.parser.CronParser.validator.CronValidator;
import com.parser.CronParser.validator.CronValidatorFactory;

import java.util.*;

public class CronParserImpl {
	static List<String> parse(String input) throws Exception{
		String[] parts = input.split(" ");
        if (parts.length != 6) {
            System.out.println("Invalid cron expression. Must have 5 fields followed by a command.");
            throw new Exception();
        }
        
        String[] strs = {"minute","hour","day of month","month","day of week"};
        for(int i=0;i<5;i++) {
        	CronValidator validator = CronValidatorFactory.getCronValidator(strs[i]);
        	boolean isValid = validator.validate(parts[i]);
        	if(!isValid)
        		throw new Exception(strs[i]+" given is in invalid format");
        }
        
        List<String> result = new ArrayList<>();
        int i=0;
        for(i=0;i<5;i++) {
        	CronParser parser = CronParserFactory.getCronParser(strs[i]);
        	String res = parser.parse(parts[i]);
        	result.add("\n "+strs[i]+" "+res);
        }
        result.add("\n "+"command"+" "+parts[i]);
        
        return result;
	}

}
