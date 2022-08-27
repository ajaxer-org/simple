package org.ajaxer.simple.utils;

import java.util.Map;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class MapUtils
{
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
		if (MapUtils.isBlank(map))
		{
			throw new NullPointerException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, String exceptionMessage)
	{
		if (MapUtils.isBlank(map))
		{
			throw new NullPointerException(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, Throwable throwable)
	{
		if (MapUtils.isBlank(map))
		{
			ExceptionUtils.rethrow(throwable);
		}
	}
}
