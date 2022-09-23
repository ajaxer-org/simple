package org.ajaxer.simple.utils;

/**
 * @author Shakir
 * @version 2022-08-22
 * @since v0.0.1
 */
public class Application
{
	/**
	 * @since v0.0.1
	 */
	public static void main(String[] args)
	{
		System.out.println(Application.class.getName());
		System.out.println("v" + Application.class.getPackage().getImplementationVersion());
	}
}
