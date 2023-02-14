package com.wps.model.service;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.wps.model.dto.input.PasswordCategoryForm;
import com.wps.model.dto.mapper.PasswordCategory;

@Service
public class PasswordCategoryService {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	private BeanPropertyRowMapper<PasswordCategory> mapper;

	public PasswordCategoryService(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("password_categories");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("name"));

		template = new NamedParameterJdbcTemplate(dataSource);
		mapper = new BeanPropertyRowMapper<PasswordCategory>(PasswordCategory.class);
	}

	public PasswordCategory findCateogryById(int categoryId) {
		final String SELECT_CATEGORY = "SELECT * FROM password_categories WHERE id = :id";

		var param = new HashMap<String, Object>();
		param.put("id", categoryId);
		return template.queryForObject(SELECT_CATEGORY, param, mapper);
	}

	public int save(PasswordCategoryForm form) {
		if (form.getId() == 0) {
			return saveCategory(form);
		}
		return updateCategory(form);
	}

	private int saveCategory(PasswordCategoryForm form) {
		var param = new HashMap<String, Object>();
		param.put("name", form.getName());
		return insert.executeAndReturnKey(param).intValue();
	}

	private int updateCategory(PasswordCategoryForm form) {
		final String UPDATE_CATEGORY = "UPDATE password_categories SET name = :name WHERE id = :id";
		var params = new HashMap<String, Object>();
		params.put("name", form.getName());
		params.put("id", form.getId());
		return template.update(UPDATE_CATEGORY, params);
	}

	public int delete(int categoryId) {
		final String DELETE_CATEGORY = "DELETE FROM password_categories WHERE id = :id";
		var param = new HashMap<String, Object>();
		param.put("id", categoryId);
		return template.update(DELETE_CATEGORY, param);
	}


}
