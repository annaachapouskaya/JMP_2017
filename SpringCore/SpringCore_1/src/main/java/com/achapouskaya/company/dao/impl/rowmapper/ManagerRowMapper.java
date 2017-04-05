package com.achapouskaya.company.dao.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.dao.impl.DatabaseConstants;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.Manager;

public class ManagerRowMapper implements CommonRowMapper<Manager> {
	
	private EmployeeRowMapper employeeRowMapper;
	
	public EmployeeRowMapper getEmployeeRowMapper() {
		return employeeRowMapper;
	}

	public void setEmployeeRowMapper(EmployeeRowMapper employeeRowMapper) {
		this.employeeRowMapper = employeeRowMapper;
	}

	public Manager mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = employeeRowMapper.mapRow(rs, arg1);
		Manager manager = new Manager();
		
		manager.setAge(employee.getAge());
		manager.setBirthDate(employee.getBirthDate());
		manager.setEnglishLevel(employee.getEnglishLevel());
		manager.setId(employee.getId());
		manager.setJobFunction(employee.getJobFunction());
		manager.setLevel(employee.getLevel());
		manager.setName(employee.getName());
		
		manager.setProjectName(rs.getString(DatabaseConstants.PROJECT_NAME_FIELD_NAME));
		manager.setType(rs.getString(DatabaseConstants.TYPE_FIED_NAME));
		
		return manager;
	}

	public MapSqlParameterSource prepareEmployeeParameters(Manager employee) {
		MapSqlParameterSource params = employeeRowMapper.prepareEmployeeParameters(employee);
		params.addValue(DatabaseConstants.PROJECT_NAME_FIELD_NAME, employee.getProjectName())
			  .addValue(DatabaseConstants.TYPE_FIED_NAME, employee.getType());
		return params;
	}
	

}
