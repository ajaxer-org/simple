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
import org.ajaxer.simple.github.dto.*;
import org.ajaxer.simple.utils.Base64Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.net.http.HttpClient;
import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GitHubClientTest
{
	private String blobSha;
	private final String filePath = "folder/hello.txt";
	private static final String repositoryName = "test-github-client-repo";

	private static final GitHubAuth auth = new GitHubAuth(
			System.getenv("PERSONAL_ACCESS_TOKEN"),
			System.getenv("GITHUB_USERNAME"),
			repositoryName
	);

	private final GitHubClient gitHubClient = new GitHubClient(auth, HttpClient.newHttpClient());

	@BeforeEach
	void setUp()
	{
		Assertions.assertThat(auth).isNotNull();
		Assertions.assertThat(repositoryName).isNotNull();
		Assertions.assertThat(filePath).isNotNull();
	}

	@Test
	@Order(1)
	void createRepository()
	{
		long millis = System.currentTimeMillis();
		log.info("millis = {}", millis);

		RepositoryDto requestDto = new RepositoryDto();
		requestDto.setPrivate(false);
		requestDto.setTemplate(false);
		requestDto.setName(repositoryName);
		requestDto.setDescription("test-repository-description-" + millis);
		log.info("requestDto = {}", requestDto);

		RepositoryDto responseDto = gitHubClient.createRepository(requestDto);
		log.info("responseDto = {}", responseDto);

		Assertions.assertThat(responseDto).isNotNull();
		Assertions.assertThat(responseDto.getId()).isGreaterThan(0);
		Assertions.assertThat(responseDto.isPrivate()).isFalse();
		Assertions.assertThat(responseDto.isTemplate()).isFalse();
		Assertions.assertThat(responseDto.getName()).isNotNull().isEqualTo(repositoryName);
		Assertions.assertThat(responseDto.getDescription()).isNotNull().isEqualTo("test-repository-description-" + millis);
	}

	@Test
	@Order(20)
	void createContent()
	{
		WriteContentRequestDto dto = new WriteContentRequestDto();
		dto.setContent(Base64Utils.encode("test-content"));
		dto.setFilePath(filePath);
		dto.setCommitMessage("My Commit Message");

		CommitDto.Author committer = new CommitDto.Author();
		committer.setName("Octocat");
		committer.setEmail("octocat@github.com");
		dto.setCommitter(committer);

		WriteContentResponseDto writeContentResponseDto = gitHubClient.createContent(dto);
		Assertions.assertThat(writeContentResponseDto).isNotNull();

		Assertions.assertThat(writeContentResponseDto.getContent()).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getContent().getSha()).isNotNull();

		Assertions.assertThat(writeContentResponseDto.getCommit()).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getCommit().getMessage()).isNotNull().isEqualTo("My Commit Message");
		Assertions.assertThat(writeContentResponseDto.getCommit().getCommitter()).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getCommit().getCommitter().getName()).isNotNull().isEqualTo("Octocat");

		this.blobSha = writeContentResponseDto.getContent().getSha();
		log.info("blobSha = {}", this.blobSha);
	}

	@Test
	@Order(30)
	void readCreatedContent()
	{
		ContentDto contentDto = gitHubClient.readContent(filePath);
		log.info("contentDto = {}", contentDto);

		Assertions.assertThat(contentDto).isNotNull();

		log.info("contentDto.getContent() = {}", contentDto.getContent());

		log.info("contentDto.getContent().length = {}", contentDto.getContent().length());
		Assertions.assertThat(contentDto.getContent()).isNotNull();

		log.info("getContent = {}", contentDto.getContent());
		log.info("getFilteredContent = {}", contentDto.getFilteredContent());

		String decoded = Base64Utils.decode(contentDto.getFilteredContent());
		log.info("decoded: {}", decoded);
		Assertions.assertThat(decoded).isNotNull().isEqualTo("test-content");
	}

	@Test
	@Order(40)
	void updateContent()
	{
		WriteContentRequestDto dto = new WriteContentRequestDto();
		dto.setBlobSha(blobSha);
		dto.setContent(Base64Utils.encode("test-content-updated"));
		dto.setFilePath(filePath);
		dto.setCommitMessage("My New Commit Message");

		CommitDto.Author committer = new CommitDto.Author();
		committer.setName("Octocat");
		committer.setEmail("octocat@github.com");
		dto.setCommitter(committer);

		WriteContentResponseDto writeContentResponseDto = gitHubClient.updateContent(dto);
		Assertions.assertThat(writeContentResponseDto).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getCommit()).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getCommit().getMessage()).isNotNull().isEqualTo("My New Commit Message");
		Assertions.assertThat(writeContentResponseDto.getCommit().getCommitter()).isNotNull();
		Assertions.assertThat(writeContentResponseDto.getCommit().getCommitter().getName()).isNotNull().isEqualTo("Octocat");
	}

	@Test
	@Order(50)
	void readUpdatedContent()
	{
		ContentDto contentDto = gitHubClient.readContent(filePath);
		log.info("contentDto = {}", contentDto);

		Assertions.assertThat(contentDto).isNotNull();

		log.info("contentDto.getContent() = {}", contentDto.getContent());

		log.info("contentDto.getContent().length = {}", contentDto.getContent().length());
		Assertions.assertThat(contentDto.getContent()).isNotNull();

		log.info("getContent = {}", contentDto.getContent());
		log.info("getFilteredContent = {}", contentDto.getFilteredContent());

		String decoded = Base64Utils.decode(contentDto.getFilteredContent());
		log.info("decoded: {}", decoded);
		Assertions.assertThat(decoded).isNotNull().isEqualTo("test-content-updated");
	}

	@Test
	@Order(9990)
	void getAllCommits()
	{
		List<CommitDto> allCommitDtoList = gitHubClient.getAllCommits();
		log.info("allCommitDtoList: {}", allCommitDtoList);

		Assertions.assertThat(allCommitDtoList).isNotNull();

		allCommitDtoList.forEach(System.out::println);
	}

	@Test
	@Order(10000)
	void deleteRepository()
	{
		boolean deletedRepository = gitHubClient.deleteRepository(repositoryName);
		log.info("deletedRepository = {}", deletedRepository);
		Assertions.assertThat(deletedRepository).isTrue();
	}
}