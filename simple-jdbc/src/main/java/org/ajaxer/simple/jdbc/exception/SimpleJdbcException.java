package org.ajaxer.simple.jdbc.exception;

import org.ajaxer.simple.utils.exceptions.SimpleException;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public class SimpleJdbcException extends SimpleException
{
	public SimpleJdbcException()
	{
		super();
	}

	public SimpleJdbcException(String message)
	{
		super(message);
	}

	public SimpleJdbcException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SimpleJdbcException(Throwable cause)
	{
		super(cause);
	}

	protected SimpleJdbcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
