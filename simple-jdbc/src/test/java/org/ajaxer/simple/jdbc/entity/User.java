package org.ajaxer.simple.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shakir
 * @version 2022-11-14
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User
{
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "full_name")
	private String fullName;
}
