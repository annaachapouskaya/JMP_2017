package com.achapouskaya.company.dao.impl.spring;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.achapouskaya.company.dao.IAutomationTesterDAO;
import com.achapouskaya.company.staff.AutomationTester;

public class SpringAutomationTesterDAO extends SpringCommonDAO implements IAutomationTesterDAO {
	
	private SpringEmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(SpringEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public String create(AutomationTester employee) {
		employeeDAO.create(employee);
		return null;
	}

	public AutomationTester get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AutomationTester> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(AutomationTester employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
