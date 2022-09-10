package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author Shakir
 * @version 2022-09-02
 * @since v0.0.1
 */
@Log4j2
public class MapUtilsTest
{
	private final static String SOMETHING_WENT_WRONG = "Something went wrong";

	@Test
	void isBlank_and_isNotBlank_with_null_map()
	{
		HashMap<String, String> map = null;

		Assertions.assertTrue(MapUtils.isBlank(map));
		Assertions.assertFalse(MapUtils.isNotBlank(map));
	}

	@Test
	void isBlank_and_isNotBlank_with_empty_map()
	{
		HashMap<String, String> map = new HashMap<>();

		Assertions.assertTrue(MapUtils.isBlank(map));
		Assertions.assertFalse(MapUtils.isNotBlank(map));
	}

	@Test
	void isBlank_and_isNotBlank_with_correct_map()
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("hello", "world");
		map.put("foor", "bar");

		Assertions.assertFalse(MapUtils.isBlank(map));
		Assertions.assertTrue(MapUtils.isNotBlank(map));
	}

	@Test
	void throwWhenBlank_default()
	{
		HashMap<String, String> nullMap = null;
		HashMap<String, String> emptyMap = new HashMap<>();

		Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap));
		Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap));

		Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new FileNotFoundException()));
		Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new FileNotFoundException()));

		Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Exception()));
		Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Exception()));
	}

	@Test
	void throwWhenBlank_with_exceptionMessage()
	{
		HashMap<String, String> nullMap = null;
		HashMap<String, String> emptyMap = new HashMap<>();

		IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, SOMETHING_WENT_WRONG));
		IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, SOMETHING_WENT_WRONG));

		Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
		Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
	}

	@Test
	void throwWhenBlank_with_throwable()
	{
		HashMap<String, String> nullMap = null;
		HashMap<String, String> emptyMap = new HashMap<>();

		FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
			ExceptionUtils.throwWhenBlank(nullMap, new FileNotFoundException(SOMETHING_WENT_WRONG));
		});
		FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
			ExceptionUtils.throwWhenBlank(emptyMap, new FileNotFoundException(SOMETHING_WENT_WRONG));
		});
		Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
		Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

		Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Exception()));
		Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Exception()));

		Assertions.assertNull(exception1.getMessage());
		Assertions.assertNull(exception2.getMessage());
	}

}