package org.ajaxer.simple.github;

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

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.ajaxer.simple.github.dto.CommitDto;
import org.ajaxer.simple.github.dto.RepositoryDto;
import org.ajaxer.simple.utils.GsonUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * <a href="https://docs.github.com/en/rest/repos/contents?apiVersion=2022-11-28">GitHub Docs</a>
 *
 * @author Shakir Ansari
 * @since 2024-08-17
 */
@RequiredArgsConstructor
public class GitHubClient
{
	private final static String BASE_URL = "https://api.github.com";

	final private GitHubAuth gitHubAuth;
	final private HttpClient httpClient;

	private HttpRequest.Builder getBuilder(String url)
	{
		return HttpRequest.newBuilder()
		                  .uri(URI.create(url))
		                  .header("X-GitHubDto-Api-Version", GitHubAuth.HEADER_API_VERSION)
		                  .header("Accept", GitHubAuth.HEADER_ACCEPT)
		                  .header("Authorization", "Bearer " + gitHubAuth.getPersonalAccessToken());
	}

	private HttpRequest.BodyPublisher getBodyPublisher(Object requestBody)
	{
		String jsonRequestBody = GsonUtils.toJsonString(requestBody);
		return HttpRequest.BodyPublishers.ofString(jsonRequestBody);
	}

	/**
	 * ${base_url}/repos/{owner}/{repo}/commits
	 *
	 * @apiNote <a href="https://docs.github.com/en/rest/commits/commits?apiVersion=2022-11-28#list-commits">GitHub Docs</a>
	 * @implSpec The fine-grained token must have the following permission set: "Contents" repository permissions (read)
	 */
	@SneakyThrows
	public List<CommitDto> getAllCommits()
	{
		String url = BASE_URL + "/repos/" + gitHubAuth.getUsername() + "/" + gitHubAuth.getRepository() + "/commits";

		HttpRequest request = getBuilder(url).GET().build();

		HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		return GsonUtils.toObjectList(httpResponse.body(), CommitDto.class);
	}

	/**
	 * ${base_url}/user/repos
	 *
	 * @apiNote <a href="https://docs.github.com/en/rest/repos/repos?apiVersion=2022-11-28#create-a-repository-for-the-authenticated-user">GitHub Docs</a>
	 * @implSpec The fine-grained token must have the following permission set: "Administration" repository permissions (write)
	 */
	@SneakyThrows
	public RepositoryDto createRepository(final RepositoryDto requestDto)
	{
		String url = BASE_URL + "/user/repos";

		HttpRequest request = getBuilder(url).POST(getBodyPublisher(requestDto)).build();

		HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		return GsonUtils.toObject(httpResponse.body(), RepositoryDto.class);
	}

	/**
	 * ${base_url}/repos/{owner}/{repo}/contents/{path}
	 *
	 * @apiNote <a href="https://docs.github.com/en/rest/repos/contents?apiVersion=2022-11-28#get-repository-content">GitHub Docs</a>
	 * @implSpec The fine-grained token must have the following permission set: "Contents" repository permissions (read)
	 */
	public void getContent(String filePath)
	{
		String url = BASE_URL + "/repos/" + gitHubAuth.getUsername() + "/" + gitHubAuth.getRepository() + "/contents/" + filePath;

		//		HttpRequest request = getBuilder(url).POST(getBodyPublisher(requestDto)).build();
	}
}
