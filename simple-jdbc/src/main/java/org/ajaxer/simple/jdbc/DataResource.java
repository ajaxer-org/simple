package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.dto.ResourceMetaData;

/**
 * @author Shakir
 * @version 2022-11-09
 * @since v0.0.3
 */
public interface DataResource extends Persistence, Transactional, AutoCloseable
{
	ResourceMetaData getResourceMetaData();
}
