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

import lombok.extern.slf4j.Slf4j;
import org.ajaxer.simple.github.GitHubAuth;
import org.ajaxer.simple.github.GitHubClient;
import org.ajaxer.simple.github.dto.CommitDto;
import org.ajaxer.simple.github.dto.RepositoryDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.List;

@Slf4j
public class GitHubClientTest
{
	private GitHubAuth auth = new GitHubAuth(
			System.getenv("PERSONAL_ACCESS_TOKEN"),
			System.getenv("GITHUB_USERNAME"),
			System.getenv("REPOSITORY"));


	private final GitHubClient gitHubClient = new GitHubClient(auth, HttpClient.newHttpClient());

	@Test
	void getAllCommits()
	{
		List<CommitDto> allCommitDtos = gitHubClient.getAllCommits();
		Assertions.assertThat(allCommitDtos).isNotNull();

		allCommitDtos.forEach(System.out::println);
	}

	@Test
	void createRepository()
	{
		long millis = System.currentTimeMillis();
		log.info("millis = {}", millis);

		RepositoryDto requestDto = new RepositoryDto();
		requestDto.setPrivate(false);
		requestDto.setTemplate(false);
		requestDto.setName("test-repository-" + millis);
		requestDto.setDescription("test-repository-description-" + millis);
		log.info("requestDto = {}", requestDto);

		RepositoryDto responseDto = gitHubClient.createRepository(requestDto);
		log.info("responseDto = {}", responseDto);

		Assertions.assertThat(responseDto).isNotNull();
		Assertions.assertThat(responseDto.getId()).isGreaterThan(0);
		Assertions.assertThat(responseDto.isPrivate()).isFalse();
		Assertions.assertThat(responseDto.isTemplate()).isFalse();
		Assertions.assertThat(responseDto.getName()).isNotNull().isEqualTo("test-repository-" + millis);
		Assertions.assertThat(responseDto.getDescription()).isNotNull().isEqualTo("test-repository-description-" + millis);
	}
}