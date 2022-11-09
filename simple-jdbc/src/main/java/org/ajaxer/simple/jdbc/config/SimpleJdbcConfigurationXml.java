package org.ajaxer.simple.jdbc.config;

import org.ajaxer.simple.jdbc.ConnectionManager;
import org.ajaxer.simple.jdbc.SimpleJdbcConfiguration;
import org.ajaxer.simple.jdbc.exception.SimpleJdbcException;

import javax.xml.bind.JAXBContext;
import java.io.File;
import java.net.URL;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public class SimpleJdbcConfigurationXml implements SimpleJdbcConfiguration
{
	private Configuration configuration;

	private void readXmlFile()
	{
		try
		{
			URL url = SimpleJdbcConfiguration.class.getClassLoader().getResource(Constants.FILE_JDBC_XML);

			if (url == null) throw new SimpleJdbcException("File " + Constants.FILE_JDBC_XML + " not found on classpath");

			String path = url.getFile();
			File xmlFile = new File(path);

			JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
			this.configuration = (Configuration) jaxbContext.createUnmarshaller().unmarshal(xmlFile);
		} catch (Exception exception)
		{
			throw new SimpleJdbcException("Configuration failed: " + exception.getMessage(), exception);
		}
	}

	@Override
	public SimpleJdbcConfiguration load()
	{
		readXmlFile();
		return this;
	}

	@Override
	public ConnectionManager getConnectionManager()
	{
		return new ConnectionManagerImpl(this.configuration.getResource());
	}

	@Override
	public ConnectionManager getConnectionManager(String resourceName)
	{
		return new ConnectionManagerImpl(this.configuration.getResource(resourceName));
	}
}
