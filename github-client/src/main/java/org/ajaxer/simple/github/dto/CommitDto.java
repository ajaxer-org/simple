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

import java.util.List;

/**
 * @author Shakir Ansari
 * @since 2024-08-17
 */
@Data
public class CommitDto
{
	@SerializedName("url")
	@JsonProperty("url")
	private String url;

	@SerializedName("sha")
	@JsonProperty("sha")
	private String sha;

	@SerializedName("node_id")
	@JsonProperty("node_id")
	private String nodeId;

	@SerializedName("html_url")
	@JsonProperty("html_url")
	private String htmlUrl;

	@SerializedName("comments_url")
	@JsonProperty("comments_url")
	private String commentsUrl;

	@SerializedName("commit")
	@JsonProperty("commit")
	private Commit commit;

	@SerializedName("author")
	@JsonProperty("author")
	private User author;

	@SerializedName("committer")
	@JsonProperty("committer")
	private User committer;

	@SerializedName("parents")
	@JsonProperty("parents")
	private List<Parent> parents;

	@Data
	public static class Commit
	{
		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("author")
		@JsonProperty("author")
		private Author author;

		@SerializedName("committer")
		@JsonProperty("committer")
		private Author committer;

		@SerializedName("message")
		@JsonProperty("message")
		private String message;

		@SerializedName("tree")
		@JsonProperty("tree")
		private Tree tree;

		@SerializedName("comment_count")
		@JsonProperty("comment_count")
		private int commentCount;

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
	public static class User
	{
		@SerializedName("login")
		@JsonProperty("login")
		private String login;

		@SerializedName("id")
		@JsonProperty("id")
		private int id;

		@SerializedName("node_id")
		@JsonProperty("node_id")
		private String nodeId;

		@SerializedName("avatar_url")
		@JsonProperty("avatar_url")
		private String avatarUrl;

		@SerializedName("gravatar_id")
		@JsonProperty("gravatar_id")
		private String gravatarId;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("html_url")
		@JsonProperty("html_url")
		private String htmlUrl;

		@SerializedName("followers_url")
		@JsonProperty("followers_url")
		private String followersUrl;

		@SerializedName("following_url")
		@JsonProperty("following_url")
		private String followingUrl;

		@SerializedName("gists_url")
		@JsonProperty("gists_url")
		private String gistsUrl;

		@SerializedName("starred_url")
		@JsonProperty("starred_url")
		private String starredUrl;

		@SerializedName("subscriptions_url")
		@JsonProperty("subscriptions_url")
		private String subscriptionsUrl;

		@SerializedName("organizations_url")
		@JsonProperty("organizations_url")
		private String organizationsUrl;

		@SerializedName("repos_url")
		@JsonProperty("repos_url")
		private String reposUrl;

		@SerializedName("events_url")
		@JsonProperty("events_url")
		private String eventsUrl;

		@SerializedName("received_events_url")
		@JsonProperty("received_events_url")
		private String receivedEventsUrl;

		@SerializedName("type")
		@JsonProperty("type")
		private String type;

		@SerializedName("site_admin")
		@JsonProperty("site_admin")
		private boolean siteAdmin;
	}

	@Data
	public static class Tree
	{
		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("sha")
		@JsonProperty("sha")
		private String sha;
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

	@Data
	public static class Parent
	{
		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("sha")
		@JsonProperty("sha")
		private String sha;
	}
}
