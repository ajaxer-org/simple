package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Properties;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
public class SystemUtilsTest
{
	private String blankString1 = null;
	private String blankString2 = "";
	private String blankString3 = "  ";
	private String key = "org.ajaxer.temp.key";
	private String value = "org.ajaxer.temp.value";

	@BeforeEach
	void beforeEach()
	{
		SystemUtils.setProperty(key, value);
		Assertions.assertEquals(value, SystemUtils.getProperty(key));
//		log.info("beforeEach");
	}

	@AfterEach
	void afterEach()
	{
		SystemUtils.clearProperty(key);
		Assertions.assertNull(SystemUtils.getProperty(key));
//		log.info("afterEach");
	}

	@Nested
	class GetSetProperty
	{
		@Test
		public void setProperty_with_blank_key_and_blank_value()
		{
			//blank key
			Assertions.assertNull(SystemUtils.setProperty(blankString1, value));
			Assertions.assertNull(SystemUtils.setProperty(blankString2, value));
			Assertions.assertNull(SystemUtils.setProperty(blankString3, value));

			//blank value
			Assertions.assertNull(SystemUtils.setProperty(key, blankString1));
			Assertions.assertNull(SystemUtils.setProperty(key, blankString2));
			Assertions.assertNull(SystemUtils.setProperty(key, blankString3));
		}

		@Test
		public void getProperty_with_blank_key()
		{
			Assertions.assertNull(SystemUtils.getProperty(blankString1));
			Assertions.assertNull(SystemUtils.getProperty(blankString2));
			Assertions.assertNull(SystemUtils.getProperty(blankString3));
		}

		@Test
		public void getProperty_setProperty_with_valid_key_value()
		{
			Assertions.assertEquals(value, SystemUtils.setProperty(key, value));
			Assertions.assertEquals(value, SystemUtils.getProperty(key));
		}

		@Test
		public void clearProperty()
		{
			//blank key
			Assertions.assertNull(SystemUtils.clearProperty(blankString1));
			Assertions.assertNull(SystemUtils.clearProperty(blankString2));
			Assertions.assertNull(SystemUtils.clearProperty(blankString3));
			//blank key
			Assertions.assertNull(SystemUtils.clearProperty(key + "_just_to_make_it_not_exists"));
		}
	}

	@Nested
	class OperatingSystem
	{
		@Test
		void getOsName()
		{
			String osName = SystemUtils.getOsName();
			log.info("osName: {}", osName);

			Assertions.assertNotNull(osName);
		}

		@Test
		@EnabledOnOs(OS.WINDOWS)
		void isWindows()
		{
			Assertions.assertTrue(SystemUtils.isWindows());
			Assertions.assertFalse(SystemUtils.isUnix());
		}

		@Test
		@EnabledOnOs(OS.SOLARIS)
		void isUnix()
		{
			Assertions.assertTrue(SystemUtils.isSolaris());
		}

		@Test
		@EnabledOnOs(OS.MAC)
		void isMac()
		{
			Assertions.assertTrue(SystemUtils.isMac());
		}

	}

	@Test
	void getJavaClasspath()
	{
		String classpath = SystemUtils.getJavaClasspath();
		log.info("classpath: {}", classpath);

		Assertions.assertNotNull(classpath);
	}

	@Test
	void userHomeDirectory()
	{
		String homeDirectory = SystemUtils.userHomeDirectory();
		log.info("homeDirectory: {}", homeDirectory);

		Assertions.assertNotNull(homeDirectory);
	}

	@Test
	void getPresentWorkingDirectory()
	{
		String pwd = SystemUtils.getPresentWorkingDirectory();
		log.info("pwd: {}", pwd);

		Assertions.assertNotNull(pwd);
	}

	@Test
	void getTempDirectory()
	{
		String tempDirectory = SystemUtils.getTempDirectory();
		log.info("tempDirectory: {}", tempDirectory);

		Assertions.assertNotNull(tempDirectory);
	}

	@Test
	void allProperties()
	{
		Properties allProperties = SystemUtils.allProperties();
		for (String key : allProperties.stringPropertyNames())
		{
			String value = allProperties.getProperty(key);
			log.info("key: {}", key);
			log.info("value: {}", value);
		}

	}
}
