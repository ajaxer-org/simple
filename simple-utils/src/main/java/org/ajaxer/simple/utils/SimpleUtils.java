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
		if (trueCondition)
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, String exceptionMessage)
	{
		if (trueCondition)
		{
			throw new IllegalArgumentException(exceptionMessage);
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
	public static void throwWhenFalse(boolean falseCondition)
	{
		if (!falseCondition)
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, String exceptionMessage)
	{
		if (!falseCondition)
		{
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, Throwable throwable)
	{
		if (!falseCondition)
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
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i1, int i2, String exceptionMessage)
	{
		if (i1 == i2)
		{
			throw new IllegalArgumentException(exceptionMessage);
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
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i1, int i2, String exceptionMessage)
	{
		if (i1 != i2)
		{
			throw new IllegalArgumentException(exceptionMessage);
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
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (o1.equals(o2))
		{
			throw new IllegalArgumentException(exceptionMessage);
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
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (!o1.equals(o2))
		{
			throw new IllegalArgumentException(exceptionMessage);
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
		if (t == null)
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		if (t == null)
		{
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, Throwable throwable)
	{
		if (t == null)
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

}
