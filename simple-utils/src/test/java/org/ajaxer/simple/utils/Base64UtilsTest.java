package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;

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
	void beforeAll() throws FileAlreadyExistsException
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

		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.encode(array));
		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.decode(array));
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

		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.encode(text));
		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.decode(text));
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

		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.encode(sourceFile, destinationFile));
		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.decode(sourceFile, destinationFile));
	}

	@Test
	void withFiles() throws FileAlreadyExistsException
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

		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.encode(sourceFile, destinationFile));
		Assertions.assertThrows(BlankPointerException.class, () -> Base64Utils.decode(sourceFile, destinationFile));
	}

	@Test
	void withFileNames() throws FileAlreadyExistsException
	{
		FileUtils.writeFile(sourceFile, "HelloWorld", true);

		String sourceFileName = sourceFile.getAbsolutePath();
		String encodedFileName =encodedFile.getAbsolutePath();
		String decodedFileName = decodedFile.getAbsolutePath();

		Base64Utils.encode(sourceFileName, encodedFileName);
		Base64Utils.decode(encodedFileName, decodedFileName);

		Assertions.assertTrue(FileUtils.equals(sourceFileName, decodedFileName));
	}
}