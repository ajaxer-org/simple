package org.ajaxer.simple.utils;

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
		void equalsToAny_with_string_array()
		{
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "saregama"));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "hello-world"));
			Assertions.assertFalse(StringUtils.equalsToAny(strings, "HELLO"));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "world"));
			Assertions.assertTrue(StringUtils.equalsToAny(strings, "ajaxer"));
		}
	}

}