package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class SimpleUtils
{
	/**
	 * @since v0.0.1
	 */
	public static void close(AutoCloseable autoCloseable)
	{
		try
		{
			autoCloseable.close();
			log.debug("autoCloseable.close() executed successfully: {}", autoCloseable.toString());
		} catch (Exception exception)
		{
			log.warn("autoCloseable.close() executed unsuccessfully: {}", autoCloseable.toString());
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void sleep(long mili)
	{
		if (mili <= 0)
		{
			return;
		}

		try
		{
			Thread.sleep(mili);
		} catch (InterruptedException ignored)
		{
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void sleep()
	{
		sleep(2000);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition)
	{
		throwWhenTrue(trueCondition, new IllegalArgumentException());
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
			ExceptionUtils.rethrow(throwable);
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
	public static void throwWhenEquals(int i1, int i2)
	{
		throwWhenTrue(i1 == i2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, String exceptionMessage)
	{
		throwWhenTrue(i1 == i2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, Throwable throwable)
	{
		throwWhenTrue(i1 == i2, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2)
	{
		throwWhenFalse(i1 == i2);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, String exceptionMessage)
	{
		throwWhenFalse(i1 == i2, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, Throwable throwable)
	{
		throwWhenFalse(i1 == i2, throwable);
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

}
