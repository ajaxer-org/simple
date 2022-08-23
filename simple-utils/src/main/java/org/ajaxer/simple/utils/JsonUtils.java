package org.ajaxer.simple.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class JsonUtils
{
	private static Gson gsonPretty;

	private static Gson gson;

	/**
	 * @since v0.0.1
	 */
	public static Gson getGson()
	{
		return gson == null ? new Gson() : gson;
	}

	/**
	 * @since v0.0.1
	 */
	public static Gson getGsonPrettyPrinting()
	{
		return gsonPretty == null ? new GsonBuilder().setPrettyPrinting().create() : gsonPretty;
	}

	/**
	 * @since v0.0.1
	 */
	public static String getPrettyJson(String uglyJson)
	{
		log.debug("uglyJson: {}", uglyJson);

		if (StringUtils.isBlank(uglyJson))
		{
			return null;
		}

		JsonElement jsonElement = JsonParser.parseString(uglyJson);
		return getGsonPrettyPrinting().toJson(jsonElement);
	}

	/**
	 * @since v0.0.1
	 */
	public static String toJsonString(Object object)
	{
		return object == null ? null : getGson().toJson(object);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T toObject(String jsonString, Class<T> classOfT)
	{
		log.debug("jsonString: {}, class: {}", jsonString, classOfT);
		if (StringUtils.isBlank(jsonString) || classOfT == null)
		{
			return null;
		}

		return getGson().fromJson(jsonString, classOfT);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> toObjectList(String jsonString, Class<T> classOfT)
	{
		log.debug("jsonString: {}, class: {}", jsonString, classOfT);
		if (StringUtils.isBlank(jsonString) || classOfT == null)
		{
			return null;
		}

		JsonArray array = JsonParser.parseString(jsonString).getAsJsonArray();

		List<T> tList = new ArrayList<>();
		for (final JsonElement json : array)
		{
			tList.add(getGson().fromJson(json, classOfT));
		}
		return tList;
	}

	/**
	 * @since v0.0.1
	 */
	public static JsonObject getElementAsJsonObject(String jsonString, String key)
	{
		log.debug("key: {}, jsonString: {}", key, jsonString);

		StringUtils.throwWhenBlank(jsonString);
		StringUtils.throwWhenBlank(key);

		JsonElement jsonElement = JsonParser.parseString(jsonString);
		JsonObject jObject = jsonElement.getAsJsonObject();
		return jObject.getAsJsonObject(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static JsonArray getElementAsJsonArray(String jsonString, String key)
	{
		log.debug("key: {}, jsonString: {}", key, jsonString);

		StringUtils.throwWhenBlank(jsonString);
		StringUtils.throwWhenBlank(key);

		JsonElement jsonElement = JsonParser.parseString(jsonString);
		JsonObject jObject = jsonElement.getAsJsonObject();

		return jObject.getAsJsonArray(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T getElementAsType(String jsonString, Class<T> clazz, String key)
	{
		log.debug("key: {}, clazz: {}, jsonString: {}", key, clazz, jsonString);

		StringUtils.throwWhenBlank(jsonString);
		StringUtils.throwWhenBlank(key);
		ValidationUtils.throwWhenNull(clazz);

		return getGson().fromJson(getElementAsJsonObject(jsonString, key), clazz);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getElementAsString(String jsonString, String key)
	{
		log.debug("key: {}, jsonString: {}", key, jsonString);

		StringUtils.throwWhenBlank(jsonString);
		StringUtils.throwWhenBlank(key);

		return getElementAsType(jsonString, String.class, key);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getElementAsTypeList(String jsonString, Class<T> clazz, String key)
	{
		log.debug("key: {}, clazz: {}, jsonString: {}", key, clazz, jsonString);

		StringUtils.throwWhenBlank(jsonString);
		StringUtils.throwWhenBlank(key);
		ValidationUtils.throwWhenNull(clazz);

		List<T> tList = new ArrayList<>();
		for (final JsonElement json : getElementAsJsonArray(jsonString, key))
		{
			tList.add(getGson().fromJson(json, clazz));
		}
		return tList;
	}
}
