package org.ajaxer.simple.utils.encoders;

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
import org.ajaxer.simple.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
public class HexaEncoderTest
{
	private String blankString1 = null;
	private String blankString2 = "";
	private String blankString3 = "   ";

	private Encoder<String, String> encoder;
	private Decoder<String, String> decoder;

	@BeforeEach
	void beforeEach()
	{
		encoder = new HexaEncoder();
		decoder = new HexaEncoder();
	}

	@Test
	void encode_with_blank_message()
	{
		Assertions.assertNull(encoder.encode(blankString1));
		Assertions.assertNull(encoder.encode(blankString2));
		Assertions.assertNotNull(encoder.encode(blankString3));
	}

	@Test
	void decode_with_blank_message()
	{
		Assertions.assertNull(decoder.decode(blankString1));
		Assertions.assertNull(decoder.decode(blankString2));

		Assertions.assertThrows(IllegalArgumentException.class, () -> decoder.decode(blankString3));
	}

	@RepeatedTest(10)
	void encode_decode_with_valid_message()
	{
		String message = StringUtils.getUUID();
		String encoded = encoder.encode(message);
		String decoded = decoder.decode(encoded);
		log.info("encoded: {}, decoded: {}", encoded, decoded);

		Assertions.assertEquals(decoded, message);
	}
}