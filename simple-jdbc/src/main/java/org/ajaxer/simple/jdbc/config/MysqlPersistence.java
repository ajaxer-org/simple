package org.ajaxer.simple.jdbc.config;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.jdbc.Persistence;

/**
 * @author Shakir
 * @version 2022-11-14
 * @since v0.0.3
 */
@Log4j2
public class MysqlPersistence implements Persistence
{
	@Override
	public <T> T persist(T t)
	{
		log.debug("persisting object: {}", t);
		//TODO
		log.debug("object persisted: {}", t);
		return null;
	}
}
