package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.achapouskaya.company.dao.IEmployeeDAO;
import com.achapouskaya.company.dao.impl.rowmapper.EmployeeRowMapper;
import com.achapouskaya.company.staff.Employee;


public class SpringEmployeeDAO<Entity extends Employee> extends SpringCommonDAO implements IEmployeeDAO<Employee> {
	
	private static String GET_ALL_EMPLOYEES_SQL = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME,"
			+ " EMPLOYEE.BIRTH_DATE, EMPLOYEE.AGE, JOB_FUNCTION.VALUE AS JOB_FUNCTION,"
			+ " LANGUAGE_LEVEL.VALUE AS ENGLISH_LEVEL, EMPLOYEE.CAREER_LEVEL FROM EMPLOYEE"
			+ " INNER JOIN JOB_FUNCTION ON EMPLOYEE.JOB_FUNCTION = JOB_FUNCTION.ID"
			+ " INNER JOIN LANGUAGE_LEVEL ON EMPLOYEE.ENGLISH_LEVEL = LANGUAGE_LEVEL.ID";
	
	private static String CREATE_EMPLOYEE = "INSERT INTO EMPLOYEE "
			+ "(ID, NAME, JOB_FUNCTION, BIRTH_DATE, AGE, ENGLISH_LEVEL, CAREER_LEVEL)"
			+ " VALUES (:ID, :NAME, (SELECT ID FROM JOB_FUNCTION WHERE VALUE=:JOB_FUNCTION), "
			+ " :BIRTH_DATE, :AGE, (SELECT ID FROM LANGUAGE_LEVEL WHERE VALUE=:ENGLISH_LEVEL), :CAREER_LEVEL)";
	
		
	//private static String DELETE_EMPLOYEE = "DELETE"
		
	public String create(Employee employee) {
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		this.namedParameterJdbcTemplate.update(CREATE_EMPLOYEE, namedParameters);
		return employee.getId();
	}

	public Entity get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAll() {
		return jdbcTemplate.query(GET_ALL_EMPLOYEES_SQL, employeeRowMapper);
	}

	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
