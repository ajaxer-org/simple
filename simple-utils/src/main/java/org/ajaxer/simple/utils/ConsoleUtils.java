package org.ajaxer.simple.utils;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
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
	private String readConsoleLine() throws IOException
	{
		return bufferedReader.readLine();
	}

	/**
	 * @since v0.0.1
	 */
	public String readPassword() throws IOException
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
	public String readString() throws IOException
	{
		return readConsoleLine();
	}

	/**
	 * @since v0.0.1
	 */
	public int readInt() throws IOException
	{
		return Integer.parseInt(this.readConsoleLine());
	}

	/**
	 * @since v0.0.1
	 */
	public float readFloat() throws IOException
	{
		return Float.parseFloat(this.readConsoleLine());
	}

	/**
	 * @since v0.0.1
	 */
	public double readDouble() throws IOException
	{
		return Double.parseDouble(this.readConsoleLine());
	}

	/**
	 * @since v0.0.1
	 */
	public boolean readBoolean() throws IOException
	{
		return Boolean.parseBoolean(this.readConsoleLine());
	}

	/**
	 * @since v0.0.1
	 */
		@Override
	public void close() throws Exception
	{
		if (this.autoClose)
		{
			SimpleUtils.close(inputStream);

			SimpleUtils.close(bufferedReader);
		}
	}
}
