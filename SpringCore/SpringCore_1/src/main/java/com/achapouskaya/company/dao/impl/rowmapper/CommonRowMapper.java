package com.achapouskaya.company.dao.impl.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.staff.Employee;

public interface CommonRowMapper<Entity extends Employee> extends RowMapper<Entity> {
	public MapSqlParameterSource prepareEmployeeParameters(Entity employee);
}
