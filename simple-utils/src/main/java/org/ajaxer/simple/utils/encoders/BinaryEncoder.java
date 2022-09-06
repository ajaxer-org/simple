package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.ExceptionUtils;
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
		if (message == null || message.isEmpty()) return null;

		StringBuilder encoded = new StringBuilder();
		for (int i = 0; i < message.length(); i++)
		{
			encoded.append((i % 2 == 0) ? "2" : "3");
			encoded.append(convert(message.charAt(i)));
		}

		return encoded.toString();
	}

	@Override
	public String decode(String message)
	{
		if (message == null || message.isEmpty()) return null;

		String pattern = "^[0-3]*$";
		ExceptionUtils.throwWhenFalse(message.matches(pattern), INVALID_ENCRYPTION_FORMAT);

		//splitting with two delimiters [2 or 3]
		String[] charInt = message.split("[23]");
		log.debug(Arrays.toString(charInt));

		StringBuilder decoded = new StringBuilder();

		//loop should start from 1, bc charInt[]'s first value will be empty
		for (int i = 1; i < charInt.length; i++)
		{
			decoded.append((char) convert(charInt[i]));
		}

		return StringUtils.isBlank(decoded.toString()) ? null : decoded.toString();
	}
}
