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
		return Base64.getEncoder().encode(bytes);
	}

	/**
	 * @since v0.0.1
	 */
	public static byte[] decode(byte[] bytes)
	{
		return Base64.getDecoder().decode(bytes);
	}

	/**
	 * @since v0.0.1
	 */
	public static String encode(String text)
	{
		return new String(encode(text.getBytes()));
	}

	/**
	 * @since v0.0.1
	 */
	public static String decode(String text)
	{
		return new String(decode(text.getBytes()));
	}

	/**
	 * @since v0.0.1
	 */
	public static void encode(String sourceFile, String targetFile)
	{
		encode(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static void decode(String sourceFile, String targetFile)
	{
		decode(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static void encode(File sourceFile, File targetFile)
	{
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
