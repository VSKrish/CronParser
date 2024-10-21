package com.parser.CronParser;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import java.util.List;

@ShellComponent
public class MyCommands {

    @ShellMethod(key = "parse-cron", value = "Parses the provided cron expression.")
    public String parseCron(@ShellOption String cronExpression) {
    	try {
    		List<String> result = CronParserImpl.parse(cronExpression);
    		return result.toString();
    	}
    	catch(Exception e) {
    		return "Parsing failed due to invalid Cron expression. "+e.getMessage();
    	}
    }
}
