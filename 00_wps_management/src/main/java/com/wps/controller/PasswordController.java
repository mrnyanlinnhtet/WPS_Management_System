package com.wps.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wps.model.dto.input.PasswordCategoryForm;
import com.wps.model.dto.input.PasswordForm;
import com.wps.model.service.PasswordCategoryService;
import com.wps.model.service.PasswordService;

@Controller
@RequestMapping("/passowrd")
public class PasswordController {

	@SuppressWarnings("unused")
	@Autowired
	private PasswordService service;
	@SuppressWarnings("unused")
	@Autowired
	private PasswordCategoryService categoryService;

	@GetMapping
	public String index(Optional<String> name, Optional<String> username) {
		return "password";
	}

	@GetMapping("edit")
	public String editPassword(Optional<Integer> id) {
		return "";
	}

	@GetMapping("delete")
	public String deletePassword(Optional<Integer> id) {
		return "";
	}

	@PostMapping
	public String savePassword(PasswordForm form) {
		return "";
	}

	@PostMapping("category/save")
	public String savePasswordCategory(PasswordCategoryForm form) {
		return "";
	}

	@GetMapping("/category/edit")
	public String editCategory(Optional<Integer> categoryId) {
		return "";
	}

	@GetMapping("/category/delete")
	public String deleteCategory(Optional<Integer> categoryId) {
		return "";
	}
}
