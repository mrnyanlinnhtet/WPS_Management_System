package com.wps.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryForm {

	private int id;
	private String name;
	
	
	public CategoryForm() {
		
	}


	public CategoryForm(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	
	
	
}
