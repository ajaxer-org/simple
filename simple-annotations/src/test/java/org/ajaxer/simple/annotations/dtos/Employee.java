package org.ajaxer.simple.annotations.dtos;

import org.ajaxer.simple.annotations.Builder;

/**
 * @author Shakir
 * @version 2022-09-18
 */
@Builder
public class Employee
{
	private String name;
	private int age;

	public Employee(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
}

