package com.achapouskaya.company.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.achapouskaya.company.dao.EmployeeDAO;
import com.achapouskaya.company.staff.Employee;

public class DatabasedEmployeeStatisticImpl extends IEmployeeStatistic {
	
	private EmployeeDAO<Employee> employeeDAO;

	
	public EmployeeDAO<Employee> getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO<Employee> employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void init() {
		if (this.getAllEmployees() == null || this.getAllEmployees().isEmpty()) {
			this.setAllEmployees(populateEmployeesMap(employeeDAO.getAll()));
		}
		this.initAverageAge();
		this.initEmployeesNumbByEngLevel();
	}
	
	private Map<String, Employee> populateEmployeesMap(List<Employee> empList) {
		Map<String, Employee> empMap = new TreeMap<String, Employee>();
		for (int i = 0; i < empList.size(); i++) {
			empMap.put(empList.get(i).getId(), empList.get(i));
		}
		return empMap;
		
	}

}
