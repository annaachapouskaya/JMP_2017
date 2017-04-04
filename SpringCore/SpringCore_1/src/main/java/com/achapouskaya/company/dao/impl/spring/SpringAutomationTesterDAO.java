package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import com.achapouskaya.company.dao.IAutomationTesterDAO;
import com.achapouskaya.company.dao.impl.rowmapper.AutomationTesterRowMapper;
import com.achapouskaya.company.staff.AutomationTester;

public class SpringAutomationTesterDAO extends SpringCommonDAO implements IAutomationTesterDAO {
	
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
			
	private SpringEmployeeDAO employeeDAO;
	private AutomationTesterRowMapper autoTesterRowMapper;
		
	public SpringAutomationTesterDAO() {
		super();
		this.autoTesterRowMapper = new AutomationTesterRowMapper();
	}

	public void setEmployeeDAO(SpringEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public String create(AutomationTester employee) {
		employee.setId(employeeDAO.create(employee));
		MapSqlParameterSource namedParameters = this.autoTesterRowMapper.prepareAutomationTesterParameters(employee);
		this.namedParameterJdbcTemplate.update(CREATE_AUTO_TESTER_SQL, namedParameters);
		return employee.getId();
	}

	public AutomationTester get(String id) {
		return (AutomationTester) this.jdbcTemplate.queryForObject(GET_AUTOTESTER_BY_ID_SQL,
				new Object[] { id }, autoTesterRowMapper);
	}

	public List<AutomationTester> getAll() {
		return jdbcTemplate.query(GET_ALL_AUTOTESTERS_SQL, autoTesterRowMapper);
	}

	@Transactional
	public boolean update(AutomationTester employee) {
		boolean employeeUpdated = employeeDAO.update(employee);
		
		MapSqlParameterSource namedParameters = this.autoTesterRowMapper.prepareAutomationTesterParameters(employee);
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
		boolean employeeDeleted = this.employeeDAO.delete(id);
		this.jdbcTemplate.update(DELETE_AUTOTESTER_SQL, new Object[] { id });
		return employeeDeleted;
	}

}
