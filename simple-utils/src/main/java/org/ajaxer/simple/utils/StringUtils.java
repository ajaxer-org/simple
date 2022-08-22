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
}
