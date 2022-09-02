package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class RandomUtilsTest
{
	@Nested
	public class RandomByte
	{
		@RepeatedTest(10)
		public void getByte()
		{
			byte rand = RandomUtils.getByte();
			byte min = Byte.MIN_VALUE;
			byte max = Byte.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getByteLessThanOrEqualTo()
		{
			byte limit = 28;
			byte rand = RandomUtils.getByteLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getByteGreaterThanOrEqualTo()
		{
			byte limit = 28;
			byte rand = RandomUtils.getByteGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}

	@Nested
	public class RandomShort
	{
		@RepeatedTest(10)
		public void getShort()
		{
			short rand = RandomUtils.getShort();
			short min = Short.MIN_VALUE;
			short max = Short.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getShortLessThanOrEqualTo()
		{
			short limit = 2877;
			short rand = RandomUtils.getShortLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getShortGreaterThanOrEqualTo()
		{
			short limit = 2877;
			short rand = RandomUtils.getShortGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}

	@Nested
	public class RandomInt
	{
		@RepeatedTest(10)
		public void getInt()
		{
			int rand = RandomUtils.getInt();
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getIntLessThanOrEqualTo()
		{
			int limit = 1992877;
			int rand = RandomUtils.getIntLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getIntGreaterThanOrEqualTo()
		{
			int limit = 1992877;
			int rand = RandomUtils.getIntGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}

	@Nested
	public class RandomLong
	{
		@RepeatedTest(10)
		public void getLong()
		{
			long rand = RandomUtils.getLong();
			long min = Long.MIN_VALUE;
			long max = Long.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getLongLessThanOrEqualTo()
		{
			long limit = 34341992877L;
			long rand = RandomUtils.getLongLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getLongGreaterThanOrEqualTo()
		{
			long limit = -34341992877L;
			long rand = RandomUtils.getLongGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}

	@Nested
	public class RandomFloat
	{
		@RepeatedTest(10)
		public void getFloat()
		{
			float rand = RandomUtils.getFloat();
			float min = Float.MIN_VALUE;
			float max = Float.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getFloatLessThanOrEqualTo()
		{
			float limit = 34341992877.89F;
			float rand = RandomUtils.getFloatLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getFloatGreaterThanOrEqualTo()
		{
			float limit = -34341992877.89F;
			float rand = RandomUtils.getFloatGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}

	@Nested
	public class RandomDouble
	{
		@RepeatedTest(10)
		public void getDouble()
		{
			double rand = RandomUtils.getDouble();
			double min = Double.MIN_VALUE;
			double max = Double.MAX_VALUE;
			log.info("min: {}, max: {}, rand: {}", min, max, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
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

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + min, rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + max, rand, Matchers.lessThanOrEqualTo(max));
		}

		@RepeatedTest(10)
		public void getDoubleLessThanOrEqualTo()
		{
			double limit = 34341992877.89D;
			double rand = RandomUtils.getDoubleLessThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " lessThanOrEqualTo " + limit, rand, Matchers.lessThanOrEqualTo(limit));
		}

		@RepeatedTest(10)
		public void getDoubleGreaterThanOrEqualTo()
		{
			double limit = -34341992877.89D;
			double rand = RandomUtils.getDoubleGreaterThanOrEqualTo(limit);
			log.info("limit: {}, rand: {}", limit, rand);

			MatcherAssert.assertThat(rand + " greaterThanOrEqualTo " + limit, rand, Matchers.greaterThanOrEqualTo(limit));
		}
	}
}