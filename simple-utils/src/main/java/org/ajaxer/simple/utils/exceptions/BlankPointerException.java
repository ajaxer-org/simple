package org.ajaxer.simple.utils.exceptions;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
@SuppressWarnings("unused")
public class BlankPointerException extends SimpleException
{
	public BlankPointerException()
	{
		super();
	}

	public BlankPointerException(String message)
	{
		super(message);
	}

	public BlankPointerException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public BlankPointerException(Throwable cause)
	{
		super(cause);
	}

	protected BlankPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
