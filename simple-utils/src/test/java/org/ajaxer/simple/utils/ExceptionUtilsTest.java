package org.ajaxer.simple.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-30
 * @since v0.0.1
 */
public
class ExceptionUtilsTest
{
	@Test
	public void rethrow_unchecked_exception()
	{
		Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.rethrow(new NullPointerException()));
	}

	@Test
	public void rethrow_checked_exception()
	{
		Assertions.assertThrows(FileNotFoundException.class, () -> {
			FileInputStream fileInputStream = new FileInputStream("FILE_NOT_FOUND_EXCEPTION");
		});
	}

	@Nested
	class GetStackTraces
	{
		@Test
		public void getStackTraces_when_all_args_null()
		{
			Assertions.assertNull(ExceptionUtils.getStackTraces(null, null));
		}

		@Test
		public void getStackTraces_when_error_message_null()
		{
			List<String> stackTraces = ExceptionUtils.getStackTraces(new NullPointerException());

			//t1
			Assertions.assertTrue(CollectionUtils.isNotBlank(stackTraces));
		}

		@Test
		public void getStackTraces_when_error_message()
		{
			String errorMessage = StringUtils.getUUID();
			List<String> stackTraces = ExceptionUtils.getStackTraces(new NullPointerException(errorMessage));

			//t1
			Assertions.assertTrue(CollectionUtils.isNotBlank(stackTraces));

			//t2
			Assertions.assertTrue(errorMessage.equals(stackTraces.get(0)));
		}
	}
}