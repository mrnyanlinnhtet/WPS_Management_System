package com.wps.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordCategoryForm {
	
	private int id;
	private String name;
	
	public PasswordCategoryForm() {
		
	}

	public PasswordCategoryForm(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
