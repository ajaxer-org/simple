package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
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
		if (isBlank(string)) return -1;

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
	public static String removePrefix(String string, String prefix)
	{
		log.debug("string: {}, prefix: {}", string, prefix);
		if (isBlank(string) || isBlank(prefix)) return string;

		if (string.startsWith(prefix))
		{
			return string.substring(prefix.length());
		}
		return string;
	}

	/**
	 * @since v0.0.1
	 */
	public static String removeSuffix(String string, String suffix)
	{
		log.debug("string: {}, suffix: {}", string, suffix);
		if (isBlank(string) || isBlank(suffix)) return string;

		if (string.endsWith(suffix))
		{
			return string.substring(0, string.length() - suffix.length());
		}
		return string;
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
	public static String getUUID(String string)
	{
		log.debug("string: {}", string);

		return isBlank(string)
				? getUUID()
				: UUID.nameUUIDFromBytes(string.getBytes()).toString();
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(char[] array, char val)
	{
		log.debug("char: {}, array: {}", val, Arrays.toString(array));
		if (ArrayUtils.isBlank(array)) return false;

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
		log.debug("string: {}, array: {}", val, Arrays.toString(array));
		if (ArrayUtils.isBlank(array)) return false;

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
