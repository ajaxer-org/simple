package org.ajaxer.simple.utils;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public class ConsoleUtils implements AutoCloseable
{
	private final InputStream inputStream;

	private final BufferedReader bufferedReader;

	private boolean autoClose = true;

	/**
	 * @since v0.0.1
	 */
	public ConsoleUtils()
	{
		inputStream = System.in;
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	}

	/**
	 * @since v0.0.1
	 */
	public ConsoleUtils(InputStream inputStream)
	{
		this.autoClose = false;
		this.inputStream = inputStream;
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	}

	/**
	 * @since v0.0.1
	 */
	private String readConsoleLine()
	{
		try
		{
			return bufferedReader.readLine();
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public String readPassword()
	{
		String pass = null;

		Console console = System.console();
		if (console != null)
		{
			pass = new String(console.readPassword());
		} else
		{
			pass = readConsoleLine();
		}

		return pass;
	}

	/**
	 * @since v0.0.1
	 */
	public String readString()
	{
		return readConsoleLine();
	}

	/**
	 * @since v0.0.1
	 */
	public int readInt()
	{
		return NumberUtils.toInt(this.readString());
	}

	/**
	 * @since v0.0.1
	 */
	public long readLong()
	{
		return NumberUtils.toLong(this.readString());
	}

	/**
	 * @since v0.0.1
	 */
	public float readFloat()
	{
		return NumberUtils.toFloat(this.readString());
	}

	/**
	 * @since v0.0.1
	 */
	public double readDouble()
	{
		return NumberUtils.toDouble(this.readString());
	}

	/**
	 * @since v0.0.1
	 */
	public boolean readBoolean()
	{
		return Boolean.parseBoolean(this.readConsoleLine());
	}

	/**
	 * @since v0.0.1
	 */
	@Override
	public void close()
	{
		if (this.autoClose)
		{
			SimpleUtils.close(inputStream);

			SimpleUtils.close(bufferedReader);
		}
	}
}
