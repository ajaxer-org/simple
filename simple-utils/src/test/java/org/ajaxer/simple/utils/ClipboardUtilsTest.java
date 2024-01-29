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

import lombok.extern.log4j.Log4j2;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shakir
 * @version 2022-08-27
 * @since v0.0.1
 */
@Log4j2
class ClipboardUtilsTest
{
	private String backMsg = null;

	@BeforeEach
	public void setUp()
	{
		backMsg = ClipboardUtils.paste();
	}

	@AfterEach
	public void tearDown()
	{
		ClipboardUtils.copy(backMsg);
	}

	@Test
	void onCopyPasteEmptyString()
	{
		String source = "";
		ClipboardUtils.copy(source);
		String paste = ClipboardUtils.paste();
		MatcherAssert.assertThat(source, CoreMatchers.equalTo(paste));
	}

	@Test
	void onCopyPasteNullValue()
	{
		String source = null;
		ClipboardUtils.copy(source);
		String paste = ClipboardUtils.paste();
		MatcherAssert.assertThat(source, CoreMatchers.equalTo(paste));
	}

	@Test
	void onCopyPasteSomeLoremIpsum()
	{
		String source = StringUtils.getUUID();
		ClipboardUtils.copy(source);
		String paste = ClipboardUtils.paste();
		MatcherAssert.assertThat(source, CoreMatchers.equalTo(paste));
	}
}