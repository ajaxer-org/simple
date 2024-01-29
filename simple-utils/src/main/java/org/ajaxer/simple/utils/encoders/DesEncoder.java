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

import org.ajaxer.simple.utils.ExceptionUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
public class DesEncoder implements Encoder
{
	public static final String ENCRYPTION_NAME = "DES";
	private static KeyGenerator keygenerator;
	private static SecretKey secretKey;
	private static Cipher cipher;

	private static void init() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		if (keygenerator == null)
		{
			keygenerator = KeyGenerator.getInstance(ENCRYPTION_NAME);
		}

		if (secretKey == null)
		{
			secretKey = keygenerator.generateKey();
		}

		if (cipher == null)
		{
			cipher = Cipher.getInstance(ENCRYPTION_NAME);
		}
	}

	@Override
	public String encode(final String message)
	{
		if (message == null || message.isEmpty()) return null;

		try
		{
			init();

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			byte[] cipherText = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

			return Base64.getEncoder().encodeToString(cipherText);

		} catch (Exception exception)
		{
			return ExceptionUtils.rethrow(exception, String.class);
		}
	}

	@Override
	public String decode(final String message)
	{
		if (message == null || message.isEmpty()) return null;

		try
		{
			init();

			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] cipherBytes = cipher.doFinal(Base64.getDecoder().decode(message));

			return new String(cipherBytes);

		} catch (Exception exception)
		{
			return ExceptionUtils.rethrow(exception, String.class);
		}
	}
}
