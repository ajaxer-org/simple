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
 * @since 2024-08-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WriteContentResponseDto extends BaseDto
{

	@SerializedName("content")
	@JsonProperty("content")
	private Content content;

	@SerializedName("commit")
	@JsonProperty("commit")
	private Commit commit;

	@Data
	public static class Content
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

		@SerializedName("_links")
		@JsonProperty("_links")
		private Links links;
	}

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

	@Data
	public static class Commit
	{
		@SerializedName("sha")
		@JsonProperty("sha")
		private String sha;

		@SerializedName("node_id")
		@JsonProperty("node_id")
		private String nodeId;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("html_url")
		@JsonProperty("html_url")
		private String htmlUrl;

		@SerializedName("author")
		@JsonProperty("author")
		private Author author;

		@SerializedName("committer")
		@JsonProperty("committer")
		private Committer committer;

		@SerializedName("tree")
		@JsonProperty("tree")
		private Tree tree;

		@SerializedName("message")
		@JsonProperty("message")
		private String message;

		@SerializedName("parents")
		@JsonProperty("parents")
		private Parent[] parents;

		@SerializedName("verification")
		@JsonProperty("verification")
		private Verification verification;
	}

	@Data
	public static class Author
	{
		@SerializedName("name")
		@JsonProperty("name")
		private String name;

		@SerializedName("email")
		@JsonProperty("email")
		private String email;

		@SerializedName("date")
		@JsonProperty("date")
		private String date;
	}

	@Data
	public static class Committer
	{
		@SerializedName("name")
		@JsonProperty("name")
		private String name;

		@SerializedName("email")
		@JsonProperty("email")
		private String email;

		@SerializedName("date")
		@JsonProperty("date")
		private String date;
	}

	@Data
	public static class Tree
	{
		@SerializedName("sha")
		@JsonProperty("sha")
		private String sha;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;
	}

	@Data
	public static class Parent
	{
		@SerializedName("sha")
		@JsonProperty("sha")
		private String sha;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("html_url")
		@JsonProperty("html_url")
		private String htmlUrl;
	}

	@Data
	public static class Verification
	{
		@SerializedName("verified")
		@JsonProperty("verified")
		private boolean verified;

		@SerializedName("reason")
		@JsonProperty("reason")
		private String reason;

		@SerializedName("signature")
		@JsonProperty("signature")
		private String signature;

		@SerializedName("payload")
		@JsonProperty("payload")
		private String payload;
	}
}


