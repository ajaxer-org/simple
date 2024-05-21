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

/**
 * @author Shakir Ansari
 * @since 2024-05-21
 */
@Log4j2
public class WindowsSoundUtils
{
	public static final String ASTERISK = "asterisk";
	public static final String CLOSE = "close";
	public static final String DEFAULT = "default";
	public static final String EXCLAMATION = "exclamation";
	public static final String EXIT = "exit";
	public static final String HAND = "hand";
	public static final String MAXIMIZE = "maximize";
	public static final String MENU_COMMAND = "menuCommand";
	public static final String MENU_POPUP = "menuPopup";
	public static final String MINIMIZE = "minimize";
	public static final String OPEN = "open";
	public static final String QUESTION = "question";
	public static final String RESTORE_DOWN = "restoreDown";
	public static final String RESTORE_UP = "restoreUp";
	public static final String START = "start";

	public static void alert()
	{
		alert(DEFAULT);
	}

	public static void alert(String soundName)
	{
		log.debug("playing sound: {}", soundName);

		final Runnable sound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound." + soundName);
		if (sound != null)
			new Thread(sound).start();
			//sound.run();
		SimpleUtils.sleep();
	}

	public static void main(String[] args)
	{
//		alert();
//		alert(ASTERISK);
//		alert(CLOSE);
//		alert(EXCLAMATION);
//		alert(EXIT);
//		alert(HAND);
//		alert(MAXIMIZE);
//		alert(MENU_COMMAND);
//		alert(MENU_POPUP);
//		alert(MINIMIZE);
//		alert(OPEN);
//		alert(QUESTION);
//		alert(RESTORE_DOWN);
//		alert(RESTORE_UP);
//		alert(START);
	}
}
