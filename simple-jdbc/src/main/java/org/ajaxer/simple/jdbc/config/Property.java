package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * @author Shakir
 * @version 2022-11-08
 */
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Property implements Serializable
{
	@XmlAttribute
	private String key;

	@XmlAttribute
	private String value;
}
