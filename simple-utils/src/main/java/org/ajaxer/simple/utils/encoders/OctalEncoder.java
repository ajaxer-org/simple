package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.ExceptionUtils;
import org.ajaxer.simple.utils.StringUtils;

import java.util.Arrays;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class OctalEncoder implements Encoder
{
	public String convert(int x)
	{
		return Integer.toOctalString(x);
	}

	public int convert(String string)
	{
		return Integer.parseInt(string, 8);
	}

	@Override
	public String encode(String message)
	{
		ExceptionUtils.throwWhenBlank(message);

		StringBuilder encoded = new StringBuilder();

		for (int i = 0; i < message.length(); i++)
		{
			encoded.append((i % 2 == 0) ? "8" : "9");
			encoded.append(convert(message.charAt(i)));
		}

		return encoded.toString();
	}

	@Override
	public String decode(String message)
	{
		ExceptionUtils.throwWhenBlank(message);

		String pattern = "^[0-9]*$";
		if (!message.matches(pattern))
		{
			throw new IllegalArgumentException("Invalid number format");
		}

		//splitting with two delimiters [8 or 9]
		String[] charInt = message.split("[89]");
		log.debug(Arrays.toString(charInt));

		StringBuilder decoded = new StringBuilder();

		//loop must start 1, bc charInt[]'s first value will be empty
		for (int i = 1; i < charInt.length; i++)
		{
			decoded.append((char) convert(charInt[i]));
		}

		return StringUtils.isBlank(decoded.toString()) ? null : decoded.toString();
	}
}
