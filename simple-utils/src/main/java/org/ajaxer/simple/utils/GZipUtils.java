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

	private GZipUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static long zip(FileInputStream fileInputStream, GZIPOutputStream gZIPOutputStream) throws IOException
	{
		return FileUtils.copy(fileInputStream, gZIPOutputStream);
	}

	/**
	 * @since v0.0.1
	 */
	public static long unzip(GZIPInputStream gZIPInputStream, FileOutputStream fileOutputStream) throws IOException
	{
		return FileUtils.copy(gZIPInputStream, fileOutputStream);
	}

	/**
	 * @since v0.0.1
	 */
	public static long zip(File source, File target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);

		ExceptionUtils.throwWhenInvalid(source, "invalid source file");
		ExceptionUtils.throwWhenInvalid(target, "invalid target file");

		try (FileInputStream fileInputStream = new FileInputStream(source);
			 GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(Files.newOutputStream(target.toPath())))
		{
			return zip(fileInputStream, gZIPOutputStream);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static long zip(String source, String target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);

		ExceptionUtils.throwWhenInvalid(source, "invalid source file");
		ExceptionUtils.throwWhenInvalid(target, "invalid target file");

		return zip(new File(source), new File(target));
	}

	/**
	 * @since v0.0.1
	 */
	public static File zip(File source) throws IOException
	{
		log.debug("source: {}", source);
		ExceptionUtils.throwWhenInvalid(source);

		return new File(zip(source.getAbsolutePath()));
	}

	/**
	 * @since v0.0.1
	 */
	public static String zip(String source) throws IOException
	{
		log.debug("source: {}", source);
		ExceptionUtils.throwWhenBlank(source);

		String target = getTargetFileName(source);
		log.debug("target: {}", target);
		ExceptionUtils.throwWhenBlank(target);

		if (!new File(target).exists())
		{
			boolean created = new File(target).createNewFile();
			log.info("target file created=[{}] as - {}", created, target);
		}

		zip(source, target);

		return target;
	}

	/**
	 * @since v0.0.1
	 */
	public static long unzip(File source, File target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);

		ExceptionUtils.throwWhenInvalid(source, "invalid source file");
		ExceptionUtils.throwWhenInvalid(target, "invalid target file");

		try (GZIPInputStream gZIPInputStream = new GZIPInputStream(Files.newInputStream(source.toPath()));
			 FileOutputStream fileOutputStream = new FileOutputStream(target))
		{
			return unzip(gZIPInputStream, fileOutputStream);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static long unzip(String source, String target) throws IOException
	{
		log.debug("source: {}, target: {}", source, target);

		ExceptionUtils.throwWhenInvalid(source, "invalid source file");
		ExceptionUtils.throwWhenInvalid(target, "invalid target file");

		return unzip(new File(source), new File(target));
	}

	/**
	 * @since v0.0.1
	 */
	public static File unzip(File source) throws IOException
	{
		log.debug("source: {}", source);
		ExceptionUtils.throwWhenInvalid(source);

		return new File(unzip(source.getAbsolutePath()));
	}

	/**
	 * @since v0.0.1
	 */
	public static String unzip(String source) throws IOException
	{
		log.debug("source: {}", source);
		ExceptionUtils.throwWhenBlank(source);

		String target = getSourceFileName(source);
		log.debug("target: {}", target);
		ExceptionUtils.throwWhenBlank(target);

		if (!new File(target).exists())
		{
			boolean created = new File(target).createNewFile();
			log.info("target file created=[{}] as - {}", created, target);
		}

		unzip(source, target);

		return target;
	}

	/**
	 * @since v0.0.1
	 */
	private static String getTargetFileName(String source)
	{
		log.debug("source: {}", source);
		String targetFileName = source + EXTENSION;
		log.debug("targetFileName: {}", targetFileName);

		return targetFileName;
	}

	/**
	 * @since v0.0.1
	 */
	private static String getSourceFileName(String target)
	{
		log.debug("target: {}", target);
		if (!target.endsWith(EXTENSION))
		{
			throw new IllegalArgumentException("Given target file is not " + EXTENSION + " file");
		}

		String sourceFileName = StringUtils.removeSuffix(target, EXTENSION);
		log.debug("sourceFileName: {}", sourceFileName);

		return sourceFileName;
	}
}
