package com.epam.achapouskaya.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epam.achapouskaya.error.EmployeeCreatingException;
import com.epam.achapouskaya.model.Employee;

@Path("/employees")
public class EmployeeServiceImpl implements EmployeeService {
	private static Map<String, Employee> employees = new HashMap<String, Employee>();

	@Override
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String createEmployee(Employee employee) throws EmployeeCreatingException {
		if (checkID(employee.getId())) {
			throw new EmployeeCreatingException("Employee with ID " + employee.getId() + " already exists");
		} else {
			employees.put(employee.getId(), employee);
			return employee.getId();
		}
	}

	@Override
	@PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean updateEmployee(Employee employee) {
		if (checkID(employee.getId())) {
			employees.put(employee.getId(), createEmployeeForUpdate(employee));
			return true;
		} else {
			return false;
		}
	}

	@Override
	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean deleteEmployee(@PathParam("id") String id) {
		if (employees.remove(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployee(@PathParam("id") String id) {
		return employees.get(id);
	}

	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
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
