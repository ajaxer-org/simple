package org.ajaxer.simple.utils;

import java.util.Map;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class MapUtils
{
	private MapUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> boolean isBlank(Map<K, V> map)
	{
		return map == null || map.isEmpty();
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> boolean isNotBlank(Map<K, V> map)
	{
		return !isBlank(map);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map)
	{
		ExceptionUtils.throwWhenTrue(MapUtils.isBlank(map));
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(MapUtils.isBlank(map), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(MapUtils.isBlank(map), throwable);
	}
}
