package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import org.ajaxer.simple.jdbc.ConnectionManager;
import org.ajaxer.simple.jdbc.DataResource;

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

	public DataResource getDataResource() throws ClassNotFoundException, SQLException
	{
		Class.forName(resource.getDriverName());
		Connection connection = DriverManager.getConnection(resource.getUrl(), resource.getUsername(), resource.getPassword());

		return new MysqlDataResource(connection);
	}
}
