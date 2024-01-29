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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.dtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shakir
 * @version 2022-09-02
 * @since v0.0.1
 */
@Log4j2
public class JsonUtilsTest
{
	private UserDto mUserDto = new UserDto("ajaxer", "email@ajaxer.org", "uuid-123-4567-890");
	private String mUserDtoJson = "{\"name\":\"ajaxer\",\"email\":\"email@ajaxer.org\",\"uuid\":\"uuid-123-4567-890\"}";

	@Nested
	class GetPrettyJson
	{
		@Test
		void getPrettyJson_with_blank_string()
		{
			Assertions.assertNull(JsonUtils.getPrettyJson(null));
			Assertions.assertNull(JsonUtils.getPrettyJson(""));
		}

		@Test
		void getPrettyJson_with_non_json_string()
		{
			String nonJson = StringUtils.getUUID();
			log.info("nonJson: {}", nonJson);

			String response = JsonUtils.getPrettyJson(nonJson);
			log.info("response: {}", response);

			String expected = "\"" + nonJson + "\"";
			log.info("expected: {}", expected);

			Assertions.assertEquals(expected, response);
		}

		@Test
		void getPrettyJson_with_correct_json_string()
		{
			String response = JsonUtils.getPrettyJson(mUserDtoJson);
			log.info("response: {}", response);

			UserDto responseDto = JsonUtils.toObject(response, UserDto.class);
			log.info("responseDto: {}", responseDto);

			Assertions.assertEquals(mUserDto, responseDto);
		}
	}

	@Nested
	class ToJsonStringToObject
	{
		@Test
		void toJsonString_with_null_object()
		{
			Assertions.assertNull(JsonUtils.toJsonString(null));
		}

		@Test
		void toObject_with_blank_json_and_null_type()
		{
			Assertions.assertNull(JsonUtils.toObject(null, null));
			Assertions.assertNull(JsonUtils.toObject("", null));
		}

		@Test
		void toJsonString_toObject()
		{
			String userDtoString = JsonUtils.toJsonString(mUserDto);
			log.info("userDtoString: {}", userDtoString);

			UserDto userDtoResult = JsonUtils.toObject(userDtoString, UserDto.class);
			log.info("userDtoResult: {}", userDtoResult);

			Assertions.assertEquals(mUserDto, userDtoResult);
		}
	}

	@Nested
	class ToObjectList
	{
		@Test
		void toObjectList_with_blank_json_and_null_type()
		{
			Assertions.assertNull(JsonUtils.toObjectList(null, null));
			Assertions.assertNull(JsonUtils.toObjectList("", null));
		}

		@Test
		void toObjectList_with_correct_data()
		{
			List<UserDto> userDtos = Arrays.asList(
					new UserDto("name0", "email0", "uuid0"),
					new UserDto("name1", "email1", "uuid1"),
					new UserDto("name2", "email2", "uuid2")
			);
			String json = JsonUtils.toJsonString(userDtos);
			log.info("json: {}", json);

			List<UserDto> userDtosResult = JsonUtils.toObjectList(json, UserDto.class);
			log.info("userDtosResult: {}", userDtosResult);

			for (int i = 0; i < 3; i++)
			{
				Assertions.assertEquals(userDtos.get(i).getName(), userDtosResult.get(i).getName());
				Assertions.assertEquals(userDtos.get(i).getEmail(), userDtosResult.get(i).getEmail());
				Assertions.assertEquals(userDtos.get(i).getUuid(), userDtosResult.get(i).getUuid());
				Assertions.assertEquals(userDtos.get(i), userDtosResult.get(i));
			}
		}
	}

	@Nested
	class Parse
	{
		@Test
		void parse_when_jsonString_blank()
		{
			Assertions.assertNull(JsonUtils.parse(null));
			Assertions.assertNull(JsonUtils.parse(""));
		}

		@Test
		void parse_when_correct_args_t1()
		{
			JsonObject jsonObject = JsonUtils.parse(mUserDtoJson);
			log.info("jsonObject: {}", jsonObject);

			Assertions.assertEquals(jsonObject.getAsJsonPrimitive("name").getAsString(), "ajaxer");
		}

		@Test
		void parse_when_correct_args_t2()
		{
			JsonObject jsonObject = JsonUtils.parse(mUserDtoJson);
			log.info("jsonObject: {}", jsonObject);
			String actual = "email@ajaxer.org";

			Assertions.assertEquals(jsonObject.getAsJsonPrimitive("email").getAsString(), actual);
		}
	}

	@Nested
	class GetJsonArray
	{
		@Test
		void getJsonArray_when_args_null_blank()
		{
			Assertions.assertNull(JsonUtils.getJsonArray(null, null));
			Assertions.assertNull(JsonUtils.getJsonArray("", ""));
			Assertions.assertNull(JsonUtils.getJsonArray("", null));
			Assertions.assertNull(JsonUtils.getJsonArray(null, ""));
		}

		@Test
		void getJsonArray_with_correct_data()
		{
			HashMap<String, Object> hashMap = new HashMap<>();

			List<UserDto> userDtos = Arrays.asList(
					new UserDto("name0", "email0", "uuid0"),
					new UserDto("name1", "email1", "uuid1"),
					new UserDto("name2", "email2", "uuid2")
			);

			hashMap.put("userDtos", userDtos);
			hashMap.put("foo", "bar");

			String json = JsonUtils.toJsonString(hashMap);
			log.info("json: {}", json);

			JsonArray array = JsonUtils.getJsonArray(json, "userDtos");
			for (int i = 0; i < array.size(); i++)
			{
				log.info("jsonElement: {}", array.get(i));

				String result = array.get(i).getAsJsonObject().getAsJsonPrimitive("email").getAsString();
				String expected = userDtos.get(i).getEmail();

				Assertions.assertEquals(result, expected);
			}
		}
	}

	@Nested
	class GetElementAs
	{
		@Test
		void getElementAsType_when_args_null_blank()
		{
			Assertions.assertNull(JsonUtils.getElementAsType(null, null, null));
			Assertions.assertNull(JsonUtils.getElementAsType("", null, ""));
			Assertions.assertNull(JsonUtils.getElementAsType("", null, null));
			Assertions.assertNull(JsonUtils.getElementAsType(null, null, ""));
		}
	}

}