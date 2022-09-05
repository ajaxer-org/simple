package org.ajaxer.simple.utils;

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

			Assertions.assertEquals(end - start, 2000L, delta);
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
			SimpleUtils.sleep(700L);
			long end = System.currentTimeMillis();

			Assertions.assertEquals(end - start, 700L, delta);
		}
	}

}