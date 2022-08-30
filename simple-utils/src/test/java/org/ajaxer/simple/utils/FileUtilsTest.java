package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.dtos.SerializedObject;
import org.ajaxer.simple.utils.dtos.UserDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-30
 * @since v0.0.1
 */
@Log4j2
public class FileUtilsTest
{
	private File validFile;
	private File invalidFile;
	private File tempFile;
	private String tempPath;

	@BeforeEach
	void beforeEach() throws IOException
	{
		validFile = new File(FileUtilsTest.class.getClassLoader().getResource("file-utils-test-data.txt").getFile());
		invalidFile = new File("NOT-EXIST", "invalid-file-utils-test-data.txt");
		tempFile = FileUtils.createTempFile();
		tempPath = tempFile.getAbsolutePath();
	}

	@AfterEach
	void afterEach()
	{
		tempFile.delete();
	}

	@Nested
	class ReadLines
	{
		@Test
		void when_file_null()
		{
			File file = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readLines(file));
		}

		@Test
		void with_valid_file() throws IOException
		{
			List<String> lines = FileUtils.readLines(validFile);
			Assertions.assertEquals(5, lines.size());
		}

		@Test
		void with_invalid_file()
		{
			Assertions.assertThrows(FileNotFoundException.class, () -> FileUtils.readLines(invalidFile));
		}

		@Test
		void when_path_null()
		{
			String path = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readLines(path));
		}

		@Test
		void with_valid_path() throws IOException
		{
			List<String> lines = FileUtils.readLines(validFile.getAbsolutePath());
			Assertions.assertEquals(5, lines.size());
		}

		@Test
		void with_invalid_path()
		{
			Assertions.assertThrows(FileNotFoundException.class, () -> FileUtils.readLines(invalidFile.getAbsolutePath()));
		}
	}

	@Nested
	class ReadFile
	{
		@Test
		void with_invalid_file()
		{
			Assertions.assertThrows(FileNotFoundException.class, () -> FileUtils.readFile(invalidFile));
		}

		@Test
		void with_valid_file() throws IOException
		{
			String content = FileUtils.readFile(validFile);
			Assertions.assertTrue(content.contains("hello world"));
		}

		@Test
		void with_invalid_path()
		{
			Assertions.assertThrows(FileNotFoundException.class, () -> FileUtils.readFile(invalidFile.getAbsolutePath()));
		}

		@Test
		void with_valid_path() throws IOException
		{
			String content = FileUtils.readFile(validFile.getAbsolutePath());
			Assertions.assertTrue(content.contains("hello world"));
		}
	}

	@Nested
	class WriteFile
	{
		@Test
		void with_null_file()
		{
			File nullFile = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeFile(nullFile, "msg", true));
		}

		@Test
		void with_valid_file() throws IOException
		{
			FileUtils.writeFile(tempFile, "hello-world", false);
			String content = FileUtils.readFile(tempFile);
			Assertions.assertTrue(content.equals("hello-world"));
		}

		@Test
		void with_valid_file_append_false() throws IOException
		{
			FileUtils.writeFile(tempFile, "hello-world", false);
			FileUtils.writeFile(tempFile, System.lineSeparator(), false);
			FileUtils.writeFile(tempFile, "hello-world", false);
			FileUtils.writeFile(tempFile, System.lineSeparator(), false);
			FileUtils.writeFile(tempFile, "hello-world", false);

			List<String> lines = FileUtils.readLines(tempFile);
			String content = FileUtils.readFile(tempFile);

			Assertions.assertTrue(content.equals("hello-world"));
			Assertions.assertEquals(1, lines.size());
		}

		@Test
		void with_valid_file_append_true() throws IOException
		{
			FileUtils.writeFile(tempFile, "hello-world", true);
			FileUtils.writeFile(tempFile, System.lineSeparator(), true);
			FileUtils.writeFile(tempFile, "hello-world", true);
			FileUtils.writeFile(tempFile, System.lineSeparator(), true);
			FileUtils.writeFile(tempFile, "hello-world", true);

			List<String> lines = FileUtils.readLines(tempFile);
			String content = FileUtils.readFile(tempFile);

			Assertions.assertFalse(content.equals("hello-world"));
			Assertions.assertTrue(content.contains("hello-world"));
			Assertions.assertEquals(3, lines.size());
		}

		@Test
		void with_valid_file_append_default() throws IOException
		{
			FileUtils.writeFile(tempFile, "hello-world");
			FileUtils.writeFile(tempFile, System.lineSeparator());
			FileUtils.writeFile(tempFile, "hello-world");
			FileUtils.writeFile(tempFile, System.lineSeparator());
			FileUtils.writeFile(tempFile, "hello-world");

			List<String> lines = FileUtils.readLines(tempFile);
			String content = FileUtils.readFile(tempFile);

			Assertions.assertFalse(content.equals("hello-world"));
			Assertions.assertTrue(content.contains("hello-world"));
			Assertions.assertEquals(3, lines.size());
		}

		@Test
		void with_null_path()
		{
			String nullPath = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeFile(nullPath, "msg", true));
		}

		@Test
		void with_valid_path_append_false() throws IOException
		{
			FileUtils.writeFile(tempPath, "hello-world", false);
			FileUtils.writeFile(tempPath, System.lineSeparator(), false);
			FileUtils.writeFile(tempPath, "hello-world", false);
			FileUtils.writeFile(tempPath, System.lineSeparator(), false);
			FileUtils.writeFile(tempPath, "hello-world", false);

			List<String> lines = FileUtils.readLines(tempPath);
			String content = FileUtils.readFile(tempPath);

			Assertions.assertTrue(content.equals("hello-world"));
			Assertions.assertEquals(1, lines.size());
		}

		@Test
		void with_valid_path_append_true() throws IOException
		{
			FileUtils.writeFile(tempPath, "hello-world", true);
			FileUtils.writeFile(tempPath, System.lineSeparator(), true);
			FileUtils.writeFile(tempPath, "hello-world", true);
			FileUtils.writeFile(tempPath, System.lineSeparator(), true);
			FileUtils.writeFile(tempPath, "hello-world", true);

			List<String> lines = FileUtils.readLines(tempPath);
			String content = FileUtils.readFile(tempPath);

			Assertions.assertFalse(content.equals("hello-world"));
			Assertions.assertTrue(content.contains("hello-world"));
			Assertions.assertEquals(3, lines.size());
		}

		@Test
		void with_valid_path_append_default() throws IOException
		{
			FileUtils.writeFile(tempPath, "hello-world");
			FileUtils.writeFile(tempPath, System.lineSeparator());
			FileUtils.writeFile(tempPath, "hello-world");
			FileUtils.writeFile(tempPath, System.lineSeparator());
			FileUtils.writeFile(tempPath, "hello-world");

			List<String> lines = FileUtils.readLines(tempPath);
			String content = FileUtils.readFile(tempPath);

			Assertions.assertFalse(content.equals("hello-world"));
			Assertions.assertTrue(content.contains("hello-world"));
			Assertions.assertEquals(3, lines.size());
		}

	}

	@Nested
	class SerializedObjects
	{
		@Test
		void read_with_null_file()
		{
			File nullFile = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readSerializedObject(nullFile, SerializedObject.class));
		}

		@Test
		void read_with_null_path()
		{
			String nullPath = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readSerializedObject(nullPath, SerializedObject.class));
		}

		@Test
		void write_with_null_file_and_null_object()
		{
			File nullFile = null;
			SerializedObject serializedObject = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeSerializedObject(nullFile, serializedObject));
		}

		@Test
		void write_with_null_path_and_null_object()
		{
			String nullPath = null;
			SerializedObject serializedObject = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeSerializedObject(nullPath, serializedObject));
		}

		@Test
		void read_write_with_valid_file_and_valid_data() throws IOException
		{
			SerializedObject serializedObject = new SerializedObject("value1", "value2");
			FileUtils.writeSerializedObject(tempFile, serializedObject);

			SerializedObject result = FileUtils.readSerializedObject(tempFile, SerializedObject.class);
			System.out.println(result.toString());
			Assertions.assertEquals(serializedObject, result);
		}

		@Test
		void read_write_with_valid_path_and_valid_data() throws IOException
		{
			SerializedObject serializedObject = new SerializedObject("value1", "value2");
			FileUtils.writeSerializedObject(tempFile, serializedObject);

			SerializedObject result = FileUtils.readSerializedObject(tempPath, SerializedObject.class);
			System.out.println(result.toString());
			Assertions.assertEquals(serializedObject, result);
		}
	}

	@Nested
	class XMLObjects
	{
		@Test
		void read_with_null_file()
		{
			File nullFile = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readXmlObject(nullFile, UserDto.class));
		}

		@Test
		void read_with_null_path()
		{
			String nullPath = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readXmlObject(nullPath, UserDto.class));
		}

		@Test
		void write_with_null_file_and_null_object()
		{
			File nullFile = null;
			UserDto userDto = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeXmlObject(nullFile, userDto));
		}

		@Test
		void write_with_null_path_and_null_object()
		{
			String nullPath = null;
			UserDto userDto = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeXmlObject(nullPath, userDto));
		}

		@Test
		void read_write_with_valid_file_and_valid_data() throws IOException
		{
			UserDto userDto = new UserDto("user", "user@ajaxer.org", "123-456-7890");
			FileUtils.writeXmlObject(tempFile, userDto);

			UserDto result = FileUtils.readXmlObject(tempFile, UserDto.class);
			System.out.println(result.toString());
			Assertions.assertEquals(userDto, result);
		}

		@Test
		void read_write_with_valid_path_and_valid_data() throws IOException
		{
			UserDto userDto = new UserDto("user", "user@ajaxer.org", "123-456-7890");
			FileUtils.writeXmlObject(tempFile, userDto);

			UserDto result = FileUtils.readXmlObject(tempPath, UserDto.class);
			System.out.println(result.toString());
			Assertions.assertEquals(userDto, result);
		}
	}

	@Nested
	class JsonObjects
	{
		@Test
		void read_with_null_file()
		{
			File nullFile = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readJsonObject(nullFile, UserDto.class));
		}

		@Test
		void read_with_null_path()
		{
			String nullPath = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.readJsonObject(nullPath, UserDto.class));
		}

		@Test
		void write_with_null_file_and_null_object()
		{
			File nullFile = null;
			UserDto userDto = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeJsonObject(nullFile, userDto));
		}

		@Test
		void write_with_null_path_and_null_object()
		{
			String nullPath = null;
			UserDto userDto = null;
			Assertions.assertThrows(IllegalArgumentException.class, () -> FileUtils.writeJsonObject(nullPath, userDto));
		}

		@Test
		void read_write_with_valid_file_and_valid_data() throws IOException
		{
			UserDto userDto = new UserDto("user", "user@ajaxer.org", "123-456-7890");
			FileUtils.writeJsonObject(tempFile, userDto);

			UserDto result = FileUtils.readJsonObject(tempFile, UserDto.class);
			System.out.println(result.toString());
			Assertions.assertEquals(userDto, result);
		}

		@Test
		void read_write_with_valid_path_and_valid_data() throws IOException
		{
			UserDto userDto = new UserDto("user", "user@ajaxer.org", "123-456-7890");
			FileUtils.writeJsonObject(tempFile, userDto);

			UserDto result = FileUtils.readJsonObject(tempPath, UserDto.class);
			System.out.println(result.toString());
			Assertions.assertEquals(userDto, result);
		}
	}

	@Nested
	class TempFile
	{
		@RepeatedTest(10)
		void random_name() throws Exception
		{
			File file = FileUtils.createTempFile();
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());
			file.delete();
		}

		@RepeatedTest(10)
		void random_name_with_prefix_suffix() throws Exception
		{
			File file = FileUtils.createTempFile("ajaxer-", ".txt");
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());
			file.delete();
		}

		@Test
		void fix_name() throws Exception
		{
			File file = FileUtils.createTempFile("ajaxer");
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());
			file.delete();
		}

		@Test
		void fix_name_with_prefix_suffix() throws Exception
		{
			File file = FileUtils.createTempFile("ajaxer-", "dummy-file", ".txt");
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());
			file.delete();
		}

		@Test
		void fix_name_already_exists() throws Exception
		{
			File file = FileUtils.createTempFile("ajaxer");
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());

			Assertions.assertThrows(FileAlreadyExistsException.class, () -> FileUtils.createTempFile("ajaxer"));
			file.delete();
		}

		@Test
		void fix_name_already_exists_with_prefix_suffix() throws Exception
		{
			File file = FileUtils.createTempFile("ajaxer-", "dummy-file", ".txt");
			log.info("tempFile: {}", file.getAbsolutePath());
			Assertions.assertTrue(file.exists());

			Assertions.assertThrows(FileAlreadyExistsException.class, () -> FileUtils.createTempFile("ajaxer-", "dummy-file", ".txt"));
			file.delete();

		}
	}

	@Nested
	class CopyTest
	{

	}
}