package org.ajaxer.simple.jdbc;

/**
 * @author Shakir
 * @version 2022-10-26
 * @since 0.0.3
 */
public class Application
{
	/**
	 * @since v0.0.2
	 */
	public static void main(String[] args)
	{
		System.out.println(Application.class.getName());
		System.out.println("v" + Application.class.getPackage().getImplementationVersion());
	}
}
