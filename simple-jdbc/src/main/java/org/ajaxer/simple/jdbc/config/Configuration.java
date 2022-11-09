package org.ajaxer.simple.jdbc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ajaxer.simple.jdbc.exception.ResourceNotDefineException;
import org.ajaxer.simple.utils.CollectionUtils;

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
@ToString
@NoArgsConstructor
@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configuration implements Serializable
{
	@XmlElementWrapper(name = "resources")
	@XmlElement(name = "resource")
	private List<Resource> resourceList;

	public Resource getResource()
	{
		return CollectionUtils.isBlank(resourceList) ? null : resourceList.get(0);
	}

	public Resource getResource(String resourceName)
	{
		if (CollectionUtils.isBlank(resourceList)) return null;

		return resourceList
				.stream()
				.filter(resource -> resource.getName() != null && resource.getName().equals(resourceName))
				.findFirst()
				.orElseThrow(() -> new ResourceNotDefineException(resourceName));
	}
}
