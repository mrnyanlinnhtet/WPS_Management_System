package com.wps.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteDataForm {
	
	private String name;
	private String link;
	private String category;
	private String description;
	
	public WebsiteDataForm() {
		
	}
	
}
