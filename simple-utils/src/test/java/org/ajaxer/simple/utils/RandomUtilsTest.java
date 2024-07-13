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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class RandomUtilsTest
{
	private final int RANDOM_ARRAY_LENGTH = 25;
	private final int REPEATED_TEST_COUNT = 10;

	@Nested
	public class RandomByte
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getByte()
		{
			byte rand = RandomUtils.getByte();
			byte min = Byte.MIN_VALUE;
			byte max = Byte.MAX_VALUE;
			log.debug("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getByte_within_range()
		{
			byte min = RandomUtils.getByte();
			byte max = RandomUtils.getByte();

			if (min > max)
			{
				byte t = min;
				min = max;
				max = t;
			}

			byte rand = RandomUtils.getByte(min, max);
			log.debug("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getByteLessThanOrEqualTo()
		{
			byte limit = 28;
			byte rand = RandomUtils.getByteLessThanOrEqualTo(limit);
			log.debug("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getByteGreaterThanOrEqualTo()
		{
			byte limit = 28;
			byte rand = RandomUtils.getByteGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThanOrEqualTo(limit);
		}
	}

	@Nested
	public class RandomShort
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getShort()
		{
			short rand = RandomUtils.getShort();
			short min = Short.MIN_VALUE;
			short max = Short.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getShort_within_range()
		{
			short min = RandomUtils.getShort();
			short max = RandomUtils.getShort();

			if (min > max)
			{
				short t = min;
				min = max;
				max = t;
			}

			short rand = RandomUtils.getShort(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getShortLessThanOrEqualTo()
		{
			short limit = 2877;
			short rand = RandomUtils.getShortLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getShortGreaterThanOrEqualTo()
		{
			short limit = 2877;
			short rand = RandomUtils.getShortGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThanOrEqualTo(limit);
		}
	}

	@Nested
	public class RandomInt
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getInt()
		{
			int rand = RandomUtils.getInt();
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getInt_within_range()
		{
			int min = RandomUtils.getInt();
			int max = RandomUtils.getInt();

			if (min > max)
			{
				int t = min;
				min = max;
				max = t;
			}

			int rand = RandomUtils.getInt(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getIntLessThanOrEqualTo()
		{
			int limit = 1992877;
			int rand = RandomUtils.getIntLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getIntGreaterThanOrEqualTo()
		{
			int limit = 1992877;
			int rand = RandomUtils.getIntGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThan(limit);
		}
	}

	@Nested
	public class RandomLong
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getLong()
		{
			long rand = RandomUtils.getLong();
			long min = Long.MIN_VALUE;
			long max = Long.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getLong_within_range()
		{
			long min = RandomUtils.getLong();
			long max = RandomUtils.getLong();

			if (min > max)
			{
				long t = min;
				min = max;
				max = t;
			}

			long rand = RandomUtils.getLong(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getLongLessThanOrEqualTo()
		{
			long limit = 34341992877L;
			long rand = RandomUtils.getLongLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getLongGreaterThanOrEqualTo()
		{
			long limit = -34341992877L;
			long rand = RandomUtils.getLongGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThan(limit);
		}
	}

	@Nested
	public class RandomFloat
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getFloat()
		{
			float rand = RandomUtils.getFloat();
			float min = Float.MIN_VALUE;
			float max = Float.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getFloat_within_range()
		{
			float min = RandomUtils.getFloat();
			float max = RandomUtils.getFloat();

			if (min > max)
			{
				float t = min;
				min = max;
				max = t;
			}

			float rand = RandomUtils.getFloat(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getFloatLessThanOrEqualTo()
		{
			float limit = 34341992877.89F;
			float rand = RandomUtils.getFloatLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getFloatGreaterThanOrEqualTo()
		{
			float limit = -34341992877.89F;
			float rand = RandomUtils.getFloatGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThan(limit);
		}
	}

	@Nested
	public class RandomDouble
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getDouble()
		{
			double rand = RandomUtils.getDouble();
			double min = Double.MIN_VALUE;
			double max = Double.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getDouble_within_range()
		{
			double min = RandomUtils.getDouble();
			double max = RandomUtils.getDouble();

			if (min > max)
			{
				double t = min;
				min = max;
				max = t;
			}

			double rand = RandomUtils.getDouble(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getDoubleLessThanOrEqualTo()
		{
			double limit = 34341992877.89D;
			double rand = RandomUtils.getDoubleLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isLessThanOrEqualTo(limit);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getDoubleGreaterThanOrEqualTo()
		{
			double limit = -34341992877.89D;
			double rand = RandomUtils.getDoubleGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			Assertions.assertThat(rand).isGreaterThan(limit);
		}
	}

	@Nested
	public class RandomChar
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getChar()
		{
			char rand = RandomUtils.getChar();
			char min = 'a';
			char max = 'z';
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getChar_within_range_lowercase()
		{
			char min = RandomUtils.getChar();
			char max = RandomUtils.getChar();

			if (min > max)
			{
				char t = min;
				min = max;
				max = t;
			}

			char rand = RandomUtils.getChar(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getChar_within_range_uppercase()
		{
			char min = RandomUtils.getCharUppercase();
			char max = RandomUtils.getCharUppercase();

			if (min > max)
			{
				char t = min;
				min = max;
				max = t;
			}

			char rand = RandomUtils.getChar(min, max);
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void getCharUppercase()
		{
			char rand = RandomUtils.getCharUppercase();
			char min = 'A';
			char max = 'Z';
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			Assertions.assertThat(rand)
			          .isGreaterThanOrEqualTo(min)
			          .isLessThanOrEqualTo(max);
		}
	}

	@Nested
	public class RandomArray
	{
		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfBoolean()
		{
			boolean[] array = RandomUtils.arrayOfBoolean(RANDOM_ARRAY_LENGTH);
			log.info("random array: {}", Arrays.toString(array));
			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				Assertions.assertThat(array[i] || !array[i]).isTrue();
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfChar()
		{
			char[] array = RandomUtils.arrayOfChar(RANDOM_ARRAY_LENGTH);
			char min = 'a';
			char max = 'z';
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				char rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfBytes()
		{
			byte[] array = RandomUtils.arrayOfBytes(RANDOM_ARRAY_LENGTH);
			byte min = Byte.MIN_VALUE;
			byte max = Byte.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				byte rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfShort()
		{
			short[] array = RandomUtils.arrayOfShort(RANDOM_ARRAY_LENGTH);
			short min = Short.MIN_VALUE;
			short max = Short.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				short rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfInt()
		{
			int[] array = RandomUtils.arrayOfInt(RANDOM_ARRAY_LENGTH);
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				int rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfLong()
		{
			long[] array = RandomUtils.arrayOfLong(RANDOM_ARRAY_LENGTH);
			long min = Long.MIN_VALUE;
			long max = Long.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				long rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfFloat()
		{
			float[] array = RandomUtils.arrayOfFloat(RANDOM_ARRAY_LENGTH);
			float min = Float.MIN_VALUE;
			float max = Float.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				float rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}

		@RepeatedTest(REPEATED_TEST_COUNT)
		public void arrayOfDouble()
		{
			double[] array = RandomUtils.arrayOfDouble(RANDOM_ARRAY_LENGTH);
			double min = Double.MIN_VALUE;
			double max = Double.MAX_VALUE;
			log.info("min: {}, max: {}, random array: {}", min, max, Arrays.toString(array));

			for (int i = 0; i < RANDOM_ARRAY_LENGTH; i++)
			{
				double rand = array[i];
				Assertions.assertThat(rand)
				          .isGreaterThanOrEqualTo(min)
				          .isLessThanOrEqualTo(max);
			}
		}
	}

	@Nested
	public class GenerateUniqueCode
	{
		@Test
		void generateUniqueCode()
		{
			List<String> list = new ArrayList<>();

			for (int i = 0; i < 1000; i++)
			{
				String uniqueCode = RandomUtils.generateUniqueCode(6);

				Assertions.assertThat(uniqueCode).isNotNull().hasSize(6);
				Assertions.assertThat(list).doesNotContain(uniqueCode);

				list.add(uniqueCode);
			}
		}
	}

}