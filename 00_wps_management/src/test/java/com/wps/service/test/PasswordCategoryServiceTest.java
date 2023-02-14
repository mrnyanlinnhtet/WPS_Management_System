package com.wps.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wps.model.dto.input.PasswordCategoryForm;
import com.wps.model.service.PasswordCategoryService;

@SpringJUnitConfig(locations = "/root-config.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PasswordCategoryServiceTest {

	@Autowired
	private PasswordCategoryService service;

	@Order(1)
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@ParameterizedTest
	@CsvSource({ "0,Desktop Password,3" })
	void save_test(int id, String name, int count) {

		var form = new PasswordCategoryForm(id, name);
		var result = service.save(form);

		assertEquals(count, result);
	}

	@Order(2)
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@ParameterizedTest
	@CsvSource({ "1,Website Passwords,1" })
	void update_test(int id, String name, int count) {

		var form = new PasswordCategoryForm(id, name);
		var result = service.save(form);

		assertEquals(count, result);

	}
	
	

}
