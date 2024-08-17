package org.ajaxer.simple;

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

import lombok.Data;

import java.util.List;

/**
 * @author Shakir Ansari
 * @since 2024-08-17
 */
@Data
public class Commit
{
	private String url;
	private String sha;
	private String nodeId;
	private String htmlUrl;
	private String commentsUrl;
	private CommitDetails commit;
	private User author;
	private User committer;
	private List<Parent> parents;

	@Data
	public static class CommitDetails
	{
		private String url;
		private Person author;
		private Person committer;
		private String message;
		private Tree tree;
		private int commentCount;
		private Verification verification;
	}

	@Data
	public static class Person
	{
		private String name;
		private String email;
		private String date;
	}

	@Data
	public static class Tree
	{
		private String url;
		private String sha;
	}

	@Data
	public static class Verification
	{
		private boolean verified;
		private String reason;
		private String signature;
		private String payload;
	}

	@Data
	public static class User
	{
		private String login;
		private int id;
		private String nodeId;
		private String avatarUrl;
		private String gravatarId;
		private String url;
		private String htmlUrl;
		private String followersUrl;
		private String followingUrl;
		private String gistsUrl;
		private String starredUrl;
		private String subscriptionsUrl;
		private String organizationsUrl;
		private String reposUrl;
		private String eventsUrl;
		private String receivedEventsUrl;
		private String type;
		private boolean siteAdmin;
	}

	@Data
	public static class Parent
	{
		private String url;
		private String sha;
	}
}
