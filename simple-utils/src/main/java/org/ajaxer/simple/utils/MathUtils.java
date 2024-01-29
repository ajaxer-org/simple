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

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class MathUtils
{
	private MathUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static byte min(byte... values)
	{
		byte min = values[0];

		for (byte val : values)
			min = (byte) Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static byte max(byte... values)
	{
		byte max = values[0];
		for (byte value : values)
			max = (byte) Math.max(max, value);

		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static short min(short... values)
	{
		short min = values[0];
		for (short val : values)
			min = (short) Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static short max(short... values)
	{
		short max = values[0];
		for (short value : values)
			max = (short) Math.max(max, value);

		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static int min(int... values)
	{
		int min = values[0];
		for (int val : values)
			min = Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static int max(int... values)
	{
		int max = values[0];
		for (int value : values)
			max = Math.max(max, value);

		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static long min(long... values)
	{
		long min = values[0];
		for (long val : values)
			min = Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static long max(long... values)
	{
		long max = values[0];
		for (long value : values)
			max = Math.max(max, value);

		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static float min(float... values)
	{
		float min = values[0];
		for (float val : values)
			min = Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static float max(float... values)
	{
		float max = values[0];
		for (float value : values)
			max = Math.max(max, value);

		return max;
	}

	/**
	 * @since v0.0.1
	 */
	public static double min(double... values)
	{
		double min = values[0];
		for (double val : values)
			min = Math.min(min, val);

		return min;
	}

	/**
	 * @since v0.0.1
	 */
	public static double max(double... values)
	{
		double max = values[0];
		for (double value : values)
			max = Math.max(max, value);

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
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(short[] array, short val)
	{
		for (short e : array)
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(int[] array, int val)
	{
		for (int e : array)
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(long[] array, long val)
	{
		for (long e : array)
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(float[] array, float val)
	{
		for (float e : array)
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(double[] array, double val)
	{
		for (double e : array)
			if (e == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(byte val, byte... otherValues)
	{
		for (byte v : otherValues)
			if (v == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(short val, short... otherValues)
	{
		for (short v : otherValues)
			if (v == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(int val, int... otherValues)
	{
		for (int v : otherValues)
			if (v == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(long val, long... otherValues)
	{
		for (long v : otherValues)
			if (v == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(float val, float... otherValues)
	{
		for (float v : otherValues)
			if (v == val)
				return true;

		return false;
	}

	/**
	 * @since v0.0.2
	 */
	public static boolean equalsToAny(double val, double... otherValues)
	{
		for (double v : otherValues)
			if (v == val)
				return true;

		return false;
	}
}
