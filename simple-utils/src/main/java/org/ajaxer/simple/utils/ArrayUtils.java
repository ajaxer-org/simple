package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
@Log4j2
public class ArrayUtils
{
	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(boolean[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(boolean[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(char[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(char[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(byte[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(byte[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(short[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(short[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(int[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(int[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(long[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(long[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(float[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(double[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isBlank(double[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isNotBlank(float[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isBlank(T[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isNotBlank(T[] array)
	{
		return !isBlank(array);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void swap(T[] array, int pos1, int pos2)
	{
		T temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(char[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					char temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}

		log.debug("sorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(byte[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					byte temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}

		log.debug("sorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(short[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					short temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}

		log.debug("sorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(int[] array)
	{
		log.debug("array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(long[] array)
	{
		log.debug("array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					long temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(float[] array)
	{
		log.debug("array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					float temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void bubbleSort(double[] array)
	{
		log.debug("array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					double temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					doMore = true;
				}
			}
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		boolean doMore = true;
		while (doMore)
		{
			doMore = false;
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i].compareTo(array[i + 1]) > 0)
				{
					swap(array, i, i + 1);
					doMore = true;
				}
			}
		}

		log.debug("sorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(char[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				char temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(byte[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				byte temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(short[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				short temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(int[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(long[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				long temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(float[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				float temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void selectionSort(double[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				double temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] array)
	{
		log.debug("unsorted array: {}", Arrays.toString(array));

		for (int i = 0; i < array.length - 1; i++)
		{
			// Index of the smallest remaining value.
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex].compareTo(array[j]) > 0)
				{
					minIndex = j;
				}
			}

			if (minIndex != i)
			{
				// Exchange current element with the smallest remaining.
				swap(array, i, minIndex);
			}
		}

		log.debug("unsorted array: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(char[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			char key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(byte[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			byte key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(short[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			short key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(int[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			int key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(long[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			long key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(float[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			float key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void insertionSort(double[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			double key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j] > key)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] array)
	{
		for (int i = 1; i < array.length; ++i)
		{
			T key = array[i];
			int j = i - 1;

            /*
            Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position
            */
			while (j >= 0 && array[j].compareTo(key) > 0)
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(char[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			char x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(byte[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			byte x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(short[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			short x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(long[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			long x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(float[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			float x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void binaryInsertionSort(double[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			double x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void binaryInsertionSort(T[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			T x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(char[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(char[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			char t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(byte[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(byte[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			byte t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(short[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(short[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			short t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(int[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(int[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			int t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(long[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(long[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			long t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(float[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(float[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			float t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(double[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static void reverse(double[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			double t = array[i];
			array[i] = array[len - i - 1];
			array[len - i - 1] = t;
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void reverse(T[] array)
	{
		reverse(array, array.length);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void reverse(T[] array, int len)
	{
		log.debug("array before reverse: {}", Arrays.toString(array));

		for (int i = 0; i < len / 2; i++)
		{
			swap(array, i, len - i - 1);
		}

		log.debug("array after reverse: {}", Arrays.toString(array));
	}
}
