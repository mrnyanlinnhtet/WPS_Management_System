package com.wps.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wps.model.service.PasswordService;

@SpringJUnitConfig(locations = "/root-config.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PasswordServiceTest {

	@Autowired
	private PasswordService service;

	@Order(1)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource({ "git,,,1", ",nyan,,2", ",,Social,2" })
	void search_test(String name, String username, String category, int count) {

		var result = service.search(Optional.ofNullable(name), Optional.ofNullable(username),
				Optional.ofNullable(category));

		assertNotNull(result);
		assertEquals(count, result.size());
	}

	@Order(2)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource("1,mrnyanlinnhtet13")
	void search_by_id(int id, String username) {

		var obj = service.findPasswordById(id);

		assertNotNull(obj);
		assertEquals(username, obj.getUsername());
	}

	@Order(3)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource("1,1")
	void delete_by_id(int id, int count) {

		var eff_count = service.deletePasssword(id);

		assertEquals(count, eff_count);
	}

}
