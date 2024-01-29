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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Shakir
 * @version 2022-08-28
 * @since v0.0.1
 */
@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsoleUtilsTest
{
	private ConsoleUtils consoleUtils;

	@BeforeAll
	void beforeAll()
	{
		consoleUtils = new ConsoleUtils();
	}

	@AfterAll
	void afterAll()
	{
		SimpleUtils.close(consoleUtils);
	}
}