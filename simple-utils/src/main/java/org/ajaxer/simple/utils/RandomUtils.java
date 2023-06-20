package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@Log4j2
public class RandomUtils
{
	private RandomUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static boolean getBoolean()
	{
		return getByte() % 2 == 0;
	}

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
		return min + (Math.random() * Math.abs(max - min + 1));
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
		return (char) getInt('A', 'Z');
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
	public static boolean[] arrayOfBoolean(int length)
	{
		boolean[] array = new boolean[length];
		for (int i = 0; i < length; i++)
			array[i] = getBoolean();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static char[] arrayOfChar(int length)
	{
		char[] array = new char[length];
		for (int i = 0; i < length; i++)
			array[i] = getChar();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static byte[] arrayOfBytes(int length)
	{
		byte[] array = new byte[length];
		for (int i = 0; i < length; i++)
			array[i] = getByte();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static short[] arrayOfShort(int length)
	{
		short[] array = new short[length];
		for (int i = 0; i < length; i++)
			array[i] = getShort();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static int[] arrayOfInt(int length)
	{
		int[] array = new int[length];
		for (int i = 0; i < length; i++)
			array[i] = getInt();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static long[] arrayOfLong(int length)
	{
		long[] array = new long[length];
		for (int i = 0; i < length; i++)
			array[i] = getLong();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static float[] arrayOfFloat(int length)
	{
		float[] array = new float[length];
		for (int i = 0; i < length; i++)
			array[i] = getFloat();

		return array;
	}

	/**
	 * @since v0.0.1
	 */
	public static double[] arrayOfDouble(int length)
	{
		double[] array = new double[length];
		for (int i = 0; i < length; i++)
			array[i] = getDouble();

		return array;
	}
}
