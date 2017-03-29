package com.achapouskaya.company;

import com.achapouskaya.company.staff.AutomationTester;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.Manager;
import com.achapouskaya.company.staff.ManualTester;
import com.achapouskaya.company.staff.SoftwareEngineer;

public class EmployeeFactory {
	
	public EmployeeFactory() {
		super();
	}

	public Employee createAutomationTester() {
		return new AutomationTester();
	}
	
	public Employee createManager() {
		return new Manager();
	}
	
	public Employee createManualTester() {
		return new ManualTester();
	}
	
	public Employee createSoftwareEngineer() {
		return new SoftwareEngineer();
	}
	
	

}
