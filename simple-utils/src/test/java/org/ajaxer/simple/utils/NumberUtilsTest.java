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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-09-02
 * @since v0.0.1
 */
@Log4j2
public class NumberUtilsTest
{
	@Nested
	class Parse
	{
		@Test
		void byte_parse()
		{
			Assertions.assertEquals((byte) 0, NumberUtils.toByte(null));
			Assertions.assertEquals((byte) 10, NumberUtils.toByte(null, (byte) 10));

			Assertions.assertEquals((byte) 0, NumberUtils.toByte(""));
			Assertions.assertEquals((byte) 10, NumberUtils.toByte("", (byte) 10));

			Assertions.assertEquals((byte) 123, NumberUtils.toByte("123"));
			Assertions.assertEquals((byte) -10, NumberUtils.toByte("-10", (byte) 10));
		}

		@Test
		void short_parse()
		{
			Assertions.assertEquals((short) 0, NumberUtils.toShort(null));
			Assertions.assertEquals((short) 10, NumberUtils.toShort(null, (short) 10));

			Assertions.assertEquals((short) 0, NumberUtils.toShort(""));
			Assertions.assertEquals((short) 10, NumberUtils.toShort("", (short) 10));

			Assertions.assertEquals((short) 12367, NumberUtils.toShort("12367"));
			Assertions.assertEquals((short) -10, NumberUtils.toShort("-10", (short) 10));
		}

		@Test
		void int_parse()
		{
			Assertions.assertEquals(0, NumberUtils.toInt(null));
			Assertions.assertEquals(10, NumberUtils.toInt(null, 10));

			Assertions.assertEquals(0, NumberUtils.toInt(""));
			Assertions.assertEquals(10, NumberUtils.toInt("", 10));

			Assertions.assertEquals(123456789, NumberUtils.toInt("123456789"));
			Assertions.assertEquals(-1009, NumberUtils.toInt("-1009", 10));
		}

		@Test
		void long_parse()
		{
			Assertions.assertEquals(0L, NumberUtils.toLong(null));
			Assertions.assertEquals(10L, NumberUtils.toLong(null, 10L));

			Assertions.assertEquals(0L, NumberUtils.toLong(""));
			Assertions.assertEquals(10L, NumberUtils.toLong("", 10L));

			Assertions.assertEquals(123456789L, NumberUtils.toLong("123456789"));
			Assertions.assertEquals(-1009L, NumberUtils.toLong("-1009", 10L));
		}

		@Test
		void float_parse()
		{
			Assertions.assertEquals(0F, NumberUtils.toFloat(null));
			Assertions.assertEquals(10F, NumberUtils.toFloat(null, 10L));

			Assertions.assertEquals(0F, NumberUtils.toFloat(""));
			Assertions.assertEquals(10F, NumberUtils.toFloat("", 10L));

			Assertions.assertEquals(1.234F, NumberUtils.toFloat("1.234E+10"));
			Assertions.assertEquals(123456789F, NumberUtils.toFloat("123456789"));

			Assertions.assertEquals(-1009F, NumberUtils.toFloat("-1009", 10L));
		}

		@Test
		void double_parse()
		{
			Assertions.assertEquals(0D, NumberUtils.toDouble(null));
			Assertions.assertEquals(10D, NumberUtils.toDouble(null, 10D));

			Assertions.assertEquals(0D, NumberUtils.toDouble(""));
			Assertions.assertEquals(10D, NumberUtils.toDouble("", 10D));

			Assertions.assertEquals(12345.6789D, NumberUtils.toDouble("12345.6789"));
			Assertions.assertEquals(-1009.98D, NumberUtils.toDouble("-1009.98", 10D));
		}
	}
}