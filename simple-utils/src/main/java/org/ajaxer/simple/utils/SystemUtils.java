package org.ajaxer.simple.utils;

/*
 * Copyright (c) 2024 ajaxer.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import lombok.extern.log4j.Log4j2;

import java.util.Properties;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class SystemUtils
{
	private SystemUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static String setProperty(String key, String value)
	{
		log.debug("key: {}, value: {}", key, value);
		if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) return null;

		System.setProperty(key, value);
		return value;
	}

	/**
	 * @since v0.0.1
	 */
	public static String getProperty(String key)
	{
		log.debug("key: {}", key);
		if (StringUtils.isBlank(key)) return null;

		return System.getProperty(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static String clearProperty(String key)
	{
		log.debug("key: {}", key);
		if (StringUtils.isBlank(key)) return null;

		return System.clearProperty(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static Properties allProperties()
	{
		return System.getProperties();
	}

	/**
	 * @since v0.0.1
	 */
	public static String getOsName()
	{
		return SystemUtils.getProperty("os.name");
	}

	/**
	 * <p>os.version</p>
	 *
	 * @since v0.0.1
	 */
	public static String osVersion()
	{
		return SystemUtils.getProperty("os.version");
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isMac()
	{
		return getOsName().toLowerCase().contains("mac");
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isWindows()
	{
		return getOsName().toLowerCase().contains("win");
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isSolaris()
	{
		return getOsName().toLowerCase().contains("sunos");
	}

	/**
	 * @since v0.0.1
	 */
	public static boolean isUnix()
	{
		String osName = getOsName();
		log.debug("osName: {}", osName);

		return osName.toLowerCase().contains("nix")
				|| osName.toLowerCase().contains("nux")
				|| osName.toLowerCase().contains("aix");
	}

	/**
	 * <p>java.class.version</p>
	 *
	 * @since v0.0.1
	 */
	public static int javaClassVersion()
	{
		return NumberUtils.toInt(System.getProperty("java.class.version"));
	}

	/**
	 * <p>java.class.path</p>
	 *
	 * @since v0.0.1
	 */
	public static String getJavaClasspath()
	{
		return System.getProperty("java.class.path");
	}

	/**
	 * <p>java.home</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaHome()
	{
		return System.getProperty("java.home");
	}

	/**
	 * <p>java.runtime.name</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaRuntimeName()
	{
		return System.getProperty("java.runtime.name");
	}

	/**
	 * <p>java.specification.version</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaVersion()
	{
		return System.getProperty("java.specification.version");
	}

	/**
	 * <p>java.vm.specification.version</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaVMVersion()
	{
		return System.getProperty("java.vm.specification.version");
	}

	/**
	 * <p>java.vm.vendor</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaVMVendor()
	{
		return System.getProperty("java.vm.vendor");
	}

	/**
	 * <p>java.specification.vendor</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaVendor()
	{
		return System.getProperty("java.specification.vendor");
	}

	/**
	 * <p>java.vendor.url</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaVendorUrl()
	{
		return System.getProperty("java.vendor.url");
	}

	/**
	 * <p>java.io.tmpdir</p>
	 *
	 * @since v0.0.1
	 */
	public static String javaTempDirectory()
	{
		return System.getProperty("java.io.tmpdir");
	}

	/**
	 * <p>user.timezone</p>
	 *
	 * @since v0.0.1
	 */
	public static String userTimezone()
	{
		return System.getProperty("java.vendor.url");
	}

	/**
	 * <p>user.home</p>
	 *
	 * @since v0.0.1
	 */
	public static String userHomeDirectory()
	{
		return SystemUtils.getProperty("user.home");
	}

	/**
	 * <p>user.dir</p>
	 *
	 * @since v0.0.1
	 */
	public static String userDir()
	{
		return SystemUtils.getProperty("user.dir");
	}

	/**
	 * <p>user.name</p>
	 *
	 * @since v0.0.1
	 */
	public static String userName()
	{
		return SystemUtils.getProperty("user.name");
	}

	/**
	 * <p>user.country</p>
	 *
	 * @since v0.0.1
	 */
	public static String userCountry()
	{
		return SystemUtils.getProperty("user.country");
	}

	/**
	 * <p>user.language</p>
	 *
	 * @since v0.0.1
	 */
	public static String userLanguage()
	{
		return SystemUtils.getProperty("user.language");
	}

	/**
	 * @since v0.0.1
	 */
	public static String getPresentWorkingDirectory()
	{
		return SystemUtils.getProperty("user.dir");
	}

	/**
	 * @since v0.0.1
	 */
	public static String getTempDirectory()
	{
		return SystemUtils.getProperty("java.io.tmpdir");
	}
}
