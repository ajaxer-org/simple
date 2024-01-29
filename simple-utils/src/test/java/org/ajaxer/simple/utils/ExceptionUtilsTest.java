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

import org.ajaxer.simple.utils.dtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shakir
 * @version 2022-08-30
 * @since v0.0.1
 */
public class ExceptionUtilsTest
{
	private final static String ERR_MSG = "Something went wrong";

	@Nested
	class Rethrow
	{
		@Test
		public void rethrow_RuntimeException()
		{
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.rethrow(new RuntimeException()));
			RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.rethrow(new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex.getMessage(), ERR_MSG);
		}

		@Test
		public void rethrow_RuntimeException_with_return()
		{
			Assertions.assertThrows(RuntimeException.class, () -> {
				String s = ExceptionUtils.rethrow(new RuntimeException(), String.class);
			});

			RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> {
				String s = ExceptionUtils.rethrow(new RuntimeException(ERR_MSG), String.class);
			});
			Assertions.assertEquals(ex.getMessage(), ERR_MSG);
		}

		@Test
		public void rethrow_Exception()
		{
			Assertions.assertThrows(Exception.class, () -> {
				Integer integer = ExceptionUtils.rethrow(new Exception(), Integer.class);
			});
			Exception ex = Assertions.assertThrows(Exception.class, () -> {
				Integer integer = ExceptionUtils.rethrow(new Exception(ERR_MSG), Integer.class);
			});
			Assertions.assertEquals(ex.getMessage(), ERR_MSG);
		}

		@Test
		public void rethrow_Throwable()
		{
			Assertions.assertThrows(Throwable.class, () -> {
				UserDto userDto = ExceptionUtils.rethrow(new Throwable(), UserDto.class);
			});
			Throwable ex = Assertions.assertThrows(Throwable.class, () -> {
				UserDto userDto = ExceptionUtils.rethrow(new Throwable(ERR_MSG), UserDto.class);
			});
			Assertions.assertEquals(ex.getMessage(), ERR_MSG);
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
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenTrue(condition, ERR_MSG));
			Assertions.assertEquals(ERR_MSG, exception1.getMessage());
		}

		@Test
		void throwWhenTrue_with_throwable()
		{
			//without error message
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenTrue(condition, new NullPointerException()));
			//with error message
			NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenTrue(condition, new NullPointerException(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, exception1.getMessage());

			//without error message
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(condition, new Exception()));
			//with error message
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenTrue(condition, new Exception(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, exception2.getMessage());

			//without error message
			Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenTrue(condition, new Error()));
			//with error message
			Error exception3 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenTrue(condition, new Error(ERR_MSG)));
			Assertions.assertEquals(exception3.getMessage(), ERR_MSG);
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
			IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenFalse(condition, ERR_MSG));
			Assertions.assertEquals(ERR_MSG, exception1.getMessage());
		}

		@Test
		void throwWhenFalse_with_throwable()
		{
			//without error message
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenFalse(condition, new NullPointerException()));
			//with error message
			NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																	  () -> ExceptionUtils.throwWhenFalse(condition, new NullPointerException(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, exception1.getMessage());

			//without error message
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(condition, new Exception()));
			//with error message
			Exception exception2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenFalse(condition, new Exception(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, exception2.getMessage());

			//without error message
			Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenFalse(condition, new Error()));
			//with error message
			Error exception3 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenFalse(condition, new Error(ERR_MSG)));
			Assertions.assertEquals(exception3.getMessage(), ERR_MSG);
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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				FileNotFoundException fileNotFoundException1 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				FileNotFoundException fileNotFoundException2 = Assertions.assertThrows(FileNotFoundException.class,
																					   () -> ExceptionUtils.throwWhenEquals(arg1, arg2, new FileNotFoundException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, fileNotFoundException1.getMessage());
				Assertions.assertEquals(ERR_MSG, fileNotFoundException2.getMessage());

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
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenEquals(null, null, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//throwable of Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//throwable of RuntimeException
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenEquals(null, null, new NullPointerException()));
				NullPointerException ex3 = Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenEquals(null, null, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
				//throwable of Error
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Error()));
				Error ex4 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenEquals(null, null, new Error(ERR_MSG)));
				Assertions.assertEquals(ex4.getMessage(), ERR_MSG);
			}

			@Test
			void throwWhenEquals_exceptionMessage_when_one_object_null()
			{
				//no exception will be thrown
				ExceptionUtils.throwWhenEquals(null, arg2, ERR_MSG);
				ExceptionUtils.throwWhenEquals(arg1, null, ERR_MSG);
			}

			@Test
			void throwWhenEquals_throwable_when_one_object_null()
			{
				//no exception will be thrown

				//throwable of Exception
				ExceptionUtils.throwWhenEquals(null, arg2, new Exception());
				ExceptionUtils.throwWhenEquals(arg1, null, new Exception());
				ExceptionUtils.throwWhenEquals(null, arg2, new Exception(ERR_MSG));
				ExceptionUtils.throwWhenEquals(arg1, null, new Exception(ERR_MSG));

				//throwable of RuntimeException
				ExceptionUtils.throwWhenEquals(null, arg2, new NullPointerException());
				ExceptionUtils.throwWhenEquals(arg1, null, new NullPointerException());
				ExceptionUtils.throwWhenEquals(null, arg2, new NullPointerException(ERR_MSG));
				ExceptionUtils.throwWhenEquals(arg1, null, new NullPointerException(ERR_MSG));

				//throwable of Error
				ExceptionUtils.throwWhenEquals(null, arg2, new Error());
				ExceptionUtils.throwWhenEquals(arg1, null, new Error());
				ExceptionUtils.throwWhenEquals(null, arg2, new Error(ERR_MSG));
				ExceptionUtils.throwWhenEquals(arg1, null, new Error(ERR_MSG));
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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, ERR_MSG));
				Assertions.assertEquals(ERR_MSG, exception.getMessage());
			}

			@Test
			void throwWhenNotEquals_with_throwable()
			{
				NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class,
																		  () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception1.getMessage());

				Error exception2 = Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, arg2, new Error(ERR_MSG)));
				Assertions.assertEquals(ERR_MSG, exception2.getMessage());

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
				ExceptionUtils.throwWhenNotEquals(null, null, ERR_MSG);

				//throwable of Exception
				ExceptionUtils.throwWhenNotEquals(null, null, new Exception());
				ExceptionUtils.throwWhenNotEquals(null, null, new Exception(ERR_MSG));
				//throwable of RuntimeException
				ExceptionUtils.throwWhenNotEquals(null, null, new NullPointerException());
				ExceptionUtils.throwWhenNotEquals(null, null, new NullPointerException(ERR_MSG));
				//throwable of Error
				ExceptionUtils.throwWhenNotEquals(null, null, new Error());
				ExceptionUtils.throwWhenNotEquals(null, null, new Error(ERR_MSG));
			}

			@Test
			void throwWhenNotEquals_exceptionMessage_when_one_object_null()
			{
				//exception message
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, ERR_MSG));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, ERR_MSG));
			}

			@Test
			void throwWhenNotEquals_throwable_when_one_object_null()
			{
				//throwable of Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Exception()));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Exception()));

				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Exception(ERR_MSG)));
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Exception(ERR_MSG)));

				//throwable of RuntimeException
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new NullPointerException()));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new NullPointerException()));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new NullPointerException(ERR_MSG)));
				Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new NullPointerException(ERR_MSG)));

				//throwable of Error
				//throwable of RuntimeException
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Error()));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Error()));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(null, arg2, new Error(ERR_MSG)));
				Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwWhenNotEquals(arg1, null, new Error(ERR_MSG)));
			}
		}
	}

	@Nested
	class ThrowWhenNull
	{
		@Test
		void throwWhenNull_default()
		{
			//with null object
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNull(null));

			//with not null object
			ExceptionUtils.throwWhenNull(new Object());
		}

		@Test
		void throwWhenNull_exceptionMessage()
		{
			//with null object
			IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenNull(null, ERR_MSG));
			Assertions.assertEquals(ERR_MSG, ex.getMessage());

			//with not null object
			ExceptionUtils.throwWhenNull(new Object(), ERR_MSG);
		}

		@Test
		void throwWhenNull_throwable_with_null_object()
		{
			//RuntimeException
			Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNull(null, new NullPointerException()));
			NullPointerException ex1 = Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.throwWhenNull(null, new NullPointerException(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, ex1.getMessage());

			//Exception
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNull(null, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenNull(null, new Exception(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, ex2.getMessage());

			//Throwable
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenNull(null, new Throwable()));
			Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenNull(null, new Exception(ERR_MSG)));
			Assertions.assertEquals(ERR_MSG, ex3.getMessage());
		}

		@Test
		void throwWhenNull_throwable_with_not_null_object()
		{
			//RuntimeException
			ExceptionUtils.throwWhenNull(new Object(), new RuntimeException());
			ExceptionUtils.throwWhenNull(new Object(), new RuntimeException(ERR_MSG));

			//Exception
			ExceptionUtils.throwWhenNull(new Object(), new Exception());
			ExceptionUtils.throwWhenNull(new Object(), new Exception(ERR_MSG));

			//Throwable
			ExceptionUtils.throwWhenNull(new Object(), new Throwable());
			ExceptionUtils.throwWhenNull(new Object(), new Throwable(ERR_MSG));
		}
	}

	@Nested
	class ThrowWhenBlankArray
	{
		@Nested
		class BooleanArray
		{
			boolean[] nullArray = null;
			boolean[] emptyArray = {};
			boolean[] notBlankArray = {true, false};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class CharacterArray
		{
			char[] nullArray = null;
			char[] emptyArray = {};
			char[] notBlankArray = {'a', 'o'};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class ByteArray
		{
			byte[] nullArray = null;
			byte[] emptyArray = {};
			byte[] notBlankArray = {Byte.MIN_VALUE, Byte.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class ShortArray
		{
			short[] nullArray = null;
			short[] emptyArray = {};
			short[] notBlankArray = {Short.MIN_VALUE, Short.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class IntegerArray
		{
			int[] nullArray = null;
			int[] emptyArray = {};
			int[] notBlankArray = {Integer.MIN_VALUE, Integer.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class LongArray
		{
			long[] nullArray = null;
			long[] emptyArray = {};
			long[] notBlankArray = {Long.MIN_VALUE, Long.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class FloatArray
		{
			float[] nullArray = null;
			float[] emptyArray = {};
			float[] notBlankArray = {Float.MIN_VALUE, Float.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class DoubleArray
		{
			double[] nullArray = null;
			double[] emptyArray = {};
			double[] notBlankArray = {Double.MIN_VALUE, Double.MAX_VALUE};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}

		@Nested
		class ObjectArray
		{
			Object[] nullArray = null;
			Object[] emptyArray = {};
			Object[] notBlankArray = {"ajaxer", "org"};

			@Test
			void throwWhenBlank_default()
			{
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray));
				Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray));
				ExceptionUtils.throwWhenBlank(notBlankArray);
			}

			@Test
			void throwWhenEquals_with_exceptionMessage()
			{
				IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, ERR_MSG));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyArray, ERR_MSG));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				ExceptionUtils.throwWhenBlank(notBlankArray, ERR_MSG);
			}

			@Test
			void throwWhenEquals_with_throwable()
			{
				//RuntimeException
				Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException()));
				RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new RuntimeException(ERR_MSG)));
				Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

				//Exception
				Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception()));
				Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Exception(ERR_MSG)));
				Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

				//Throwable
				Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable()));
				Throwable ex3 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullArray, new Throwable(ERR_MSG)));
				Assertions.assertEquals(ex3.getMessage(), ERR_MSG);
			}
		}
	}

	@Nested
	class ThrowWhenBlankCollection
	{
		List<String> nullList = null;
		List<String> emptyList = new ArrayList<>();
		List<String> notEmptyList = Arrays.asList("ajaxer", "org");

		@Test
		void throwWhenBlank_collection_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullList));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyList));
			ExceptionUtils.throwWhenBlank(notEmptyList);
		}

		@Test
		void throwWhenBlank_collection_exceptionMessage()
		{
			IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullList, ERR_MSG));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyList, ERR_MSG));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			ExceptionUtils.throwWhenBlank(notEmptyList, ERR_MSG);
		}

		@Test
		void throwWhenBlank_collection_throwable_RuntimeException()
		{
			//nullList
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullList, new RuntimeException()));
			RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullList, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyList
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new RuntimeException()));
			RuntimeException ex2 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//notEmptyList
			ExceptionUtils.throwWhenBlank(notEmptyList, new RuntimeException());
			ExceptionUtils.throwWhenBlank(notEmptyList, new RuntimeException(ERR_MSG));
		}

		@Test
		void throwWhenBlank_collection_Exception()
		{

			//nullList
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullList, new Exception()));
			Exception ex1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullList, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyList
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyList
			ExceptionUtils.throwWhenBlank(notEmptyList, new Exception());
			ExceptionUtils.throwWhenBlank(notEmptyList, new Exception(ERR_MSG));
		}

		@Test
		void throwWhenBlank_collection_Throwable()
		{
			//nullList
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullList, new Throwable()));
			Throwable ex1 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullList, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyList
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new Throwable()));
			Throwable ex2 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyList, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyList
			ExceptionUtils.throwWhenBlank(notEmptyList, new Throwable());
			ExceptionUtils.throwWhenBlank(notEmptyList, new Throwable(ERR_MSG));
		}
	}

	@Nested
	class ThrowWhenBlankMap
	{
		Map<String, String> nullMap = null;
		Map<String, String> emptyMap = new HashMap<>();
		Map<String, String> notEmptyMap = Collections.singletonMap("key", "value");

		@Test
		void throwWhenBlank_collection_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap));
			ExceptionUtils.throwWhenBlank(notEmptyMap);
		}

		@Test
		void throwWhenBlank_map_exceptionMessage()
		{
			IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, ERR_MSG));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, ERR_MSG));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			ExceptionUtils.throwWhenBlank(notEmptyMap, ERR_MSG);
		}

		@Test
		void throwWhenBlank_map_throwable_RuntimeException()
		{
			//nullMap
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new RuntimeException()));
			RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyMap
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new RuntimeException()));
			RuntimeException ex2 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//notEmptyMap
			ExceptionUtils.throwWhenBlank(notEmptyMap, new RuntimeException());
			ExceptionUtils.throwWhenBlank(notEmptyMap, new RuntimeException(ERR_MSG));
		}

		@Test
		void throwWhenBlank_map_Exception()
		{
			//nullMap
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Exception()));
			Exception ex1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyMap
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyMap
			ExceptionUtils.throwWhenBlank(notEmptyMap, new Exception());
			ExceptionUtils.throwWhenBlank(notEmptyMap, new Exception(ERR_MSG));
		}

		@Test
		void throwWhenBlank_map_Throwable()
		{
			//nullMap
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Throwable()));
			Throwable ex1 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullMap, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyMap
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Throwable()));
			Throwable ex2 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyMap, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyMap
			ExceptionUtils.throwWhenBlank(notEmptyMap, new Throwable());
			ExceptionUtils.throwWhenBlank(notEmptyMap, new Throwable(ERR_MSG));
		}
	}

	@Nested
	class ThrowWhenBlankString
	{
		String nullString = null;
		String emptyString1 = "";
		String emptyString2 = "    	";
		String notEmptyString = "hello-world";

		@Test
		void throwWhenBlank_string_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullString));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyString1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyString2));
			ExceptionUtils.throwWhenBlank(notEmptyString);
		}

		@Test
		void throwWhenBlank_string_exceptionMessage()
		{
			IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(nullString, ERR_MSG));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, ERR_MSG));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			IllegalArgumentException ex2a = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenBlank(emptyString2, ERR_MSG));
			Assertions.assertEquals(ex2a.getMessage(), ERR_MSG);

			ExceptionUtils.throwWhenBlank(notEmptyString, ERR_MSG);
		}

		@Test
		void throwWhenBlank_string_throwable_RuntimeException()
		{
			//nullString
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullString, new RuntimeException()));
			RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(nullString, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyString
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new RuntimeException()));
			RuntimeException ex2 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyString2, new RuntimeException()));
			RuntimeException ex2a = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenBlank(emptyString2, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2a.getMessage(), ERR_MSG);

			//notEmptyString
			ExceptionUtils.throwWhenBlank(notEmptyString, new RuntimeException());
			ExceptionUtils.throwWhenBlank(notEmptyString, new RuntimeException(ERR_MSG));
		}

		@Test
		void throwWhenBlank_string_Exception()
		{
			//nullString
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullString, new Exception()));
			Exception ex1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(nullString, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyString
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyString2, new Exception()));
			Exception ex2a = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenBlank(emptyString2, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyString
			ExceptionUtils.throwWhenBlank(notEmptyString, new Exception());
			ExceptionUtils.throwWhenBlank(notEmptyString, new Exception(ERR_MSG));
		}

		@Test
		void throwWhenBlank_string_Throwable()
		{
			//nullString
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullString, new Throwable()));
			Throwable ex1 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(nullString, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);
			//emptyString
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new Throwable()));
			Throwable ex2 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenBlank(emptyString1, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);
			//notEmptyString
			ExceptionUtils.throwWhenBlank(notEmptyString, new Throwable());
			ExceptionUtils.throwWhenBlank(notEmptyString, new Throwable(ERR_MSG));
		}
	}

	@Nested
	class throwWhenInvalidFile
	{
		File invalidFile1 = null;
		File invalidFile2 = new File("DOES-NOT-EXISTS");
		File validFile = new File(ExceptionUtils.class.getClassLoader().getResource("file-utils-test-data.txt").getFile());

		@Test
		void throwWhenBlank_file_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2));
			ExceptionUtils.throwWhenInvalid(validFile);
		}

		@Test
		void throwWhenBlank_file_exceptionMessage()
		{
			//invalidFile
			IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, ERR_MSG));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, ERR_MSG));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validFile
			ExceptionUtils.throwWhenInvalid(validFile, ERR_MSG);
		}

		@Test
		void throwWhenBlank_file_throwable_RuntimeException()
		{
			//invalidFile
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new RuntimeException()));
			RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new RuntimeException()));
			RuntimeException ex2 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validFile
			ExceptionUtils.throwWhenInvalid(validFile, new RuntimeException());
			ExceptionUtils.throwWhenInvalid(validFile, new RuntimeException(ERR_MSG));
		}

		@Test
		void throwWhenBlank_file_Exception()
		{
			//invalidFile
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new Exception()));
			Exception ex1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validFile
			ExceptionUtils.throwWhenInvalid(validFile, new Exception());
			ExceptionUtils.throwWhenInvalid(validFile, new Exception(ERR_MSG));
		}

		@Test
		void throwWhenBlank_file_Throwable()
		{
			//invalidFile
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new Throwable()));
			Throwable ex1 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile1, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new Throwable()));
			Throwable ex2 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidFile2, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validFile
			ExceptionUtils.throwWhenInvalid(validFile, new Throwable());
			ExceptionUtils.throwWhenInvalid(validFile, new Throwable(ERR_MSG));
		}
	}

	@Nested
	class throwWhenInvalidPath
	{
		String invalidPath1 = null;
		String invalidPath2 = "/tmp/user/DOES-NOT-EXISTS";
		String validPath = ExceptionUtils.class.getClassLoader().getResource("file-utils-test-data.txt").getFile();

		@Test
		void throwWhenBlank_path_default()
		{
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1));
			Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2));
			ExceptionUtils.throwWhenInvalid(validPath);
		}

		@Test
		void throwWhenBlank_path_exceptionMessage()
		{
			//invalidPath
			IllegalArgumentException ex1 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, ERR_MSG));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			IllegalArgumentException ex2 = Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, ERR_MSG));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validPath
			ExceptionUtils.throwWhenInvalid(validPath, ERR_MSG);
		}

		@Test
		void throwWhenBlank_path_throwable_RuntimeException()
		{
			//invalidPath
			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new RuntimeException()));
			RuntimeException ex1 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new RuntimeException()));
			RuntimeException ex2 = Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new RuntimeException(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validPath
			ExceptionUtils.throwWhenInvalid(validPath, new RuntimeException());
			ExceptionUtils.throwWhenInvalid(validPath, new RuntimeException(ERR_MSG));
		}

		@Test
		void throwWhenBlank_path_Exception()
		{
			//invalidPath
			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new Exception()));
			Exception ex1 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new Exception()));
			Exception ex2 = Assertions.assertThrows(Exception.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new Exception(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validPath
			ExceptionUtils.throwWhenInvalid(validPath, new Exception());
			ExceptionUtils.throwWhenInvalid(validPath, new Exception(ERR_MSG));
		}

		@Test
		void throwWhenBlank_path_Throwable()
		{
			//invalidPath
			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new Throwable()));
			Throwable ex1 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath1, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex1.getMessage(), ERR_MSG);

			Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new Throwable()));
			Throwable ex2 = Assertions.assertThrows(Throwable.class, () -> ExceptionUtils.throwWhenInvalid(invalidPath2, new Throwable(ERR_MSG)));
			Assertions.assertEquals(ex2.getMessage(), ERR_MSG);

			//validPath
			ExceptionUtils.throwWhenInvalid(validPath, new Throwable());
			ExceptionUtils.throwWhenInvalid(validPath, new Throwable(ERR_MSG));
		}
	}
}