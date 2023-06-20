package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.dtos.DateTimeDTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Useful Keys</p>
 * <p></p>
 * <p><b>G</b> Era designator :AD</p>
 * <p><b>Y</b> Week year :2009; 09</p>
 * <p><b>y</b> Year :1996; 96</p>
 * <p><b>M</b> Month in year :July; Jul; 07</p>
 * <p><b>w</b> Week in year :27</p>
 * <p><b>W</b> Week in month :2</p>
 * <p><b>D</b> Day in year :189</p>
 * <p><b>d</b> Day in month :10</p>
 * <p><b>F</b> Day of week in month :2</p>
 * <p><b>E</b> Day name in week :Tuesday; Tue</p>
 * <p><b>u</b> Day number of week :(1 = Monday, …, 7 = Sunday)	1</p>
 * <p><b>a</b> Am/pm marker	PM</p>
 * <p><b>H</b> Hour in day (0-23)	0</p>
 * <p><b>k</b> Hour in day (1-24)	24</p>
 * <p><b>K</b> Hour in am/pm (0-11)	0</p>
 * <p><b>h</b> Hour in am/pm (1-12)	12</p>
 * <p><b>m</b> Minute in hour	30</p>
 * <p><b>s</b> Second in minute	55</p>
 * <p><b>S</b> Millisecond	978</p>
 * <p><b>z</b> Time zone	Pacific Standard Time; PST; GMT-08:00</p>
 * <p><b>Z</b> Time zone	-0800</p>
 * <p><b>X</b> Time zone	-08; -0800; -08:00</p>
 *
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@SuppressWarnings("unused")
@Log4j2
public class DateTimeUtils
{
	/**
	 * @since v0.0.1
	 */
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DateTimeUtils() {}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	private static Date addDateTime(Date date, int field, int amount)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount); //minus number would decrement
		return cal.getTime();
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addMilliSeconds(Date date, int milliSeconds)
	{
		return addDateTime(date, Calendar.MILLISECOND, milliSeconds);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addSeconds(Date date, int seconds)
	{
		return addDateTime(date, Calendar.SECOND, seconds);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addMinutes(Date date, int minutes)
	{
		return addDateTime(date, Calendar.MINUTE, minutes);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addHours(Date date, int hours)
	{
		return addDateTime(date, Calendar.HOUR, hours);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addDays(Date date, int days)
	{
		return addDateTime(date, Calendar.DATE, days);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addMonths(Date date, int months)
	{
		return addDateTime(date, Calendar.MONTH, months);
	}

	/**
	 * minus number would decrement
	 *
	 * @since v0.0.1
	 */
	public static Date addYears(Date date, int years)
	{
		return addDateTime(date, Calendar.YEAR, years);
	}

	/**
	 * @since v0.0.1
	 */
	public static DateTimeDTO getDifference(Date currentDate)
	{
		log.debug("currentDate: {}", currentDate);

		return getDifference(currentDate, new Date());
	}

	/**
	 * @since v0.0.1
	 */
	public static DateTimeDTO getDifference(Date end, Date start)
	{
		log.debug("start: {}, end: {}", start, end);

		return getDifference(end.getTime(), start.getTime());
	}

	/**
	 * @since v0.0.1
	 */
	public static DateTimeDTO getDifference(long startMilliseconds)
	{
		log.debug("startMilliseconds: {}", startMilliseconds);
		return getDifference(startMilliseconds, System.currentTimeMillis());
	}

	/**
	 * @since v0.0.1
	 */
	public static DateTimeDTO getDifference(long end, long start)
	{
		log.debug("start: {}, end: {}", start, end);

		long diff = end - start;
		log.debug("diff: {}", diff);

		boolean inverse = false;
		if (diff < 0)
		{
			inverse = true;
			diff = -diff;
		}

		log.debug("inverse: {}", inverse);

		DateTimeDTO dateTimeDTO = new DateTimeDTO();

		if (diff == 0)
		{
			return dateTimeDTO;
		}

		dateTimeDTO.milliSeconds = diff % 1000;
		dateTimeDTO.seconds = diff / 1000 % 60;
		dateTimeDTO.minutes = diff / (60 * 1000) % 60;
		dateTimeDTO.hours = diff / (60 * 60 * 1000) % 24;
		dateTimeDTO.days = diff / (24 * 60 * 60 * 1000);

		if (inverse)
		{
			dateTimeDTO.milliSeconds = -dateTimeDTO.milliSeconds;
			dateTimeDTO.seconds = -dateTimeDTO.seconds;
			dateTimeDTO.minutes = -dateTimeDTO.minutes;
			dateTimeDTO.hours = -dateTimeDTO.hours;
			dateTimeDTO.days = -dateTimeDTO.days;
		}

		return dateTimeDTO;
	}

	/**
	 * @since v0.0.1
	 */
	public static long toMilliseconds(Date date)
	{
		return date == null ? 0L : date.getTime();
	}

	/**
	 * @since v0.0.1
	 */
	public static String toString(Date date)
	{
		return toString(date, DEFAULT_DATE_TIME_FORMAT);
	}

	/**
	 * @since v0.0.1
	 */
	public static String toString(Date date, String pattern)
	{
		return new SimpleDateFormat(pattern).format(date);
	}
}
