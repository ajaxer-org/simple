package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.ToString;
import org.ajaxer.simple.utils.CollectionUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 * @author Shakir
 * @version 2022-11-08
 */
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Resource implements Serializable
{
	@XmlAttribute(name = "name")
	private String name;

	@XmlElement(name = "jdbc.driverName")
	private String driverName;

	@XmlElement(name = "jdbc.url")
	private String url;

	@XmlElement(name = "jdbc.username")
	private String username;

	@XmlElement(name = "jdbc.password")
	private String password;

	@XmlElementWrapper(name = "properties")
	@XmlElement(name = "property")
	private List<Property> userProperties;

	private final Properties properties;

	public Resource()
	{
		this.properties = new Properties();
		this.properties.setProperty("show_sql", String.valueOf(false));
		this.properties.setProperty("enable_transaction", String.valueOf(false));
	}

	public void overrideUserProperties()
	{
		if (CollectionUtils.isNotBlank(this.userProperties))
		{
			userProperties.forEach(p -> this.properties.setProperty(p.getKey(), p.getValue()));
		}
	}
}
