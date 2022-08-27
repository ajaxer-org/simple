package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.exceptions.BlankPointerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@Log4j2
public class CollectionUtilsTest
{
	@Nested
	class CollectionBlankOrNotBlank
	{
		@Test
		void when_list_null()
		{
			Assertions.assertTrue(CollectionUtils.isBlank(null));
			Assertions.assertFalse(CollectionUtils.isNotBlank(null));
		}

		@Test
		void when_list_empty()
		{
			List<String> list = new ArrayList<>();
			Assertions.assertTrue(CollectionUtils.isBlank(list));
			Assertions.assertFalse(CollectionUtils.isNotBlank(list));
		}

		@Test
		void when_list_not_empty()
		{
			List<String> list = Arrays.asList("ajaxer", "dot", "org");
			Assertions.assertFalse(CollectionUtils.isBlank(list));
			Assertions.assertTrue(CollectionUtils.isNotBlank(list));
		}
	}

	@Test
	void throwWhenBlank_null()
	{
		Assertions.assertThrows(BlankPointerException.class, () -> CollectionUtils.throwWhenBlank(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.throwWhenBlank(null, new IllegalArgumentException()));
	}

	@Test
	void throwWhenBlank_empty()
	{
		List<String> list = new ArrayList<>();

		Assertions.assertThrows(BlankPointerException.class, () -> CollectionUtils.throwWhenBlank(list));
		Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.throwWhenBlank(list, new IllegalArgumentException()));
	}

	@Nested
	class Equals
	{
		@Test
		void when_both_list_null()
		{
			List<String> l1 = null;
			List<String> l2 = null;
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_both_list_empty()
		{
			List<String> l1 = new ArrayList<>();
			List<String> l2 = new ArrayList<>();
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_first_list_null_second_list_empty()
		{
			List<String> l1 = null;
			List<String> l2 = new ArrayList<>();
			boolean expected = false;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_second_list_null_first_list_empty()
		{
			List<String> l1 = new ArrayList<>();
			List<String> l2 = null;
			boolean expected = false;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_both_list_have_different_data()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> l2 = Arrays.asList("ajaxer", "dash", "org");
			boolean expected = false;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_both_list_have_different_case_sensitive()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> l2 = Arrays.asList("ajaxer", "DOT", "org");
			boolean expected = false;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}

		@Test
		void when_both_list_have_same_data()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> l2 = Arrays.asList("ajaxer", "dot", "org");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(l1, l2));
		}
	}

	@Nested
	class Concat
	{
		@Test
		void when_both_list_null()
		{
			Assertions.assertNull(CollectionUtils.concat(null, null));
		}

		@Test
		void when_both_list_empty()
		{
			List<String> list1 = new ArrayList<>();
			List<String> list2 = new ArrayList<>();
			int value = CollectionUtils.concat(list1, list2).size();

			Assertions.assertEquals(0, value);
		}

		@Test
		void when_first_list_empty()
		{
			List<String> list1 = new ArrayList<>();
			List<String> list2 = Arrays.asList("ajaxer", "dot", "org");
			Collection<String> result = CollectionUtils.concat(list1, list2);

			Assertions.assertTrue(CollectionUtils.equals(list2, result));
		}

		@Test
		void when_second_list_empty()
		{
			List<String> list1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> list2 = new ArrayList<>();
			List<String> result = CollectionUtils.concat(list1, list2);

			Assertions.assertTrue(CollectionUtils.equals(list1, result));
		}
	}
}