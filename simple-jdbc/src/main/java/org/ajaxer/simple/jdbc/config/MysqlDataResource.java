package org.ajaxer.simple.jdbc.config;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.jdbc.DataResource;
import org.ajaxer.simple.jdbc.Persistence;
import org.ajaxer.simple.jdbc.config.dto.ResourceMetaData;
import org.ajaxer.simple.jdbc.exception.SimpleJdbcException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Shakir
 * @version 2022-11-09
 */
@Log4j2
public class MysqlDataResource implements DataResource
{
	private final Connection connection;
	private final Persistence persistence;

	public MysqlDataResource(Connection connection)
	{
		this.connection = connection;
		this.persistence = new MysqlPersistence();
	}

	@Override
	public ResourceMetaData getResourceMetaData()
	{
		try
		{
			return new ResourceMetaData(connection.getMetaData());
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to get database metaData", sqlException);
		}
	}

	@Override
	public void startTransaction()
	{
		try
		{
			log.debug("starting transaction");
			this.connection.setAutoCommit(false);
			log.debug("transaction started");
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to start transaction", sqlException);
		}
	}

	@Override
	public void commitTransaction()
	{
		try
		{
			log.debug("committing transaction");
			this.connection.commit();
			log.debug("transaction committed");
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to commit transaction", sqlException);
		}
	}

	@Override
	public void rollbackTransaction()
	{
		try
		{
			log.debug("rolling back transaction");
			this.connection.rollback();
			log.debug("transaction rolled back");
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to rollback transaction", sqlException);
		}
	}

	@Override
	public void close()
	{
		try
		{
			log.debug("closing collection");
			this.connection.close();
			log.debug("collection closed");
		} catch (SQLException sqlException)
		{
			throw new SimpleJdbcException("Unable to close connection", sqlException);
		}
	}

	@Override
	public <T> T persist(T t)
	{
		return this.persistence.persist(t);
	}
}
