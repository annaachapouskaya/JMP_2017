package com.achapouskaya.company.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.achapouskaya.company.staff.Employee;

public class SpringEmployeesStatisticImpl extends IEmployeeStatistic implements ApplicationContextAware{
	
	private ApplicationContext context;
	
	public SpringEmployeesStatisticImpl() {
		super();
	}

	@Override
	public void init() {
		if (this.getAllEmployees() == null || this.getAllEmployees().isEmpty()) {
			System.out.println("Context: " + context);
			this.setAllEmployees(this.context.getBeansOfType(Employee.class));
		}
		this.initAverageAge();
		this.initEmployeesNumbByEngLevel();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;		
	}

}
