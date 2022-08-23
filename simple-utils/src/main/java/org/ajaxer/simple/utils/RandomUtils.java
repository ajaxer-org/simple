package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Random;

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
		return (byte) (min + (byte) (Math.random() * (max - min)));
	}

	/**
	 * @since v0.0.1
	 */
	public static byte getByteLessThanOrEqualTo(byte lowerValue)
	{
		return getByte(Byte.MIN_VALUE, lowerValue);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte getByteGreaterThanOrEqualTo(byte highValue)
	{
		return getByte(highValue, Byte.MAX_VALUE);
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
		return (short) (min + (short) (Math.random() * (max - min)));
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShortLessThanOrEqualTo(short lowerValue)
	{
		return getShort(Short.MIN_VALUE, lowerValue);
	}

	/**
	 * @since v0.0.1
	 */
	public static short getShortGreaterThanOrEqualTo(short highValue)
	{
		return getShort(highValue, Short.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getInt()
	{
		return new Random().nextInt();
	}

	/**
	 * @since v0.0.1
	 */
	public static int getInt(int min, int max)
	{
		return new Random().nextInt((max - min) + 1) + min;
	}

	/**
	 * @since v0.0.1
	 */
	public static int getIntLessThan(int lowerValue)
	{
		return new Random().nextInt(lowerValue - 1);
	}

	/**
	 * @since v0.0.1
	 */
	public static int getIntGreaterThan(int highValue)
	{
		return getInt(highValue + 1, Integer.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLong()
	{
		return new Random().nextLong();
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLong(long min, long max)
	{
		return min + (long) (Math.random() * (max - min));
//		return min + (getLong() * (max - min));
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLongLessThanOrEqualTo(long lowValue)
	{
		return getLong(Long.MIN_VALUE, lowValue);
	}

	/**
	 * @since v0.0.1
	 */
	public static long getLongGreaterThanOrEqualTo(long highValue)
	{
		return getLong(highValue, Long.MAX_VALUE);
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloat()
	{
		return new Random().nextFloat();
	}

	/**
	 * @since v0.0.1
	 */
	public static float getFloat(float min, float max)
	{
		return (getFloat() % (max - min + 1)) + min;
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDouble()
	{
		return new Random().nextDouble();
	}

	/**
	 * @since v0.0.1
	 */
	public static double getDouble(double min, double max)
	{
		return (getDouble() % (max - min + 1)) + min;
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
