package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.ajaxer.simple.jdbc.exception.ResourceNotDefineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

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
	void test_named_resource() throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager = new SimpleJdbcConfigurationXml().load().getConnectionManager("mysql");
		Assertions.assertNotNull(connectionManager);

		try (DataResource dataResource = connectionManager.getDataResource())
		{
			DatabaseMetaData databaseMetaData = dataResource.getDatabaseMetaData();

			System.out.println("driverName:	" + databaseMetaData.getDriverName());
			System.out.println("driverVersion: " + databaseMetaData.getDriverVersion());
			System.out.println("productVersion: " + databaseMetaData.getDatabaseProductName());
			System.out.println("productVersion: " + databaseMetaData.getDatabaseProductVersion());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	void test_named_unknown_resource()
	{
		Assertions.assertThrows(
				ResourceNotDefineException.class,
				() -> new SimpleJdbcConfigurationXml().load().getConnectionManager("UNKNOWN_SOURCE"));
	}
}