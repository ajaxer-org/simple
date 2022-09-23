package org.ajaxer.simple.annotations;

/**
 * @author Shakir
 * @version 2022-09-18
 * @since 0.0.2
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