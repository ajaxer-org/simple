package org.ajaxer.simple.utils;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class MathUtils
{
	/**
	 * @since v0.0.1
	 */
	public static byte min(byte... values)
	{
		byte min = values[0];
		for (byte val : values)
		{
			min = (byte) Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static byte max(byte... values)
	{
		byte max = values[0];
		for (byte value : values)
		{
			max = (byte) Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static short min(short... values)
	{
		short min = values[0];
		for (short val : values)
		{
			min = (short) Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static short max(short... values)
	{
		short max = values[0];
		for (short value : values)
		{
			max = (short) Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static int min(int... values)
	{
		int min = values[0];
		for (int val : values)
		{
			min = Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static int max(int... values)
	{
		int max = values[0];
		for (int value : values)
		{
			max = Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static long min(long... values)
	{
		long min = values[0];
		for (long val : values)
		{
			min = Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static long max(long... values)
	{
		long max = values[0];
		for (long value : values)
		{
			max = Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static float min(float... values)
	{
		float min = values[0];
		for (float val : values)
		{
			min = Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static float max(float... values)
	{
		float max = values[0];
		for (float value : values)
		{
			max = Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static double min(double... values)
	{
		double min = values[0];
		for (double val : values)
		{
			min = Math.min(min, val);
		}
		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static double max(double... values)
	{
		double max = values[0];
		for (double value : values)
		{
			max = Math.max(max, value);
		}
		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static int getPercentage(int value, int percentage)
	{
		return value * percentage / 100;
	}

	/**
	 * @since v0.0.1
	 */
	public static float getPercentage(float value, float percentage)
	{
		return value * percentage / 100;
	}

	/**
	 * @since v0.0.1
	 */
	public static double getPercentage(double value, double percentage)
	{
		return value * percentage / 100;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(byte[] array, byte val)
	{
		for (byte e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(short[] array, short val)
	{
		for (short e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(int[] array, int val)
	{
		for (int e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(long[] array, long val)
	{
		for (long e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(float[] array, float val)
	{
		for (float e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(double[] array, double val)
	{
		for (double e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}
}
