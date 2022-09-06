package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
			//noinspection ConstantConditions
			Assertions.assertTrue(CollectionUtils.isBlank(null));

			//noinspection ConstantConditions
			Assertions.assertFalse(CollectionUtils.isNotBlank(null));
		}

		@Test
		void when_list_empty()
		{
			//noinspection MismatchedQueryAndUpdateOfCollection
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
		Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank((Collection<?>) null));
		Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank((Collection<?>) null, new NullPointerException()));
	}

	@Test
	void throwWhenBlank_empty()
	{
		List<String> list = new ArrayList<>();

		Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(list));
		Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(list, new NullPointerException()));
	}

	@Nested
	class Equals
	{
		@Test
		void when_both_lists_blank()
		{
		}

		@Test
		void when_lists_are_blank()
		{
			Assertions.assertTrue(CollectionUtils.equals(null, null));

			Assertions.assertTrue(CollectionUtils.equals(new ArrayList<>(), new ArrayList<>()));

			Assertions.assertFalse(CollectionUtils.equals(null, new ArrayList<>()));

			Assertions.assertFalse(CollectionUtils.equals(new ArrayList<>(), null));
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
	class EqualsToAny
	{
		String val = "ajaxer";
		List<String> list = Arrays.asList("hello", "world", "foo", "bar", "ajaxer");

		@Test
		void equalsToAny_with_blank_collection()
		{
			Assertions.assertFalse(CollectionUtils.equalsToAny(null, val));
			Assertions.assertFalse(CollectionUtils.equalsToAny(new ArrayList<>(), val));
		}

		@Test
		void equalsToAny_with_blank_value()
		{
			Assertions.assertFalse(CollectionUtils.equalsToAny(list, null));
		}

		@Test
		void equalsToAny()
		{
			Assertions.assertFalse(CollectionUtils.equalsToAny(list, ""));
			Assertions.assertFalse(CollectionUtils.equalsToAny(list, "  "));
			Assertions.assertFalse(CollectionUtils.equalsToAny(list, "hello-world"));
			Assertions.assertTrue(CollectionUtils.equalsToAny(list, "hello"));
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

			//noinspection ConstantConditions
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

	@Nested
	class SubList
	{
		@Test
		void when_list_null()
		{
			Assertions.assertNull(CollectionUtils.subList(null, 0));
			Assertions.assertNull(CollectionUtils.subList(null, 0, 2));
		}

		@Test
		void when_list_empty()
		{
			List<String> l1 = new ArrayList<>();
			List<String> resultList1 = CollectionUtils.subList(l1, 0);
			List<String> resultList2 = CollectionUtils.subList(l1, 0, 2);
			List<String> expectedList = new ArrayList<>();

			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList1));
			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList2));
		}

		@Test
		void when_list_have_same_data_t1()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> resultList = CollectionUtils.subList(l1, 1);
			List<String> expectedList = Arrays.asList("dot", "org");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t2()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> resultList = CollectionUtils.subList(l1, 1, 2);
			List<String> expectedList = Collections.singletonList("dot");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t3()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> resultList = CollectionUtils.subList(l1, 1, l1.size());
			List<String> expectedList = Arrays.asList("dot", "org");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}
	}

	@Nested
	class GetNextChunk
	{
		@Test
		void when_list_null()
		{
			Assertions.assertNull(CollectionUtils.getNextChunk(null, 10, 0));
		}

		@Test
		void when_list_empty()
		{
			List<String> l1 = new ArrayList<>();
			List<String> resultList = CollectionUtils.getNextChunk(l1, 10, 0);
			List<String> expectedList = new ArrayList<>();
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t1()
		{
			List<Integer> l1 = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140);
			List<Integer> resultList = CollectionUtils.getNextChunk(l1, 5, 2);
			List<Integer> expectedList = Arrays.asList(20, 30, 40, 50, 60);
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t2()
		{
			List<Integer> l1 = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140);
			List<Integer> resultList = CollectionUtils.getNextChunk(l1, 8, 6);
			List<Integer> expectedList = Arrays.asList(60, 70, 80, 90, 100, 110, 120, 130);
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}
	}

	@Nested
	class Reverse
	{
		@Test
		void when_list_blank()
		{
			Assertions.assertNull(CollectionUtils.reverse(null));

			List<String> l1 = new ArrayList<>();
			List<String> resultList = CollectionUtils.reverse(l1);
			List<String> expectedList = new ArrayList<>();
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t1()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> resultList = CollectionUtils.reverse(l1);
			List<String> expectedList = Arrays.asList("org", "dot", "ajaxer");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_list_have_same_data_t2()
		{
			List<String> l1 = Arrays.asList("ajaxer", "dot", "org");
			List<String> resultList = CollectionUtils.reverse(l1);
			List<String> expectedList = Arrays.asList("org", "DOT", "ajaxer");
			boolean expected = false;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}
	}

	@Nested
	class AsArrayList
	{
		@Test
		void when_array_blank()
		{
			Assertions.assertNull(CollectionUtils.asArrayList(null));

			String[] array = {};
			List<String> resultList = CollectionUtils.asArrayList(array);
			List<String> expectedList = new ArrayList<>();
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}

		@Test
		void when_array_have_same_data_t1()
		{
			String[] array = {"ajaxer", "dot", "org"};
			List<String> resultList = CollectionUtils.asArrayList(array);
			List<String> expectedList = Arrays.asList("ajaxer", "dot", "org");
			boolean expected = true;

			Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
		}
	}

	@Test
	void get_top_list()
	{
		List<Integer> l1 = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140);
		List<Integer> resultList = CollectionUtils.getTopList(l1, 8);
		List<Integer> expectedList = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70);
		boolean expected = true;

		Assertions.assertEquals(expected, CollectionUtils.equals(expectedList, resultList));
	}

}