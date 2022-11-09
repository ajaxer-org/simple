package org.ajaxer.simple.jdbc.exception;

/**
 * @author Shakir
 * @version 2022-11-09
 */
public class ResourceNotDefineException extends SimpleJdbcException
{
	public ResourceNotDefineException()
	{
		super();
	}

	public ResourceNotDefineException(String message)
	{
		super(message);
	}

	public ResourceNotDefineException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ResourceNotDefineException(Throwable cause)
	{
		super(cause);
	}

	protected ResourceNotDefineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
