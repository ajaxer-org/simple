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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Shakir
 * @version 2022-08-31
 * @since v0.0.1
 */
@Log4j2
public class GZipUtilsTest
{
	private File validFile;
	private File invalidFile1, invalidFile2;
	private File tempFile1, tempFile2;
	private String tempPath1, tempPath2;

	@BeforeEach
	void beforeEach() throws IOException
	{
		validFile = new File(FileUtilsTest.class.getClassLoader().getResource("file-utils-test-data.txt").getFile());
		invalidFile1 = new File("NOT-EXIST", "invalid-file-1.txt");
		invalidFile2 = new File("NOT-EXIST", "invalid-file-2.txt");
		tempFile1 = FileUtils.createTempFile();
		tempFile2 = FileUtils.createTempFile();
		tempPath1 = tempFile1.getAbsolutePath();
		tempPath2 = tempFile2.getAbsolutePath();
	}

	@AfterEach
	void afterEach()
	{
		log.debug("tempFile1 delete response: {}, for file: {}", tempFile1.delete(), tempFile1.getAbsolutePath());
		log.debug("tempFile2 delete response: {}, for file: {}", tempFile2.delete(), tempFile2.getAbsolutePath());
	}

	@Nested
	class SourceTarget
	{
		@Test
		void zip_unzip_with_null_file()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.zip((File) null, (File) null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.unzip((File) null, (File) null));
		}

		@Test
		void zip_unzip_with_null_path()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.zip((String) null, (String) null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.unzip((String) null, (String) null));
		}

		@Test
		void zip_unzip_with_file() throws IOException
		{
			long zipBytes = GZipUtils.zip(validFile, tempFile1);
			long unzipBytes = GZipUtils.unzip(tempFile1, tempFile2);
			log.info("zipBytes: {}, unzipBytes: {}", zipBytes, unzipBytes);

			Assertions.assertTrue(FileUtils.equals(validFile, tempFile2));
		}

		@Test
		void zip_unzip_with_path() throws IOException
		{
			long zipBytes = GZipUtils.zip(validFile.getAbsolutePath(), tempPath1);
			long unzipBytes = GZipUtils.unzip(tempPath1, tempPath2);
			log.info("zipBytes: {}, unzipBytes: {}", zipBytes, unzipBytes);

			Assertions.assertTrue(FileUtils.equals(validFile.getAbsolutePath(), tempPath2));
		}
	}

	@Nested
	class SourceOrTargetOnly
	{
		@Test
		void zip_unzip_with_null_file()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.zip((File) null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.unzip((File) null));
		}

		@Test
		void zip_unzip_with_null_path()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.zip((String) null));
			Assertions.assertThrows(IllegalArgumentException.class, () -> GZipUtils.unzip((String) null));
		}

		@Test
		void zip_unzip_with_file() throws IOException
		{
			FileUtils.copy(validFile, tempFile1);

			File zipFile = GZipUtils.zip(tempFile1);
			File unzipFile = GZipUtils.unzip(zipFile);

			log.info("zipFile: {}, unzipFile: {}", zipFile, unzipFile);

			Assertions.assertTrue(FileUtils.equals(validFile, unzipFile));
			zipFile.delete();
			unzipFile.delete();
		}

		@Test
		void zip_unzip_with_path() throws IOException
		{
			FileUtils.copy(validFile.getAbsolutePath(), tempPath1);

			String zipPath = GZipUtils.zip(tempPath1);
			String unzipPath = GZipUtils.unzip(zipPath);

			log.info("zipPath: {}, unzipPath: {}", zipPath, unzipPath);

			Assertions.assertTrue(FileUtils.equals(validFile.getAbsolutePath(), unzipPath));
			new File(zipPath).delete();
			new File((unzipPath)).delete();
		}
	}
}