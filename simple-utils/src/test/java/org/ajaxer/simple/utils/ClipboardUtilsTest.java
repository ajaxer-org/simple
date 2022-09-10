package org.ajaxer.simple.utils;

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