package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.exceptions.BlankPointerException;

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
	 * throws BlankPointerException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t)
	{
		if (t == null)
		{
			throw new BlankPointerException();
		}
	}

	/**
	 * throws BlankPointerException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		if (t == null)
		{
			throw new BlankPointerException(exceptionMessage);
		}
	}

	/**
	 * throws BlankPointerException when object is null
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
