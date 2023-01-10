package com.wps.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wps.model.dto.input.PasswordForm;
import com.wps.model.dto.output.PasswordListVO;

@Service
public class PasswordService {

	public List<PasswordListVO>search(Optional<String>name,Optional<String>username,Optional<String>category){
		return null;
	}
	
	public PasswordForm findPasswordById(Optional<Integer>id) {
		return null;
	}
	
	public int savePassword(PasswordForm form) {
		return 0;
	}
	
	public int deletePasssword(Optional<Integer> id) {
		return 0;
	}
}
