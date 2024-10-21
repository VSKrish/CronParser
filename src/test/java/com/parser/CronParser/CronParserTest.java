package com.parser.CronParser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class CronParserTest {

    @Test
    public void testCronWithStep() throws Exception {
        String input = "*/15 0 1,15 * 1-5 /usr/bin/find";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0 15 30 45",
            "\n hour 0",
            "\n day of month 1 15",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 1 2 3 4 5",
            "\n command /usr/bin/find"
        );
        
        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCronWithRange() throws Exception {
        String input = "0 0 * * 1-5 /bin/run_weekday_task";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0",
            "\n hour 0",
            "\n day of month 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 1 2 3 4 5",
            "\n command /bin/run_weekday_task"
        );

        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCronWithSpecialTimeString() throws Exception {
        String input = "0 12 1,15-20 * * /bin/midday_task";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0",
            "\n hour 12",
            "\n day of month 1 15 16 17 18 19 20",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 0 1 2 3 4 5 6",
            "\n command /bin/midday_task"
        );

        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCronWithList() throws Exception {
        String input = "0 0 * * 0,6 /bin/run_weekend_task";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0",
            "\n hour 0",
            "\n day of month 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 0 6",
            "\n command /bin/run_weekend_task"
        );

        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCronWithMixedRangeAndList() throws Exception {
        String input = "0 12 1,15-20 * * /bin/midday_task";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0",
            "\n hour 12",
            "\n day of month 1 15 16 17 18 19 20",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 0 1 2 3 4 5 6",
            "\n command /bin/midday_task"
        );

        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCronWithHourlySpecialTime() throws Exception {
        String input = "0 0-23 1-20,21-31 * * /bin/midday_task";
        List<String> expectedOutput = Arrays.asList(
            "\n minute 0",
            "\n hour 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23",
            "\n day of month 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31",
            "\n month 1 2 3 4 5 6 7 8 9 10 11 12",
            "\n day of week 0 1 2 3 4 5 6",
            "\n command /bin/midday_task"
        );

        List<String> actualOutput = CronParserImpl.parse(input);
        assertEquals(expectedOutput, actualOutput);
    }
}

