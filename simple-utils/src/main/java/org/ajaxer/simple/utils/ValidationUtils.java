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
		ExceptionUtils.throwWhenTrue(true);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(trueCondition, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(trueCondition, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition)
	{
		ExceptionUtils.throwWhenFalse(falseCondition);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, String exceptionMessage)
	{
		ExceptionUtils.throwWhenFalse(falseCondition, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, Throwable throwable)
	{
		ExceptionUtils.throwWhenFalse(falseCondition, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2)
	{
		ExceptionUtils.throwWhenEquals(i1, i2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, String exceptionMessage)
	{
		ExceptionUtils.throwWhenEquals(i1, i2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, Throwable throwable)
	{
		ExceptionUtils.throwWhenEquals(i1, i2, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2)
	{
		ExceptionUtils.throwWhenNotEquals(i1, i2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, String exceptionMessage)
	{
		ExceptionUtils.throwWhenNotEquals(i1, i2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, Throwable throwable)
	{
		ExceptionUtils.throwWhenNotEquals(i1, i2, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2)
	{
		ExceptionUtils.throwWhenEquals(o1, o2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, String exceptionMessage)
	{
		ExceptionUtils.throwWhenEquals(o1, o2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, Throwable throwable)
	{
		ExceptionUtils.throwWhenEquals(o1, o2, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2)
	{
		ExceptionUtils.throwWhenNotEquals(o1, o2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, String exceptionMessage)
	{
		ExceptionUtils.throwWhenNotEquals(o1, o2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, Throwable throwable)
	{
		ExceptionUtils.throwWhenNotEquals(o1, o2, throwable);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t)
	{
		ExceptionUtils.throwWhenNull(t);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		ExceptionUtils.throwWhenNull(t, exceptionMessage);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, Throwable throwable)
	{
		ExceptionUtils.throwWhenNull(t, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string)
	{
		ExceptionUtils.throwWhenBlank(string);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, String exceptionMessage)
	{
		ExceptionUtils.throwWhenBlank(string, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, Throwable throwable)
	{
		ExceptionUtils.throwWhenBlank(string, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection)
	{
		ExceptionUtils.throwWhenBlank(collection);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, String exceptionMessage)
	{
		ExceptionUtils.throwWhenBlank(collection, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, Throwable throwable)
	{
		ExceptionUtils.throwWhenBlank(collection, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map)
	{
		ExceptionUtils.throwWhenBlank(map);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, String exceptionMessage)
	{
		ExceptionUtils.throwWhenBlank(map, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, Throwable throwable)
	{
		ExceptionUtils.throwWhenBlank(map, throwable);
	}
}
