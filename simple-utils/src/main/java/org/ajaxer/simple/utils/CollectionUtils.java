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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since 0.0.1
 */
@Log4j2
public class CollectionUtils
{
	private CollectionUtils() {}

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
	public static <T> boolean equals(Collection<T> c1, Collection<T> c2)
	{
		if (c1 == null && c2 == null)
			return true;

		if (c1 == null)
			return false;

		if (c2 == null)
			return false;

		if (c1.isEmpty() && c2.isEmpty())
			return true;

		if (c1.isEmpty())
			return false;

		if (c2.isEmpty())
			return false;

		if (c1.size() != c2.size())
			return false;

		for (int i = 0; i < c1.size(); i++)
			if (!c1.equals(c2))
				return false;

		return true;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> boolean equalsToAny(Collection<T> collection, T val)
	{
		if (isBlank(collection) || val == null)
			return false;

		for (T s : collection)
		{
			if (s.equals(val))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> concat(List<T> list1, List<T> list2)
	{
		if (list1 == null && list2 == null)
		{
			log.warn("list1, list2, both are null");
			return null;
		}

		if (isBlank(list1))
			return list2;

		if (isBlank(list2))
			return list1;

		list1.addAll(list2);

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
	 * From startIndex to endIndex - 1
	 *
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
			throw new IllegalArgumentException(
					String.format("startIndex: [%d], cannot be greaterOrEqualsTo endIndex: [%d]", startIndex, endIndex));
		}

		if (startIndex == 0 && endIndex == list.size())
		{
			return list;
		}

		List<T> responseList = new ArrayList<>();
		for (int i = startIndex; i < endIndex; i++)
		{
			responseList.add(list.get(i));
		}

		return responseList;
	}

	public static <T> List<List<T>> subLists(List<T> list, int batchSize)
	{
		ExceptionUtils.throwWhenBlank(list, "list cannot be blank");
		ExceptionUtils.throwWhenTrue(batchSize < 1, "batch size cannot be less than zero");

		List<List<T>> result = new ArrayList<>();

		List<T> batchList = new ArrayList<>();
		for (T t : list)
		{
			batchList.add(t);

			if (batchList.size() == batchSize)
			{
				result.add(batchList);
				batchList = new ArrayList<>();
			}
		}

		if (!batchList.isEmpty())
			result.add(batchList);

		return result;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getNextChunk(List<T> idList, int chunk, int startIndex)
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

		List<T> resultList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
		{
			resultList.add(list.get(list.size() - 1 - i));
		}

		return resultList;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> asArrayList(T[] tArray)
	{
		if (tArray == null)
			return null;

		if (tArray.length == 0)
			return new ArrayList<>();

		List<T> tList = new ArrayList<>();
		Collections.addAll(tList, tArray);

		return tList;
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getTopList(List<T> idList, int chunkSize)
	{
		return getNextChunk(idList, chunkSize, 0);
	}
}
