package org.ajaxer.simple.annotations.dtos;

import org.ajaxer.simple.annotations.BuilderProperty;

/**
 * @author Shakir
 * @version 2022-09-23
 * @since 0.0.2
 */
public class Teacher
{
	private String name;
	private String subject;
	private String rollNumber;

	public String getName()
	{
		return name;
	}

	@BuilderProperty
	public void setName(String name)
	{
		this.name = name;
	}

	public String getSubject()
	{
		return subject;
	}

	@BuilderProperty
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getRollNumber()
	{
		return rollNumber;
	}

	@BuilderProperty
	public void setRollNumber(String rollNumber)
	{
		this.rollNumber = rollNumber;
	}
}
