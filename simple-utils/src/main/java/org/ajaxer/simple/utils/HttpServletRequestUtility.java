package org.ajaxer.simple.utils;

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

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shakir Ansari
 * @since 2024-02-05
 */
public class HttpServletRequestUtility
{
	/**
	 * @since v0.2.1
	 */
	public static String getIpAddress(HttpServletRequest httpServletRequest)
	{
		String unknown = "unknown";

		String ip = httpServletRequest.getHeader("X-Forwarded-For");

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip))
			ip = httpServletRequest.getHeader("Proxy-Client-IP");

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip))
			ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip))
			ip = httpServletRequest.getHeader("HTTP_CLIENT_IP");

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip))
			ip = httpServletRequest.getHeader("HTTP_X_FORWARDED_FOR");

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip))
			ip = httpServletRequest.getRemoteAddr();

		return ip;
	}
}
