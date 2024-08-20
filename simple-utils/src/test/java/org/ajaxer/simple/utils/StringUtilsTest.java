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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Slf4j
public class StringUtilsTest
{
	String blankString1 = null;
	String blankString2 = "";
	String blankString3 = "   ";
	String notBlankString = "ajaxer.org";

	@Nested
	public class IsBlank
	{
		@Test
		public void testIsBlank_NullString()
		{
			assertTrue(StringUtils.isBlank((String) null));
		}

		@Test
		public void testIsBlank_EmptyString()
		{
			String str = "";

			boolean result = StringUtils.isBlank(str);

			assertTrue(result);
		}

		@Test
		public void testIsBlank_WhitespaceString()
		{
			String str = "   ";

			boolean result = StringUtils.isBlank(str);

			assertTrue(result);
		}

		@Test
		public void testIsBlank_NonEmptyString()
		{
			String str = "Hello";

			boolean result = StringUtils.isBlank(str);

			assertFalse(result);
		}

		@Test
		public void testIsBlank_StringWithLeadingAndTrailingSpaces()
		{
			String str = "   Hello   ";

			boolean result = StringUtils.isBlank(str);

			assertFalse(result);
		}

		@Test
		public void testIsBlank_StringWithTabsAndNewlines()
		{
			String str = "\t\n   \n\t";

			boolean result = StringUtils.isBlank(str);

			assertTrue(result);
		}

		@Test
		public void testIsBlank_StringWithSpacesAndCharacters()
		{
			String str = "   H   ";

			boolean result = StringUtils.isBlank(str);

			assertFalse(result);
		}
	}

	@Nested
	public class IsNotBlank
	{
		@Test
		public void testIsNotBlank_NullString()
		{
			assertFalse(StringUtils.isNotBlank(null));
		}

		@Test
		public void testIsNotBlank_EmptyString()
		{
			String str = "";

			boolean result = StringUtils.isNotBlank(str);

			assertFalse(result);
		}

		@Test
		public void testIsNotBlank_WhitespaceString()
		{
			String str = "   ";

			boolean result = StringUtils.isNotBlank(str);

			assertFalse(result);
		}

		@Test
		public void testIsNotBlank_NonEmptyString()
		{
			String str = "Hello";

			boolean result = StringUtils.isNotBlank(str);

			assertTrue(result);
		}

		@Test
		public void testIsNotBlank_StringWithLeadingAndTrailingSpaces()
		{
			String str = "   Hello   ";

			boolean result = StringUtils.isNotBlank(str);

			assertTrue(result);
		}

		@Test
		public void testIsNotBlank_StringWithTabsAndNewlines()
		{
			String str = "\t\n   \n\t";

			boolean result = StringUtils.isNotBlank(str);

			assertFalse(result);
		}

		@Test
		public void testIsNotBlank_StringWithSpacesAndCharacters()
		{
			String str = "   H   ";

			boolean result = StringUtils.isNotBlank(str);

			assertTrue(result);
		}

		@Test
		void isBlank_multiple()
		{
			assertTrue(StringUtils.isBlank(blankString1, blankString2, blankString3));
			assertFalse(StringUtils.isBlank(notBlankString));
		}
	}

	@Nested
	class CharCount
	{
		@Test
		public void testCharCount_StringIsNull()
		{
			String str = null;
			char ch = 'a';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = {}, ch = '{}', Result = {}", str, ch, result);
			assertEquals(-1, result);
		}

		@Test
		public void testCharCount_StringIsEmpty()
		{
			String str = "";
			char ch = 'a';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(-1, result);
		}

		@Test
		public void testCharCount_CharacterNotInString()
		{
			String str = "hello";
			char ch = 'z';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(0, result);
		}

		@Test
		public void testCharCount_CharacterOccursOnce()
		{
			String str = "hello";
			char ch = 'e';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(1, result);
		}

		@Test
		public void testCharCount_CharacterOccursMultipleTimes()
		{
			String str = "hello world";
			char ch = 'o';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(2, result);
		}

		@Test
		public void testCharCount_CharacterIsWhitespace()
		{
			String str = "hello world ";
			char ch = ' ';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(2, result);
		}

		@Test
		public void testCharCount_EmptyStringAndWhitespaceCharacter()
		{
			String str = "";
			char ch = ' ';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(-1, result);
		}

		@Test
		public void testCharCount_StringWithOnlyWhitespace()
		{
			String str = "     ";
			char ch = ' ';

			int result = StringUtils.charCount(str, ch);

			log.debug("Input: str = '{}', ch = '{}', Result = {}", str, ch, result);
			assertEquals(-1, result);
		}
	}

	@Nested
	class RemovePrefix
	{
		@Test
		void removePrefix_with_blank_string()
		{
			assertNull(StringUtils.removePrefix(blankString1, "ajaxer"));
			assertEquals(blankString2, StringUtils.removePrefix(blankString2, "ajaxer"));
			assertEquals(blankString3, StringUtils.removePrefix(blankString3, "ajaxer"));
		}

		@Test
		void removePrefix_with_not_blank_string()
		{
			assertEquals(".org", StringUtils.removePrefix(notBlankString, "ajaxer"));
			assertEquals("er.org", StringUtils.removePrefix(notBlankString, "ajax"));
			assertEquals("jaxer.org", StringUtils.removePrefix(notBlankString, "a"));
		}
	}

	@Nested
	class RemoveSuffix
	{
		@Test
		void removeSuffix_with_blank_string()
		{
			assertNull(StringUtils.removeSuffix(blankString1, ".org"));
			assertEquals(blankString2, StringUtils.removeSuffix(blankString2, ".org"));
			assertEquals(blankString3, StringUtils.removeSuffix(blankString3, ".org"));
		}

		@Test
		void removeSuffix_with_not_blank_string()
		{
			assertEquals("ajaxer", StringUtils.removeSuffix(notBlankString, ".org"));
			assertEquals("ajaxer.", StringUtils.removeSuffix(notBlankString, "org"));
			assertEquals("ajaxer.or", StringUtils.removeSuffix(notBlankString, "g"));
		}
	}

	@Nested
	class UUID
	{
		@RepeatedTest(10)
		void getUUID()
		{
			assertNotNull(StringUtils.getUUID());
		}

		@RepeatedTest(10)
		void getUUID_with_blank_string()
		{
			assertNotNull(StringUtils.getUUID(blankString1));
			assertNotNull(StringUtils.getUUID(blankString2));
			assertNotNull(StringUtils.getUUID(blankString3));
		}

		@Test
		void getUUID_with_not_blank_string()
		{
			String uuid = StringUtils.getUUID(notBlankString);
			for (int i = 0; i < 10; i++)
			{
				assertEquals(uuid, StringUtils.getUUID(notBlankString));
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
				assertTrue(StringUtils.isLowercase((char) (i + 97)));

			assertFalse(StringUtils.isLowercase('A'));
			assertFalse(StringUtils.isLowercase('Z'));
			assertFalse(StringUtils.isLowercase('1'));
			assertFalse(StringUtils.isLowercase('*'));
			assertFalse(StringUtils.isLowercase('\\'));
		}

		@Test
		void isLowercase_with_blank_string()
		{
			assertFalse(StringUtils.isLowercase(null));
			assertFalse(StringUtils.isLowercase(""));
			assertFalse(StringUtils.isLowercase("  "));
		}

		@Test
		void isLowercase_with_valid_string()
		{
			assertFalse(StringUtils.isLowercase("Hello World"));
			assertFalse(StringUtils.isLowercase("Ajaxer Org"));
			assertFalse(StringUtils.isLowercase("AJAXER ORG"));

			assertTrue(StringUtils.isLowercase("hello"));
			assertTrue(StringUtils.isLowercase("hello world"));
			assertTrue(StringUtils.isLowercase("ajaxer org"));
		}

		@Test
		void toLowerCase_char()
		{
			for (int i = 0; i < 26; i++)
			{
				char lcase = (char) (i + 97);
				char ucase = (char) (i + 65);
				log.info("lcase: {}, ucase: {}", lcase, ucase);

				assertEquals(lcase, StringUtils.toLowerCase(ucase));
			}

			assertEquals('a', StringUtils.toLowerCase('a'));
			assertEquals('g', StringUtils.toLowerCase('g'));
			assertEquals('1', StringUtils.toLowerCase('1'));
			assertEquals('0', StringUtils.toLowerCase('0'));
			assertEquals('-', StringUtils.toLowerCase('-'));
			assertEquals('&', StringUtils.toLowerCase('&'));
		}

		@Test
		public void testIsLowercase_LowercaseLetter()
		{
			char c = 'a';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertTrue(result);
		}

		@Test
		public void testIsLowercase_UppercaseLetter()
		{
			char c = 'A';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertFalse(result);
		}

		@Test
		public void testIsLowercase_Number()
		{
			char c = '5';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertFalse(result);
		}

		@Test
		public void testIsLowercase_Symbol()
		{
			char c = '!';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertFalse(result);
		}

		@Test
		public void testIsLowercase_UpperBoundaryLowercase()
		{
			char c = 'z';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertTrue(result);
		}

		@Test
		public void testIsLowercase_LowerBoundaryLowercase()
		{
			char c = 'a';

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertTrue(result);
		}

		@Test
		public void testIsLowercase_BelowLowerBoundary()
		{
			char c = '`'; // ASCII value 96, just below 'a'

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertFalse(result);
		}

		@Test
		public void testIsLowercase_AboveUpperBoundary()
		{
			char c = '{'; // ASCII value 123, just above 'z'

			boolean result = StringUtils.isLowercase(c);

			log.info("Input: char = '{}', Result = {}", c, result);
			assertFalse(result);
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
				assertTrue(StringUtils.isUppercase((char) (i + 65)));
			}
		}

		@Test
		void isUppercase_with_blank_string()
		{
			assertFalse(StringUtils.isUppercase(null));
			assertFalse(StringUtils.isUppercase(""));
			assertFalse(StringUtils.isUppercase("  "));
		}

		@Test
		void isUppercase_with_valid_string()
		{
			assertTrue(StringUtils.isUppercase("HELLO WORLD"));
			assertFalse(StringUtils.isUppercase("Hello World"));
			assertFalse(StringUtils.isUppercase("Ajaxer Org"));
			assertTrue(StringUtils.isUppercase("AJAXER ORG"));

			assertFalse(StringUtils.isUppercase("hello"));
			assertFalse(StringUtils.isUppercase("hello world"));
			assertFalse(StringUtils.isUppercase("ajaxer orG"));

		}

		@Test
		void toUppercase_char()
		{
			for (int i = 0; i < 26; i++)
			{
				char lcase = (char) (i + 97);
				char ucase = (char) (i + 65);
				log.info("lcase: {}, ucase: {}", lcase, ucase);

				assertEquals(ucase, StringUtils.toUppercase(lcase));
			}

			assertEquals('A', StringUtils.toUppercase('A'));
			assertEquals('G', StringUtils.toUppercase('G'));
			assertEquals('1', StringUtils.toUppercase('1'));
			assertEquals('0', StringUtils.toUppercase('0'));
			assertEquals('-', StringUtils.toUppercase('-'));
			assertEquals('&', StringUtils.toUppercase('&'));
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
			assertFalse(StringUtils.equalsToAny(null, chars[0]));
			assertFalse(StringUtils.equalsToAny(emptyChars, chars[0]));
		}

		@Test
		void equalsToAny_with_char_array()
		{
			assertFalse(StringUtils.equalsToAny(chars, 'q'));
			assertFalse(StringUtils.equalsToAny(chars, 's'));
			assertTrue(StringUtils.equalsToAny(chars, 'a'));
			assertTrue(StringUtils.equalsToAny(chars, '.'));
		}

		@Test
		void equalsToAny_with_blank_string_array()
		{
			assertFalse(StringUtils.equalsToAny(null, strings[0]));
			assertFalse(StringUtils.equalsToAny(emptyStrings, strings[0]));
		}

		@Test
		void equalsToAny_with_blank_val()
		{
			assertFalse(StringUtils.equalsToAny(strings, null));
			assertFalse(StringUtils.equalsToAny(strings, ""));
			assertFalse(StringUtils.equalsToAny(strings, "  "));
			assertTrue(StringUtils.equalsToAny(strings, "world"));
			assertTrue(StringUtils.equalsToAny(strings, "ajaxer"));
		}

		@Test
		void equalsToAny_with_string_array()
		{
			assertFalse(StringUtils.equalsToAny(strings, "sagamore"));
			assertFalse(StringUtils.equalsToAny(strings, "hello-world"));
			assertFalse(StringUtils.equalsToAny(strings, "HELLO"));
			assertTrue(StringUtils.equalsToAny(strings, "world"));
			assertTrue(StringUtils.equalsToAny(strings, "ajaxer"));
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
			assertFalse(StringUtils.equalsIgnoreCaseToAny(null, chars[0]));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(emptyChars, chars[0]));
		}

		@Test
		void equalsIgnoreCaseToAny_with_char_array()
		{
			assertFalse(StringUtils.equalsIgnoreCaseToAny(chars, 'q'));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(chars, 's'));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(chars, 'a'));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(chars, '.'));
		}

		@Test
		void equalsIgnoreCaseToAny_with_blank_string_array()
		{
			assertFalse(StringUtils.equalsIgnoreCaseToAny(null, strings[0]));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(emptyStrings, strings[0]));
		}

		@Test
		void equalsIgnoreCaseToAny_with_blank_val()
		{
			assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, null));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, ""));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "  "));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "world"));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "ajaxer"));
		}

		@Test
		void equalsIgnoreCaseToAny_with_string_array()
		{
			assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "sagamore"));
			assertFalse(StringUtils.equalsIgnoreCaseToAny(strings, "hello-world"));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "HELLO"));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "worLd"));
			assertTrue(StringUtils.equalsIgnoreCaseToAny(strings, "Ajaxer"));
		}
	}

	@Nested
	class ValueOf
	{
		@Test
		void valueOf_null_object()
		{
			assertNull(StringUtils.valueOf(null));
			assertEquals("hello", StringUtils.valueOf(null, "hello"));
		}

		@Test
		void valueOf_not_null_object()
		{
			assertNotNull(StringUtils.valueOf("Hello"));
			assertNotNull(StringUtils.valueOf(new Object()));
			assertEquals("Hello", StringUtils.valueOf("Hello", "hello"));
		}

		@Test
		void valueOf_null_object_with_defaultValue()
		{
			assertNotNull(StringUtils.valueOf(null, "123"));
			assertEquals("hello", StringUtils.valueOf(null, "hello"));
		}

		@Test
		void valueOf_not_null_object_with_defaultValue()
		{
			assertEquals("123", StringUtils.valueOf(123, "def"));
			assertEquals("123", StringUtils.valueOf(123L, "def"));
		}
	}

	@Nested
	public class RemoveStartsWith
	{
		@Test
		public void testRemoveStartsWith_RemovesPrefix()
		{
			String str = "HelloWorld";
			String prefix = "Hello";

			String result = StringUtils.removeStartsWith(str, prefix);

			assertEquals("World", result);
		}

		@Test
		public void testRemoveStartsWith_NoPrefixMatch()
		{
			String str = "HelloWorld";
			String prefix = "hello"; // Different case

			String result = StringUtils.removeStartsWith(str, prefix);

			assertEquals("HelloWorld", result);
		}

		@Test
		public void testRemoveStartsWith_EmptyPrefix()
		{
			String str = "HelloWorld";
			String prefix = "";

			assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith(str, prefix);
			});
		}

		@Test
		public void testRemoveStartsWith_EmptyString()
		{
			String str = "";
			String prefix = "Hello";

			assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith(str, prefix);
			});
		}

		@Test
		public void testRemoveStartsWith_StrEqualsPrefix()
		{
			String str = "Hello";
			String prefix = "Hello";

			String result = StringUtils.removeStartsWith(str, prefix);

			assertEquals("", result);
		}

		@Test
		public void testRemoveStartsWith_MultipleOccurrenceOfPrefix()
		{
			String str = "HelloHelloWorld";
			String prefix = "Hello";

			String result = StringUtils.removeStartsWith(str, prefix);

			assertEquals("HelloWorld", result);
		}

		@Test
		public void testRemoveStartsWith_NullString_ShouldThrowException()
		{
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeStartsWith(null, "Hello");
			});

			assertEquals("String cannot be null", exception.getMessage());
		}

		@Test
		public void testRemoveStartsWith_NullPrefix_ShouldThrowException()
		{
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeStartsWith("HelloWorld", null);
			});

			assertEquals("startsWith cannot be null", exception.getMessage());
		}
	}

	@Nested
	public class RemoveEndsWith
	{
		@Test
		public void testRemoveEndsWith_RemovesSuffix()
		{
			String str = "HelloWorld";
			String suffix = "World";

			String result = StringUtils.removeEndsWith(str, suffix);

			assertEquals("Hello", result);
		}

		@Test
		public void testRemoveEndsWith_NoSuffixMatch()
		{
			String str = "HelloWorld";
			String suffix = "world"; // Different case

			String result = StringUtils.removeEndsWith(str, suffix);

			assertEquals("HelloWorld", result);
		}

		@Test
		public void testRemoveEndsWith_EmptySuffix()
		{
			String str = "HelloWorld";
			String suffix = "";

			assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith(str, suffix);
			});
		}

		@Test
		public void testRemoveEndsWith_EmptyString()
		{
			String str = "";
			String suffix = "World";

			assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith(str, suffix);
			});
		}

		@Test
		public void testRemoveEndsWith_StrEqualsSuffix()
		{
			String str = "World";
			String suffix = "World";

			String result = StringUtils.removeEndsWith(str, suffix);

			assertEquals("", result);
		}

		@Test
		public void testRemoveEndsWith_MultipleOccurrenceOfSuffix()
		{
			String str = "HelloWorldWorld";
			String suffix = "World";

			String result = StringUtils.removeEndsWith(str, suffix);

			assertEquals("HelloWorld", result);
		}

		@Test
		public void testRemoveEndsWith_NullString_ShouldThrowException()
		{
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith(null, "World");
			});

			assertEquals("String cannot be null", exception.getMessage());
		}

		@Test
		public void testRemoveEndsWith_NullSuffix_ShouldThrowException()
		{
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				StringUtils.removeEndsWith("HelloWorld", null);
			});

			assertEquals("endsWith cannot be null", exception.getMessage());
		}
	}

	@Nested
	public class RemoveTrailingNewline
	{
		@Test
		void removeTrailingNewline()
		{
			String text1 = "Hello World\n";
			assertEquals(StringUtils.removeTrailingNewline(text1), "Hello World");

			String text2 = "Hello World\r";
			assertEquals(StringUtils.removeTrailingNewline(text2), "Hello World");

			String text3 = "Hello World\r\n";
			assertEquals(StringUtils.removeTrailingNewline(text3), "Hello World");

			String text4 = "Hello World";
			assertEquals(StringUtils.removeTrailingNewline(text4), "Hello World");
		}
	}
}