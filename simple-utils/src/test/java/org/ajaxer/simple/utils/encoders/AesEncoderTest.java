package org.ajaxer.simple.utils.encoders;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
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
	void encode_with_blank_key()
	{
		Assertions.assertNull(encoder.encode(blankString1));
		Assertions.assertNotNull(encoder.encode(blankString2));
		Assertions.assertNotNull(encoder.encode(blankString3));
	}

	@Test
	void decode_with_blank_key()
	{
		Assertions.assertNull(encoder.decode(blankString1));
		Assertions.assertNotNull(encoder.decode(blankString2));
		Assertions.assertNotNull(encoder.decode(blankString3));
	}
}