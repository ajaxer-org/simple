package org.ajaxer.simple.utils;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class ExceptionUtils
{
	/**
	 * @since v0.0.1
	 */
	@SneakyThrows
	public static void rethrow(Throwable throwable)
	{
		if (throwable == null)
		{
			throw new NullPointerException();
		}

		if (throwable instanceof RuntimeException)
		{
			throw (RuntimeException) throwable;
		}

		if (throwable instanceof Error)
		{
			throw (Error) throwable;
		}

		throw throwable;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T rethrow(Throwable throwable, @SuppressWarnings("unused") Class<T> tClass)
	{
		rethrow(throwable);
		return null;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable, String packageFilter)
	{
		if (throwable == null)
		{
			return null;
		}

		List<String> traces = new ArrayList<>();

		if (StringUtils.isNotBlank(throwable.getMessage()))
		{
			traces.add(throwable.getMessage());
		}

		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		if (ArrayUtils.isBlank(stackTraceElements))
		{
			return traces;
		}

		for (StackTraceElement stackTraceElement : stackTraceElements)
		{
			if (ValidationUtils.isBlank(packageFilter))
			{
				traces.add(stackTraceElement.toString());
			} else
			{
				if (stackTraceElement.toString().startsWith(packageFilter))
				{
					traces.add(stackTraceElement.toString());
				}
			}
		}

		return traces;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable)
	{
		return getStackTraces(throwable, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition)
	{
		throwWhenTrue(trueCondition, (String) null);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, String exceptionMessage)
	{
		throwWhenTrue(trueCondition, new IllegalArgumentException(exceptionMessage));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, Throwable throwable)
	{
		if (trueCondition)
		{
			rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition)
	{
		throwWhenTrue(!falseCondition);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, String exceptionMessage)
	{
		throwWhenTrue(!falseCondition, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, Throwable throwable)
	{
		throwWhenTrue(!falseCondition, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2)
	{
		throwWhenTrue(o1.equals(o2));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, String exceptionMessage)
	{
		throwWhenTrue(o1.equals(o2), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, Throwable throwable)
	{
		throwWhenTrue(o1.equals(o2), throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2)
	{
		throwWhenFalse(o1.equals(o2));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, String exceptionMessage)
	{
		throwWhenFalse(o1.equals(o2), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, Throwable throwable)
	{
		throwWhenFalse(o1.equals(o2), throwable);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t)
	{
		throwWhenTrue(t == null);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		throwWhenTrue(t == null, exceptionMessage);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, Throwable throwable)
	{
		throwWhenTrue(t == null, throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}
}
