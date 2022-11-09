package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.exception.SimpleJdbcException;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public abstract class DataResource implements AutoCloseable
{
	private Connection connection;

	public DataResource(Connection connection)
	{
		this.connection = connection;
	}

	public DatabaseMetaData getDatabaseMetaData()
	{
		try
		{
			return connection.getMetaData();
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to get database metaData", sqlException);
		}
	}

	public void startTransaction()
	{
		try
		{
			this.connection.setAutoCommit(false);
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to start transaction", sqlException);
		}
	}

	public void commitTransaction()
	{
		try
		{
			this.connection.commit();
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to commit transaction", sqlException);
		}
	}

	@Override
	public void close()
	{
		try
		{
			this.connection.close();
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to close connection", sqlException);
		}
	}
}
