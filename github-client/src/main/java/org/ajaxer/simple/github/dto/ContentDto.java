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
import lombok.EqualsAndHashCode;

/**
 * @author Shakir Ansari
 * @since 2024-08-19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContentDto extends BaseDto
{
	@SerializedName("name")
	@JsonProperty("name")
	private String name;

	@SerializedName("path")
	@JsonProperty("path")
	private String path;

	@SerializedName("sha")
	@JsonProperty("sha")
	private String sha;

	@SerializedName("size")
	@JsonProperty("size")
	private int size;

	@SerializedName("url")
	@JsonProperty("url")
	private String url;

	@SerializedName("html_url")
	@JsonProperty("html_url")
	private String htmlUrl;

	@SerializedName("git_url")
	@JsonProperty("git_url")
	private String gitUrl;

	@SerializedName("download_url")
	@JsonProperty("download_url")
	private String downloadUrl;

	@SerializedName("type")
	@JsonProperty("type")
	private String type;

	@SerializedName("content")
	@JsonProperty("content")
	private String content;

	@SerializedName("encoding")
	@JsonProperty("encoding")
	private String encoding;

	@SerializedName("_links")
	@JsonProperty("_links")
	private Links links;

	@Data
	public static class Links
	{
		@SerializedName("self")
		@JsonProperty("self")
		private String self;

		@SerializedName("git")
		@JsonProperty("git")
		private String git;

		@SerializedName("html")
		@JsonProperty("html")
		private String html;
	}
}
