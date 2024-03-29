package org.ajaxer.simple.utils;

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

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Formatter;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class HashUtils
{
	public static final String MD5 = "MD5";
	public static final String SHA_1 = "SHA-1";
	public static final String SHA_224 = "SHA-224";
	public static final String SHA_256 = "SHA-256";
	public static final String SHA_384 = "SHA-384";
	public static final String SHA_512 = "SHA-512";
	public static final String SHA3_224 = "SHA3-224";
	public static final String SHA3_256 = "SHA3-256";
	public static final String SHA3_384 = "SHA3-384";
	public static final String SHA3_512 = "SHA3-512";

	//with password
	public static final String HMAC_SHA1 = "HmacSHA1";
	public static final String HMAC_SHA224 = "HmacSHA224";
	public static final String HMAC_SHA256 = "HmacSHA256";
	public static final String HMAC_SHA384 = "HmacSHA384";
	public static final String HMAC_SHA512 = "HmacSHA512";

	private HashUtils() {}

	private static String toHexString(MessageDigest digest)
	{
		return new BigInteger(1, digest.digest()).toString(16);
	}

	private static String toHexString(byte[] bytes)
	{
		Formatter formatter = new Formatter();

		for (byte b : bytes)
			formatter.format("%02x", b);

		return formatter.toString();
	}

	private static String getHash(String encodeType, InputStream inputStream)
	{
		log.debug("encodeType: {}, inputStream: {}", encodeType, inputStream);
		try
		{
			MessageDigest digest = MessageDigest.getInstance(encodeType);

			byte[] byteArray = new byte[FileUtils.ONE_BYTE];
			int bytesCount;

			while ((bytesCount = inputStream.read(byteArray)) != -1)
				digest.update(byteArray, 0, bytesCount);

			return toHexString(digest);

		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static String getHash(String msg, String hashType)
	{
		log.debug("msg: {}, hashType: {}", msg, hashType);

		ExceptionUtils.throwWhenBlank(msg, "Unable to generate hash of blank message");
		ExceptionUtils.throwWhenBlank(hashType, "Unable to generate hash from blank hash type");

		try
		{
			MessageDigest digest = MessageDigest.getInstance(hashType);

			//Update msg string in message digest
			digest.update(msg.getBytes(), 0, msg.length());

			return toHexString(digest);
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static String getMD5Hash(String msg)
	{
		return getHash(msg, MD5);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA1Hash(String msg)
	{
		return getHash(msg, SHA_1);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA224Hash(String msg)
	{
		return getHash(msg, SHA_224);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA256Hash(String msg)
	{
		return getHash(msg, SHA_256);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA384Hash(String msg)
	{
		return getHash(msg, SHA_384);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA512Hash(String msg)
	{
		return getHash(msg, SHA_512);
	}

	/**
	 * @since v0.0.2
	 */
	public static String getSHA3_224Hash(String msg)
	{
		return getHash(msg, SHA3_224);
	}

	/**
	 * @since v0.0.2
	 */
	public static String getSHA3_256Hash(String msg)
	{
		return getHash(msg, SHA3_256);
	}

	/**
	 * @since v0.0.2
	 */
	public static String getSHA3_384Hash(String msg)
	{
		return getHash(msg, SHA3_384);
	}

	/**
	 * @since v0.0.2
	 */
	public static String getSHA3_512Hash(String msg)
	{
		return getHash(msg, SHA3_512);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getHash(String msg, String key, String hashType)
	{
		log.debug("msg: {}, key: {}, hashType: {}", msg, key, hashType);

		ExceptionUtils.throwWhenBlank(msg, "Unable to generate hash of blank message");
		ExceptionUtils.throwWhenBlank(key, "Unable to generate hash from blank key");
		ExceptionUtils.throwWhenBlank(hashType, "Unable to generate hash from blank hash type");

		try
		{
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), hashType);
			Mac mac = Mac.getInstance(hashType);
			mac.init(signingKey);
			return toHexString(mac.doFinal(msg.getBytes()));
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA1Hash(String msg, String key)
	{
		return getHash(msg, key, HMAC_SHA1);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA224Hash(String msg, String key)
	{
		return getHash(msg, key, HMAC_SHA224);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA256Hash(String msg, String key)
	{
		return getHash(msg, key, HMAC_SHA256);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA384Hash(String msg, String key)
	{
		return getHash(msg, key, HMAC_SHA384);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getSHA512Hash(String msg, String key)
	{
		return getHash(msg, key, HMAC_SHA512);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getHash(File file, String hashType)
	{
		log.debug("hashType: {}, file: {}", hashType, file);

		ExceptionUtils.throwWhenBlank(hashType, "Unable to generate hash from blank hash type");
		ExceptionUtils.throwWhenInvalid(file, "Unable to generate hash of invalid file");

		try (FileInputStream fileInputStream = new FileInputStream(file))
		{
			return getHash(hashType, fileInputStream);
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return null;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static String getMD5Hash(File file)
	{
		return getHash(file, MD5);
	}

	public static String getSHA1Hash(File file)
	{
		return getHash(file, SHA_1);
	}

	public static String getSHA224Hash(File file)
	{
		return getHash(file, SHA_224);
	}

	public static String getSHA256Hash(File file)
	{
		return getHash(file, SHA_256);
	}

	public static String getSHA384Hash(File file)
	{
		return getHash(file, SHA_384);
	}

	public static String getSHA512Hash(File file)
	{
		return getHash(file, SHA_512);
	}
}
