package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import com.achapouskaya.company.dao.AutomationTesterDAO;
import com.achapouskaya.company.staff.AutomationTester;

public class SpringAutomationTesterDAO extends SpringEmployeeDAO<AutomationTester> implements AutomationTesterDAO {
	
	private static String CREATE_AUTO_TESTER_SQL = "INSERT INTO AUTOMATION_TESTER (ID, FRAMEWORK, LANGUAGE)"
			+ " VALUES (:ID, :FRAMEWORK, :LANGUAGE)";
	
	private static String DELETE_AUTOTESTER_SQL = "DELETE FROM AUTOMATION_TESTER WHERE ID=:ID";
	
	private static String GET_ALL_AUTOTESTERS_SQL = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME, EMPLOYEE.BIRTH_DATE,"
			+ " EMPLOYEE.AGE, JOB_FUNCTION.VALUE AS JOB_FUNCTION, LANGUAGE_LEVEL.VALUE AS ENGLISH_LEVEL,"
			+ " EMPLOYEE.CAREER_LEVEL, AUTOMATION_TESTER.FRAMEWORK, AUTOMATION_TESTER.LANGUAGE" 
			+ " FROM EMPLOYEE INNER JOIN JOB_FUNCTION ON EMPLOYEE.JOB_FUNCTION = JOB_FUNCTION.ID"
			+ " INNER JOIN LANGUAGE_LEVEL ON EMPLOYEE.ENGLISH_LEVEL = LANGUAGE_LEVEL.ID"
			+ " INNER JOIN AUTOMATION_TESTER ON EMPLOYEE.ID = AUTOMATION_TESTER.ID";
	
	private static String GET_AUTOTESTER_BY_ID_SQL = GET_ALL_AUTOTESTERS_SQL + " WHERE EMPLOYEE.ID=:ID";
	
	private static String UPDATE_AUTOTESTER_SQL = "UPDATE AUTOMATION_TESTER SET FRAMEWORK=:FRAMEWORK,"
			+ " LANGUAGE=:LANGUAGE WHERE ID=:ID";
			
	
	@Transactional
	public String create(AutomationTester employee) {
		employee.setId(super.create(employee));
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		this.namedParameterJdbcTemplate.update(CREATE_AUTO_TESTER_SQL, namedParameters);
		return employee.getId();
	}

	public AutomationTester get(String id) {
		return (AutomationTester) this.jdbcTemplate.queryForObject(GET_AUTOTESTER_BY_ID_SQL,
				new Object[] { id }, employeeRowMapper);
	}

	public List<AutomationTester> getAll() {
		return jdbcTemplate.query(GET_ALL_AUTOTESTERS_SQL, employeeRowMapper);
	}

	@Transactional
	public boolean update(AutomationTester employee) {
		boolean employeeUpdated = super.update(employee);
		
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		int numberOfUpdated = this.namedParameterJdbcTemplate.update(UPDATE_AUTOTESTER_SQL, namedParameters);
		if (numberOfUpdated == 1 && employeeUpdated) {
			return true;
		} else {
			return false;
		}
	}

	//Cascade delete is on
	@Transactional
	public boolean delete(String id) {
		boolean employeeDeleted = super.delete(id);
		this.jdbcTemplate.update(DELETE_AUTOTESTER_SQL, new Object[] { id });
		return employeeDeleted;
	}

}
