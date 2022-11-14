package org.ajaxer.simple.jdbc;

/**
 * @author Shakir
 * @version 2022-11-14
 * @since v0.0.3
 */
public interface Transactional
{
	/**
	 * @since v0.03
	 */
	void startTransaction();

	/**
	 * @since v0.03
	 */
	void commitTransaction();

	/**
	 * @since v0.03
	 */
	void rollbackTransaction();
}
