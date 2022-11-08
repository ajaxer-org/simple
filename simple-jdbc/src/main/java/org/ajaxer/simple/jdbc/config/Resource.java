package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @author Shakir
 * @version 2022-11-08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
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
}
