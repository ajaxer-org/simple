package org.ajaxer.simple.jdbc;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public interface SimpleJdbcConfiguration
{
	public SimpleJdbcConfiguration load();

	public ConnectionManager getConnectionManager();

	public ConnectionManager getConnectionManager(String resourceName);
}
