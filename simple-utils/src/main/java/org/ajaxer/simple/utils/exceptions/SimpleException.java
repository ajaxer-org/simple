package org.ajaxer.simple.utils.exceptions;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
public class SimpleException extends RuntimeException
{
	public SimpleException()
	{
		super();
	}

	public SimpleException(String message)
	{
		super(message);
	}

	public SimpleException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SimpleException(Throwable cause)
	{
		super(cause);
	}

	protected SimpleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
