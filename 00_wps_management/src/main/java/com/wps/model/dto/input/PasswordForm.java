package com.wps.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordForm {

	public String name;
	public String username;
	public String password;
	public String description;
	
	public PasswordForm() {
		
	}
}
