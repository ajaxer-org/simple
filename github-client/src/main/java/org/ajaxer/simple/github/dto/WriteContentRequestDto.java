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

/**
 * @author Shakir Ansari
 * @since 2024-08-20
 */
@Data
public class WriteContentRequestDto
{
	/**
	 * Required if you are updating a file. The blob SHA of the file being replaced.
	 */
	@SerializedName("sha")
	@JsonProperty("sha")
	private String blobSha;

	@SerializedName("path")
	@JsonProperty("path")
	private String filePath;

	@SerializedName("message")
	@JsonProperty("message")
	private String commitMessage;

	@SerializedName("committer")
	@JsonProperty("committer")
	private CommitDto.Author committer;

	@SerializedName("content")
	@JsonProperty("content")
	private String content;
}
