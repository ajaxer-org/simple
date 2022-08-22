package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@Log4j2
public class ArrayUtilsTest
{
	@Nested
	class BubbleSortTest
	{
		@Test
		void withRandomChars()
		{
			char[] unsortedArray = {'s', 'a', 'j', 'd', 'a'};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			char[] sortedArray = {'a', 'a', 'd', 'j', 's'};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomBytes()
		{
			byte[] unsortedArray = {1, 23, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			byte[] sortedArray = {-9, 1, 23, 89, 127};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomShorts()
		{
			short[] unsortedArray = {1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			short[] sortedArray = {-9, 1, 23, 89, 127, 3456, Short.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomInts()
		{
			int[] unsortedArray = {1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			int[] sortedArray = {Integer.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Integer.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomLongs()
		{
			long[] unsortedArray = {1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			long[] sortedArray = {Long.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Long.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomFloats()
		{
			float[] unsortedArray = {1, 23.4f, 23.5f, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			float[] sortedArray = {-9, 1, 23.4f, 23.5f, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomDoubles()
		{
			double[] unsortedArray = {1, 23.4d, 23.5d, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			double[] sortedArray = {-9, 1, 23.4d, 23.5d, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomStrings()
		{
			String[] unsortedArray = {"truman", "chloe", "john", "doe", "ajaxer"};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.bubbleSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			String[] sortedArray = {"ajaxer", "chloe", "doe", "john", "truman"};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}
	}

	@Nested
	class SelectionSortTest
	{
		@Test
		void withRandomChars()
		{
			char[] unsortedArray = {'s', 'a', 'j', 'd', 'a'};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			char[] sortedArray = {'a', 'a', 'd', 'j', 's'};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomBytes()
		{
			byte[] unsortedArray = {1, 23, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			byte[] sortedArray = {-9, 1, 23, 89, 127};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomShorts()
		{
			short[] unsortedArray = {1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			short[] sortedArray = {-9, 1, 23, 89, 127, 3456, Short.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomInts()
		{
			int[] unsortedArray = {1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			int[] sortedArray = {Integer.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Integer.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomLongs()
		{
			long[] unsortedArray = {1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			long[] sortedArray = {Long.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Long.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomFloats()
		{
			float[] unsortedArray = {1, 23.4f, 23.5f, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			float[] sortedArray = {-9, 1, 23.4f, 23.5f, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomDoubles()
		{
			double[] unsortedArray = {1, 23.4d, 23.5d, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			double[] sortedArray = {-9, 1, 23.4d, 23.5d, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomStrings()
		{
			String[] unsortedArray = {"truman", "chloe", "john", "doe", "ajaxer"};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.selectionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			String[] sortedArray = {"ajaxer", "chloe", "doe", "john", "truman"};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}
	}

	@Nested
	class InsertionSortTest
	{
		@Test
		void withRandomChars()
		{
			char[] unsortedArray = {'s', 'a', 'j', 'd', 'a'};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			char[] sortedArray = {'a', 'a', 'd', 'j', 's'};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomBytes()
		{
			byte[] unsortedArray = {1, 23, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			byte[] sortedArray = {-9, 1, 23, 89, 127};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomShorts()
		{
			short[] unsortedArray = {1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			short[] sortedArray = {-9, 1, 23, 89, 127, 3456, Short.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomInts()
		{
			int[] unsortedArray = {1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			int[] sortedArray = {Integer.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Integer.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomLongs()
		{
			long[] unsortedArray = {1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			long[] sortedArray = {Long.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Long.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomFloats()
		{
			float[] unsortedArray = {1, 23.4f, 23.5f, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			float[] sortedArray = {-9, 1, 23.4f, 23.5f, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomDoubles()
		{
			double[] unsortedArray = {1, 23.4d, 23.5d, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			double[] sortedArray = {-9, 1, 23.4d, 23.5d, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomStrings()
		{
			String[] unsortedArray = {"truman", "chloe", "john", "doe", "ajaxer"};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.insertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			String[] sortedArray = {"ajaxer", "chloe", "doe", "john", "truman"};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}
	}

	@Nested
	class BinaryInsertionSortTest
	{
		@Test
		void withRandomChars()
		{
			char[] unsortedArray = {'s', 'a', 'j', 'd', 'a'};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			char[] sortedArray = {'a', 'a', 'd', 'j', 's'};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomBytes()
		{
			byte[] unsortedArray = {1, 23, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			byte[] sortedArray = {-9, 1, 23, 89, 127};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomShorts()
		{
			short[] unsortedArray = {1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			short[] sortedArray = {-9, 1, 23, 89, 127, 3456, Short.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomInts()
		{
			int[] unsortedArray = {1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			int[] sortedArray = {Integer.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Integer.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomLongs()
		{
			long[] unsortedArray = {1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			long[] sortedArray = {Long.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Long.MAX_VALUE};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomFloats()
		{
			float[] unsortedArray = {1, 23.4f, 23.5f, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			float[] sortedArray = {-9, 1, 23.4f, 23.5f, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomDoubles()
		{
			double[] unsortedArray = {1, 23.4d, 23.5d, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			double[] sortedArray = {-9, 1, 23.4d, 23.5d, 89, 127, 3456};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withRandomStrings()
		{
			String[] unsortedArray = {"truman", "chloe", "john", "doe", "ajaxer"};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.binaryInsertionSort(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			String[] sortedArray = {"ajaxer", "chloe", "doe", "john", "truman"};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}
	}

	@Nested
	class ReverseTest
	{
		@Test
		void withCharArray()
		{
			char[] unsortedArray = {'s', 'a', 'j', 'd', 'a'};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			char[] sortedArray = {'a', 'd', 'j', 'a', 's'};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withByteArray()
		{
			byte[] unsortedArray = {1, 23, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			byte[] sortedArray = {89, 127, -9, 23, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withShortArray()
		{
			short[] unsortedArray = {1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			short[] sortedArray = {Short.MAX_VALUE, 89, 127, -9, 3456, 23, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withIntArray()
		{
			int[] unsortedArray = {1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			int[] sortedArray = {89, 127, -9, Integer.MAX_VALUE, Integer.MIN_VALUE, 3456, 23, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withLongArray()
		{
			long[] unsortedArray = {1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			long[] sortedArray = {89, 127, -9, Long.MAX_VALUE, Long.MIN_VALUE, 3456, 23, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withFloatArray()
		{
			float[] unsortedArray = {1, 23.4f, 23.5f, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			float[] sortedArray = {89, 127, -9, 3456, 23.5f, 23.4f, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray);
		}

		@Test
		void withDoubleArray()
		{
			double[] unsortedArray = {1, 23.4d, 23.5d, 3456, -9, 127, 89};
			log.info("before {}", Arrays.toString(unsortedArray));

			ArrayUtils.reverse(unsortedArray);
			log.info("after {}", Arrays.toString(unsortedArray));

			double[] sortedArray = {89, 127, -9, 3456, 23.5f, 23.4f, 1};

			Assertions.assertArrayEquals(unsortedArray, sortedArray, 0.001D);
		}

		@Nested
		class withStringArray
		{
			@Test
			void withRandomStrings()
			{
				String[] beforeArray = {"truman", "chloe", "john", "doe", "ajaxer"};
				log.info("before {}", Arrays.toString(beforeArray));

				ArrayUtils.reverse(beforeArray);
				log.info("after {}", Arrays.toString(beforeArray));

				String[] expectedArray = {"ajaxer", "doe", "john", "chloe", "truman"};

				Assertions.assertArrayEquals(beforeArray, expectedArray);
			}
		}
	}
}