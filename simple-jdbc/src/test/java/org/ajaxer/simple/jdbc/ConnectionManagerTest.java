package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.ajaxer.simple.jdbc.exception.ResourceNotDefineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir Ansari
 * @version 2022-11-09
 */
public class ConnectionManagerTest
{
	@Test
	void test_default()
	{
		Assertions.assertNotNull(new SimpleJdbcConfigurationXml().load().getConnectionManager());
	}

	@Test
	void test_named_resource()
	{
		ConnectionManager connectionManager = new SimpleJdbcConfigurationXml().load().getConnectionManager("mysql");
		Assertions.assertNotNull(connectionManager);
	}

	@Test
	void test_named_unknown_resource()
	{
		Assertions.assertThrows(
				ResourceNotDefineException.class,
				() -> new SimpleJdbcConfigurationXml().load().getConnectionManager("UNKNOWN_SOURCE"));
	}
}