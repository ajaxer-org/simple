package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.AbstractTest;
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
public class Number52EncoderTest extends AbstractTest
{
	private Encoder encoder;

	@BeforeEach
	void beforeEach()
	{
		encoder = new Number52Encoder();
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
		Assertions.assertNull(encoder.decode(blankString1));
		Assertions.assertNull(encoder.decode(blankString2));

		Assertions.assertThrows(IllegalArgumentException.class, () -> encoder.decode(blankString3));
	}

	@RepeatedTest(10)
	void encode_decode_with_valid_message()
	{
		String message = StringUtils.getUUID();
		String encoded = encoder.encode(message);
		String decoded = encoder.decode(encoded);
		log.info("encoded: {}, decoded: {}", encoded, decoded);

		Assertions.assertEquals(decoded, message);
	}
}