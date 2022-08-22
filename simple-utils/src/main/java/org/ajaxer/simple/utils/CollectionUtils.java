package org.ajaxer.simple.utils;

import java.util.Collection;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since 0.0.1
 */
public class CollectionUtils
{
	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isBlank(Collection<T> collection)
	{
		return collection == null || collection.isEmpty();
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean isNotBlank(Collection<T> collection)
	{
		return !isBlank(collection);
	}
}
