package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.DataResource;

import java.sql.SQLException;

/**
 * @author Shakir
 * @version 2022-10-27
 * @since v0.0.3
 */
public interface ConnectionManager
{
	public DataResource getDataResource() throws ClassNotFoundException, SQLException;
}