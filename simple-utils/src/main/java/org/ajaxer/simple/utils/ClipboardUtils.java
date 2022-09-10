package org.ajaxer.simple.utils;

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
