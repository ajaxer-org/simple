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
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
public class SimpleUtilsTest
{
	@Nested
	class Close
	{
		@Test
		void close_with_null()
		{
			Assertions.assertFalse(SimpleUtils.close(null));
		}

		@Test
		void close_with_already_closed()
		{
			InputStream inputStream = SimpleUtils.class.getClassLoader().getResourceAsStream("file-utils-test-data.txt");
			try
			{
				//noinspection ConstantConditions
				inputStream.close();
			} catch (IOException e)
			{
				log.error("Unable to close inputStream", e);
			}

			Assertions.assertTrue(SimpleUtils.close(inputStream));
		}

		@Test
		void close_with_open_stream()
		{
			InputStream inputStream = SimpleUtils.class.getClassLoader().getResourceAsStream("file-utils-test-data.txt");
			Assertions.assertTrue(SimpleUtils.close(inputStream));
		}
	}

	@Nested
	class Sleep
	{
		//buffer gap of 30 milliseconds
		long delta = 20L;

		@Test
		void sleep_default()
		{
			long start = System.currentTimeMillis();
			SimpleUtils.sleep();
			long end = System.currentTimeMillis();

			org.assertj.core.api.Assertions
					.assertThat(end - start)
					.isGreaterThanOrEqualTo(2000L);
		}

		@RepeatedTest(5)
		void sleep_with_zero_interval()
		{
			long start = System.currentTimeMillis();
			SimpleUtils.sleep(0L);
			long end = System.currentTimeMillis();

			Assertions.assertEquals(end - start, 0L, delta);
		}

		@RepeatedTest(5)
		void sleep_with_negative_interval()
		{
			long start = System.currentTimeMillis();
			SimpleUtils.sleep(-200L);
			long end = System.currentTimeMillis();

			Assertions.assertEquals(end - start, 0L, delta);
		}

		@RepeatedTest(5)
		void sleep_with_custom_interval()
		{
			long start = System.currentTimeMillis();
			SimpleUtils.sleep(333L);
			long end = System.currentTimeMillis();

			org.assertj.core.api.Assertions
					.assertThat(end - start)
					.isGreaterThanOrEqualTo(333L);
		}
	}

}