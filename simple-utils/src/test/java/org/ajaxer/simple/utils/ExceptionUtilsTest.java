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
		boolean p1 = true;
		boolean p2 = 1 == 1;

		@Test
		void throwWhenTrue_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(p1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(p2));

			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenTrue(p1, new FileNotFoundException()));
			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenTrue(p2, new FileNotFoundException()));

			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(p1, new Exception()));
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(p2, new Exception()));
		}

		@Test
		void throwWhenTrue_with_exceptionMessage()
		{
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(p1, SOMETHING_WENT_WRONG));
			IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(p2, SOMETHING_WENT_WRONG));

			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
		}

		@Test
		void throwWhenTrue_with_throwable()
		{
			FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
				ExceptionUtils.throwWhenTrue(p1, new FileNotFoundException(SOMETHING_WENT_WRONG));
			});
			FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
				ExceptionUtils.throwWhenTrue(p2, new FileNotFoundException(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
			Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

			Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(p1, new Exception()));
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(p2, new Exception()));

			Assertions.assertNull(exception1.getMessage());
			Assertions.assertNull(exception2.getMessage());
		}
	}

	@Nested
	class ThrowWhenFalse
	{
		boolean p1 = false;
		boolean p2 = 1 == 2;

		@Test
		void throwWhenFalse_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(p1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(p2));

			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenFalse(p1, new FileNotFoundException()));
			Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenFalse(p2, new FileNotFoundException()));

			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(p1, new Exception()));
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(p2, new Exception()));
		}

		@Test
		void throwWhenFalse_with_exceptionMessage()
		{
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(p1, SOMETHING_WENT_WRONG));
			IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(p2, SOMETHING_WENT_WRONG));

			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
			Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
		}

		@Test
		void throwWhenFalse_with_throwable()
		{
			FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
				ExceptionUtils.throwWhenFalse(p1, new FileNotFoundException(SOMETHING_WENT_WRONG));
			});
			FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
				ExceptionUtils.throwWhenFalse(p2, new FileNotFoundException(SOMETHING_WENT_WRONG));
			});
			Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
			Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

			Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(p1, new Exception()));
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(p2, new Exception()));

			Assertions.assertNull(exception1.getMessage());
			Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class,
																			  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG));

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
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
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2));

				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage()
			{
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});
				IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, SOMETHING_WENT_WRONG);
				});

				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, arg2, new FileNotFoundException(SOMETHING_WENT_WRONG));
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(SOMETHING_WENT_WRONG, fileNotFoundException2.getMessage());

				Exception exception1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));
				Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Exception()));

				Assertions.assertNull(exception1.getMessage());
				Assertions.assertNull(exception2.getMessage());
			}

			@Test
			void throwWhenNotEquals_default_both_object_null()
			{
				//no exception will be thrown, because both args are same (null)
				ExceptionUtils.throwWhenNotEquals(null, null);
				ExceptionUtils.throwWhenNotEquals(null, null, new FileNotFoundException());
				ExceptionUtils.throwWhenNotEquals(null, null, new Exception());
			}

			@Test
			void throwWhenNotEquals_default_first_object_null()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Exception()));
			}

			@Test
			void throwWhenNotEquals_default_second_object_null()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null));
				Assertions.assertThrows(FileNotFoundException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new FileNotFoundException()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Exception()));
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage_both_object_null()
			{
				ExceptionUtils.throwWhenNotEquals(null, null, SOMETHING_WENT_WRONG);
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage_first_object_null()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(null, arg2, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_exceptionMessage_second_object_null()
			{
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					ExceptionUtils.throwWhenNotEquals(arg1, null, SOMETHING_WENT_WRONG);
				});
				Assertions.assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
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