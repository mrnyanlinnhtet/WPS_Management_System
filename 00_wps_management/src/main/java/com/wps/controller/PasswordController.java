package com.wps.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wps.model.dto.input.PasswordForm;
import com.wps.model.service.PasswordService;

@Controller
@RequestMapping("/passowrd")
public class PasswordController {
     
	@SuppressWarnings("unused")
	@Autowired
	 private PasswordService service;
	
	@GetMapping
	public String index(Optional<String>name,Optional<String>username) {
		return "";
	}
	
	@GetMapping("edit")
	public String editPassword(Optional<Integer>id) {
		return "";
	}
	
	@GetMapping("delete")
	public String deletePassword(Optional<Integer>id) {
		return "";
	}
	
	@PostMapping
	public String savePassword(PasswordForm form) {
		return "";
	}
}
