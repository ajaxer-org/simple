package org.ajaxer.simple.utils;

/*
 * Copyright (c) 2024 ajaxer.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
	 * @return <b>true</b> if all strings are blank, <b>false</b> if any string is notBlank
	 * @since v0.4.0
	 */
	public static boolean isBlank(String... strings)
	{
		for (String string : strings)
		{
			if (isNotBlank(string))
				return false;
		}

		return true;
	}

	/**
	 * @since v0.0.1
	 */
	public static int charCount(String string, char ch)
	{
		log.debug("string: {}, ch: {}", string, ch);
		if (isBlank(string))
			return -1;

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
		if (isBlank(string) || isBlank(prefix))
			return string;

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
		if (isBlank(string) || isBlank(suffix))
			return string;

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
	 * @since v0.0.1
	 */
	public static boolean isLowercase(String string)
	{
		log.debug("string: {}", string);
		if (isBlank(string))
			return false;

		//noinspection SimplifyStreamApiCallChains
		return !string.chars().mapToObj(i -> (char) i).anyMatch(StringUtils::isUppercase);
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
	 * @since v0.0.1
	 */
	public static boolean isUppercase(String string)
	{
		log.debug("string: {}", string);
		if (isBlank(string))
			return false;

		//noinspection SimplifyStreamApiCallChains
		return !string.chars().mapToObj(i -> (char) i).anyMatch(StringUtils::isLowercase);
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
		if (ArrayUtils.isBlank(array))
			return false;

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
		if (ArrayUtils.isBlank(array))
			return false;

		boolean lowercaseC = isLowercase(c);
		log.debug("lowercaseC: {}", lowercaseC);

		boolean uppercaseC = isUppercase(c);
		log.debug("uppercaseC: {}", uppercaseC);

		for (char e : array)
		{
			//No need to check further if bo characters are same.
			if (e == c)
				return true;

			boolean lowercaseE = isLowercase(e);
			boolean uppercaseE = isUppercase(e);

			// arg = Z and array[i] = z
			if (uppercaseC && lowercaseE && c == e - 32)
				return true;

			// arg = z and array[i] = Z
			if (lowercaseC && uppercaseE && c == e + 32)
				return true;
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean equalsToAny(String[] array, String val)
	{
		log.debug("string: {}, array: {}", val, Arrays.toString(array));
		if (ArrayUtils.isBlank(array) || val == null)
			return false;

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
		if (ArrayUtils.isBlank(array) || val == null)
			return false;

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

	public static String removeStartsWith(String str, String startsWith)
	{
		log.debug("str: {}, startsWith: {}", str, startsWith);
		ExceptionUtils.throwWhenBlank(str, "String cannot be null");
		ExceptionUtils.throwWhenBlank(startsWith, "startsWith cannot be null");

		if (str.startsWith(startsWith))
			return str.substring(startsWith.length());

		return str;
	}

	public static String removeEndsWith(String str, String endsWith)
	{
		log.debug("str: {}, endsWith: {}", str, endsWith);
		ExceptionUtils.throwWhenBlank(str, "String cannot be null");
		ExceptionUtils.throwWhenBlank(endsWith, "endsWith cannot be null");

		if (str.endsWith(endsWith))
			return str.substring(0, str.length() - endsWith.length());

		return str;
	}
}
