package com.wps.model.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordListVO {
    public int id;
	public String name;
	public String username;
	public String password;
	public String description;
	
	public PasswordListVO() {
		
	}
}
