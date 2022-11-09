package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.ToString;
import org.ajaxer.simple.utils.CollectionUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.IOException;
import java.io.InputStream;
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

	private Properties defaultProperties;

	public void loadDefaultProperties()
	{
		try (InputStream inputStream = Resource.class.getClassLoader().getResourceAsStream(Constants.FILE_DEFAULT_PROPERTIES))
		{
			this.defaultProperties = new Properties();
			this.defaultProperties.load(inputStream);
		} catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void overrideUserProperties()
	{
		loadDefaultProperties();

		if (CollectionUtils.isNotBlank(this.userProperties))
		{
			this.defaultProperties.stringPropertyNames().forEach(propName -> this.userProperties
					.stream()
					.filter(up -> up.getKey().equals(propName))
					.findFirst()
					.ifPresent(property -> this.defaultProperties.setProperty(propName, property.getValue()))
			);
		}
	}
}
