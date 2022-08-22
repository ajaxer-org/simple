package org.ajaxer.simple.utils;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since 0.0.1
 */
public class StringUtils
{
	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(String string)
	{
		return string == null || string.trim().isEmpty();
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(String string)
	{
		return !isBlank(string);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string)
	{
		if (StringUtils.isBlank(string))
		{
			throw new NullPointerException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, String customExceptionMessage)
	{
		if (StringUtils.isBlank(string))
		{
			throw new NullPointerException(customExceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, Throwable throwable)
	{
		if (StringUtils.isBlank(string))
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

}
