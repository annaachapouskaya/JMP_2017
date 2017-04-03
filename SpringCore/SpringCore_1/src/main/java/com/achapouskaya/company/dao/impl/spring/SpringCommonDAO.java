package com.achapouskaya.company.dao.impl.spring;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.achapouskaya.company.dao.impl.rowmapper.EmployeeRowMapper;

public class SpringCommonDAO {
	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;
	protected EmployeeRowMapper employeeRowMapper;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
		this.employeeRowMapper = new EmployeeRowMapper();
	}

}
