package org.ajaxer.simple.utils.encoders;

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

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public interface Encoder
{
	/**
	 * @since v0.0.1
	 */
	String INVALID_ENCRYPTION_FORMAT = "Invalid encryption format";

	/**
	 * @since v0.0.1
	 */
	String encode(String message);

	/**
	 * @since v0.0.1
	 */
	String decode(String message);
}
