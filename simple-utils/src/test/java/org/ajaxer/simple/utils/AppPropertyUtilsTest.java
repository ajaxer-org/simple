package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppPropertyUtilsTest
{
	private AppPropertyUtils propertyUtils;

	@BeforeAll
	void beforeAll()
	{
		try
		{
			propertyUtils = new AppPropertyUtils("app.properties");
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
		}
	}

	@AfterAll
	void afterAll()
	{
		SimpleUtils.close(propertyUtils);
	}

	@Test
	public void getKeyWhenKeyIsBlank()
	{
		Assertions.assertThrows(NullPointerException.class, () -> propertyUtils.getKey(null));
		Assertions.assertThrows(NullPointerException.class, () -> propertyUtils.getKey(""));
	}

	@Test
	public void getKey()
	{
		String value = propertyUtils.getKey("foo");
		String expected = "bar";

		Assertions.assertEquals(expected, value);
	}

	@Test
	public void getInt()
	{
		int value = propertyUtils.getInt("number");
		log.info("value: {}", value);
		int expected = 123;

		Assertions.assertEquals(expected, value);
	}

	@Test
	public void getIntWithDefaultValues()
	{
		int value = propertyUtils.getInt("KEY_DOES_NOT_EXISTS", 9);
		log.info("value: {}", value);
		int expected = 9;

		Assertions.assertEquals(expected, value);
	}

	@Test
	public void setKey()
	{
		propertyUtils.setKey("foo1", "bar1");
		String value = propertyUtils.getKey("foo1");
		String expected = "bar1";

		Assertions.assertEquals(expected, value);

	}

	@Test
	public void containKey()
	{
		Assertions.assertEquals(true, propertyUtils.containKey("number"));
		Assertions.assertEquals(false, propertyUtils.containKey("KEY_DOES_NOT_EXISTS"));
	}

	@Test
	public void containsValue()
	{
		Assertions.assertEquals(true, propertyUtils.containsValue("123"));
		Assertions.assertEquals(false, propertyUtils.containsValue("VALUE_DOES_NOT_EXISTS"));
	}

}