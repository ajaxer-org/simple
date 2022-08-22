package org.ajaxer.simple.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class ExceptionUtils
{
	/**
	 * @since v0.0.1
	 */
	public static void rethrow(Throwable throwable)
	{
		if (throwable == null)
		{
			throw new NullPointerException();
		}

		if (throwable instanceof RuntimeException)
		{
			throw (RuntimeException) throwable;
		}

		if (throwable instanceof Error)
		{
			throw (Error) throwable;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable, String packageFilter)
	{
		if (throwable == null)
		{
			return null;
		}

		List<String> traces = new ArrayList<>();

		if (ValidationUtils.isNotBlank(throwable.getMessage()))
		{
			traces.add(throwable.getMessage());
		}

		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		if (ValidationUtils.isNotBlank(stackTraceElements))
		{
			for (StackTraceElement stackTraceElement : stackTraceElements)
			{
				if (ValidationUtils.isBlank(packageFilter))
				{
					traces.add(stackTraceElement.toString());
				} else
				{
					if (stackTraceElement.toString().startsWith(packageFilter))
					{
						traces.add(stackTraceElement.toString());
					}
				}
			}
		}

		return traces;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable)
	{
		return getStackTraces(throwable, null);
	}
}
