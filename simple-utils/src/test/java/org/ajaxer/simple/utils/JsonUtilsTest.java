package org.ajaxer.simple.utils;

import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import org.ajaxer.simple.utils.dtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
	class GetElementAs
	{
		@Test
		void getElementAsJsonObject_when_args_null_blank()
		{
			Assertions.assertNull(JsonUtils.parseAsJsonObject(null, null));
			Assertions.assertNull(JsonUtils.parseAsJsonObject("", ""));
			Assertions.assertNull(JsonUtils.parseAsJsonObject("", null));
			Assertions.assertNull(JsonUtils.parseAsJsonObject(null, ""));
		}

		@Test
		void getElementAsJsonArray_when_args_null_blank()
		{
			Assertions.assertNull(JsonUtils.getElementAsJsonArray(null, null));
			Assertions.assertNull(JsonUtils.getElementAsJsonArray("", ""));
			Assertions.assertNull(JsonUtils.getElementAsJsonArray("", null));
			Assertions.assertNull(JsonUtils.getElementAsJsonArray(null, ""));
		}

		@Test
		void getElementAsType_when_args_null_blank()
		{
			Assertions.assertNull(JsonUtils.getElementAsType(null, null, null));
			Assertions.assertNull(JsonUtils.getElementAsType("", null, ""));
			Assertions.assertNull(JsonUtils.getElementAsType("", null, null));
			Assertions.assertNull(JsonUtils.getElementAsType(null, null, ""));
		}

		@Test
		void parseAsJsonObject_when_correct_args()
		{
			JsonObject jsonObject = JsonUtils.parseAsJsonObject(mUserDtoJson);
			log.info("jsonObject: {}", jsonObject);

			Assertions.assertEquals(jsonObject.getAsJsonPrimitive("name").getAsString(), "ajaxer");
		}
	}

}