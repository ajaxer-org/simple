package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import org.ajaxer.simple.jdbc.ConnectionManager;
import org.ajaxer.simple.jdbc.DataResource;
import org.ajaxer.simple.jdbc.config.xml.Resource;
import org.ajaxer.simple.jdbc.exception.SimpleJdbcException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public class ConnectionManagerImpl implements ConnectionManager
{
	@Getter
	private final Resource resource;

	public ConnectionManagerImpl(Resource resource)
	{
		this.resource = resource;
	}

	public DataResource getDataResource()
	{
		try
		{
			Class.forName(resource.getDriverName());
		} catch (ClassNotFoundException classNotFoundException)
		{
			throw new SimpleJdbcException("Unable find driver class", classNotFoundException);
		}

		try
		{
			Connection connection = DriverManager.getConnection(resource.getUrl(), resource.getUsername(), resource.getPassword());
			return new MysqlDataResource(connection);
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("sqlException", sqlException);
		}
	}
}
