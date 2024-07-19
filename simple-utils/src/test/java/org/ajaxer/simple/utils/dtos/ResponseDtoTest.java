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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResponseDtoTest
{
	@Test
	void validTest()
	{
		ResponseDto responseDto = new ResponseDto(true)
				.addParam("hello", "World")
				.addParam("foo", "bar")
				.addParam("number", 123)
				.addParam("numberF", "A123")
				.addParam("numberFD", "A123");

		Assertions.assertThat(responseDto.getParameter("unknown")).isNull();
		Assertions.assertThat(responseDto.getParameter("foo").asString()).isNotNull().isEqualTo("bar");

		// parsing
		Assertions.assertThat(responseDto.getParameter("number").asInt()).isEqualTo(123);

		//parsing without default value
		Assertions.assertThat(responseDto.getParameter("numberF").asInt()).isEqualTo(0);
		//parsing with default value
		Assertions.assertThat(responseDto.getParameter("numberFD").asInt(-8)).isEqualTo(-8);
	}
}