package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.dtos.DateTimeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
@Log4j2
@SuppressWarnings("deprecation")
public class DateTimeUtilsTest
{
	@Test
	void addMilliSeconds()
	{
		long milli = 222_222_000L;
		long result = DateTimeUtils.addMilliSeconds(new Date(milli), 222).getTime();
		log.info("result: {}", result);
		long expected = 222_222_222L;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addSeconds()
	{
		int seconds = 123;
		Date startDate = new Date();
		long result = DateTimeUtils.addSeconds(startDate, seconds).getTime() % startDate.getTime();
		long expected = seconds * 1000;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addMinutes()
	{
		int minutes = 123;
		Date startDate = new Date();
		long result = DateTimeUtils.addMinutes(startDate, minutes).getTime() % startDate.getTime();
		long expected = minutes * 1000 * 60;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addHours()
	{
		int hours = 12;
		Date startDate = new Date();
		long result = DateTimeUtils.addHours(startDate, hours).getTime() % startDate.getTime();
		long expected = hours * 1000 * 60 * 60;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addDays()
	{
		int days = 7;
		Date startDate = new Date();
		long result = DateTimeUtils.addDays(startDate, days).getTime() % startDate.getTime();
		long expected = days * 1000 * 60 * 60 * 24;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addMonths()
	{
		int months = 2;
		Date startDate = new Date();
		int result = DateTimeUtils.addMonths(startDate, months).getMonth();
		long expected = startDate.getMonth() + 2;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void addYears()
	{
		int years = 20;
		Date startDate = new Date();
		int result = DateTimeUtils.addYears(startDate, years).getYear();
		long expected = startDate.getYear() + years;
		Assertions.assertEquals(expected, result);
	}

	@Test
	void with_start_date_and_end_date()
	{
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime());
		endDate = DateTimeUtils.addDays(endDate, 2);
		endDate = DateTimeUtils.addHours(endDate, 3);

		DateTimeDTO dateTimeDTO = DateTimeUtils.getDifference(endDate, startDate);

		Assertions.assertEquals(2, dateTimeDTO.days);
		Assertions.assertEquals(3, dateTimeDTO.hours);
	}

	@Test
	void with_end_date_and_start_date()
	{
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime());
		endDate = DateTimeUtils.addDays(endDate, 2);
		endDate = DateTimeUtils.addHours(endDate, 3);

		DateTimeDTO dateTimeDTO = DateTimeUtils.getDifference(startDate, endDate);

		Assertions.assertEquals(-2, dateTimeDTO.days);
		Assertions.assertEquals(-3, dateTimeDTO.hours);
	}

	@Test
	void toMilliseconds()
	{
		long milliseconds1 = DateTimeUtils.toMilliseconds(null);
		Assertions.assertEquals(0L, milliseconds1);

		long milliseconds2 = System.currentTimeMillis();
		long result = DateTimeUtils.toMilliseconds(new Date(milliseconds2));
		Assertions.assertEquals(milliseconds2, result);
	}

	@Test
	void toStringTest()
	{
		long milliseconds = 123_456_789_0_123L;
		String dateString = DateTimeUtils.toString(new Date(milliseconds));
		String expectedValue = "2009-02-14 05:01:30";

		Assertions.assertEquals(expectedValue, dateString);
	}

	@Test
	void toStringTest_with_pattern()
	{
		long milliseconds = 123_456_789_0_123L;
		String dateString = DateTimeUtils.toString(new Date(milliseconds), "yyyy-MMM-dd HH:mm").toUpperCase();
		String expectedValue = "2009-FEB-14 05:01";

		Assertions.assertEquals(expectedValue, dateString);
	}
}