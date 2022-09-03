package org.ajaxer.simple.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
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
		if (gson == null)
		{
			gson = new Gson();
		}

		return gson;
	}

	/**
	 * @since v0.0.1
	 */
	public static Gson getGsonPrettyPrinting()
	{
		if (gsonPretty == null)
		{
			gsonPretty = new GsonBuilder().setPrettyPrinting().create();
		}
		return gsonPretty;
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
		if (StringUtils.isBlank(jsonString) || classOfT == null) return null;

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
	public static JsonObject parse(String jsonString)
	{
		log.debug("jsonString: {}", jsonString);
		if (StringUtils.isBlank(jsonString)) return null;

		JsonElement jsonElement = JsonParser.parseString(jsonString);
		return jsonElement.getAsJsonObject();
	}

	/**
	 * @since v0.0.1
	 */
	public static JsonArray getJsonArray(String jsonString, String key)
	{
		JsonObject jsonObject = parse(jsonString);
		return jsonObject == null ? null : jsonObject.getAsJsonArray(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> T getElementAsType(String jsonString, Class<T> clazz, String key)
	{
		log.debug("key: {}, clazz: {}, jsonString: {}", key, clazz, jsonString);
		if (clazz == null) return null;

		return getGson().fromJson(getElementAsString(jsonString, key), clazz);
	}

	/**
	 * @since v0.0.1
	 */
	public static JsonPrimitive getJsonPrimitive(String jsonString, String key)
	{
		log.debug("key: {}, jsonString: {}", key, jsonString);
		if (StringUtils.isBlank(jsonString)) return null;
		if (StringUtils.isBlank(key)) return null;

		JsonObject jsonObject = parse(jsonString);
		return jsonObject == null ? null : jsonObject.getAsJsonPrimitive(key);
	}

	/**
	 * @since v0.0.1
	 */
	public static String getElementAsString(String jsonString, String key)
	{
		JsonPrimitive jsonPrimitive = getJsonPrimitive(jsonString, key);
		log.debug("jsonPrimitive: {}", jsonPrimitive);

		return jsonPrimitive == null ? null : jsonPrimitive.getAsString();
	}

	/**
	 * @since v0.0.1
	 */
	public static <T> List<T> getElementAsTypeList(String jsonString, Class<T> clazz, String key)
	{
		log.debug("key: {}, clazz: {}, jsonString: {}", key, clazz, jsonString);

		ExceptionUtils.throwWhenBlank(jsonString);
		ExceptionUtils.throwWhenBlank(key);
		ValidationUtils.throwWhenNull(clazz);

		List<T> tList = new ArrayList<>();
		for (final JsonElement json : getJsonArray(jsonString, key))
		{
			tList.add(getGson().fromJson(json, clazz));
		}
		return tList;
	}
}
