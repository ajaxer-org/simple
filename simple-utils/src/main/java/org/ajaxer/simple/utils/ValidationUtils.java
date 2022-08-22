package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Map;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@Log4j2
public class ValidationUtils
{
	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(String string)
	{
		return StringUtils.isBlank(string);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(String string)
	{
		return StringUtils.isNotBlank(string);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isBlank(Collection<T> collection)
	{
		return CollectionUtils.isBlank(collection);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isNotBlank(Collection<T> collection)
	{
		return CollectionUtils.isNotBlank(collection);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> boolean isBlank(Map<K, V> map)
	{
		return MapUtils.isBlank(map);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> boolean isNotBlank(Map<K, V> map)
	{
		return MapUtils.isNotBlank(map);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(boolean[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(boolean[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(char[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(char[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(byte[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(byte[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(short[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(short[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(int[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(int[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(long[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(long[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(float[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(float[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(double[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(double[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

	public static <T> boolean isBlank(T[] array)
	{
		return ArrayUtils.isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isNotBlank(T[] array)
	{
		return ArrayUtils.isNotBlank(array);
	}

}
