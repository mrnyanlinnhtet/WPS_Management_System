package com.wps.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wps.model.dto.input.CategoryForm;
import com.wps.model.dto.input.WebsiteDataForm;
import com.wps.model.service.CategoryService;
import com.wps.model.service.WebsiteService;

@Controller
@RequestMapping("/website")
public class WebsiteController {

	@SuppressWarnings("unused")
	@Autowired
	private WebsiteService webService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String index(Optional<String>name,Optional<String>categoryName) {
		return "website";
	}
	
	@GetMapping("edit")
	public String editWebsite(Optional<Integer>id) {
		return "";
	}
	
	@GetMapping("delete")
	public String deleteWebsite(Optional<Integer>id) {
		return "";
	}
	
	@PostMapping
	public String saveWebsite(WebsiteDataForm form) {
		return "";
	}
	
	@GetMapping("category/edit")
	public String editCategory(Optional<Integer> categoryId) {
		return "";
	}
	
	@GetMapping("category/delete")
	public String deleteCategory(Optional<Integer>categoryId) {
		return "";
	}
	
	@PostMapping("categorySave")
	public String saveCategory(CategoryForm form) {
		return "";
	}
	
	
	
	
	
}
