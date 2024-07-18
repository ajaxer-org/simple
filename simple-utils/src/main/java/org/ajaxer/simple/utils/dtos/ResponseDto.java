package org.ajaxer.simple.utils.dtos;

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

	private boolean status;
	private final Map<String, Object> data = new HashMap<>();

	public ResponseDto() {}

	public ResponseDto(boolean status)
	{
		this.status = status;
	}

	public ResponseDto setParameter(String name, Object value)
	{
		if (ValidationUtils.isBlank(name) || value == null)
			return this;

		data.put(name, value);
		return this;
	}

	@SuppressWarnings({"UnusedReturnValue", "unchecked"})
	public ResponseDto addToList(String name, Object value)
	{
		if (ValidationUtils.isBlank(name) || value == null)
			return this;

		List<Object> objectList;
		if (data.containsKey(name))
			objectList = (List<Object>) data.get(name);
		else
			objectList = new ArrayList<>();

		objectList.add(value);

		data.put(name, objectList);
		return this;
	}

	public ResponseDto setStatus(boolean status)
	{
		this.status = status;
		return this;
	}

	@JsonIgnore
	public Parameter getParameter(String paramName)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(paramName))
			return null;

		return new Parameter(paramName, data.get(paramName));
	}

	@JsonIgnore
	public <T> T getParameter(String paramName, Class<T> outputClass)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(paramName))
			return null;

		String jsonString = GsonUtils.toJsonString(data.get(paramName));
		return GsonUtils.toObject(jsonString, outputClass);
	}

	@JsonIgnore
	public <T> List<T> getParameterList(String paramName, Class<T> outputClass)
	{
		if (ValidationUtils.isBlank(data) || !data.containsKey(paramName))
			return null;

		String jsonString = GsonUtils.toJsonString(data.get(paramName));
		return GsonUtils.toObjectList(jsonString, outputClass);
	}

	@Getter
	@AllArgsConstructor
	@ToString
	public static class Parameter
	{
		private String paramName;
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
