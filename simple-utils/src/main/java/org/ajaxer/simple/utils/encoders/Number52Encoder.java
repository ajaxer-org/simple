package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.StringUtils;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class Number52Encoder implements Encoder
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
		{
			return String.valueOf(numberScale.charAt(0));
		}

		StringBuilder num52 = new StringBuilder();
		int temp;

		while (x > 0)
		{
			temp = x % numberScale.length();
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
			if (d == -1)
			{
				throw new IllegalArgumentException("Invalid number format");
			}
			val = numberScale.length() * val + d;
		}
		return val;
	}

	@Override
	public String encode(String message)
	{
		StringUtils.throwWhenBlank(message);

		int ch;
		int length = message.length();

		StringBuilder encoded = new StringBuilder();

		for (int i = 0; i < length; i++)
		{
			ch = message.charAt(i);
			int first = ch % 10;
			int second = ch / 10;
			encoded.append(first).append(convert(second));
		}

		return encoded.toString();
	}

	@Override
	public String decode(String message)
	{
		StringUtils.throwWhenBlank(message);

		String pattern = "^[0-9a-zA-Z]*$";
		if (!message.matches(pattern))
		{
			throw new IllegalArgumentException(INVALID_ENCRYPTION_FORMAT);
		}

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
