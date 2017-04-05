package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.achapouskaya.company.dao.EmployeeDAO;
import com.achapouskaya.company.dao.impl.rowmapper.CommonRowMapper;
import com.achapouskaya.company.staff.Employee;


public class SpringEmployeeDAO<Entity extends Employee> implements EmployeeDAO<Entity> {
	
	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;
	protected CommonRowMapper<Entity> employeeRowMapper;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
		//this.employeeRowMapper = (CommonRowMapper<Entity>) new EmployeeRowMapper();
	}
	
	public void setEmployeeRowMapper(CommonRowMapper<Entity> employeeRowMapper) {
		this.employeeRowMapper = employeeRowMapper;
	}

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
	
	private static String GET_EMPLOYEES_FOR_MANAGER = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME, EMPLOYEE.BIRTH_DATE, EMPLOYEE.AGE,"
			+ " JOB_FUNCTION.VALUE AS JOB_FUNCTION, LANGUAGE_LEVEL.VALUE AS ENGLISH_LEVEL, EMPLOYEE.CAREER_LEVEL" 
			+ " FROM EMPLOYEE"
			+ " INNER JOIN JOB_FUNCTION ON EMPLOYEE.JOB_FUNCTION = JOB_FUNCTION.ID"
			+ " INNER JOIN LANGUAGE_LEVEL ON EMPLOYEE.ENGLISH_LEVEL = LANGUAGE_LEVEL.ID" 
			+ " INNER JOIN MANAGER_EMPLOYEE ON MANAGER_EMPLOYEE.EMPLOYEE_ID = EMPLOYEE.ID"
			+ " WHERE MANAGER_EMPLOYEE.MANAGER_ID = ?";
	
		
	//private static String DELETE_EMPLOYEE = "DELETE"
		
	public String create(Entity employee) {
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		this.namedParameterJdbcTemplate.update(CREATE_EMPLOYEE_SQL, namedParameters);
		return employee.getId();
	}

	public Entity get(String id) {
		return (Entity) this.jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID_SQL,
				new Object[] { id }, employeeRowMapper);
	}

	public List<Entity> getAll() {
		return (List<Entity>) jdbcTemplate.query(GET_ALL_EMPLOYEES_SQL, employeeRowMapper);
	}

	public boolean update(Entity employee) {
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		int numberOfUpdated = this.namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_SQL, namedParameters);
		if (numberOfUpdated == 1) {
			return true;
		} else {
			return false;
		}	
	}
	
	protected List<Entity> getEmployeesForManager(String id) {
		return (List<Entity>) jdbcTemplate.query(GET_EMPLOYEES_FOR_MANAGER, new Object[] {id}, employeeRowMapper);
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
