package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since 0.0.1
 */
@Log4j2
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
	public static int charCount(String string, char ch)
	{
		log.debug("string: {}, ch: {}", string, ch);
		throwWhenBlank(string);

		int count = 0;
		for (char chatAt : string.toCharArray())
		{
			if (chatAt == ch)
			{
				count++;
			}
		}

		return count;
	}

	/**
	 * @since v0.0.1
	 */
	public static String removePrefix(String str, String prefix)
	{
		log.debug("str: {}, prefix: {}", str, prefix);
		throwWhenBlank(str);
		throwWhenBlank(prefix);

		if (str.startsWith(prefix))
		{
			return str.substring(prefix.length());
		}
		return str;
	}

	/**
	 * @since v0.0.1
	 */
	public static String removeSuffix(String str, String suffix)
	{
		log.debug("str: {}, suffix: {}", str, suffix);
		throwWhenBlank(str);
		throwWhenBlank(suffix);

		if (str.endsWith(suffix))
		{
			return str.substring(0, str.length() - suffix.length());
		}
		return str;
	}

	/**
	 * @since v0.0.1
	 */
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}

	/**
	 * @since v0.0.1
	 */
	public static String getUUID(String str)
	{
		return UUID.nameUUIDFromBytes(str.getBytes()).toString();
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

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(char[] array, char val)
	{
		for (char e : array)
		{
			if (e == val)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(String[] array, String val)
	{
		for (String s : array)
		{
			if (s.equals(val))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(List<String> list, String val)
	{
		for (String s : list)
		{
			if (s.equals(val))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> String valueOf(T object)
	{
		return object == null ? null : object.toString();
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> String valueOf(T object, String defaultValue)
	{
		return object == null ? defaultValue : object.toString();
	}
}
