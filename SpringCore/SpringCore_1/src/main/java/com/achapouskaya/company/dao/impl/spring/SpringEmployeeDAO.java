package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.dao.IEmployeeDAO;
import com.achapouskaya.company.staff.Employee;


public class SpringEmployeeDAO extends SpringCommonDAO implements IEmployeeDAO<Employee> {
	
	private static String GET_ALL_EMPLOYEES_SQL = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME,"
			+ " EMPLOYEE.BIRTH_DATE, EMPLOYEE.AGE, JOB_FUNCTION.VALUE AS JOB_FUNCTION,"
			+ " LANGUAGE_LEVEL.VALUE AS ENGLISH_LEVEL, EMPLOYEE.CAREER_LEVEL FROM EMPLOYEE"
			+ " INNER JOIN JOB_FUNCTION ON EMPLOYEE.JOB_FUNCTION = JOB_FUNCTION.ID"
			+ " INNER JOIN LANGUAGE_LEVEL ON EMPLOYEE.ENGLISH_LEVEL = LANGUAGE_LEVEL.ID";
	
	private static String CREATE_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE "
			+ "(ID, NAME, JOB_FUNCTION, BIRTH_DATE, AGE, ENGLISH_LEVEL, CAREER_LEVEL)"
			+ " VALUES (:ID, :NAME, (SELECT ID FROM JOB_FUNCTION WHERE VALUE=:JOB_FUNCTION), "
			+ " :BIRTH_DATE, :AGE, (SELECT ID FROM LANGUAGE_LEVEL WHERE VALUE=:ENGLISH_LEVEL), :CAREER_LEVEL)";
	
	private static String DELETE_EMPLOYEE_SQL = "DELETE FROM EMPLOYEE WHERE ID=:ID";
	
	private static String GET_EMPLOYEE_BY_ID_SQL = GET_ALL_EMPLOYEES_SQL + " WHERE EMPLOYEE.ID=:ID";
	
	private static String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET"
			+ " NAME = :NAME, JOB_FUNCTION = (SELECT ID FROM JOB_FUNCTION WHERE VALUE = :JOB_FUNCTION),"
			+ " BIRTH_DATE=:BIRTH_DATE, AGE=:AGE,"
			+ " ENGLISH_LEVEL=(SELECT ID FROM LANGUAGE_LEVEL WHERE VALUE=:ENGLISH_LEVEL),"
			+ " CAREER_LEVEL=:CAREER_LEVEL WHERE ID=:ID";
	
		
	//private static String DELETE_EMPLOYEE = "DELETE"
		
	public String create(Employee employee) {
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		this.namedParameterJdbcTemplate.update(CREATE_EMPLOYEE_SQL, namedParameters);
		return employee.getId();
	}

	public Employee get(String id) {
		return (Employee) this.jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID_SQL,
				new Object[] { id }, employeeRowMapper);
	}

	public List<Employee> getAll() {
		return jdbcTemplate.query(GET_ALL_EMPLOYEES_SQL, employeeRowMapper);
	}

	public boolean update(Employee employee) {
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		int numberOfUpdated = this.namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_SQL, namedParameters);
		if (numberOfUpdated == 1) {
			return true;
		} else {
			return false;
		}	
	}

	public boolean delete(String id) {
		int numberOfDeleted = this.jdbcTemplate.update(DELETE_EMPLOYEE_SQL, new Object[] { id });
		if (numberOfDeleted == 1) {
			return true;
		} else {
			return false;
		}
	}
	


}
