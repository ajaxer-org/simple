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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Shakir Ansari
 * @since 2024-08-17
 */
@Getter
@RequiredArgsConstructor
public class GitHubAuth
{
	public static final String HEADER_ACCEPT = "application/vnd.github+json";
	public static final String HEADER_API_VERSION = "2022-11-28";
	/**
	 * GitHub personal access token
	 */
	final private String personalAccessToken;

	/**
	 * GitHub username
	 */
	final private String username;

	/**
	 * GitHub repository
	 */
	final private String repository;
}
