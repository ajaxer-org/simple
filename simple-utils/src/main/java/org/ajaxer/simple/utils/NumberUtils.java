package org.ajaxer.simple.utils;

/*
 * Copyright (c) 2024 ajaxer.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class NumberUtils
{
	private NumberUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static Number toNumber(String str)
	{
		try
		{
			return NumberFormat.getInstance().parse(str);
		} catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * Range for byte(1 byte) is -128 to 127
	 *
	 * @since v0.0.1
	 */
	public static byte toByte(String str)
	{
		return toByte(str, (byte) 0);
	}

	/**
	 * Range for byte(1 byte) is -128 to 127
	 *
	 * @since v0.0.1
	 */
	public static byte toByte(String str, byte defaultValue)
	{
		try
		{
			return toNumber(str).byteValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	/**
	 * Range for short(2 bytes) is -32,768 to 32,767
	 *
	 * @since v0.0.1
	 */
	public static short toShort(String str)
	{
		return toShort(str, (short) 0);
	}

	/**
	 * Range for short(2 bytes) is -32,768 to 32,767
	 *
	 * @since v0.0.1
	 */
	public static short toShort(String str, short defaultValue)
	{
		try
		{
			return toNumber(str).shortValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	/**
	 * Range for int(4 bytes) is -2,147,483,648 to 2,147,483,647
	 *
	 * @since v0.0.1
	 */
	public static int toInt(String str)
	{
		return toInt(str, 0);
	}

	/**
	 * Range for int(4 bytes) is -2,147,483,648 to 2,147,483,647
	 *
	 * @since v0.0.1
	 */
	public static int toInt(String str, int defaultValue)
	{
		try
		{
			return toNumber(str).intValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	/**
	 * Range for long(8 bytes) is -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	 *
	 * @since v0.0.1
	 */
	public static long toLong(String str)
	{
		return toLong(str, 0L);
	}

	/**
	 * Range for long(8 bytes) is -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	 *
	 * @since v0.0.1
	 */
	public static long toLong(String str, long defaultValue)
	{
		try
		{
			return toNumber(str).longValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	/**
	 * Range for float(4 bytes) is sufficient for storing 6 to 7 decimal digits
	 *
	 * @since v0.0.1
	 */
	public static float toFloat(String str)
	{
		return toFloat(str, 0.0F);
	}

	/**
	 * Range for float(4 bytes) is sufficient for storing 6 to 7 decimal digits
	 *
	 * @since v0.0.1
	 */
	public static float toFloat(String str, float defaultValue)
	{
		try
		{
			return toNumber(str).floatValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	/**
	 * Range for double(8 bytes) is sufficient for storing 15 decimal digits
	 *
	 * @since v0.0.1
	 */
	public static double toDouble(String str)
	{
		return toDouble(str, 0.0D);
	}

	/**
	 * Range for double(8 bytes) is sufficient for storing 15 decimal digits
	 *
	 * @since v0.0.1
	 */
	public static double toDouble(String str, double defaultValue)
	{
		try
		{
			return toNumber(str).doubleValue();
		} catch (Exception exception)
		{
			return defaultValue;
		}
	}

	public static String toLocalNumber(long number)
	{
		return NumberFormat.getNumberInstance().format(number);
	}

	/**
	 * @param number as 10000
	 * @param language like english as "en" or french as "fr"
	 * @param country like USA as "US" or france as "FR"
	 * @return local String as 10,000
	 */
	public static String toLocalNumber(long number, String language, String country)
	{
		// Create a NumberFormat instance for a specific locale (French in this case)
		//Locale locale = new Locale("fr", "FR");
		Locale locale = new Locale(language, country);

		// Format the number for given input
		return NumberFormat.getNumberInstance(locale).format(number);
	}
}
