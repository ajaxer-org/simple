package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class GZipUtils
{
	private final static String EXTENSION = ".gz";

	/**
	 * @since v0.0.1
	 */
	public static boolean zip(FileInputStream fileInputStream, GZIPOutputStream gZIPOutputStream) throws IOException
	{
		FileUtils.copy(fileInputStream, gZIPOutputStream);
		return true;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean unzip(GZIPInputStream gZIPInputStream, FileOutputStream fileOutputStream) throws IOException
	{
		FileUtils.copy(gZIPInputStream, fileOutputStream);
		return true;
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean zip(File sourceFile, File targetFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		log.debug("targetFile: {}", targetFile);

		try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
			 GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(Files.newOutputStream(targetFile.toPath())))
		{
			return zip(fileInputStream, gZIPOutputStream);
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return false;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean zip(File sourceFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		return zip(sourceFile.getAbsolutePath());
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean zip(String sourceFile, String targetFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		log.debug("targetFile: {}", targetFile);

		return zip(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean zip(String sourceFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		return zip(sourceFile, getTargetFileName(sourceFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean unzip(File sourceFile, File targetFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		log.debug("targetFile: {}", targetFile);

		try (GZIPInputStream gZIPInputStream = new GZIPInputStream(Files.newInputStream(sourceFile.toPath()));
			 FileOutputStream fileOutputStream = new FileOutputStream(targetFile))
		{
			return unzip(gZIPInputStream, fileOutputStream);
		} catch (Exception exception)
		{
			ExceptionUtils.rethrow(exception);
			return false;
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean unzip(File sourceFile)
	{
		log.debug("sourceFile: {}", sourceFile);

		return unzip(sourceFile.getAbsolutePath());
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean unzip(String sourceFile, String targetFile)
	{
		log.debug("sourceFile: {}", sourceFile);
		log.debug("targetFile: {}", targetFile);

		return unzip(new File(sourceFile), new File(targetFile));
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean unzip(String sourceFile)
	{
		log.debug("sourceFile: {}", sourceFile);

		return unzip(sourceFile, getSourceFileName(sourceFile));
	}

	/**
	 * @since v0.0.1
	 */
	private static String getTargetFileName(String sourceFileName)
	{
		log.debug("sourceFileName: {}", sourceFileName);
		String targetFileName = sourceFileName + EXTENSION;
		log.debug("targetFileName: {}", targetFileName);

		return targetFileName;
	}

	/**
	 * @since v0.0.1
	 */
	private static String getSourceFileName(String targetFileName)
	{
		log.debug("targetFileName: {}", targetFileName);
		if (!targetFileName.endsWith(EXTENSION))
		{
			throw new IllegalArgumentException("Given target file is not " + EXTENSION + " file");
		}

		String sourceFileName = StringUtils.removeSuffix(targetFileName, EXTENSION);
		log.debug("sourceFileName: {}", sourceFileName);

		return sourceFileName;
	}
}
