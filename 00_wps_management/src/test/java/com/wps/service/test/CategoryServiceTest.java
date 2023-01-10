package com.wps.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wps.model.dto.input.CategoryForm;
import com.wps.model.dto.mapper.WebsiteCategory;
import com.wps.model.service.CategoryService;

@SpringJUnitConfig(locations = "/root-config.xml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryServiceTest {

	@Autowired
	private CategoryService service;

	@Order(1)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource("1,Foods")
	void find_by_id_test(int id, String name) {
		WebsiteCategory obj = service.findCategoryById(id);
		assertEquals(name, obj.getName());

	}

	@Order(2)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource({ "Fashions,0,3" })
	void save_test(String name, int id, int ex_id) {

		var form = new CategoryForm(id, name);
		var categoryId = service.save(form);

		assertEquals(ex_id, categoryId);
	}

	@Order(3)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource({ "Food,1,1" })
	void update_test(String name, int id, int ex_id) {

		var form = new CategoryForm(id, name);
		var effectiveCount = service.save(form);

		assertEquals(ex_id, effectiveCount);
	}

	@Order(4)
	@ParameterizedTest
	@Sql(scripts = { "/truncate.sql", "/insert.sql" })
	@CsvSource("1,1")
	void delete_test(int id, int ex_id) {

		var effectiveCount = service.deleteCategory(id);
		assertEquals(ex_id, effectiveCount);

	}

}
