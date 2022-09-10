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
@NoArgsConstructor
@AllArgsConstructor
public class SerializedObject implements Serializable
{
	private String feild1;
	private String feild2;
}
