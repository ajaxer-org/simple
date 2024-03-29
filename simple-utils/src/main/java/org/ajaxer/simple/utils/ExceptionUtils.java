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

import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class ExceptionUtils
{
	private ExceptionUtils() {}

	/**
	 * @since v0.0.1
	 */
	@SneakyThrows
	public static void rethrow(Throwable throwable)
	{
		if (throwable == null)
			throw new NullPointerException();

		if (throwable instanceof RuntimeException)
			throw (RuntimeException) throwable;

		if (throwable instanceof Error)
			throw (Error) throwable;

		throw throwable;
	}

	/**
	 * @return This method will always return null of given type.
	 * @since v0.0.1
	 */
	public static <T> T rethrow(Throwable throwable, @SuppressWarnings("unused") Class<T> tClass)
	{
		rethrow(throwable);
		return null;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable, String packageFilter)
	{
		if (throwable == null)
			return null;

		List<String> traces = new ArrayList<>();
		if (StringUtils.isNotBlank(throwable.getMessage()))
			traces.add(throwable.getMessage());

		StackTraceElement[] stackTraceElements = throwable.getStackTrace();

		if (ArrayUtils.isBlank(stackTraceElements))
			return traces;

		for (StackTraceElement stackTraceElement : stackTraceElements)
		{
			if (StringUtils.isBlank(packageFilter))
			{
				traces.add(stackTraceElement.toString());
				continue;
			}

			if (stackTraceElement.toString().contains(packageFilter))
				traces.add(stackTraceElement.toString());
		}

		return traces;
	}

	/**
	 * @since v0.0.1
	 */
	public static List<String> getStackTraces(Throwable throwable)
	{
		return getStackTraces(throwable, null);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition)
	{
		throwWhenTrue(trueCondition, (String) null);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, String exceptionMessage)
	{
		throwWhenTrue(trueCondition, new IllegalArgumentException(exceptionMessage));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenTrue(boolean trueCondition, Throwable throwable)
	{
		if (trueCondition)
			rethrow(throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition)
	{
		throwWhenTrue(!falseCondition);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, String exceptionMessage)
	{
		throwWhenTrue(!falseCondition, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenFalse(boolean falseCondition, Throwable throwable)
	{
		throwWhenTrue(!falseCondition, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(char i, char j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(char i, char j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(byte i, byte j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(byte i, byte j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(short i, short j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(short i, short j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(int i, int j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(int i, int j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(long i, long j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(long i, long j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(float i, float j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(float i, float j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j)
	{
		throwWhenTrue(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j, String exceptionMessage)
	{
		throwWhenTrue(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(double i, double j, Throwable throwable)
	{
		throwWhenTrue(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j)
	{
		throwWhenFalse(i == j);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j, String exceptionMessage)
	{
		throwWhenFalse(i == j, exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(double i, double j, Throwable throwable)
	{
		throwWhenFalse(i == j, throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2)
	{
		if (o1 == null && o2 == null)
			throwWhenTrue(true);

		if (o1 == null || o2 == null)
			return;

		throwWhenTrue(o1.equals(o2));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (o1 == null && o2 == null)
			throwWhenTrue(true, exceptionMessage);

		if (o1 == null || o2 == null)
			return;

		throwWhenTrue(o1.equals(o2), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenEquals(Object o1, Object o2, Throwable throwable)
	{
		if (o1 == null && o2 == null)
			throwWhenTrue(true, throwable);
		if (o1 == null || o2 == null)
			return;

		throwWhenTrue(o1.equals(o2), throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2)
	{
		if (o1 == null && o2 == null)
			return;
		if (o1 == null || o2 == null)
			throwWhenFalse(false);

		//noinspection ConstantConditions
		throwWhenFalse(o1.equals(o2));
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, String exceptionMessage)
	{
		if (o1 == null && o2 == null)
			return;
		if (o1 == null || o2 == null)
			throwWhenFalse(false, exceptionMessage);

		//noinspection ConstantConditions
		throwWhenFalse(o1.equals(o2), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static void throwWhenNotEquals(Object o1, Object o2, Throwable throwable)
	{
		if (o1 == null && o2 == null)
			return;
		if (o1 == null || o2 == null)
			throwWhenFalse(false, throwable);

		//noinspection ConstantConditions
		throwWhenFalse(o1.equals(o2), throwable);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t)
	{
		throwWhenTrue(t == null);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, String exceptionMessage)
	{
		throwWhenTrue(t == null, exceptionMessage);
	}

	/**
	 * throws IllegalArgumentException when object is null
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenNull(T t, Throwable throwable)
	{
		throwWhenTrue(t == null, throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(boolean[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(char[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(byte[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(short[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(int[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(long[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(float[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(double[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array)
	{
		throwWhenTrue(ArrayUtils.isBlank(array));
	}

	/**
	 * throws IllegalArgumentException, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), exceptionMessage);
	}

	/**
	 * throws throwable, if given array is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(T[] array, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(ArrayUtils.isBlank(array), throwable);
	}

	/**
	 * throws IllegalArgumentException, if given {@link Collection} is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection)
	{
		throwWhenTrue(CollectionUtils.isBlank(collection));
	}

	/**
	 * throws IllegalArgumentException, if given {@link Collection} is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(CollectionUtils.isBlank(collection), exceptionMessage);
	}

	/**
	 * throws provided Throwable, if given {@link Collection} is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static <T> void throwWhenBlank(Collection<T> collection, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(CollectionUtils.isBlank(collection), throwable);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map)
	{
		throwWhenTrue(MapUtils.isBlank(map));
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, String exceptionMessage)
	{
		throwWhenTrue(MapUtils.isBlank(map), exceptionMessage);
	}

	/**
	 * @since v0.0.1
	 */
	public static <K, V> void throwWhenBlank(Map<K, V> map, Throwable throwable)
	{
		throwWhenTrue(MapUtils.isBlank(map), throwable);
	}

	/**
	 * throws IllegalArgumentException when given string is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string)
	{
		throwWhenTrue(StringUtils.isBlank(string));
	}

	/**
	 * throws IllegalArgumentException when given string is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(StringUtils.isBlank(string), exceptionMessage);
	}

	/**
	 * throws IllegalArgumentException when given string is either null or empty
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenBlank(String string, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(StringUtils.isBlank(string), throwable);
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(File)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(File file)
	{
		throwWhenTrue(FileUtils.isNotValid(file));
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(File)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(File file, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(FileUtils.isNotValid(file), exceptionMessage);
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(File)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(File file, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(FileUtils.isNotValid(file), throwable);
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(String)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(String path)
	{
		throwWhenTrue(FileUtils.isNotValid(path));
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(String)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(String path, String exceptionMessage)
	{
		ExceptionUtils.throwWhenTrue(FileUtils.isNotValid(path), exceptionMessage);
	}

	/**
	 * <p> throws {@link IllegalArgumentException} when {@link FileUtils#isNotValid(String)}</p>
	 *
	 * @since v0.0.1
	 */
	public static void throwWhenInvalid(String path, Throwable throwable)
	{
		ExceptionUtils.throwWhenTrue(FileUtils.isNotValid(path), throwable);
	}
}