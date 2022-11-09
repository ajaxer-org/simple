package org.ajaxer.simple.jdbc.config;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.jdbc.DataResource;

import java.sql.Connection;

/**
 * @author Shakir
 * @version 2022-11-09
 */
@Log4j2
public class MysqlDataResource extends DataResource
{
	public MysqlDataResource(Connection connection)
	{
		super(connection);
	}
}
