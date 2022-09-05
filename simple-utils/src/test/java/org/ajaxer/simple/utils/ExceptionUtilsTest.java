package org.ajaxer.simple.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-30
 * @since v0.0.1
 */
public class ExceptionUtilsTest
{
	private final static String SOMETHING_WENT_WRONG = "Something went wrong";

	@Nested
	class Rethrow
	{
		@Test
		public void rethrow_unchecked_exception()
		{
			Assertions.assertThrows(NullPointerException.class, () -> {
				ExceptionUtils.rethrow(new NullPointerException());
			});
		}

		@Test
		public void rethrow_checked_exception()
		{
			Assertions.assertThrows(FileNotFoundException.class, () -> {
				ExceptionUtils.rethrow(new FileNotFoundException("FILE_NOT_FOUND_EXCEPTION"));
			});
		}

		@Test
		public void rethrow_checked_exception_t2()
		{
			Assertions.assertThrows(Exception.class, () -> {
				ExceptionUtils.rethrow(new Exception(SOMETHING_WENT_WRONG));
			});
		}
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

	@Nested
	class ThrowWhenTrue
	{
		boolean condition = true;

		@Test
		void throwWhenTrue_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(condition));
			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenTrue(condition, new FileNotFoundException()));
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(condition, new Exception()));
		}

		@Test
		void throwWhenTrue_with_exceptionMessage()
		{
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				ExceptionUtils.throwWhenTrue(condition, SOMETHING_WENT_WRONG);
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
		}

		@Test
		void throwWhenTrue_with_throwable()
		{
			//without error message
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenTrue(condition, new NullPointerException()));
			//with error message
			NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
				ExceptionUtils.throwWhenTrue(condition, new NullPointerException(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

			//without error message
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(condition, new Exception()));
			//with error message
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> {
				ExceptionUtils.throwWhenTrue(condition, new Exception(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

			//without error message
			Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenTrue(condition, new Error()));
			//with error message
			Error exception3 = Assertions.assertThrows(Error.class, () -> {
				ExceptionUtils.throwWhenTrue(condition, new Error(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(exception3.getMessage(),SOMETHING_WENT_WRONG);
		}
	}

	@Nested
	class ThrowWhenFalse
	{
		boolean condition = false;

		@Test
		void throwWhenFalse_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(condition));
			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenFalse(condition, new FileNotFoundException()));
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(condition, new Exception()));
		}

		@Test
		void throwWhenFalse_with_exceptionMessage()
		{
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				ExceptionUtils.throwWhenFalse(condition, SOMETHING_WENT_WRONG);
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
		}

		@Test
		void throwWhenFalse_with_throwable()
		{
			//without error message
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenFalse(condition, new NullPointerException()));
			//with error message
			NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
				ExceptionUtils.throwWhenFalse(condition, new NullPointerException(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

			//without error message
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(condition, new Exception()));
			//with error message
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> {
				ExceptionUtils.throwWhenFalse(condition, new Exception(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

			//without error message
			Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenFalse(condition, new Error()));
			//with error message
			Error exception3 = Assertions.assertThrows(Error.class, () -> {
				ExceptionUtils.throwWhenFalse(condition, new Error(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(exception3.getMessage(), SOMETHING_WENT_WRONG);
		}
	}

	@Nested
	class ThrowWhenEquals
	{
		@Nested
		class ThrowWhenEqualsChars
		{
			char arg1 = 'a';
			char arg2 = 'a';

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsByte
		{
			byte arg1 = 12;
			byte arg2 = 12;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsShort
		{
			short arg1 = 256;
			short arg2 = 256;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsInt
		{
			int arg1 = 2560099;
			int arg2 = 2560099;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsLong
		{
			long arg1 = 2560099L;
			long arg2 = 2560099L;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsFloat
		{
			float arg1 = 2560099.67F;
			float arg2 = 2560099.67F;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsDouble
		{
			double arg1 = 2560099.67D;
			double arg2 = 2560099.67D;

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}
		}

		@Nested
		class ThrowWhenEqualsObject
		{
			String arg1 = "hello-world";
			String arg2 = "hello-world";

			@Test
			void throwWhenEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () ->
				{
					ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}

			@Test
			void throwWhenEquals_default_when_args_null()
			{
				//default
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(null, null));

				//exception message
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(null, null, SOMETHING_WENT_WRONG));
				Assertions.assertEquals(ex1.getMessage(), SOMETHING_WENT_WRONG);

				//throwable of Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Exception(SOMETHING_WENT_WRONG)));
				Assertions.assertEquals(ex2.getMessage(), SOMETHING_WENT_WRONG);

				//throwable of RuntimeException
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenEquals(null, null, new NullPointerException()));
				NullPointerException ex3 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenEquals(null, null, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(ex3.getMessage(), SOMETHING_WENT_WRONG);
				//throwable of Error
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Error()));
				Error ex4 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Error(SOMETHING_WENT_WRONG)));
				Assertions.assertEquals(ex4.getMessage(), SOMETHING_WENT_WRONG);
			}

			@Test
			void throwWhenEquals_exceptionMessage_when_one_object_null()
			{
				//no exception will be thrown
				ExceptionUtils.throwWhenEquals(null, arg2, SOMETHING_WENT_WRONG);
				ExceptionUtils.throwWhenEquals(arg1, null, SOMETHING_WENT_WRONG);
			}

			@Test
			void throwWhenEquals_throwable_when_one_object_null()
			{
				//no exception will be thrown

				//throwable of Exception
				ExceptionUtils.throwWhenEquals(null, arg2, new Exception());
				ExceptionUtils.throwWhenEquals(arg1, null, new Exception());
				ExceptionUtils.throwWhenEquals(null, arg2, new Exception(SOMETHING_WENT_WRONG));
				ExceptionUtils.throwWhenEquals(arg1, null, new Exception(SOMETHING_WENT_WRONG));

				//throwable of RuntimeException
				ExceptionUtils.throwWhenEquals(null, arg2, new NullPointerException());
				ExceptionUtils.throwWhenEquals(arg1, null, new NullPointerException());
				ExceptionUtils.throwWhenEquals(null, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				ExceptionUtils.throwWhenEquals(arg1, null, new NullPointerException(SOMETHING_WENT_WRONG));

				//throwable of Error
				ExceptionUtils.throwWhenEquals(null, arg2, new Error());
				ExceptionUtils.throwWhenEquals(arg1, null, new Error());
				ExceptionUtils.throwWhenEquals(null, arg2, new Error(SOMETHING_WENT_WRONG));
				ExceptionUtils.throwWhenEquals(arg1, null, new Error(SOMETHING_WENT_WRONG));
			}

		}
	}

	@Nested
	class ThrowWhenNotEquals
	{
		@Nested
		class ThrowWhenNotEqualsChars
		{
			char arg1 = 'a';
			char arg2 = 'z';

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsByte
		{
			byte arg1 = 12;
			byte arg2 = 28;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsShort
		{
			short arg1 = 256;
			short arg2 = 257;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsInt
		{
			int arg1 = 2560099;
			int arg2 = -2560099;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsLong
		{
			long arg1 = 2560099L;
			long arg2 = 2560090L;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsFloat
		{
			float arg1 = 2560099.67F;
			float arg2 = 256009.698F;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsDouble
		{
			double arg1 = 2560099.67D;
			double arg2 = 2561199.89D;

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}
		}

		@Nested
		class throwWhenNotEqualsObject
		{
			String arg1 = "hello-world";
			String arg2 = "foo bar";

			@Test
			void throwWhenNotEquals_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());

				Exception exception3 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertNull(exception3.getMessage());
			}

			@Test
			void throwWhenNotEquals_default_when_args_null()
			{
				//no exception will be thrown, because both args are same (null)
				//default
				ExceptionUtils.throwWhenNotEquals(null, null);
				//exception message
				ExceptionUtils.throwWhenNotEquals(null, null, SOMETHING_WENT_WRONG);

				//throwable of Exception
				ExceptionUtils.throwWhenNotEquals(null, null, new Exception());
				ExceptionUtils.throwWhenNotEquals(null, null, new Exception(SOMETHING_WENT_WRONG));
				//throwable of RuntimeException
				ExceptionUtils.throwWhenNotEquals(null, null, new NullPointerException());
				ExceptionUtils.throwWhenNotEquals(null, null, new NullPointerException(SOMETHING_WENT_WRONG));
				//throwable of Error
				ExceptionUtils.throwWhenNotEquals(null, null, new Error());
				ExceptionUtils.throwWhenNotEquals(null, null, new Error(SOMETHING_WENT_WRONG));
			}

			@Test
			void throwWhenNotEquals_exceptionMessage_when_one_object_null()
			{
				//exception message
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, SOMETHING_WENT_WRONG));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, SOMETHING_WENT_WRONG));
			}

			@Test
			void throwWhenNotEquals_throwable_when_one_object_null()
			{
				//throwable of Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Exception()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Exception(SOMETHING_WENT_WRONG)));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Exception(SOMETHING_WENT_WRONG)));

				//throwable of RuntimeException
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new NullPointerException()));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new NullPointerException()));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new NullPointerException(SOMETHING_WENT_WRONG)));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new NullPointerException(SOMETHING_WENT_WRONG)));

				//throwable of Error
				//throwable of RuntimeException
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Error()));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Error()));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Error(SOMETHING_WENT_WRONG)));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Error(SOMETHING_WENT_WRONG)));
			}
		}
	}

	@Nested
	class ThrowWhenBlankMap
	{
		HashMap<String, String> nullMap = null;
		HashMap<String, String> emptyMap = new HashMap<>();

		@Test
		void throwWhenBlank_map_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap));

			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new FileNotFoundException()));
			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new FileNotFoundException()));

			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Exception()));
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Exception()));
		}

		@Test
		void throwWhenBlank_map_with_exceptionMessage()
		{
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, SOMETHING_WENT_WRONG));
			IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, SOMETHING_WENT_WRONG));

			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
		}

		@Test
		void throwWhenBlank_map_with_throwable()
		{
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
}