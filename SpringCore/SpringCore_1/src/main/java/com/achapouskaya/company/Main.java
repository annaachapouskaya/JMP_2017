package com.achapouskaya.company;


import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.achapouskaya.company.dao.IEmployeeDAO;
import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.skillmatrix.JobFunction;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employees-beans.xml");
		
		System.out.println(context.getBean("juniorJavaDev"));
		System.out.println(context.getBean("bigManager"));
		System.out.println(context.getBean("employeeStatistic"));
		
		System.out.println("TEST DAO: ");
		IEmployeeDAO<Employee> employeeDAO = (IEmployeeDAO<Employee>)context.getBean("employeeDAO");
		System.out.println(employeeDAO.getAll());
		
		Employee newEmployee = new Employee();
		newEmployee.setAge(23);
		newEmployee.setBirthDate(new GregorianCalendar(1990, Calendar.FEBRUARY, 11).getTime());
		newEmployee.setEnglishLevel(LanguageLevel.B2);
		newEmployee.setId("123");
		newEmployee.setJobFunction(JobFunction.SOFTWARE_ENGINEERING);
		newEmployee.setLevel(2);
		newEmployee.setName("Elena");
		
		employeeDAO.create(newEmployee);
		
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
		//((ClassPathXmlApplicationContext) context).close();
	}

}
