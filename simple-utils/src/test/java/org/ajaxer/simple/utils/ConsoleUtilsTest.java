package org.ajaxer.simple.utils;

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