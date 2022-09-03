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
public class HexaEncoder implements Encoder
{
	private final String digits = "0123456789ABCDEF";

	public String convert(int x)
	{
		//return Integer.toHexString(x);
		if (x == 0)
		{
			return "0";
		}
		StringBuilder hex = new StringBuilder();
		while (x > 0)
		{
			int digit = x % 16;                // rightmost digit
			hex.insert(0, digits.charAt(digit));  // string concatenation
			x = x / 16;
		}
		return hex.toString();
	}

	public int convert(String s)
	{
		//return Integer.parseInt(string, 16);

		s = s.toUpperCase();

		int val = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	@Override
	public String encode(String message)
	{
		ExceptionUtils.throwWhenBlank(message);

		StringBuilder encoded = new StringBuilder();

		for (int i = 0; i < message.length(); i++)
		{
			encoded.append(i % 2 == 0 ? "g" : "h");
			encoded.append(convert(message.charAt(i)));
		}

		return encoded.toString();
	}

	@Override
	public String decode(String message)
	{
		ExceptionUtils.throwWhenBlank(message);

		String messageLowerCase = message.toLowerCase();

		String pattern = "^[0-9a-h]*$";
		if (!messageLowerCase.matches(pattern))
		{
			throw new IllegalArgumentException("Invalid number format");
		}

		//splitting with two delimiters [g or h]
		String[] charInt = messageLowerCase.split("[gh]");
		log.debug(Arrays.toString(charInt));

		StringBuilder decoded = new StringBuilder();

		//loop must start from 1, because charInt[]'s first value will be empty
		for (int i = 1; i < charInt.length; i++)
		{
			decoded.append((char) convert(charInt[i]));
		}

		return StringUtils.isBlank(decoded.toString()) ? null : decoded.toString();
	}
}
