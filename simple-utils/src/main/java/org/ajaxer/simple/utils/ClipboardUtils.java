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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
@Log4j2
public class ClipboardUtils
{
	private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	private ClipboardUtils() {}

	/**
	 * @since v0.0.1
	 */
	public static void copy(String string)
	{
		log.info("string: {}", string);
		clipboard.setContents(new StringSelection(string), null);
	}

	/**
	 * @since v0.0.1
	 */
	public static String paste()
	{
		DataFlavor flavor = DataFlavor.stringFlavor;
		if (clipboard.isDataFlavorAvailable(flavor))
		{
			try
			{
				return (String) ClipboardUtils.clipboard.getData(flavor);
			} catch (Exception exception)
			{
				log.error("Exception:", exception);
				ExceptionUtils.rethrow(exception);
			}
		}
		return null;
	}
}
