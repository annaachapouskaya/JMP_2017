package com.achapouskaya.company.dao.impl.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.achapouskaya.company.dao.ManagerDAO;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.Manager;

public class SpringManagerDAO extends SpringEmployeeDAO<Manager> implements ManagerDAO {
	private static String CREATE_MANAGER_SQL = "INSERT INTO MANAGER (ID, TYPE, PROJECT_NAME) "
			+ "VALUES (:ID, :TYPE, :PROJECT_NAME)";
	
	private static String CONNECT_MANAGER_WITH_EMPLOYEE_SQL = "INSERT INTO MANAGER_EMPLOYEE (MANAGER_ID, EMPLOYEE_ID) "
			+ "VALUES (?, ?)";
	
	private static String GET_ALL_MANAGERS_SQL = "SELECT EMPLOYEE.ID, EMPLOYEE.NAME, EMPLOYEE.BIRTH_DATE, EMPLOYEE.AGE, JOB_FUNCTION.VALUE AS JOB_FUNCTION, LANGUAGE_LEVEL.VALUE AS ENGLISH_LEVEL, EMPLOYEE.CAREER_LEVEL, " 
	+ " MANAGER.TYPE, MANAGER.PROJECT_NAME"
	+ " FROM EMPLOYEE"
	+ " INNER JOIN JOB_FUNCTION ON EMPLOYEE.JOB_FUNCTION = JOB_FUNCTION.ID"
	+ " INNER JOIN LANGUAGE_LEVEL ON EMPLOYEE.ENGLISH_LEVEL = LANGUAGE_LEVEL.ID" 
	+ " INNER JOIN MANAGER ON EMPLOYEE.ID = MANAGER.ID";
	
	private static String GET_MANAGER_BY_ID_SQL = GET_ALL_MANAGERS_SQL + " WHERE MANAGER.ID = ?";
	
	private static String UPDATE_MANAGER_SQL = "UPDATE MANAGER SET TYPE=:TYPE,"
			+ " PROJECT_NAME=:PROJECT_NAME WHERE ID=:ID";
	
	private static String GET_EMPLOYEES_IDS_SQL = "SELECT EMPLOYEE_ID FROM MANAGER_EMPLOYEE WHERE MANAGER_ID = ?";
	private static String DELETE_EMPLOYEE_FROM_MANAGER_SQL = "DELETE FROM MANAGER_EMPLOYEE WHERE MANAGER_ID=? AND EMPLOYEE_ID=?";
	private static String DELETE_MANAGER_SQL = "DELETE FROM MANAGER WHERE ID = ?";
	private static String DELETE_MANAGER_CONN_SQL = "DELETE FROM MANAGER_EMPLOYEE WHERE MANAGER_ID = ?";

	public String create(Manager manager) {
		manager.setId(super.create(manager));
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(manager);
		this.namedParameterJdbcTemplate.update(CREATE_MANAGER_SQL, namedParameters);
		
		manager.getEmployees().forEach(employee->{
			this.jdbcTemplate.update(CONNECT_MANAGER_WITH_EMPLOYEE_SQL, 
					new Object[] { manager.getId(), employee.getId()});
		});
		
		return manager.getId();
	}

	public Manager get(String id) {
		Manager manager = this.jdbcTemplate.queryForObject(GET_MANAGER_BY_ID_SQL,
				new Object[] { id }, employeeRowMapper);
		manager.setEmployees(new HashSet<Employee>(super.getEmployeesForManager(manager.getId())));
		return manager;
	}

	public List<Manager> getAll() {
		List<Manager> managers = jdbcTemplate.query(GET_ALL_MANAGERS_SQL, employeeRowMapper);
		managers.forEach(manager -> {
			manager.setEmployees(new HashSet<Employee>(super.getEmployeesForManager(manager.getId())));

		});
		return managers;
	}

	public boolean update(Manager employee) {
		boolean employeeUpdated = super.update(employee);
		
		MapSqlParameterSource namedParameters = this.employeeRowMapper.prepareEmployeeParameters(employee);
		int numberOfUpdated = this.namedParameterJdbcTemplate.update(UPDATE_MANAGER_SQL, namedParameters);
		updateEmployeesForManager(employee);
		if (numberOfUpdated == 1 && employeeUpdated) {
			return true;
		} else {
			return false;
		}
	}
	
	public void updateEmployeesForManager(Manager manager) {
		List<String> currentEmployees = 
				this.jdbcTemplate.queryForList(GET_EMPLOYEES_IDS_SQL, new Object[] { manager.getId() }, String.class);
		List<String> newEmployeesIds = new ArrayList<String>();
		for (Employee newEmployee : manager.getEmployees()) {
			newEmployeesIds.add(newEmployee.getId());
			if (!currentEmployees.contains(newEmployee.getId())) {
				this.jdbcTemplate.update(CONNECT_MANAGER_WITH_EMPLOYEE_SQL, 
						new Object[] { manager.getId(), newEmployee.getId()});
			}
		}
		for (String currentEmployee : currentEmployees) {
			if (!newEmployeesIds.contains(currentEmployee)) {
				this.jdbcTemplate.update(DELETE_EMPLOYEE_FROM_MANAGER_SQL, 
						new Object[] { manager.getId(), currentEmployee});
			}
		}
	}

	public boolean delete(String id) {
		boolean employeeDeleted = super.delete(id);
		this.jdbcTemplate.update(DELETE_MANAGER_CONN_SQL, new Object[] { id });
		this.jdbcTemplate.update(DELETE_MANAGER_SQL, new Object[] { id });
		return employeeDeleted;
	}

}
