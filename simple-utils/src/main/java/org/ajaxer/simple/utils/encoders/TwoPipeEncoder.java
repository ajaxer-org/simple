package org.ajaxer.simple.utils.encoders;

import org.ajaxer.simple.utils.ExceptionUtils;
import org.ajaxer.simple.utils.StringUtils;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
public class TwoPipeEncoder implements Encoder
{
	public static final String EXTENSION = ".tp";

	@Override
	public String encode(String message)
	{
		if (message == null || message.isEmpty()) return null;

		StringBuilder firstHalf = new StringBuilder();
		StringBuilder secondHalf = new StringBuilder();
		for (int i = 0; i < message.length(); i++)
		{
			if (i % 2 == 0)
			{
				//-- 0,2,4,6.....
				firstHalf.append(message.charAt(i));
			} else
			{
				//-- 1,3,5,7.....
				secondHalf.append(message.charAt(i));
			}
		}
		return firstHalf + secondHalf.toString() + EXTENSION;
	}

	@Override
	public String decode(String message)
	{
		if (message == null || message.isEmpty()) return null;

		ExceptionUtils.throwWhenFalse(message.endsWith(EXTENSION), INVALID_ENCRYPTION_FORMAT);

		// removing extension
		message = StringUtils.removeSuffix(message, EXTENSION);

		// new length
		int len = message.length();
		int point = (len + 1) / 2;

		String firstHalf = message.substring(0, point);
		String secondHalf = message.substring(point);

		StringBuilder deMsg = new StringBuilder();
		int lenF = firstHalf.length();
		int lenH = secondHalf.length();
		for (int i = 0; i < lenF || i < lenH; i++)
		{
			if (i < lenF)
			{
				deMsg.append(firstHalf.charAt(i));
			}
			if (i < lenH)
			{
				deMsg.append(secondHalf.charAt(i));
			}
		}

		return deMsg.toString();
	}
}
