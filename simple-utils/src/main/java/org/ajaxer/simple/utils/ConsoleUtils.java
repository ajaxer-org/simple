package org.ajaxer.simple.utils;

/*
 * Copyright (c) 2024 ajaxer.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
