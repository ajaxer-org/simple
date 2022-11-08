package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-11-08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configuration implements Serializable
{
	@XmlElementWrapper(name = "resources")
	@XmlElement(name = "resource")
	private List<Resource> resourceList;
}
