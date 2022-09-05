package org.ajaxer.simple.utils;

import java.text.NumberFormat;

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
}
