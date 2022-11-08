package org.ajaxer.simple.jdbc;

import java.sql.Connection;

/**
 * @author Shakir
 * @version 2022-10-27
 * @since v0.0.3
 */
public class ConnectionManagerFactory
{
	/**
	 * Will always open a new jdbc connection
	 *
	 * @return Connection
	 *
	 * @since 0.0.3
	 */
	public Connection openConnection()
	{
		return null;
	}

	/**
	 * Will provide a connection from pool
	 * <p>property enable_pool should be true</p>
	 *
	 * @return Connection
	 *
	 * @since 0.0.3
	 */
	public Connection getConnection()
	{
		return null;
	}
}
