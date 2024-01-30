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
import org.ajaxer.simple.utils.StringUtils;

import java.util.Arrays;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class BinaryEncoder implements Encoder<String, String>, Decoder<String, String>
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
		if (message == null || message.isEmpty())
			return null;

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
		if (message == null || message.isEmpty())
			return null;

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
