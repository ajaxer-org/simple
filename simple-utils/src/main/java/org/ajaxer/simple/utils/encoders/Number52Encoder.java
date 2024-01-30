package org.ajaxer.simple.utils.encoders;

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

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.ExceptionUtils;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class Number52Encoder implements Encoder<String, String>, Decoder<String, String>
{
	private final String numberScale;

	public Number52Encoder()
	{
		numberScale = initNumberScale();
		log.info("numberScale: {}", numberScale);
	}

	private String initNumberScale()
	{
		StringBuilder _numberScale = new StringBuilder();

		/*
		 * ASCII
		 * A-Z = 65...90
		 * a-z = 97...122
		 * 0-9 = 48...57
		 */
		for (int i = 0; i < 26; i++)
		{
			_numberScale.append((char) ((int) 'A' + i));
		}
		for (int i = 0; i < 10; i++)
		{
			_numberScale.append(i);
		}
		for (int i = 0; i < 26; i++)
		{
			_numberScale.append((char) ((int) 'a' + i));
		}
		return _numberScale.toString();
	}

	public String convert(int x)
	{
		if (x == 0)
			return String.valueOf(numberScale.charAt(0));

		StringBuilder num52 = new StringBuilder();

		while (x > 0)
		{
			int temp = x % numberScale.length();
			num52.insert(0, numberScale.charAt(temp));
			x /= numberScale.length();
		}
		return num52.toString();
	}

	public int convert(String s)
	{
		int val = 0;
		for (int i = 0; i < s.length(); i++)
		{
			int d = numberScale.indexOf(s.charAt(i));
			ExceptionUtils.throwWhenEquals(d, -1, INVALID_ENCRYPTION_FORMAT);

			val = numberScale.length() * val + d;
		}
		return val;
	}

	@Override
	public String encode(String message)
	{
		if (message == null || message.isEmpty())
			return null;

		int length = message.length();
		StringBuilder encoded = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			int ch = message.charAt(i);
			int first = ch % 10;
			int second = ch / 10;
			encoded.append(first).append(convert(second));
		}

		return encoded.toString();
	}

	@Override
	public String decode(String message)
	{
		if (message == null || message.isEmpty())
			return null;

		String pattern = "^[0-9a-zA-Z]*$";
		ExceptionUtils.throwWhenFalse(message.matches(pattern), INVALID_ENCRYPTION_FORMAT);

		/*
		 * ASCII
		 * A-Z = 65...90
		 * a-z = 97...122
		 * 0-9 = 48...57
		 */
		StringBuilder decoded = new StringBuilder();
		int length = message.length();
		for (int i = 0; i < length; i++)
		{
			char ch = message.charAt(i);

			if (ch >= '0' && ch <= '9')
			{
				int nextI = i;
				char nextChar = message.charAt(nextI++);
				while ((nextChar >= 'a' && nextChar <= 'z')
				       || (nextChar >= 'A' && nextChar <= 'Z'))
				{
					nextChar = message.charAt(nextI++);
				}

				StringBuilder temp = new StringBuilder();
				while (nextI > i && nextI < length)
				{
					temp.append(message.charAt(nextI));
					nextI--;
				}
				decoded.append((char) ((convert(temp.toString()) * 10) + (ch - 48)));
			}
		}

		return decoded.toString();
	}
}
