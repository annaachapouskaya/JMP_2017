package com.achapouskaya.company.dao.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.dao.impl.DatabaseConstants;
import com.achapouskaya.company.staff.AutomationTester;
import com.achapouskaya.company.staff.Employee;

public class AutomationTesterRowMapper implements CommonRowMapper<AutomationTester> {
	
	private EmployeeRowMapper employeeRowMapper;
	
	public void setEmployeeRowMapper(EmployeeRowMapper employeeRowMapper) {
		this.employeeRowMapper = employeeRowMapper;
	}

	public AutomationTester mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = employeeRowMapper.mapRow(rs, arg1);
		AutomationTester autoTester = new AutomationTester();
		
		autoTester.setAge(employee.getAge());
		autoTester.setBirthDate(employee.getBirthDate());
		autoTester.setEnglishLevel(employee.getEnglishLevel());
		autoTester.setId(employee.getId());
		autoTester.setJobFunction(employee.getJobFunction());
		autoTester.setLevel(employee.getLevel());
		autoTester.setName(employee.getName());
		
		autoTester.setFramework(rs.getString(DatabaseConstants.FRAMEWORK_FIELD_NAME));
		autoTester.setLanguage(rs.getString(DatabaseConstants.LANGUAGE_FIELD_NAME));
		
		return autoTester;
	}
	
	public MapSqlParameterSource prepareEmployeeParameters(AutomationTester tester) {
		MapSqlParameterSource params = employeeRowMapper.prepareEmployeeParameters(tester);
		params.addValue(DatabaseConstants.FRAMEWORK_FIELD_NAME, tester.getFramework())
			  .addValue(DatabaseConstants.LANGUAGE_FIELD_NAME, tester.getLanguage());
		return params;
	}

}
