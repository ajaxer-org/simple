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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

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
	void beforeAll() throws IOException
	{
		propertyUtils = new AppPropertyUtils("app.properties");
	}

	@AfterAll
	void afterAll()
	{
		SimpleUtils.close(propertyUtils);
	}

	@Test
	public void getKeyWhenKeyIsBlank()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> propertyUtils.getKey(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> propertyUtils.getKey(""));
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