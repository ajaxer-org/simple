package org.ajaxer.simple.jdbc;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.ajaxer.simple.jdbc.config.dto.ResourceMetaData;
import org.ajaxer.simple.jdbc.exception.ResourceNotDefineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir Ansari
 * @version 2022-11-09
 */
@Log4j2
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
		ConnectionManager connectionManager = new SimpleJdbcConfigurationXml().load()
				.getConnectionManager("mysql");

		Assertions.assertNotNull(connectionManager);

		try (DataResource dataResource = connectionManager.getDataResource())
		{
			ResourceMetaData resourceMetaData = dataResource.getResourceMetaData();
			log.info("resourceMetaData: {}", resourceMetaData);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	void test_named_unknown_resource()
	{
		Assertions.assertThrows(ResourceNotDefineException.class, () -> {
			new SimpleJdbcConfigurationXml().load().getConnectionManager("UNKNOWN_SOURCE");
		});
	}
}