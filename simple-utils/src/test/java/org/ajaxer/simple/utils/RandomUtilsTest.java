package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
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
		public void randomByteValueInRange()
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
			System.out.println(String.format("min: %d, max: %d, rand: %d", min, max, rand));

			MatcherAssert.assertThat(rand + "greaterThanOrEqualTo(" + min + ")", rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + "lessThanOrEqualTo(" + max + ")", rand, Matchers.lessThanOrEqualTo(max));
		}
	}

	@Nested
	public class RandomLong
	{
		@RepeatedTest(10)
		public void randomLongValueInRange()
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
			System.out.println(String.format("min: %d, max: %d, rand: %d", min, max, rand));

			MatcherAssert.assertThat(rand + "greaterThanOrEqualTo(" + min + ")", rand, Matchers.greaterThanOrEqualTo(min));
			MatcherAssert.assertThat(rand + "lessThanOrEqualTo(" + max + ")", rand, Matchers.lessThanOrEqualTo(max));
		}
	}
}