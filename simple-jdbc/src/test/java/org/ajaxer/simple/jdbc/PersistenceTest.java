package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.ajaxer.simple.jdbc.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Shakir Ansari
 * @version 2022-11-14
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersistenceTest
{
	ConnectionManager connectionManager;

	@BeforeAll
	void beforeAll()
	{
		connectionManager = new SimpleJdbcConfigurationXml().load().getConnectionManager();
	}

	@Test
	void insert() throws Exception
	{
		try (DataResource dataResource = connectionManager.getDataResource();)
		{
			User user = new User(1L, "Hello");

			dataResource.startTransaction();

			User a = dataResource.persist(user);

			dataResource.commitTransaction();
		}
	}
}