package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.StringUtils;

import java.util.Arrays;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class BinaryEncoder implements Encoder
{
	public String convert(int x)
	{
		return Integer.toBinaryString(x);
	}

	public int convert(String string)
	{
		return Integer.parseInt(string, 2);
	}

	@Override
	public String encode(String message)
	{
		StringUtils.throwWhenBlank(message);

		String encoded = "";

		for (int i = 0; i < message.length(); i++)
		{
			encoded += (i % 2 == 0) ? "2" : "3";
			encoded += convert(message.charAt(i));
		}

		return encoded;
	}

	@Override
	public String decode(String message)
	{
		StringUtils.throwWhenBlank(message);

		String pattern = "^[0-3]*$";
		if (!message.matches(pattern))
		{
			throw new IllegalArgumentException("Invalid number format");
		}

		//splitting with two delimiters [2 or 3]
		String[] charInt = message.split("[23]");
		log.debug(Arrays.toString(charInt));

		String decoded = "";

		//i starting from 1, bc charInt[]'s first value will be empty
		for (int i = 1; i < charInt.length; i++)
		{
			decoded += (char) convert(charInt[i]);
		}

		return StringUtils.isBlank(decoded) ? null : decoded;
	}
}
