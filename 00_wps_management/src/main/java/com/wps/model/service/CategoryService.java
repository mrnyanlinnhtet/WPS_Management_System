package com.wps.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wps.model.dto.input.WebsiteDataForm;
import com.wps.model.dto.output.WebsiteListVO;

@Service
public class CategoryService {

	public List<WebsiteListVO>search(Optional<String>name,Optional<String>categoryName){
		return null;
	}
	
	public WebsiteDataForm findWebsiteById(Optional<Integer> id) {
	 return null;	
	}
	
	public int save(WebsiteDataForm form) {
		return 0;
	}
	
	public int delete(Optional<Integer>id) {
		return 0;
	}
}
