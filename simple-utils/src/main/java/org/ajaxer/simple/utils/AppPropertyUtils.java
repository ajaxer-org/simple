package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Shakir
 * @version 2022-08-24
 * @since v0.0.1
 */
@Log4j2
public class AppPropertyUtils implements AutoCloseable
{
	private final InputStream inputStream;
	private final Properties properties;

	public AppPropertyUtils(String fileName) throws IOException
	{
		log.debug("fileName: {}", fileName);
		fileName = fileName.endsWith(".properties") ? fileName : fileName + ".properties";
		log.debug("fileName: {}", fileName);

		this.inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

		this.properties = new Properties();
		this.properties.load(inputStream);
	}

	/**
	 * @since v0.0.1
	 */
	public String getKey(String key)
	{
		log.debug("key: {}", key);
		StringUtils.throwWhenBlank(key, "Key could not be null/empty.");

		return this.properties.getProperty(key);
	}

	/**
	 * @since v0.0.1
	 */
	public void setKey(String key, String value)
	{
		log.debug("key: {}, value: {}", key, value);
		StringUtils.throwWhenBlank(key, "Key could not be null/empty.");

		this.properties.setProperty(key, value);
	}

	/**
	 * @since v0.0.1
	 */
	public int getInt(String key)
	{
		return getInt(key, 0);
	}

	/**
	 * @since v0.0.1
	 */
	public int getInt(String key, int defaultValue)
	{
		log.debug("key: {}, defaultValue: {}", key, defaultValue);
		StringUtils.throwWhenBlank(key, "Key could not be null/empty.");

		return NumberUtils.toInt(properties.getProperty(key), defaultValue);
	}

	/**
	 * @since v0.0.1
	 */
	public boolean containKey(String key)
	{
		log.debug("key: {}", key);
		StringUtils.throwWhenBlank(key, "Key could not be null/empty.");

		return this.properties.containsKey(key);
	}

	/**
	 * @since v0.0.1
	 */
	public boolean containsValue(String value)
	{
		log.debug("value: {}", value);
		if (value == null)
		{
			return false;
		}

		return this.properties.containsValue(value);
	}

	@Override
	public void close()
	{
		SimpleUtils.close(this.inputStream);

		if (this.properties != null)
		{
			this.properties.clear();
		}
	}
}
