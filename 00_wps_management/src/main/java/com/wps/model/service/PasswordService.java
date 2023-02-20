package com.wps.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wps.model.dto.input.PasswordForm;
import com.wps.model.dto.output.PasswordListVO;

@Service
public class PasswordService {

	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insert;
	private BeanPropertyRowMapper<PasswordListVO> mapper;

	private final String PROJECTION = """
			SELECT c.name,p.name,p.username,p.password,p.description FROM passwords p
			         JOIN password_categories c
			         ON c.id = p.password_categories_id WHERE 1=1
			""";

	public PasswordService(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setGeneratedKeyName("id");
		insert.setTableName("passwords");
		insert.setColumnNames(List.of("name", "username", "password", "description", "password_categories_id"));

		template = new NamedParameterJdbcTemplate(dataSource);
		mapper = new BeanPropertyRowMapper<PasswordListVO>(PasswordListVO.class);
	}

	public List<PasswordListVO> search(Optional<String> name, Optional<String> username, Optional<String> category) {
		var and = new StringBuilder(PROJECTION);
		var params = new HashMap<String, Object>();

		and.append(name.filter(StringUtils::hasLength).map(a -> {
			params.put("name", a.toLowerCase().concat("%"));
			return " AND p.name LIKE :name";
		}).orElse(""));

		and.append(username.filter(StringUtils::hasLength).map(a -> {
			params.put("username", a.toLowerCase().concat("%"));
			return " AND p.username LIKE :username";
		}).orElse(""));

		and.append(category.filter(StringUtils::hasLength).map(a -> {
			params.put("category", a.concat("%"));
			return " AND c.name LIKE :category";
		}).orElse(""));

		return template.query(and.toString(), params, mapper);
	}

	public PasswordListVO findPasswordById(int id) {
		final String PASSWORDS = "SELECT * FROM passwords WHERE id = :id";
		var param = new HashMap<String, Object>();
		param.put("id", id);

		return template.queryForObject(PASSWORDS, param, mapper);
	}

	public int deletePasssword(int id) {
		final String DELETE = "DELETE FROM passwords WHERE id = :id";
		var param = new HashMap<String, Object>();
		param.put("id", id);

		return template.update(DELETE, param);
	}

	public int savePassword(PasswordForm form) {
		return 0;
	}

}
