package org.ajaxer.simple.utils.dtos;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ajaxer.simple.utils.GsonUtils;
import org.ajaxer.simple.utils.NumberUtils;
import org.ajaxer.simple.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shakir
 * @version 2023-07-04
 */
@Getter
@ToString
public class ResponseDto
{
	public static final String KEY_MESSAGE = "MESSAGE";
	public static final String KEY_USER_MESSAGES = "USER_MESSAGES";

	final private boolean status;
	final private Map<String, Object> data = new HashMap<>();

	public ResponseDto(boolean status)
	{
		this.status = status;
	}

	public ResponseDto addParam(String key, Object value)
	{
		if (ValidationUtils.isBlank(key) || value == null)
			return this;

		data.put(key, value);
		return this;
	}

	@SuppressWarnings({"UnusedReturnValue", "unchecked"})
	public ResponseDto addToList(String key, Object value)
	{
		if (ValidationUtils.isBlank(key) || value == null)
			return this;

		List<Object> objectList;
		if (data.containsKey(key))
			objectList = (List<Object>) data.get(key);
		else
			objectList = new ArrayList<>();

		objectList.add(value);

		data.put(key, objectList);
		return this;
	}

	@JsonIgnore
	public Parameter getParameter(String key)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(key))
			return null;

		return new Parameter(key, data.get(key));
	}

	@Deprecated
	@JsonIgnore
	public <T> T getParameter(String paramName, Class<T> outputClass)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(paramName))
			return null;

		String jsonString = GsonUtils.toJsonString(data.get(paramName));
		return GsonUtils.toObject(jsonString, outputClass);
	}

	@JsonIgnore
	public <T> List<T> getParameterList(String key, Class<T> outputClass)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(key))
			return null;

		String jsonString = GsonUtils.toJsonString(data.get(key));
		return GsonUtils.toObjectList(jsonString, outputClass);
	}

	@Getter
	@AllArgsConstructor
	@ToString
	public static class Parameter
	{
		private String key;
		private Object value;

		public String asString()
		{
			String jsonString = GsonUtils.toJsonString(value);
			return GsonUtils.toObject(jsonString, String.class);
		}

		public boolean asBoolean()
		{
			return Boolean.parseBoolean(asString());
		}

		public int asInt()
		{
			return NumberUtils.toInt(asString());
		}

		public int asInt(int defaultValue)
		{
			return NumberUtils.toInt(asString(), defaultValue);
		}

		public long asLong(String paramName)
		{
			return NumberUtils.toLong(asString());
		}

		public long asLong(long defaultValue)
		{
			return NumberUtils.toLong(asString(), defaultValue);
		}
	}
}
