package com.wps.model.service;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wps.model.dto.input.CategoryForm;
import com.wps.model.dto.mapper.WebsiteCategory;

@Service
public class CategoryService {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	private BeanPropertyRowMapper<WebsiteCategory> mapper;

	public CategoryService(DataSource datasource) {
		insert = new SimpleJdbcInsert(datasource);
		insert.setTableName("website_categories");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("name"));

		template = new NamedParameterJdbcTemplate(datasource);
		mapper = new BeanPropertyRowMapper<WebsiteCategory>(WebsiteCategory.class);
	}

	// Find By Id Process
	public WebsiteCategory findCategoryById(int id) {
		final String SELECT_SQL = "SELECT * FROM website_categories WHERE id = :id";
		var param = new HashMap<String, Object>();
		param.put("id", id);
		return template.queryForObject(SELECT_SQL, param, mapper);
	}

	// Save Process
	@Transactional
	public int save(CategoryForm form) {
		if (form.getId() == 0 || form.getId() < 1) {
			return saveCategory(form);
		}
		return updateCategory(form);
	}

	// Delete Process
	@Transactional
	public int deleteCategory(int id) {
		final String DELETE_SQL = "DELETE FROM website_categories WHERE id = :id";

		var param = new HashMap<String, Object>();
		param.put("id", id);
		return template.update(DELETE_SQL, param);
	}

	private int updateCategory(CategoryForm form) {
		final String UPDATE_SQL = "UPDATE website_categories SET name = :name WHERE id = :id";

		var params = new HashMap<String, Object>();
		params.put("name", form.getName());
		params.put("id", form.getId());
		return template.update(UPDATE_SQL, params);
	}

	
	private int saveCategory(CategoryForm form) {
		var param = new HashMap<String, Object>();
		param.put("name", form.getName());
		return insert.executeAndReturnKey(param).intValue();
	}
}
