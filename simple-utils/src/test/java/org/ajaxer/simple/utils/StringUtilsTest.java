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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
public class StringUtilsTest
{
	String blankString1 = null;
	String blankString2 = "";
	String blankString3 = "   ";
	String notBlankString = "ajaxer.org";

	@Nested
	class Blank
	{
		@Test
		void isBlank()
		{
			Assertions.assertTrue(StringUtils.isBlank(blankString1));
			Assertions.assertTrue(StringUtils.isBlank(blankString2));
			Assertions.assertTrue(StringUtils.isBlank(blankString3));
			Assertions.assertFalse(StringUtils.isBlank(notBlankString));
		}

		@Test
		void isNotBlank()
		{
			Assertions.assertFalse(StringUtils.isNotBlank(blankString1));
			Assertions.assertFalse(StringUtils.isNotBlank(blankString2));
			Assertions.assertFalse(StringUtils.isNotBlank(blankString3));
			Assertions.assertTrue(StringUtils.isNotBlank(notBlankString));
		}
	}

	@Nested
	class CharCount
	{
		@Test
		void charCount_with_blank_string()
		{
			Assertions.assertEquals(-1, StringUtils.charCount(blankString1, 'a'));
			Assertions.assertEquals(-1, StringUtils.charCount(blankString2, 'a'));
			Assertions.assertEquals(-1, StringUtils.charCount(blankString3, ' '));
		}

		@Test
		void charCount_with_not_blank_string()
		{
			Assertions.assertEquals(2, StringUtils.charCount(notBlankString, 'a'));
			Assertions.assertEquals(1, StringUtils.charCount(notBlankString, '.'));
			Assertions.assertEquals(0, StringUtils.charCount(notBlankString, 's'));
		}
	}

	@Nested
	class RemovePrefix
	{
		@Test
		void removePrefix_with_blank_string()
		{
			Assertions.assertNull(StringUtils.removePrefix(blankString1, "ajaxer"));
			Assertions.assertEquals(blankString2, StringUtils.removePrefix(blankString2, "ajaxer"));
			Assertions.assertEquals(blankString3, StringUtils.removePrefix(blankString3, "ajaxer"));
		}

		@Test
		void removePrefix_with_not_blank_string()
		{
			Assertions.assertEquals(".org", StringUtils.removePrefix(notBlankString, "ajaxer"));
			Assertions.assertEquals("er.org", StringUtils.removePrefix(notBlankString, "ajax"));
			Assertions.assertEquals("jaxer.org", StringUtils.removePrefix(notBlankString, "a"));
		}
	}

	@Nested
	class RemoveSuffix
	{
		@Test
		void removeSuffix_with_blank_string()
		{
			Assertions.assertNull(StringUtils.removeSuffix(blankString1, ".org"));
			Assertions.assertEquals(blankString2, StringUtils.removeSuffix(blankString2, ".org"));
			Assertions.assertEquals(blankString3, StringUtils.removeSuffix(blankString3, ".org"));
		}

		@Test
		void removeSuffix_with_not_blank_string()
		{
			Assertions.assertEquals("ajaxer", StringUtils.removeSuffix(notBlankString, ".org"));
			Assertions.assertEquals("ajaxer.", StringUtils.removeSuffix(notBlankString, "org"));
			Assertions.assertEquals("ajaxer.or", StringUtils.removeSuffix(notBlankString, "g"));
		}
	}

	@Nested
	class UUID
	{
		@RepeatedTest(10)
		void getUUID()
		{
			Assertions.assertNotNull(StringUtils.getUUID());
		}

		@RepeatedTest(10)
		void getUUID_with_blank_string()
		{
			Assertions.assertNotNull(StringUtils.getUUID(blankString1));
			Assertions.assertNotNull(StringUtils.getUUID(blankString2));
			Assertions.assertNotNull(StringUtils.getUUID(blankString3));
		}

		@Test
		void getUUID_with_not_blank_string()
		{
			String uuid = StringUtils.getUUID(notBlankString);
			for (int i = 0; i < 10; i++)
			{
				Assertions.assertEquals(uuid, StringUtils.getUUID(notBlankString));
			}
		}
	}

	@Nested
	class Lowercase
	{
		@Test
		void isLowercase_char()
		{
			for (int i = 0; i < 26; i++)
				Assertions.assertTrue(StringUtils.isLowercase((char) (i + 97)));

			Assertions.assertFalse(StringUtils.isLowercase('A'));
			Assertions.assertFalse(StringUtils.isLowercase('Z'));
			Assertions.assertFalse(StringUtils.isLowercase('1'));
			Assertions.assertFalse(StringUtils.isLowercase('*'));
			Assertions.assertFalse(StringUtils.isLowercase('\\'));
		}

		@Test
		void isLowercase_with_blank_string()
		{
			Assertions.assertFalse(StringUtils.isLowercase(null));
			Assertions.assertFalse(StringUtils.isLowercase(""));
			Assertions.assertFalse(StringUtils.isLowercase("  "));
		}

		@Test
		void isLowercase_with_valid_string()
		{
			Assertions.assertFalse(StringUtils.isLowercase("Hello World"));
			Assertions.assertFalse(StringUtils.isLowercase("Ajaxer Org"));
			Assertions.assertFalse(StringUtils.isLowercase("AJAXER ORG"));

			Assertions.assertTrue(StringUtils.isLowercase("hello"));
			Assertions.assertTrue(StringUtils.isLowercase("hello world"));
			Assertions.assertTrue(StringUtils.isLowercase("ajaxer org"));
		}

		@Test
		void toLowerCase_char()
		{
			for (int i = 0; i < 26; i++)
			{
				char lcase = (char) (i + 97);
				char ucase = (char) (i + 65);
				log.info("lcase: {}, ucase: {}", lcase, ucase);

				Assertions.assertEquals(lcase, StringUtils.toLowerCase(ucase));
			}

			Assertions.assertEquals('a', StringUtils.toLowerCase('a'));
			Assertions.assertEquals('g', StringUtils.toLowerCase('g'));
			Assertions.assertEquals('1', StringUtils.toLowerCase('1'));
			Assertions.assertEquals('0', StringUtils.toLowerCase('0'));
			Assertions.assertEquals('-', StringUtils.toLowerCase('-'));
			Assertions.assertEquals('&', StringUtils.toLowerCase('&'));
		}
	}

	@Nested
	class Uppercase
	{
		@Test
		void isUppercase_char()
		{
			for (int i = 0; i < 26; i++)
			{
				Assertions.assertTrue(StringUtils.isUppercase((char) (i + 65)));
			}
		}

		@Test
		void isUppercase_with_blank_string()
		{
			Assertions.assertFalse(StringUtils.isUppercase(null));
			Assertions.assertFalse(StringUtils.isUppercase(""));
			Assertions.assertFalse(StringUtils.isUppercase("  "));
		}

		@Test
		void isUppercase_with_valid_string()
		{
			Assertions.assertTrue(StringUtils.isUppercase("HELLO WORLD"));
			Assertions.assertFalse(StringUtils.isUppercase("Hello World"));
			Assertions.assertFalse(StringUtils.isUppercase("Ajaxer Org"));
			Assertions.assertTrue(StringUtils.isUppercase("AJAXER ORG"));

			Assertions.assertFalse(StringUtils.isUppercase("hello"));
			Assertions.assertFalse(StringUtils.isUppercase("hello world"));
			Assertions.assertFalse(StringUtils.isUppercase("ajaxer orG"));

		}

		@Test
		void toUppercase_char()
		{
			for (int i = 0; i < 26; i++)
			{
				char lcase = (char) (i + 97);
				char ucase = (char) (i + 65);
				log.info("lcase: {}, ucase: {}", lcase, ucase);

				Assertions.assertEquals(ucase, StringUtils.toUppercase(lcase));
			}

			Assertions.assertEquals('A', StringUtils.toUppercase('A'));
			Assertions.assertEquals('G', StringUtils.toUppercase('G'));
			Assertions.assertEquals('1', StringUtils.toUppercase('1'));
			Assertions.assertEquals('0', StringUtils.toUppercase('0'));
			Assertions.assertEquals('-', StringUtils.toUppercase('-'));
			Assertions.assertEquals('&', StringUtils.toUppercase('&'));
		}
	}

	@Nested
	class EqualsToAny
	{
		char[] chars = {'a', 'j', 'a', 'x', 'e', 'r', '.', 'o', 'r', 'g'};
		char[] emptyChars = {};

		String[] emptyStrings = {};
		String[] strings = {"hello", "world", "foo", "bar", "ajaxer"};

		@Test
		void equalsToAny_with_blank_char_array()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(null, chars[0]));
			Assertions.assertFalse(StringUtils.equalsToAny(emptyChars, chars[0]));
		}

		@Test
		void equalsToAny_with_char_array()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(chars, 'q'));
			Assertions.assertFalse(StringUtils.equalsToAny(chars, 's'));
			Assertions.assertTrue(StringUtils.equalsToAny(chars, 'a'));
			Assertions.assertTrue(StringUtils.equalsToAny(chars, '.'));
		}

		@Test
		void equalsToAny_with_blank_string_array()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(null, strings[0]));
			Assertions.assertFalse(StringUtils.equalsToAny(emptyStrings, strings[0]));
		}

		@Test
		void equalsToAny_with_blank_val()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(strings, null));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, ""));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "  "));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "world"));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "ajaxer"));
		}

		@Test
		void equalsToAny_with_string_array()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "sagamore"));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "hello-world"));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "HELLO"));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "world"));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "ajaxer"));
		}
	}

	@Nested
	class EqualsIgnoreCaseToAny
	{
		char[] chars = {'A', 'j', 'A', 'x', 'e', 'R', '.', 'o', 'R', 'g'};
		char[] emptyChars = {};

		String[] emptyStrings = {};
		String[] strings = {"hello", "WORLD", "foo", "bar", "ajaxer"};

		@Test
		void equalsIgnoreCaseToAny_with_blank_char_array()
		{
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(null, chars[0]));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(emptyChars, chars[0]));
		}

		@Test
		void equalsIgnoreCaseToAny_with_char_array()
		{
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(chars, 'q'));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(chars, 's'));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(chars, 'a'));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(chars, '.'));
		}

		@Test
		void equalsIgnoreCaseToAny_with_blank_string_array()
		{
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(null, strings[0]));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(emptyStrings, strings[0]));
		}

		@Test
		void equalsIgnoreCaseToAny_with_blank_val()
		{
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, null));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, ""));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "  "));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "world"));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "ajaxer"));
		}

		@Test
		void equalsIgnoreCaseToAny_with_string_array()
		{
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "sagamore"));
			Assertions.assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "hello-world"));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "HELLO"));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "worLd"));
			Assertions.assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "Ajaxer"));
		}
	}

	@Nested
	class ValueOf
	{
		@Test
		void valueOf_null_object()
		{
			Assertions.assertNull(StringUtils.valueOf(null));
			Assertions.assertEquals("hello", StringUtils.valueOf(null, "hello"));
		}

		@Test
		void valueOf_not_null_object()
		{
			Assertions.assertNotNull(StringUtils.valueOf("Hello"));
			Assertions.assertNotNull(StringUtils.valueOf(new Object()));
			Assertions.assertEquals("Hello", StringUtils.valueOf("Hello", "hello"));
		}

		@Test
		void valueOf_null_object_with_defaultValue()
		{
			Assertions.assertNotNull(StringUtils.valueOf(null, "123"));
			Assertions.assertEquals("hello", StringUtils.valueOf(null, "hello"));
		}

		@Test
		void valueOf_not_null_object_with_defaultValue()
		{
			Assertions.assertEquals("123", StringUtils.valueOf(123, "def"));
			Assertions.assertEquals("123", StringUtils.valueOf(123L, "def"));
		}
	}
}