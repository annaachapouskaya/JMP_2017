package com.achapouskaya.company;


import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.achapouskaya.company.dao.IAutomationTesterDAO;
import com.achapouskaya.company.dao.IEmployeeDAO;
import com.achapouskaya.company.staff.AutomationTester;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.skillmatrix.JobFunction;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-beans.xml");
		
		/*System.out.println(context.getBean("juniorJavaDev"));
		System.out.println(context.getBean("bigManager"));
		System.out.println(context.getBean("employeeStatistic"));*/
		
		System.out.println("TEST DAO: ");
		IEmployeeDAO<Employee> employeeDAO = (IEmployeeDAO<Employee>)context.getBean("employeeDAO");
		System.out.println(employeeDAO.getAll());
		System.out.println("Employee getall");
		
		employeeDAO.delete("testEmp1");
		
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
		
		employeeDAO.delete("testEmp1");
		
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
		
		IAutomationTesterDAO automationTesterDAO = (IAutomationTesterDAO) context.getBean("automationTesterDAO");
		automationTesterDAO.create(autotester);
		System.out.println(automationTesterDAO.getAll());
		autotester.setFramework("BrandNewFramework");
		automationTesterDAO.update(autotester);
		System.out.println(automationTesterDAO.get(autotester.getId()));
		automationTesterDAO.delete(autotester.getId());
		
		
		System.out.println("Employee statistic: " + context.getBean("employeeStatistic"));
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
		//((ClassPathXmlApplicationContext) context).close();
	}

}
