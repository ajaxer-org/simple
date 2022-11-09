package org.ajaxer.simple.jdbc;

import org.ajaxer.simple.jdbc.config.Configuration;
import org.ajaxer.simple.jdbc.config.Constants;
import org.ajaxer.simple.jdbc.config.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;

/**
 * @author Shakir Ansari
 * @version 2022-11-07
 */
public class ApplicationTest
{
	@Test
	void domParser() throws Exception
	{
		// Instantiate the Factory
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		// optional, but recommended
		// process XML securely, avoid attacks like XML External Entities (XXE)
		documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

		// parse XML file
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		try (InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(Constants.FILE_JDBC_XML))
		{
			Document document = documentBuilder.parse(inputStream);

			// optional, but recommended
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			document.getDocumentElement().normalize();

			//
			String rootNodeName = document.getDocumentElement().getNodeName();
			System.out.println("rootNodeName: " + rootNodeName);
			Assertions.assertNotNull(rootNodeName);
			Assertions.assertEquals("configuration", rootNodeName);
			System.out.println("------ ------");

			//
			NodeList resourceFactory = document.getElementsByTagName("resources");
			Assertions.assertNotNull(resourceFactory);
			Assertions.assertEquals(1, resourceFactory.getLength());

			//
			NodeList resourceList = document.getElementsByTagName("resource");
			Assertions.assertNotNull(resourceList);
			Assertions.assertNotEquals(0, resourceList.getLength());

			for (int i = 0; i < resourceList.getLength(); i++)
			{
				Node node = resourceList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element element = (Element) node;

					// get staff's attribute
					String name = element.getAttribute("name");

					// get text
					String driverName = element.getElementsByTagName("jdbc.driverName").item(0).getTextContent();
					String url = element.getElementsByTagName("jdbc.url").item(0).getTextContent();
					String username = element.getElementsByTagName("jdbc.username").item(0).getTextContent();
					String password = element.getElementsByTagName("jdbc.password").item(0).getTextContent();

					System.out.println("Current Element :" + node.getNodeName());
					System.out.println("resource name : " + name);
					System.out.println("jdbc.driverName : " + driverName);
					System.out.println("jdbc.url : " + url);
					System.out.println("jdbc.username : " + username);
					System.out.println("jdbc.password  : " + password);

					System.out.println("--------------------------");
				}
			}
		}
	}

	@Test
	void xmlToObject() throws Exception
	{
		File xmlFile = new File(Application.class.getClassLoader().getResource(Constants.FILE_JDBC_XML).getFile());

		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(Configuration.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Configuration configuration = (Configuration) jaxbUnmarshaller.unmarshal(xmlFile);
		Assertions.assertNotNull(configuration);

		configuration.getResourceList().forEach(Resource::overrideUserProperties);
		configuration.getResourceList().forEach(r -> System.out.println(r.getDefaultProperties()));

//		configuration.getResourceList().forEach(System.out::println);

		System.out.println(configuration);
	}

	@Test
	void connection()
	{
		/*Class.forName(resource.getDriverName());

		DataResource dr = DriverManager.getConnection(resource.getUrl(), resource.getUsername(), resource.getPassword());*/
	}
}
