package org.ajaxer.simple.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public class Base64Utils
{
	/**
	 * @since v0.0.1
	 */
	public static byte[] encode(byte[] bytes)
	{
		ArrayUtils.throwWhenBlank(bytes, "blank bytes cannot be encoded");
		return Base64.getEncoder().encode(bytes);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte[] decode(byte[] bytes)
	{
		ArrayUtils.throwWhenBlank(bytes, "blank bytes cannot be decoded");
		return Base64.getDecoder().decode(bytes);
	}

	/**
	 * @since v0.0.1
	 */
	public static String encode(String text)
	{
		StringUtils.throwWhenBlank(text, "null String cannot be encoded");
		return new String(encode(text.getBytes()));
	}

	/**
	 * @since v0.0.1
	 */
	public static String decode(String text)
	{
		StringUtils.throwWhenBlank(text, "null String cannot be decoded");
		return new String(decode(text.getBytes()));
	}

	/**
	 * @since v0.0.1
	 */
	public static void encode(String sourceFile, String targetFile)
	{
		StringUtils.throwWhenBlank(sourceFile, "sourceFile cannot be blank");
		StringUtils.throwWhenBlank(targetFile, "targetFile cannot be blank");

		encode(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static void decode(String sourceFile, String targetFile)
	{
		StringUtils.throwWhenBlank(sourceFile, "sourceFile cannot be blank");
		StringUtils.throwWhenBlank(targetFile, "targetFile cannot be blank");

		decode(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static void encode(File sourceFile, File targetFile)
	{
		SimpleUtils.throwWhenNull(sourceFile, "sourceFile cannot be null");
		SimpleUtils.throwWhenNull(targetFile, "targetFile cannot be null");

		try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
			 FileOutputStream fileOutputStream = new FileOutputStream(targetFile))
		{
			final byte[] byteArray = new byte[(int) sourceFile.length()];
			fileInputStream.read(byteArray);
			String file64 = Base64.getEncoder().encodeToString(byteArray);
			fileOutputStream.write(file64.getBytes());
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static void decode(File sourceFile, File targetFile)
	{
		SimpleUtils.throwWhenNull(sourceFile, "sourceFile cannot be null");
		SimpleUtils.throwWhenNull(targetFile, "targetFile cannot be null");

		try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
			 FileOutputStream fileOutputStream = new FileOutputStream(targetFile))
		{
			final byte[] byteArray = new byte[(int) sourceFile.length()];
			fileInputStream.read(byteArray);
			fileOutputStream.write(Base64.getDecoder().decode(new String(byteArray)));
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
		}
	}
}
