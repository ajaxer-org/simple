package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@SuppressWarnings("unused")
@Log4j2
public class RandomUtils
{
	/**
	 * @since v0.0.1
	 */
	public static byte getByte()
	{
		return getByte(Byte.MIN_VALUE, Byte.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte getByte(byte min, byte max)
	{
		return (byte) getDouble(min, max);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte getByteLessThanOrEqualTo(byte limit)
	{
		return getByte(Byte.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte getByteGreaterThanOrEqualTo(byte limit)
	{
		return getByte(limit, Byte.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShort()
	{
		return getShort(Short.MIN_VALUE, Short.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShort(short min, short max)
	{
		return (short) getDouble(min, max);
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShortLessThanOrEqualTo(short limit)
	{
		return getShort(Short.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShortGreaterThanOrEqualTo(short limit)
	{
		return getShort(limit, Short.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getInt()
	{
		return getInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getInt(int min, int max)
	{
		return (int) getDouble(min, max);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getIntLessThanOrEqualTo(int limit)
	{
		return getInt(Integer.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getIntGreaterThanOrEqualTo(int limit)
	{
		return getInt(limit, Integer.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLong()
	{
		return getLong(Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLong(long min, long max)
	{
		return (long) getDouble(min, max);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLongLessThanOrEqualTo(long limit)
	{
		return getLong(Long.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLongGreaterThanOrEqualTo(long limit)
	{
		return getLong(limit, Long.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloat()
	{
		return getFloat(Float.MIN_VALUE, Float.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloat(float min, float max)
	{
		return (float) getDouble(min, max);
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloatLessThanOrEqualTo(float limit)
	{
		return getFloat(Float.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloatGreaterThanOrEqualTo(float limit)
	{
		return getFloat(limit, Float.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDouble()
	{
		return getDouble(Double.MIN_VALUE, Double.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDouble(double min, double max)
	{
		return min + (Math.random() * Math.abs(max - min));
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDoubleLessThanOrEqualTo(double limit)
	{
		return getDouble(Double.MIN_VALUE, limit);
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDoubleGreaterThanOrEqualTo(double limit)
	{
		return getDouble(limit, Double.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static char getChar()
	{
		return (char) getInt('a', 'z');
	}

	/**
	 * @since v0.0.1
	 */
	public static char getCharUppercase()
	{
		return getChar('A', 'Z');
	}

	/**
	 * @since v0.0.1
	 */
	public static char getChar(char minChar, char maxChar)
	{
		return (char) getInt(minChar, maxChar);
	}

	/**
	 * @since v0.0.1
	 */
	//TODO
	public static char getChar(char[] array)
	{
		return array[getInt(0, array.length - 1)];
	}

}
