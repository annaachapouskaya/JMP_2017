package com.achapouskaya.company;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.achapouskaya.company.dao.AutomationTesterDAO;
import com.achapouskaya.company.dao.EmployeeDAO;
import com.achapouskaya.company.dao.ManagerDAO;
import com.achapouskaya.company.staff.AutomationTester;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.Manager;
import com.achapouskaya.company.staff.skillmatrix.JobFunction;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-beans.xml");
		
		/*System.out.println(context.getBean("juniorJavaDev"));
		System.out.println(context.getBean("bigManager"));
		System.out.println(context.getBean("employeeStatistic"));*/
		
		System.out.println("TEST DAO: ");
		EmployeeDAO<Employee> employeeDAO = (EmployeeDAO<Employee>)context.getBean("employeeDAO");
		System.out.println(employeeDAO.getAll());
		System.out.println("Employee getall");
		
	
		Employee newEmployee = new Employee();
		newEmployee.setAge(23);
		newEmployee.setBirthDate(new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime());
		newEmployee.setEnglishLevel(LanguageLevel.B2);
		newEmployee.setId("testEmp1");
		newEmployee.setJobFunction(JobFunction.SOFTWARE_ENGINEERING);
		newEmployee.setLevel(2);
		newEmployee.setName("Elena");
		
		employeeDAO.create(newEmployee);
		System.out.println("Employee created");
		
		newEmployee.setName("Updated elena");
		employeeDAO.update(newEmployee);
		
		System.out.println(employeeDAO.get("testEmp1"));
		
		AutomationTester autotester = new AutomationTester();
		autotester.setAge(23);
		autotester.setBirthDate(new GregorianCalendar(1993, Calendar.SEPTEMBER, 11).getTime());
		autotester.setEnglishLevel(LanguageLevel.B1);
		autotester.setId("1557");
		autotester.setJobFunction(JobFunction.TESTING);
		autotester.setLevel(2);
		autotester.setName("Magda");
		
		autotester.setFramework("testingOnRails");
		autotester.setLanguage("Ruby");
		
		AutomationTesterDAO automationTesterDAO = (AutomationTesterDAO) context.getBean("automationTesterDAO");
		automationTesterDAO.create(autotester);
		System.out.println(automationTesterDAO.getAll());
		autotester.setFramework("BrandNewFramework");
		automationTesterDAO.update(autotester);
		System.out.println(automationTesterDAO.get(autotester.getId()));
		
		//MANAGER
		Manager manager = new Manager();
		manager.setAge(23);
		manager.setBirthDate(new GregorianCalendar(1993, Calendar.SEPTEMBER, 11).getTime());
		manager.setEnglishLevel(LanguageLevel.C1);
		manager.setId("1546");
		manager.setJobFunction(JobFunction.MANAGEMENT);
		manager.setLevel(2);
		manager.setName("ManagerName");
		
		manager.setType("PM");
		manager.setProjectName("MAILO");
		
		Set<Employee> managersGuys = new HashSet<Employee>();
		managersGuys.add(autotester);
		managersGuys.add(newEmployee);
		
		manager.setEmployees(managersGuys);
		
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("managerDAO");
		managerDAO.create(manager);
		System.out.println(managerDAO.getAll());
		manager.setType("RM");
		managerDAO.update(manager);
		System.out.println(managerDAO.get(manager.getId()));
		managerDAO.delete(manager.getId());
	
		
		System.out.println("Employee statistic: " + context.getBean("employeeStatistic"));
		
		employeeDAO.delete("testEmp1");
		automationTesterDAO.delete(autotester.getId());
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
		//((ClassPathXmlApplicationContext) context).close();
	}

}
