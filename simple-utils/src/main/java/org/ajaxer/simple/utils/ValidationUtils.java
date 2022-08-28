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

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition)
	{
		if (trueCondition)
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, String exceptionMessage)
	{
		if (trueCondition)
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, Throwable throwable)
	{
		if (trueCondition)
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean trueCondition)
	{
		if (!trueCondition)
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean trueCondition, String exceptionMessage)
	{
		if (!trueCondition)
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean trueCondition, Throwable throwable)
	{
		if (!trueCondition)
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2)
	{
		if (i1 == i2)
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, String exceptionMessage)
	{
		if (i1 == i2)
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, Throwable throwable)
	{
		if (i1 == i2)
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2)
	{
		if (i1 != i2)
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, String exceptionMessage)
	{
		if (i1 != i2)
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, Throwable throwable)
	{
		if (i1 != i2)
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2)
	{
		if (o1.equals(o2))
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (o1.equals(o2))
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, Throwable throwable)
	{
		if (o1.equals(o2))
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2)
	{
		if (!o1.equals(o2))
		{
			throw new AssertionError();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (!o1.equals(o2))
		{
			throw new AssertionError(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, Throwable throwable)
	{
		if (!o1.equals(o2))
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t)
	{
		SimpleUtils.throwWhenNull(t);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		SimpleUtils.throwWhenNull(t, exceptionMessage);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, Throwable throwable)
	{
		SimpleUtils.throwWhenNull(t, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string)
	{
		StringUtils.throwWhenBlank(string);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, String exceptionMessage)
	{
		StringUtils.throwWhenBlank(string, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, Throwable throwable)
	{
		StringUtils.throwWhenBlank(string, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection)
	{
		CollectionUtils.throwWhenBlank(collection);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, String exceptionMessage)
	{
		CollectionUtils.throwWhenBlank(collection, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, Throwable throwable)
	{
		CollectionUtils.throwWhenBlank(collection, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map)
	{
		MapUtils.throwWhenBlank(map);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, String exceptionMessage)
	{
		MapUtils.throwWhenBlank(map, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, Throwable throwable)
	{
		MapUtils.throwWhenBlank(map, throwable);
	}
}
