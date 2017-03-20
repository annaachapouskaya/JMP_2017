package com.epam.achapouskaya.webservice;

import com.epam.achapouskaya.error.EmployeeCreatingException;
import com.epam.achapouskaya.model.Employee;

public interface EmployeeService {
	
	public String createEmployee(Employee employee) throws EmployeeCreatingException;
	
	public boolean updateEmployee(Employee employee);
	
	public boolean deleteEmployee(String id);
	
	public Employee getEmployee(String id);
	
	public Employee[] getAllEmployees();

}
