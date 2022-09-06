package org.ajaxer.simple.utils.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Shakir
 * @version 2022-08-30
 * @since v0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable
{
	private String name;
	private String email;
	private String uuid;
}
