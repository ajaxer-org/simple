package org.ajaxer.simple.utils.encoders;

import org.ajaxer.simple.utils.ExceptionUtils;
import org.ajaxer.simple.utils.ValidationUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public class AesEncoder implements Encoder
{
	public static final String ENCRYPTION_NAME = "AES";

	private final String key;
	private static Cipher cipher = null;

	private static byte[] getKeyBytes(String key)
	{
		ExceptionUtils.throwWhenBlank(key, "Key cannot be null");

		StringBuilder keyBuilder = new StringBuilder(key);
		while (keyBuilder.length() < 16)
		{
			keyBuilder.append("0");
		}
		key = keyBuilder.toString();

		ValidationUtils.throwWhenTrue(key.length() != 16, "Secret key should must be 16 char long only");

//		if (key.length() > 16)
//		{
//			key = key.substring(0, 15);
//		}
//		System.out.println("AesEncryptor.checkKey() - key: [" + key + "], len: [" + key.length() + "]");

		return Base64.getDecoder().decode(key);
	}

	private static SecretKeySpec getSecretKeySpec(String key)
	{
		return new SecretKeySpec(Arrays.copyOf(getKeyBytes(key), 16), ENCRYPTION_NAME);
	}

	public AesEncoder(String key)
	{
		this.key = key;
	}

	@Override
	public String encode(final String message)
	{
		ExceptionUtils.throwWhenBlank(message);

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
			ExceptionUtils.rethrow(exception);
			return null;
		}

	}

	@Override
	public String decode(final String message)
	{
		ExceptionUtils.throwWhenBlank(message);

		try
		{
			if (cipher == null)
			{
				cipher = Cipher.getInstance(ENCRYPTION_NAME);
			}

			SecretKey secretKey = getSecretKeySpec(key);

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(message));

			return new String(cipherText);
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}
}
