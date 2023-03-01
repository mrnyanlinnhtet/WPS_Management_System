package com.wps.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wps.model.dto.input.PasswordForm;
import com.wps.model.service.PasswordService;

@SpringJUnitConfig(locations = "/root-config.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PasswordServiceTest {

	@Autowired
	private PasswordService service;

	@Order(1)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource({ "Git,,,1", ",Nyan,,2", ",,social,2" })
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
	void search_by_id_test(int id, String username) {

		var obj = service.findPasswordById(id);

		assertNotNull(obj);
		assertEquals(username, obj.getUsername());
	}

	@Order(3)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource("1,1")
	void delete_by_id_test(int id, int count) {

		var eff_count = service.deletePasssword(id);

		assertEquals(count, eff_count);
	}

	@Order(4)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource({ "0,mega,tony122,wheremypassword,2,My Mega Account,5",
			"4,youtubeupt,stark123upt,youtube1update,2,personalupt,1" })
	void save_and_update_test(int id, String name, String username, String password, int passwordCategoryId,
			String description, int effectiveCount) {

		var form = new PasswordForm(id, name, username, password, passwordCategoryId, description);
		var result = service.savePassword(form);

		assertEquals(result, effectiveCount);

	}

}
