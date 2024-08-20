package org.ajaxer.simple.github.dto;
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Shakir Ansari
 * @since 2024-08-19
 */
@Data
public class BaseDto implements Serializable
{
	private String message;

	private List<Error> errors;

	@SerializedName("documentation_url")
	@JsonProperty("documentation_url")
	private String documentationUrl;

	private String status;

	@Data
	public static class Error
	{
		private String resource;
		private String code;
		private String field;
		private String message;
	}
}
