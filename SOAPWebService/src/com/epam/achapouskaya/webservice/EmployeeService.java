package com.epam.achapouskaya.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.epam.achapouskaya.error.EmployeeCreatingException;
import com.epam.achapouskaya.model.Employee;

@WebService
@SOAPBinding (style = SOAPBinding.Style.RPC)
public interface EmployeeService {
	
	@WebMethod
	public String createEmployee(Employee employee) throws EmployeeCreatingException;
	
	@WebMethod
	public boolean updateEmployee(Employee employee);
	
	@WebMethod
	public boolean deleteEmployee(String id);
	
	@WebMethod
	public Employee getEmployee(String id);
	
	@WebMethod
	public Employee[] getAllEmployees();

}
