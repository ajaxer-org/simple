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
	private SimpleUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static boolean close(AutoCloseable autoCloseable)
	{
		try
		{
			autoCloseable.close();
			log.debug("autoCloseable.close() executed successfully: {}", autoCloseable);
			return true;
		} catch (Exception exception)
		{
			log.debug("autoCloseable.close() executed unsuccessfully: {}", autoCloseable);
			return false;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void sleep(long milli)
	{
		if (milli <= 0)
		{
			return;
		}

		try
		{
			Thread.sleep(milli);
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
}
