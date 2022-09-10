package org.ajaxer.simple.utils.encoders;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public interface Encoder
{
	/**
	 * @since v0.0.1
	 */
	String INVALID_ENCRYPTION_FORMAT = "Invalid encryption format";

	/**
	 * @since v0.0.1
	 */
	String encode(String message);

	/**
	 * @since v0.0.1
	 */
	String decode(String message);
}
