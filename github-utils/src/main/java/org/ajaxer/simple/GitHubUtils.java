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

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
public class GitHubUtils
{
	private final static String BASE_URL = "https://api.github.com";

	final private GitHubAuth gitHubAuth;
	final private HttpClient httpClient;

	/**
	 * ${base_url}/repos/{owner}/{repo}/commits
	 *
	 * @return list of {@link Commit}
	 */
	@SneakyThrows
	public List<Commit> getAllCommits()
	{
		String url = BASE_URL + "/repos/" + gitHubAuth.getUsername() + "/" + gitHubAuth.getRepository() + "/commits";

		HttpRequest request = HttpRequest.newBuilder()
		                                 .uri(URI.create(url))
		                                 .header("X-GitHubDto-Api-Version", GitHubAuth.HEADER_API_VERSION)
		                                 .header("Accept", GitHubAuth.HEADER_ACCEPT)
		                                 .header("Authorization", "Bearer " + gitHubAuth.getPersonalAccessToken())
		                                 .GET()
		                                 .build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		return GsonUtils.toObjectList(response.body(), Commit.class);
	}
}
