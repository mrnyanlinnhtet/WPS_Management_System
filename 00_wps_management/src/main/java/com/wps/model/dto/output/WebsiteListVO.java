package com.wps.model.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteListVO {

	private int id;
	private String name;
	private String link;
	private String category;
	private String description;
	
	public WebsiteListVO() {
		
	}
}
