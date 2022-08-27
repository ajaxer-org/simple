package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.exceptions.BlankPointerException;
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
	class IsBlankArray
	{
		@Test
		void booleanArray()
		{
			boolean[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void charArray()
		{
			char[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void byteArray()
		{
			byte[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void shortArray()
		{
			short[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void intArray()
		{
			int[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void longArray()
		{
			long[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void floatArray()
		{
			float[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void doubleArray()
		{
			double[] array = {};
			Assertions.assertEquals(true, ArrayUtils.isBlank(array));
		}

		@Test
		void StringArray()
		{
			String[] array1 = null;
			String[] array2 = {};

			Assertions.assertEquals(true, ArrayUtils.isBlank(array1));
			Assertions.assertEquals(true, ArrayUtils.isBlank(array2));
		}
	}

	@Nested
	class IsNotBlankArray
	{
		@Test
		void booleanArray()
		{
			boolean[] array = {true, false};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void charArray()
		{
			char[] array = {'a', 'o'};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void byteArray()
		{
			byte[] array = {Byte.MIN_VALUE, 0, 1, 2};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void shortArray()
		{
			short[] array = {0, 1, 2, Short.MAX_VALUE};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void intArray()
		{
			int[] array = {10, 20, 30, Integer.MAX_VALUE};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void longArray()
		{
			long[] array = {10, 20, 30, Long.MAX_VALUE};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void floatArray()
		{
			float[] array = {0, 1.34F, 34.78F, Float.MIN_VALUE};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void doubleArray()
		{
			double[] array = {0, 1.34D, 34.78D, Double.MIN_VALUE};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array));
		}

		@Test
		void StringArray()
		{
			String[] array1 = {"ajaxer", "org"};
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(array1));
		}
	}

	@Nested
	class ThrowWhenBlank
	{
		@Test
		void booleanArray()
		{
			boolean[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void charArray()
		{
			char[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void byteArray()
		{
			byte[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void shortArray()
		{
			short[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void intArray()
		{
			int[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void longArray()
		{
			long[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void floatArray()
		{
			float[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void doubleArray()
		{
			double[] array = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));
		}

		@Test
		void StringArray()
		{
			final String[] array = null;
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array, new IllegalArgumentException()));

			final String[] array1 = {};
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array1));
			Assertions.assertThrows(BlankPointerException.class, () -> ArrayUtils.throwWhenBlank(array1, new IllegalArgumentException()));
		}
	}

	@Nested
	class Swap
	{
		@Test
		void swap()
		{
			String[] args = {"ajaxer", "dot", "org"};
			ArrayUtils.swap(args, 0, 1);
			String[] expected = {"dot", "ajaxer", "org"};

			Assertions.assertArrayEquals(args, expected);
		}
	}

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