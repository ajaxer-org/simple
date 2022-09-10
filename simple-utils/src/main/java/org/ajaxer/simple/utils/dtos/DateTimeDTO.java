package org.ajaxer.simple.utils.dtos;

/**
 * @author Shakir
 * @version 2022-08-23
 * @since v0.0.1
 */
public class DateTimeDTO
{
	public long milliSeconds = 0;
	public long seconds = 0;
	public long minutes = 0;
	public long hours = 0;
	public long days = 0;

	/**
	 * @since v0.0.1
	 */
	@Override
	public String toString()
	{
		String response = "TimeDifference: ";

		response += days != 0 ? days + " days, " : "";
		response += hours != 0 ? hours + " hours, " : "";
		response += minutes != 0 ? minutes + " minutes, " : "";
		response += seconds != 0 ? seconds + " seconds, " : "";
		response += milliSeconds != 0 ? milliSeconds + " milliSeconds " : "";

		return response;
	}
}
