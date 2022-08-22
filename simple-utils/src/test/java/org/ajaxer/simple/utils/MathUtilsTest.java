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
public class MathUtilsTest
{
	@Nested
	class MinTests
	{
		@Test
		void withByteArray()
		{
			byte[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Byte.MAX_VALUE};
			byte result = MathUtils.min(array);
			byte expected = -9;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withShortArray()
		{
			short[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Short.MAX_VALUE};
			short result = MathUtils.min(array);
			short expected = -9;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withIntArray()
		{
			int[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Integer.MIN_VALUE};
			int result = MathUtils.min(array);
			int expected = Integer.MIN_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withLongArray()
		{
			long[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Integer.MIN_VALUE};
			long result = MathUtils.min(array);
			long expected = Integer.MIN_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withFloatArray()
		{
			float[] array = {-9.5F, -8, 4, 5, 7, 2, 8, 32.5f, 3};
			float result = MathUtils.min(array);
			float expected = -9.5F;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withDoubleArray()
		{
			double[] array = {-9.5D, -8, 4, 5, 7, 2, 8, 32.5f, 3};
			double result = MathUtils.min(array);
			double expected = -9.5D;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}
	}

	@Nested
	class MaxTests
	{
		@Test
		void withByteArray()
		{
			byte[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Byte.MAX_VALUE};
			byte result = MathUtils.max(array);
			byte expected = Byte.MAX_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withShortArray()
		{
			short[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Short.MAX_VALUE};
			short result = MathUtils.max(array);
			short expected = Short.MAX_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withIntArray()
		{
			int[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Integer.MIN_VALUE};
			int result = MathUtils.max(array);
			int expected = 8;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withLongArray()
		{
			long[] array = {-9, -8, 4, 5, 7, 2, 8, 3, Long.MAX_VALUE};
			long result = MathUtils.max(array);
			long expected = Long.MAX_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void withFloatArray()
		{
			float[] array = {-9.5F, -8, 4, 5, 7, 2, 8, 32.5F, 3};
			float result = MathUtils.max(array);
			float expected = 32.5F;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result, 0.001F);
		}

		@Test
		void withDoubleArray()
		{
			double[] array = {-9.5D, -8, 4, 5, 7, 2, 8, 37.55D, 3};
			double result = MathUtils.max(array);
			double expected = 37.55D;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(array));

			Assertions.assertEquals(expected, result, 0.001D);
		}
	}

	@Nested
	class Percentage
	{
		@Test
		void withIntValue()
		{
			int result = MathUtils.getPercentage(100, 25);
			int expected = 25;
			Assertions.assertEquals(expected, result);
		}

		@Test
		void withDoubleValue()
		{
			double result = MathUtils.getPercentage(200.00D, 12.5F);
			double expected = 25.00D;
			Assertions.assertEquals(expected, result, 0.01D);
		}
	}
}
