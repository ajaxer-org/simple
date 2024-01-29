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
	byte[] byteArray = {-9, -8, 4, 5, 7, 2, 8, 3, Byte.MAX_VALUE};
	short[] shortArray = {-9, -8, 4, 5, 7, 2, 8, 3, Short.MAX_VALUE};
	int[] intArray = {-9, -8, 4, 5, 7, 2, 8, 3, Integer.MIN_VALUE};
	long[] longArray = {-9L, -8L, 4L, 5L, 7L, 2L, 8L, 3L, Long.MIN_VALUE, 45678900L};
	float[] floatArray = {-9.5F, -8F, 4.44F, 5F, 7F, 2F, 8F, 32.5f, 3F};
	double[] doubleArray = {-9.5D, -8D, 4.567D, 5.90D, 7.12D, 2.98D, 8.2341D, 32.5D, 3.22D};

	@Nested
	class MinTests
	{
		@Test
		void min_withByteArray()
		{
			byte result = MathUtils.min(byteArray);
			byte expected = -9;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(byteArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void min_withShortArray()
		{
			short result = MathUtils.min(shortArray);
			short expected = -9;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(shortArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void min_withIntArray()
		{
			int result = MathUtils.min(intArray);
			int expected = Integer.MIN_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(intArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void min_withLongArray()
		{
			long result = MathUtils.min(longArray);
			long expected = Long.MIN_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(longArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void min_withFloatArray()
		{
			float result = MathUtils.min(floatArray);
			float expected = -9.5F;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(floatArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void min_withDoubleArray()
		{
			double result = MathUtils.min(doubleArray);
			double expected = -9.5D;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(doubleArray));

			Assertions.assertEquals(expected, result);
		}
	}

	@Nested
	class MaxTests
	{
		@Test
		void max_withByteArray()
		{
			byte result = MathUtils.max(byteArray);
			byte expected = Byte.MAX_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(byteArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void max_withShortArray()
		{
			short result = MathUtils.max(shortArray);
			short expected = Short.MAX_VALUE;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(shortArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void max_withIntArray()
		{
			int result = MathUtils.max(intArray);
			int expected = 8;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(intArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void max_withLongArray()
		{
			long result = MathUtils.max(longArray);
			long expected = 45678900L;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(longArray));

			Assertions.assertEquals(expected, result);
		}

		@Test
		void max_withFloatArray()
		{
			float result = MathUtils.max(floatArray);
			float expected = 32.5F;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(floatArray));

			Assertions.assertEquals(expected, result, 0.001F);
		}

		@Test
		void max_withDoubleArray()
		{
			double result = MathUtils.max(doubleArray);
			double expected = 32.5D;
			log.info("expected: {}, result: {}, array: {}", expected, result, Arrays.toString(doubleArray));

			Assertions.assertEquals(expected, result, 0.001D);
		}
	}

	@Nested
	class Percentage
	{
		@Test
		void getPercentage_withIntValue()
		{
			int result = MathUtils.getPercentage(100, 25);
			int expected = 25;
			Assertions.assertEquals(expected, result);
		}

		@Test
		void getPercentage_withFloatValue()
		{
			double result = MathUtils.getPercentage(200.00F, 12.5F);
			double expected = 25.00F;
			Assertions.assertEquals(expected, result, 0.01F);
		}

		@Test
		void getPercentage_withDoubleValue()
		{
			double result = MathUtils.getPercentage(200.00D, 12.5D);
			double expected = 25.00D;
			Assertions.assertEquals(expected, result, 0.01D);
		}
	}

	@Nested
	class EqualsToAny
	{
		@Test
		void equalsToAny_byte_array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(byteArray, (byte) 5));
			Assertions.assertFalse(MathUtils.equalsToAny(byteArray, (byte) 55));
		}

		@Test
		void equalsToAny_short_array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(shortArray, (short) 5));
			Assertions.assertFalse(MathUtils.equalsToAny(shortArray, (short) 55));
		}

		@Test
		void equalsToAny_int_array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(intArray, 5));
			Assertions.assertFalse(MathUtils.equalsToAny(intArray, 55));
		}

		@Test
		void equalsToAny_long_array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(longArray, -9L));
			Assertions.assertFalse(MathUtils.equalsToAny(longArray, 5509234L));
		}

		@Test
		void equalsToAny_float_array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(floatArray, 4.44F));
			Assertions.assertFalse(MathUtils.equalsToAny(floatArray, 55.90F));
		}

		@Test
		void equalsToAny__array()
		{
			Assertions.assertTrue(MathUtils.equalsToAny(doubleArray, 5.90D));
			Assertions.assertFalse(MathUtils.equalsToAny(doubleArray, 55345234.656D));
		}
	}
}
