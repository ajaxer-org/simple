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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.List;

public class GitHubUtilsTest
{
	private GitHubAuth auth = new GitHubAuth(
			System.getenv("PERSONAL_ACCESS_TOKEN"),
			System.getenv("GITHUB_USERNAME"),
			System.getenv("REPOSITORY"));

	private final GitHubUtils gitHubUtils = new GitHubUtils(auth, HttpClient.newHttpClient());

	@Test
	void getAllCommits()
	{
		List<Commit> allCommits = gitHubUtils.getAllCommits();
		Assertions.assertThat(allCommits).isNotNull();

		allCommits.forEach(System.out::println);
	}
}