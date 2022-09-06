package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.AbstractTest;
import org.ajaxer.simple.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.crypto.IllegalBlockSizeException;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
@Disabled
public class AesEncoderTest extends AbstractTest
{
	private Encoder encoder;

	@BeforeEach
	void beforeEach()
	{
		encoder = new AesEncoder(key);
	}

	@Test
	void onCreate_with_blank_key()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new AesEncoder(blankString1));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new AesEncoder(blankString2));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new AesEncoder(blankString3));
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

		//unable to decode invalid format
		Assertions.assertThrows(IllegalBlockSizeException.class, () -> encoder.decode(blankString3));
		Assertions.assertThrows(IllegalBlockSizeException.class, () -> encoder.decode(notBlankString));
	}

	@RepeatedTest(10)
	void encode_decode_with_valid_message()
	{
		String message = StringUtils.getUUID();
		log.info("message: {}", message);

		String encoded = encoder.encode(message);
		log.info("encoded: {}", encoded);

		String decoded = encoder.decode(encoded);
		log.info("decoded: {}", decoded);

		log.info("encoded: {}, decoded: {}", encoded, decoded);

		Assertions.assertEquals(decoded, message);
	}
}