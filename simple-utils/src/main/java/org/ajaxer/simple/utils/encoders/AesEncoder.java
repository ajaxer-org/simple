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

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * Beta version
 *
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class AesEncoder implements Encoder
{
	public static final String ENCRYPTION_NAME = "AES";

	private final String key;
	private static Cipher cipher = null;

	private static byte[] getKeyBytes(String key)
	{
//		StringBuilder keyBuilder = new StringBuilder(key);
//		while (keyBuilder.length() < 16)
//		{
//			keyBuilder.append("0");
//		}
//		key = keyBuilder.toString();

//		if (key.length() > 16)
//		{
//			key = key.substring(0, 15);
//		}
		log.info("key: [{}], len: [{}]", key, key.length());

		return key.getBytes();
	}

	private static SecretKeySpec getSecretKeySpec(String key)
	{
		return new SecretKeySpec(Arrays.copyOf(getKeyBytes(key), 16), ENCRYPTION_NAME);
	}

	public AesEncoder(String key)
	{
		log.info("key: {}", key);
		ExceptionUtils.throwWhenBlank(key);
		this.key = key;
	}

	@Override
	public String encode(final String message)
	{
		if (message == null) return null;

		try
		{
			if (cipher == null)
			{
				cipher = Cipher.getInstance(ENCRYPTION_NAME);
			}

			SecretKey secretKey = getSecretKeySpec(key);

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
		if (message == null) return null;

		try
		{
			if (cipher == null)
			{
				cipher = Cipher.getInstance(ENCRYPTION_NAME);
			}

			SecretKey secretKey = getSecretKeySpec(key);

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] cipherText = cipher.doFinal(message.getBytes());

			return new String(cipherText);
		} catch (Exception exception)
		{
			return ExceptionUtils.rethrow(exception, String.class);
		}
	}
}
