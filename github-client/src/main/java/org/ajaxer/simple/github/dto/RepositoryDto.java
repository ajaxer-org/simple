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

import java.util.List;

/**
 * @author Shakir Ansari
 * @since 2024-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RepositoryDto extends BaseDto
{
	@SerializedName("id")
	@JsonProperty("id")
	private long id;

	@SerializedName("node_id")
	@JsonProperty("node_id")
	private String nodeId;

	@SerializedName("name")
	@JsonProperty("name")
	private String name;

	@SerializedName("full_name")
	@JsonProperty("full_name")
	private String fullName;

	@SerializedName("owner")
	@JsonProperty("owner")
	private Owner owner;

	@SerializedName("private")
	@JsonProperty("private")
	private boolean isPrivate;

	@SerializedName("html_url")
	@JsonProperty("html_url")
	private String htmlUrl;

	@SerializedName("description")
	@JsonProperty("description")
	private String description;

	@SerializedName("fork")
	@JsonProperty("fork")
	private boolean fork;

	@SerializedName("url")
	@JsonProperty("url")
	private String url;

	@SerializedName("archive_url")
	@JsonProperty("archive_url")
	private String archiveUrl;

	@SerializedName("assignees_url")
	@JsonProperty("assignees_url")
	private String assigneesUrl;

	@SerializedName("blobs_url")
	@JsonProperty("blobs_url")
	private String blobsUrl;

	@SerializedName("branches_url")
	@JsonProperty("branches_url")
	private String branchesUrl;

	@SerializedName("collaborators_url")
	@JsonProperty("collaborators_url")
	private String collaboratorsUrl;

	@SerializedName("comments_url")
	@JsonProperty("comments_url")
	private String commentsUrl;

	@SerializedName("commits_url")
	@JsonProperty("commits_url")
	private String commitsUrl;

	@SerializedName("compare_url")
	@JsonProperty("compare_url")
	private String compareUrl;

	@SerializedName("contents_url")
	@JsonProperty("contents_url")
	private String contentsUrl;

	@SerializedName("contributors_url")
	@JsonProperty("contributors_url")
	private String contributorsUrl;

	@SerializedName("deployments_url")
	@JsonProperty("deployments_url")
	private String deploymentsUrl;

	@SerializedName("downloads_url")
	@JsonProperty("downloads_url")
	private String downloadsUrl;

	@SerializedName("events_url")
	@JsonProperty("events_url")
	private String eventsUrl;

	@SerializedName("forks_url")
	@JsonProperty("forks_url")
	private String forksUrl;

	@SerializedName("git_commits_url")
	@JsonProperty("git_commits_url")
	private String gitCommitsUrl;

	@SerializedName("git_refs_url")
	@JsonProperty("git_refs_url")
	private String gitRefsUrl;

	@SerializedName("git_tags_url")
	@JsonProperty("git_tags_url")
	private String gitTagsUrl;

	@SerializedName("git_url")
	@JsonProperty("git_url")
	private String gitUrl;

	@SerializedName("issue_comment_url")
	@JsonProperty("issue_comment_url")
	private String issueCommentUrl;

	@SerializedName("issue_events_url")
	@JsonProperty("issue_events_url")
	private String issueEventsUrl;

	@SerializedName("issues_url")
	@JsonProperty("issues_url")
	private String issuesUrl;

	@SerializedName("keys_url")
	@JsonProperty("keys_url")
	private String keysUrl;

	@SerializedName("labels_url")
	@JsonProperty("labels_url")
	private String labelsUrl;

	@SerializedName("languages_url")
	@JsonProperty("languages_url")
	private String languagesUrl;

	@SerializedName("merges_url")
	@JsonProperty("merges_url")
	private String mergesUrl;

	@SerializedName("milestones_url")
	@JsonProperty("milestones_url")
	private String milestonesUrl;

	@SerializedName("notifications_url")
	@JsonProperty("notifications_url")
	private String notificationsUrl;

	@SerializedName("pulls_url")
	@JsonProperty("pulls_url")
	private String pullsUrl;

	@SerializedName("releases_url")
	@JsonProperty("releases_url")
	private String releasesUrl;

	@SerializedName("ssh_url")
	@JsonProperty("ssh_url")
	private String sshUrl;

	@SerializedName("stargazers_url")
	@JsonProperty("stargazers_url")
	private String stargazersUrl;

	@SerializedName("statuses_url")
	@JsonProperty("statuses_url")
	private String statusesUrl;

	@SerializedName("subscribers_url")
	@JsonProperty("subscribers_url")
	private String subscribersUrl;

	@SerializedName("subscription_url")
	@JsonProperty("subscription_url")
	private String subscriptionUrl;

	@SerializedName("tags_url")
	@JsonProperty("tags_url")
	private String tagsUrl;

	@SerializedName("teams_url")
	@JsonProperty("teams_url")
	private String teamsUrl;

	@SerializedName("trees_url")
	@JsonProperty("trees_url")
	private String treesUrl;

	@SerializedName("clone_url")
	@JsonProperty("clone_url")
	private String cloneUrl;

	@SerializedName("mirror_url")
	@JsonProperty("mirror_url")
	private String mirrorUrl;

	@SerializedName("hooks_url")
	@JsonProperty("hooks_url")
	private String hooksUrl;

	@SerializedName("svn_url")
	@JsonProperty("svn_url")
	private String svnUrl;

	@SerializedName("homepage")
	@JsonProperty("homepage")
	private String homepage;

	@SerializedName("license")
	@JsonProperty("license")
	private License license;

	@SerializedName("language")
	@JsonProperty("language")
	private String language;

	@SerializedName("forks_count")
	@JsonProperty("forks_count")
	private int forksCount;

	@SerializedName("forks")
	@JsonProperty("forks")
	private int forks;

	@SerializedName("stargazers_count")
	@JsonProperty("stargazers_count")
	private int stargazersCount;

	@SerializedName("watchers_count")
	@JsonProperty("watchers_count")
	private int watchersCount;

	@SerializedName("watchers")
	@JsonProperty("watchers")
	private int watchers;

	@SerializedName("size")
	@JsonProperty("size")
	private int size;

	@SerializedName("default_branch")
	@JsonProperty("default_branch")
	private String defaultBranch;

	@SerializedName("open_issues_count")
	@JsonProperty("open_issues_count")
	private int openIssuesCount;

	@SerializedName("open_issues")
	@JsonProperty("open_issues")
	private int openIssues;

	@SerializedName("is_template")
	@JsonProperty("is_template")
	private boolean isTemplate;

	@SerializedName("topics")
	@JsonProperty("topics")
	private List<String> topics;

	@SerializedName("has_issues")
	@JsonProperty("has_issues")
	private boolean hasIssues;

	@SerializedName("has_projects")
	@JsonProperty("has_projects")
	private boolean hasProjects;

	@SerializedName("has_wiki")
	@JsonProperty("has_wiki")
	private boolean hasWiki;

	@SerializedName("has_pages")
	@JsonProperty("has_pages")
	private boolean hasPages;

	@SerializedName("has_downloads")
	@JsonProperty("has_downloads")
	private boolean hasDownloads;

	@SerializedName("archived")
	@JsonProperty("archived")
	private boolean archived;

	@SerializedName("disabled")
	@JsonProperty("disabled")
	private boolean disabled;

	@SerializedName("visibility")
	@JsonProperty("visibility")
	private String visibility;

	@SerializedName("pushed_at")
	@JsonProperty("pushed_at")
	private String pushedAt;

	@SerializedName("created_at")
	@JsonProperty("created_at")
	private String createdAt;

	@SerializedName("updated_at")
	@JsonProperty("updated_at")
	private String updatedAt;

	@SerializedName("permissions")
	@JsonProperty("permissions")
	private Permissions permissions;

	@SerializedName("allow_rebase_merge")
	@JsonProperty("allow_rebase_merge")
	private boolean allowRebaseMerge;

	@SerializedName("template_repository")
	@JsonProperty("template_repository")
	private TemplateRepository templateRepository;

	@Data
	private static class Owner
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
	private static class License
	{
		@SerializedName("key")
		@JsonProperty("key")
		private String key;

		@SerializedName("name")
		@JsonProperty("name")
		private String name;

		@SerializedName("spdx_id")
		@JsonProperty("spdx_id")
		private String spdxId;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;

		@SerializedName("node_id")
		@JsonProperty("node_id")
		private String nodeId;
	}

	@Data
	private static class Permissions
	{
		@SerializedName("admin")
		@JsonProperty("admin")
		private boolean admin;

		@SerializedName("maintain")
		@JsonProperty("maintain")
		private boolean maintain;

		@SerializedName("push")
		@JsonProperty("push")
		private boolean push;

		@SerializedName("triage")
		@JsonProperty("triage")
		private boolean triage;

		@SerializedName("pull")
		@JsonProperty("pull")
		private boolean pull;
	}

	@Data
	private static class TemplateRepository
	{
		@SerializedName("id")
		@JsonProperty("id")
		private long id;

		@SerializedName("node_id")
		@JsonProperty("node_id")
		private String nodeId;

		@SerializedName("name")
		@JsonProperty("name")
		private String name;

		@SerializedName("full_name")
		@JsonProperty("full_name")
		private String fullName;

		@SerializedName("owner")
		@JsonProperty("owner")
		private Owner owner;

		@SerializedName("private")
		@JsonProperty("private")
		private boolean isPrivate;

		@SerializedName("html_url")
		@JsonProperty("html_url")
		private String htmlUrl;

		@SerializedName("description")
		@JsonProperty("description")
		private String description;

		@SerializedName("fork")
		@JsonProperty("fork")
		private boolean fork;

		@SerializedName("url")
		@JsonProperty("url")
		private String url;
	}
}