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
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base64UtilsTest
{
	private File sourceFile;
	private File encodedFile;
	private File decodedFile;

	@BeforeAll
	void beforeAll() throws IOException
	{
		sourceFile = FileUtils.createTempFile();
		encodedFile = FileUtils.createTempFile();
		decodedFile = FileUtils.createTempFile();
	}

	@AfterAll
	void afterAll()
	{
		sourceFile.delete();
		encodedFile.delete();
		decodedFile.delete();
	}

	@Test
	void whenBytesArrayIsBlank()
	{
		byte[] array = {};

		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.encode(array));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.decode(array));
	}

	@Test
	void withBytesArray()
	{
		String text = "AjaxerOrg";
		byte[] array = text.getBytes();
		byte[] encoded = Base64Utils.encode(array);
		byte[] decoded = Base64Utils.decode(encoded);
		String result = new String(decoded);

		Assertions.assertEquals(text, result);
	}

	@Test
	void whenBytesStringIsBlank()
	{
		String text = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.encode(text));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.decode(text));
	}

	@Test
	void withString()
	{
		String text = "AjaxerOrg";
		String encoded = Base64Utils.encode(text);
		String decoded = Base64Utils.decode(encoded);
		String result = new String(decoded);

		Assertions.assertEquals(text, result);
	}

	@Test
	void whenFilesAreBlanks()
	{
		File sourceFile = null;
		File destinationFile = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.encode(sourceFile, destinationFile));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.decode(sourceFile, destinationFile));
	}

	@Test
	void withFiles() throws IOException
	{
		FileUtils.writeFile(sourceFile, "HelloWorld", true);
		Base64Utils.encode(sourceFile, encodedFile);
		Base64Utils.decode(encodedFile, decodedFile);

		Assertions.assertTrue(FileUtils.equals(sourceFile, decodedFile));
	}

	@Test
	void whenFileNamesAreBlanks()
	{
		String sourceFile = null;
		String destinationFile = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.encode(sourceFile, destinationFile));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Base64Utils.decode(sourceFile, destinationFile));
	}

	@Test
	void withFileNames() throws IOException
	{
		FileUtils.writeFile(sourceFile, "HelloWorld", true);

		String sourceFileName = sourceFile.getAbsolutePath();
		String encodedFileName = encodedFile.getAbsolutePath();
		String decodedFileName = decodedFile.getAbsolutePath();

		Base64Utils.encode(sourceFileName, encodedFileName);
		Base64Utils.decode(encodedFileName, decodedFileName);

		Assertions.assertTrue(FileUtils.equals(sourceFileName, decodedFileName));
	}

	@Test
	void encode_from_file() throws IOException
	{
		FileUtils.writeFile(sourceFile, "HelloWorld", false);

		String encodedActual = Base64Utils.encode(sourceFile);
		log.info("encodedActual: {}", encodedActual);

		String encodedExpected = Base64Utils.encode("HelloWorld");
		log.info("encodedExpected: {}", encodedExpected);

		Assertions.assertNotNull(encodedActual);
		Assertions.assertEquals(encodedExpected, encodedActual);
	}

	@Test
	void encode_from_file_negative() throws IOException
	{
		File sourceFile0 = FileUtils.createTempFile();

		String encodedActual = Base64Utils.encode(sourceFile0);
		log.info("encodedActual: {}", encodedActual);

		Assertions.assertNull(encodedActual);
	}
}