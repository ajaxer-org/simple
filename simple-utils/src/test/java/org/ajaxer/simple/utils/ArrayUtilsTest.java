package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
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
	private final int REPEATED_TEST_COUNT = 10;

	private boolean[] booleanArray;
	private char[] charArray;
	private byte[] byteArray;
	private short[] shortArray;
	private int[] intArray;
	private long[] longArray;
	private float[] floatArray;
	private double[] doubleArray;
	private String[] stringArray;

	private final boolean[] sortedBooleanArray = {false, false, false, false, true, true, true, true};
	private final char[] sortedCharArray = {'a', 'a', 'd', 'j', 's'};
	private final byte[] sortedByteArray = {-9, 1, 23, 89, 127};
	private final short[] sortedShortArray = {-9, 1, 23, 89, 127, 3456, Short.MAX_VALUE};
	private final int[] sortedIntArray = {Integer.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Integer.MAX_VALUE};
	private final long[] sortedLongArray = {Long.MIN_VALUE, -9, 1, 23, 89, 127, 3456, Long.MAX_VALUE};
	private final float[] sortedFloatArray = {-9.99F, 0.89F, 1.23F, 23.45f, 23.50F, 127.2345F, 3456F};
	private final double[] sortedDoubleArray = {-9.01D, 1.00009D, 23.444D, 23.59D, 89.345D, 127.12345D, 3456D};
	private final String[] sortedStringArray = {"ajaxer", "chloe", "doe", "john", "truman"};

	@BeforeEach
	void beforeEach()
	{
		booleanArray = new boolean[]{true, true, false, true, false, false, false, true};
		charArray = new char[]{'s', 'a', 'j', 'd', 'a'};
		byteArray = new byte[]{1, 23, -9, 127, 89};
		shortArray = new short[]{1, 23, 3456, -9, 127, 89, Short.MAX_VALUE};
		intArray = new int[]{1, 23, 3456, Integer.MIN_VALUE, Integer.MAX_VALUE, -9, 127, 89};
		longArray = new long[]{1, 23, 3456, Long.MIN_VALUE, Long.MAX_VALUE, -9, 127, 89};
		floatArray = new float[]{1.23F, 23.45f, 23.50F, 3456F, -9.99F, 127.2345F, 0.89F};
		doubleArray = new double[]{1.00009D, 23.444D, 23.59D, 3456D, -9.01D, 127.12345D, 89.345D};
		stringArray = new String[]{"truman", "chloe", "john", "doe", "ajaxer"};
	}

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
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(booleanArray));
		}

		@Test
		void charArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(charArray));
		}

		@Test
		void byteArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(byteArray));
		}

		@Test
		void shortArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(shortArray));
		}

		@Test
		void intArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(intArray));
		}

		@Test
		void longArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(longArray));
		}

		@Test
		void floatArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(floatArray));
		}

		@Test
		void doubleArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(doubleArray));
		}

		@Test
		void StringArray()
		{
			Assertions.assertEquals(true, ArrayUtils.isNotBlank(stringArray));
		}
	}

	@Nested
	class Shuffle
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_booleanArray()
		{
			ArrayUtils.shuffle(booleanArray);
			log.info("shuffled array: {}", Arrays.toString(booleanArray));

			for (int i = 0; i < sortedBooleanArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < booleanArray.length; j++)
				{
					if (sortedBooleanArray[i] == booleanArray[j])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_charArray()
		{
			ArrayUtils.shuffle(charArray);
			log.info("shuffled array: {}", Arrays.toString(charArray));

			for (int i = 0; i < sortedCharArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < charArray.length; j++)
				{
					if (charArray[j] == sortedCharArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_byteArray()
		{
			ArrayUtils.shuffle(byteArray);
			log.info("shuffled array: {}", Arrays.toString(byteArray));

			for (int i = 0; i < sortedByteArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < byteArray.length; j++)
				{
					if (byteArray[j] == sortedByteArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_shortArray()
		{
			ArrayUtils.shuffle(shortArray);
			log.info("shuffled array: {}", Arrays.toString(shortArray));

			for (int i = 0; i < sortedShortArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < shortArray.length; j++)
				{
					if (shortArray[j] == sortedShortArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_intArray()
		{
			ArrayUtils.shuffle(intArray);
			log.info("shuffled array: {}", Arrays.toString(intArray));

			for (int i = 0; i < sortedIntArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < intArray.length; j++)
				{
					if (intArray[j] == sortedIntArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_longArray()
		{
			ArrayUtils.shuffle(longArray);
			log.info("shuffled array: {}", Arrays.toString(longArray));

			for (int i = 0; i < sortedLongArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < longArray.length; j++)
				{
					if (longArray[j] == sortedLongArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_floatArray()
		{
			ArrayUtils.shuffle(floatArray);
			log.info("shuffled array: {}", Arrays.toString(floatArray));

			for (int i = 0; i < sortedFloatArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < floatArray.length; j++)
				{
					if (floatArray[j] == sortedFloatArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_doubleArray()
		{
			ArrayUtils.shuffle(doubleArray);
			log.info("shuffled array: {}", Arrays.toString(doubleArray));

			for (int i = 0; i < sortedDoubleArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < doubleArray.length; j++)
				{
					if (doubleArray[j] == sortedDoubleArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		void shuffle_stringArray()
		{
			ArrayUtils.shuffle(stringArray);
			log.info("shuffled array: {}", Arrays.toString(stringArray));

			for (int i = 0; i < sortedStringArray.length; i++)
			{
				boolean flag = false;
				for (int j = 0; j < stringArray.length; j++)
				{
					if (stringArray[j] == sortedStringArray[i])
					{
						flag = true;
						break;
					}
				}
				Assertions.assertTrue(flag);
			}
		}
	}

	@Nested
	class Swap
	{
		@Test
		void swap_with_blank_array()
		{
			String[] nullArray = null;
			String[] emptyArray = {};

			ArrayUtils.swap(nullArray, 0, 1);
			Assertions.assertNull(nullArray);

//			ArrayUtils.swap(emptyArray, 0, 1);
//			Assertions.assertEquals(ArrayUtils.eq);
		}

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
			log.info("before {}", Arrays.toString(charArray));

			ArrayUtils.bubbleSort(charArray);
			log.info("after {}", Arrays.toString(charArray));

			Assertions.assertArrayEquals(charArray, sortedCharArray);
		}

		@Test
		void withRandomBytes()
		{
			log.info("before {}", Arrays.toString(byteArray));

			ArrayUtils.bubbleSort(byteArray);
			log.info("after {}", Arrays.toString(byteArray));

			Assertions.assertArrayEquals(byteArray, sortedByteArray);
		}

		@Test
		void withRandomShorts()
		{
			log.info("before {}", Arrays.toString(shortArray));

			ArrayUtils.bubbleSort(shortArray);
			log.info("after {}", Arrays.toString(shortArray));

			Assertions.assertArrayEquals(shortArray, sortedShortArray);
		}

		@Test
		void withRandomInts()
		{
			log.info("before {}", Arrays.toString(intArray));

			ArrayUtils.bubbleSort(intArray);
			log.info("after {}", Arrays.toString(intArray));

			Assertions.assertArrayEquals(intArray, sortedIntArray);
		}

		@Test
		void withRandomLongs()
		{
			log.info("before {}", Arrays.toString(longArray));

			ArrayUtils.bubbleSort(longArray);
			log.info("after {}", Arrays.toString(longArray));

			Assertions.assertArrayEquals(longArray, sortedLongArray);
		}

		@Test
		void withRandomFloats()
		{
			log.info("before {}", Arrays.toString(floatArray));

			ArrayUtils.bubbleSort(floatArray);
			log.info("after {}", Arrays.toString(floatArray));

			Assertions.assertArrayEquals(floatArray, sortedFloatArray);
		}

		@Test
		void withRandomDoubles()
		{
			log.info("before {}", Arrays.toString(doubleArray));

			ArrayUtils.bubbleSort(doubleArray);
			log.info("after {}", Arrays.toString(doubleArray));

			Assertions.assertArrayEquals(doubleArray, sortedDoubleArray);
		}

		@Test
		void withRandomStrings()
		{
			log.info("before {}", Arrays.toString(stringArray));

			ArrayUtils.bubbleSort(stringArray);
			log.info("after {}", Arrays.toString(stringArray));

			Assertions.assertArrayEquals(stringArray, sortedStringArray);
		}
	}

	@Nested
	class SelectionSortTest
	{
		@Test
		void withRandomChars()
		{
			log.info("before {}", Arrays.toString(charArray));

			ArrayUtils.selectionSort(charArray);
			log.info("after {}", Arrays.toString(charArray));

			Assertions.assertArrayEquals(charArray, sortedCharArray);
		}

		@Test
		void withRandomBytes()
		{
			log.info("before {}", Arrays.toString(byteArray));

			ArrayUtils.selectionSort(byteArray);
			log.info("after {}", Arrays.toString(byteArray));

			Assertions.assertArrayEquals(byteArray, sortedByteArray);
		}

		@Test
		void withRandomShorts()
		{
			log.info("before {}", Arrays.toString(shortArray));

			ArrayUtils.selectionSort(shortArray);
			log.info("after {}", Arrays.toString(shortArray));

			Assertions.assertArrayEquals(shortArray, sortedShortArray);
		}

		@Test
		void withRandomInts()
		{
			log.info("before {}", Arrays.toString(intArray));

			ArrayUtils.selectionSort(intArray);
			log.info("after {}", Arrays.toString(intArray));

			Assertions.assertArrayEquals(intArray, sortedIntArray);
		}

		@Test
		void withRandomLongs()
		{
			log.info("before {}", Arrays.toString(longArray));

			ArrayUtils.selectionSort(longArray);
			log.info("after {}", Arrays.toString(longArray));

			Assertions.assertArrayEquals(longArray, sortedLongArray);
		}

		@Test
		void withRandomFloats()
		{
			log.info("before {}", Arrays.toString(floatArray));

			ArrayUtils.selectionSort(floatArray);
			log.info("after {}", Arrays.toString(floatArray));

			Assertions.assertArrayEquals(floatArray, sortedFloatArray);
		}

		@Test
		void withRandomDoubles()
		{
			log.info("before {}", Arrays.toString(doubleArray));

			ArrayUtils.selectionSort(doubleArray);
			log.info("after {}", Arrays.toString(doubleArray));

			Assertions.assertArrayEquals(doubleArray, sortedDoubleArray);
		}

		@Test
		void withRandomStrings()
		{
			log.info("before {}", Arrays.toString(stringArray));

			ArrayUtils.selectionSort(stringArray);
			log.info("after {}", Arrays.toString(stringArray));

			Assertions.assertArrayEquals(stringArray, sortedStringArray);
		}
	}

	@Nested
	class InsertionSortTest
	{
		@Test
		void withRandomChars()
		{
			log.info("before {}", Arrays.toString(charArray));

			ArrayUtils.insertionSort(charArray);
			log.info("after {}", Arrays.toString(charArray));

			Assertions.assertArrayEquals(charArray, sortedCharArray);
		}

		@Test
		void withRandomBytes()
		{
			log.info("before {}", Arrays.toString(byteArray));

			ArrayUtils.insertionSort(byteArray);
			log.info("after {}", Arrays.toString(byteArray));

			Assertions.assertArrayEquals(byteArray, sortedByteArray);
		}

		@Test
		void withRandomShorts()
		{
			log.info("before {}", Arrays.toString(shortArray));

			ArrayUtils.insertionSort(shortArray);
			log.info("after {}", Arrays.toString(shortArray));

			Assertions.assertArrayEquals(shortArray, sortedShortArray);
		}

		@Test
		void withRandomInts()
		{
			log.info("before {}", Arrays.toString(intArray));

			ArrayUtils.insertionSort(intArray);
			log.info("after {}", Arrays.toString(intArray));

			Assertions.assertArrayEquals(intArray, sortedIntArray);
		}

		@Test
		void withRandomLongs()
		{
			log.info("before {}", Arrays.toString(longArray));

			ArrayUtils.insertionSort(longArray);
			log.info("after {}", Arrays.toString(longArray));

			Assertions.assertArrayEquals(longArray, sortedLongArray);
		}

		@Test
		void withRandomFloats()
		{
			log.info("before {}", Arrays.toString(floatArray));

			ArrayUtils.insertionSort(floatArray);
			log.info("after {}", Arrays.toString(floatArray));

			Assertions.assertArrayEquals(floatArray, sortedFloatArray);
		}

		@Test
		void withRandomDoubles()
		{
			log.info("before {}", Arrays.toString(doubleArray));

			ArrayUtils.insertionSort(doubleArray);
			log.info("after {}", Arrays.toString(doubleArray));

			Assertions.assertArrayEquals(doubleArray, sortedDoubleArray);
		}

		@Test
		void withRandomStrings()
		{
			log.info("before {}", Arrays.toString(stringArray));

			ArrayUtils.insertionSort(stringArray);
			log.info("after {}", Arrays.toString(stringArray));

			Assertions.assertArrayEquals(stringArray, sortedStringArray);
		}
	}

	@Nested
	class BinaryInsertionSortTest
	{
		@Test
		void withRandomChars()
		{
			log.info("before {}", Arrays.toString(charArray));

			ArrayUtils.binaryInsertionSort(charArray);
			log.info("after {}", Arrays.toString(charArray));

			Assertions.assertArrayEquals(charArray, sortedCharArray);
		}

		@Test
		void withRandomBytes()
		{
			log.info("before {}", Arrays.toString(byteArray));

			ArrayUtils.binaryInsertionSort(byteArray);
			log.info("after {}", Arrays.toString(byteArray));

			Assertions.assertArrayEquals(byteArray, sortedByteArray);
		}

		@Test
		void withRandomShorts()
		{
			log.info("before {}", Arrays.toString(shortArray));

			ArrayUtils.binaryInsertionSort(shortArray);
			log.info("after {}", Arrays.toString(shortArray));

			Assertions.assertArrayEquals(shortArray, sortedShortArray);
		}

		@Test
		void withRandomInts()
		{
			log.info("before {}", Arrays.toString(intArray));

			ArrayUtils.binaryInsertionSort(intArray);
			log.info("after {}", Arrays.toString(intArray));

			Assertions.assertArrayEquals(intArray, sortedIntArray);
		}

		@Test
		void withRandomLongs()
		{
			log.info("before {}", Arrays.toString(longArray));

			ArrayUtils.binaryInsertionSort(longArray);
			log.info("after {}", Arrays.toString(longArray));

			Assertions.assertArrayEquals(longArray, sortedLongArray);
		}

		@Test
		void withRandomFloats()
		{
			log.info("before {}", Arrays.toString(floatArray));

			ArrayUtils.binaryInsertionSort(floatArray);
			log.info("after {}", Arrays.toString(floatArray));

			Assertions.assertArrayEquals(floatArray, sortedFloatArray);
		}

		@Test
		void withRandomDoubles()
		{
			log.info("before {}", Arrays.toString(doubleArray));

			ArrayUtils.binaryInsertionSort(doubleArray);
			log.info("after {}", Arrays.toString(doubleArray));

			Assertions.assertArrayEquals(doubleArray, sortedDoubleArray);
		}

		@Test
		void withRandomStrings()
		{
			log.info("before {}", Arrays.toString(stringArray));

			ArrayUtils.binaryInsertionSort(stringArray);
			log.info("after {}", Arrays.toString(stringArray));

			Assertions.assertArrayEquals(stringArray, sortedStringArray);
		}
	}

	@Nested
	class ReverseTest
	{
		@Test
		void withCharArray()
		{
			log.info("before {}", Arrays.toString(charArray));

			ArrayUtils.reverse(charArray);
			log.info("after {}", Arrays.toString(charArray));

			char[] sortedArray = {'a', 'd', 'j', 'a', 's'};

			Assertions.assertArrayEquals(charArray, sortedArray);
		}

		@Test
		void withByteArray()
		{
			log.info("before {}", Arrays.toString(byteArray));

			ArrayUtils.reverse(byteArray);
			log.info("after {}", Arrays.toString(byteArray));

			byte[] sortedArray = {89, 127, -9, 23, 1};

			Assertions.assertArrayEquals(byteArray, sortedArray);
		}

		@Test
		void withShortArray()
		{
			log.info("before {}", Arrays.toString(shortArray));

			ArrayUtils.reverse(shortArray);
			log.info("after {}", Arrays.toString(shortArray));

			short[] sortedArray = {Short.MAX_VALUE, 89, 127, -9, 3456, 23, 1};

			Assertions.assertArrayEquals(shortArray, sortedArray);
		}

		@Test
		void withIntArray()
		{
			log.info("before {}", Arrays.toString(intArray));

			ArrayUtils.reverse(intArray);
			log.info("after {}", Arrays.toString(intArray));

			int[] sortedArray = {89, 127, -9, Integer.MAX_VALUE, Integer.MIN_VALUE, 3456, 23, 1};

			Assertions.assertArrayEquals(intArray, sortedArray);
		}

		@Test
		void withLongArray()
		{
			log.info("before {}", Arrays.toString(longArray));

			ArrayUtils.reverse(longArray);
			log.info("after {}", Arrays.toString(longArray));

			long[] sortedArray = {89, 127, -9, Long.MAX_VALUE, Long.MIN_VALUE, 3456, 23, 1};

			Assertions.assertArrayEquals(longArray, sortedArray);
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

		@Test
		void withRandomStrings()
		{
			log.info("before {}", Arrays.toString(stringArray));

			ArrayUtils.reverse(stringArray);
			log.info("after {}", Arrays.toString(stringArray));

			String[] expectedArray = {"ajaxer", "doe", "john", "chloe", "truman"};

			Assertions.assertArrayEquals(stringArray, expectedArray);
		}
	}

	@Nested
	class ThrowWhenBlank
	{
		@Test
		void booleanArray()
		{
			boolean[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void charArray()
		{
			char[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void byteArray()
		{
			byte[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void shortArray()
		{
			short[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void intArray()
		{
			int[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void longArray()
		{
			long[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void floatArray()
		{
			float[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void doubleArray()
		{
			double[] array = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));
		}

		@Test
		void StringArray()
		{
			final String[] array = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array));
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenBlank(array, new NullPointerException()));

			final String[] array1 = {};
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(array1, new IllegalArgumentException()));
		}
	}
}