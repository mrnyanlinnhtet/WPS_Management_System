package com.wps.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordForm {

	private int id;
	private String name;
	private String username;
	private String password;
	private int passwordCategoryId;
	private String description;

	public PasswordForm() {

	}

	public PasswordForm(int id, String name, String username, String password, int passwordCategoryId,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.passwordCategoryId = passwordCategoryId;
		this.description = description;
	}

}
