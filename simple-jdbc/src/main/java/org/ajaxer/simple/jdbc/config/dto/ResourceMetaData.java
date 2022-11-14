package org.ajaxer.simple.jdbc.config.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @author Shakir
 * @version 2022-11-14
 */
@Getter
@ToString
public class ResourceMetaData
{
	@ToString.Exclude
	@Getter(AccessLevel.NONE)
	final private DatabaseMetaData databaseMetaData;

	final private String driverName;
	final private String driverVersion;
	final private String productName;
	final private String productVersion;

	public ResourceMetaData(DatabaseMetaData databaseMetaData) throws SQLException
	{
		this.databaseMetaData = databaseMetaData;
		this.driverName = this.databaseMetaData.getDriverName();
		this.driverVersion = this.databaseMetaData.getDriverVersion();
		this.productName = this.databaseMetaData.getDatabaseProductName();
		this.productVersion = this.databaseMetaData.getDatabaseProductVersion();
	}
}
