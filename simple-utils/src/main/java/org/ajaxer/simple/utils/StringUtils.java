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
	private StringUtils() {}

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
	 * <p>The ASCII value of lowercase alphabets(a-z) are from 97 to 122</p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isLowercase(char c)
	{
		log.debug("char: {}", c);
		return c >= 97 && c <= 122;
	}

	/**
	 * @return returns true, if all the characters in given are in lowercase
	 *
	 * @since v0.0.1
	 */
	public static boolean isLowercase(String string)
	{
		log.debug("string: {}", string);
		if (isBlank(string)) return false;

		for (char c : string.toCharArray())
		{
			if (isUppercase(c)) return false;
		}

		return true;
	}

	/**
	 * <p>The ASCII value of uppercase alphabets(A-Z) are from 65 to 90</p>
	 *
	 * @since v0.0.1
	 */
	public static boolean isUppercase(char c)
	{
		log.debug("char: {}", c);
		return c >= 65 && c <= 90;
	}

	/**
	 * @return returns true, if all the characters in given are in uppercase
	 *
	 * @since v0.0.1
	 */
	public static boolean isUppercase(String string)
	{
		log.debug("string: {}", string);
		if (isBlank(string)) return false;

		for (char c : string.toCharArray())
		{
			if (isLowercase(c)) return false;
		}

		return true;
	}

	/**
	 * <p>The ASCII value of lowercase alphabets(a-z) are from 97 to 122</p>
	 *
	 * @since v0.0.1
	 */
	public static char toLowerCase(char c)
	{
		log.debug("char: {}", c);
		return isUppercase(c) ? (char) (c + 32) : c;
	}

	/**
	 * <p>The ASCII value of uppercase alphabets(A-Z) are from 65 to 90</p>
	 *
	 * @since v0.0.1
	 */
	public static char toUppercase(char c)
	{
		log.debug("char: {}", c);
		return isLowercase(c) ? (char) (c - 32) : c;
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
	 * <p>The ASCII value of lowercase alphabets(a-z) are from 97 to 122</p>
	 * <p>The ASCII value of uppercase alphabets(A-Z) are from 65 to 90</p>
	 *
	 * @since v0.0.1
	 */
	public static boolean equalsIgnoreCaseToAny(char[] array, char c)
	{
		log.debug("char: {}, array: {}", c, Arrays.toString(array));
		if (ArrayUtils.isBlank(array)) return false;

		boolean lowercaseC = isLowercase(c);
		log.debug("lowercaseC: {}", lowercaseC);

		boolean uppercaseC = isUppercase(c);
		log.debug("uppercaseC: {}", uppercaseC);

		for (char e : array)
		{
			//No need to check further if bo characters are same.
			if (e == c) return true;

			boolean lowercaseE = isLowercase(e);
			boolean uppercaseE = isUppercase(e);

			// arg = Z and array[i] = z
			if (uppercaseC && lowercaseE && c == e - 32) return true;

			// arg = z and array[i] = Z
			if (lowercaseC && uppercaseE && c == e + 32) return true;
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(String[] array, String val)
	{
		log.debug("string: {}, array: {}", val, Arrays.toString(array));
		if (ArrayUtils.isBlank(array) || val == null) return false;

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
	public static boolean equalsIgnoreCaseToAny(String[] array, String val)
	{
		log.debug("string: {}, array: {}", val, Arrays.toString(array));
		if (ArrayUtils.isBlank(array) || val == null) return false;

		for (String s : array)
		{
			if (s.equalsIgnoreCase(val))
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
		return valueOf(object, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> String valueOf(T object, String defaultValue)
	{
		return object == null ? defaultValue : object.toString();
	}
}
