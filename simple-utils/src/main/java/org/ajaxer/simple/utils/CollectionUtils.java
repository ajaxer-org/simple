package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.exceptions.BlankPointerException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since 0.0.1
 */
@Log4j2
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

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection)
	{
		if (CollectionUtils.isBlank(collection))
		{
			throw new BlankPointerException();
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, String exceptionMessage)
	{
		if (CollectionUtils.isBlank(collection))
		{
			throw new BlankPointerException(exceptionMessage);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, Throwable throwable)
	{
		if (CollectionUtils.isBlank(collection))
		{
			ExceptionUtils.rethrow(throwable);
		}
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean equals(Collection<T> c1, Collection<T> c2)
	{
		if (c1 == null && c2 == null)
		{
			return true;
		}

		if (c1 == null)
		{
			return false;
		}

		if (c2 == null)
		{
			return false;
		}

		if (c1.isEmpty() && c2.isEmpty())
		{
			return true;
		}

		if (c1.isEmpty())
		{
			return false;
		}

		if (c2.isEmpty())
		{
			return false;
		}

		int size1 = c1.size();
		int size2 = c2.size();
		if (size1 != size2)
		{
			return false;
		}

		for (int i = 0; i < size1; i++)
		{
			if (!c1.equals(c2))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> concat(List<T> list1, List<T> list2)
	{
		if (list1 == null && list2 == null)
		{
			log.warn("list1: {}, list2: {}", list1, list2);
			return null;
		}

		if (list1.isEmpty())
		{
			return list2;
		}

		if (list2.isEmpty())
		{
			return list1;
		}

		for (T t : list2)
		{
			list1.add(t);
		}

		return list1;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> subList(List<T> list, int startIndex)
	{
		if (isBlank(list))
		{
			return list;
		}

		return subList(list, startIndex, list.size());
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> subList(List<T> list, int startIndex, int endIndex)
	{
		if (isBlank(list))
		{
			return list;
		}

		if (startIndex < 0)
		{
			startIndex = 0;
		}

		if (endIndex > list.size())
		{
			endIndex = list.size();
		}

		if (startIndex > endIndex)
		{
			throw new IllegalArgumentException(String.format("startIndex: [%d], cannot be greaterOrEqualsTo endIndex: [%d]", startIndex, endIndex));
		}

		if (startIndex == 0 && endIndex == list.size())
		{
			return list;
		}

		List<T> responseList = new ArrayList<>();
		for (int i = startIndex; i < endIndex - 1; i++)
		{
			responseList.add(list.get(i));
		}

		return responseList;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getNextIdList(List<T> idList, int chunk, int startIndex)
	{
		if (isBlank(idList))
		{
			return idList;
		}

		List<T> temp = new ArrayList<>();
		for (int i = startIndex; i < chunk + startIndex; i++)
		{
			if (i < idList.size())
			{
				temp.add(idList.get(i));
			}
		}

		return temp;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> reverse(List<T> list)
	{
		if (isBlank(list))
		{
			return list;
		}

		int size = list.size();
		for (int i = 0; i < size / 2; i++)
		{
			T temp = list.get(i);
			list.set(i, list.get(size - 1 - i));
			list.set(size - 1 - i, temp);
		}

		return list;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> asArrayList(T[] tArray)
	{
		if (ArrayUtils.isBlank(tArray))
		{
			return null;
		}

		List<T> tList = new ArrayList<>();
		for (T t : tArray)
		{
			tList.add(t);
		}

		return tList;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getTopList(List<T> idList, int chunkSize)
	{
		if (isBlank(idList))
		{
			log.warn("idList is null or empty");
			return null;
		}

		if (chunkSize > idList.size())
		{
			log.warn("chunkSize: {} is greater then idList.size(): {}", chunkSize, idList.size());
			return idList;
		}

		List<T> topIdList = null;
		for (int i = 0; i < chunkSize; i++)
		{
			if (i < idList.size())
			{
				if (topIdList == null)
				{
					topIdList = new ArrayList<>();
				}

				topIdList.add(idList.get(i));
			}
		}
		return topIdList;
	}
}
