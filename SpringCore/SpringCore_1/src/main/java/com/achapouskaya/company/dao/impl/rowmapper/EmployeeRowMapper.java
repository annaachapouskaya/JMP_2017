package com.achapouskaya.company.dao.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.dao.impl.DatabaseConstants;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;
import com.achapouskaya.company.staff.skillmatrix.JobFunction;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setAge(rs.getInt(DatabaseConstants.AGE_FIELD_NAME));
		employee.setBirthDate(rs.getDate(DatabaseConstants.BIRTH_DATE_FIELD_NAME));
		employee.setEnglishLevel(LanguageLevel.valueOf(
			rs.getString(DatabaseConstants.ENGLISH_LEVEL_FIELD_NAME)));
		employee.setId(rs.getString(DatabaseConstants.ID_FIELD_NAME));
		employee.setJobFunction(JobFunction.valueOf(rs.getString(DatabaseConstants.JOB_FUNCTION_FIELD_NAME)));
		employee.setLevel(rs.getInt(DatabaseConstants.CAREER_LEVEL_FIELD_NAME));
		employee.setName(rs.getString(DatabaseConstants.NAME_FIELD_NAME));
		return employee;
	}

	public MapSqlParameterSource prepareEmployeeParameters(Employee employee) {
		return new MapSqlParameterSource(DatabaseConstants.ID_FIELD_NAME, employee.getId())
				.addValue(DatabaseConstants.NAME_FIELD_NAME, employee.getName())
				.addValue(DatabaseConstants.JOB_FUNCTION_FIELD_NAME, employee.getJobFunction().toString())
				.addValue(DatabaseConstants.BIRTH_DATE_FIELD_NAME, employee.getBirthDate())
				.addValue(DatabaseConstants.AGE_FIELD_NAME, employee.getAge())
				.addValue(DatabaseConstants.ENGLISH_LEVEL_FIELD_NAME, employee.getEnglishLevel().toString())
				.addValue(DatabaseConstants.CAREER_LEVEL_FIELD_NAME, employee.getLevel());
	}

}
