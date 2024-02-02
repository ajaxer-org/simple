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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-08-28
 * @since v0.0.1
 */
@Log4j2
public class ConsoleUtilsTest
{
	@Test
	@Disabled
	void singleInput()
	{
		try (ConsoleUtils consoleUtils = new ConsoleUtils())
		{
			System.out.println("Please enter a string");
			String input = consoleUtils.readString();
			System.out.println("your input was: [" + input + "]");
		}
	}

	@Test
	@Disabled
	void multipleInputs_withSameTryBlock()
	{
		try (ConsoleUtils consoleUtils = new ConsoleUtils())
		{
			System.out.println("Please enter a string");
			String input = consoleUtils.readString();
			System.out.println("your input was: [" + input + "]");

			System.out.println("Please enter a int");
			int i0 = consoleUtils.readInt();
			System.out.println("your input was: [" + i0 + "]");
		}
	}

	@Test
	@Disabled
	void multipleInputs_withMultipleTryBlock()
	{
		try (ConsoleUtils consoleUtils = new ConsoleUtils())
		{
			System.out.println("Please enter a string");
			String input = consoleUtils.readString();
			System.out.println("your input was: [" + input + "]");
		}

		try (ConsoleUtils consoleUtils = new ConsoleUtils())
		{
			System.out.println("Please enter a int");
			int i0 = consoleUtils.readInt();
			System.out.println("your input was: [" + i0 + "]");
		}
	}

	public static void main(String[] args)
	{
		ConsoleUtilsTest test = new ConsoleUtilsTest();
		test.singleInput();
		test.multipleInputs_withSameTryBlock();
		test.multipleInputs_withMultipleTryBlock();
	}
}