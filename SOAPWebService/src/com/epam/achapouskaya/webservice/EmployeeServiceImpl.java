package com.epam.achapouskaya.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.achapouskaya.error.EmployeeCreatingException;
import com.epam.achapouskaya.model.Employee;

@WebService(endpointInterface = "com.epam.achapouskaya.webservice.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	private static Map<String, Employee> employees = new HashMap<String, Employee>();

	@Override
	@WebMethod
	public String createEmployee(Employee employee) throws EmployeeCreatingException {
		if (checkID(employee.getId())) {
			throw new EmployeeCreatingException("Employee with ID " + employee.getId() + " already exists");
		} else {
			employees.put(employee.getId(), employee);
			return employee.getId();
		}
	}

	@Override
	@WebMethod
	public boolean updateEmployee(Employee employee) {
		if (checkID(employee.getId())) {
			employees.put(employee.getId(), createEmployeeForUpdate(employee));
			return true;
		} else {
			return false;
		}
	}

	@Override
	@WebMethod
	public boolean deleteEmployee(String id) {
		if (employees.remove(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	@WebMethod
	public Employee getEmployee(String id) {
		return employees.get(id);
	}

	@Override
	@WebMethod
	public Employee[] getAllEmployees() {
		Employee[] allEmployees = new Employee[employees.size()];
		int i = 0;
			for (Map.Entry<String, Employee> entry : employees.entrySet()) {
			allEmployees[i] = entry.getValue();
			i++;
		}
		return allEmployees;
	}

	private boolean checkID (String id) {
		if (employees.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	private Employee createEmployeeForUpdate(Employee employee) {
		Employee old = employees.get(employee.getId());
		if (employee.getName() == null) {
			employee.setName(old.getName());
		}
		if (employee.getSalary() <= 0) {
			employee.setSalary(old.getSalary());
		}
		return employee;
		
	}
}
