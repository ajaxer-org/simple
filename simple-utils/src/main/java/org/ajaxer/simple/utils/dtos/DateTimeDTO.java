package org.ajaxer.simple.utils.dtos;

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
public class DateTimeDTO
{
	public long milliSeconds = 0;
	public long seconds = 0;
	public long minutes = 0;
	public long hours = 0;
	public long days = 0;

	/**
	 * @since v0.0.1
	 */
	@Override
	public String toString()
	{
		String response = "TimeDifference: ";

		response += days != 0 ? days + " days, " : "";
		response += hours != 0 ? hours + " hours, " : "";
		response += minutes != 0 ? minutes + " minutes, " : "";
		response += seconds != 0 ? seconds + " seconds, " : "";
		response += milliSeconds != 0 ? milliSeconds + " milliSeconds " : "";

		return response;
	}
}
