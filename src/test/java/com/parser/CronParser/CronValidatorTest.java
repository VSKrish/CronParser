package com.parser.CronParser;

import org.junit.jupiter.api.Test;

import com.parser.CronParser.validator.CronValidator;
import com.parser.CronParser.validator.CronValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CronValidatorTest {

    private CronValidator validator;

    @Test
    public void testValidateMinute() {
    	validator = CronValidatorFactory.getCronValidator("minute");
        assertTrue(validator.validate("*/15"));
        assertTrue(validator.validate("0"));
        assertFalse(validator.validate("60"));
    }

    @Test
    public void testValidateHour() {
    	validator = CronValidatorFactory.getCronValidator("hour");
        assertTrue(validator.validate("0-23"));
        assertTrue(validator.validate("12"));
        assertFalse(validator.validate("25"));
    }

    @Test
    public void testValidateDayOfMonth() {
    	validator = CronValidatorFactory.getCronValidator("day of month");
        assertTrue(validator.validate("1-31"));
        assertFalse(validator.validate("?"));
        assertFalse(validator.validate("32"));
    }

    @Test
    public void testValidateMonth() {
    	validator = CronValidatorFactory.getCronValidator("month");
        assertTrue(validator.validate("1-12"));
        assertTrue(validator.validate("JAN"));
        assertFalse(validator.validate("13"));
    }

    @Test
    public void testValidateDayOfWeek() {
    	validator = CronValidatorFactory.getCronValidator("day of week");
        assertTrue(validator.validate("0-6"));
        assertTrue(validator.validate("SUN"));
        assertFalse(validator.validate("7"));
    }

    @Test
    public void testValidateMixedRangeAndStep() {
    	validator = CronValidatorFactory.getCronValidator("hour");
        assertTrue(validator.validate("1,15-20,*/5"));
        assertFalse(validator.validate("*/0"));
    }
}

