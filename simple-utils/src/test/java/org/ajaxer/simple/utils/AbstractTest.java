package org.ajaxer.simple.utils;

import lombok.extern.log4j.Log4j2;

/**
 * @author Shakir
 * @version 2022-09-05
 * @since v0.0.1
 */
@Log4j2
public abstract class AbstractTest
{
	protected final String blankString1 = null;
	protected final String blankString2 = "";
	protected final String blankString3 = "   ";
	protected final String notBlankString = "ajaxer.org";
	protected final String key = "org.ajaxer";
}
