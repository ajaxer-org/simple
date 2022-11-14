package org.ajaxer.simple.jdbc;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.jdbc.config.SimpleJdbcConfigurationXml;
import org.ajaxer.simple.jdbc.config.dto.ResourceMetaData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir Ansari
 * @version 2022-11-14
 */
@Log4j2
public class TransactionalTest
{
	@Test
	void test_named_resource()
	{
		ConnectionManager connectionManager = new SimpleJdbcConfigurationXml().load().getConnectionManager();

		Assertions.assertNotNull(connectionManager);

		try (DataResource dataResource = connectionManager.getDataResource())
		{
			dataResource.startTransaction();
			ResourceMetaData resourceMetaData = dataResource.getResourceMetaData();
			log.info("resourceMetaData: {}", resourceMetaData);
			dataResource.commitTransaction();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}