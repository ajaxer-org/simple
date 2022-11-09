package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir Ansari
 * @version 2022-11-09
 */
public class SimpleJdbcConfigurationTest
{
	@Test
	void loadTest_WhenFilePresentInClassPath()
	{
		SimpleJdbcConfiguration configuration = new SimpleJdbcConfigurationXml().load();
		Assertions.assertNotNull(configuration);
	}
}