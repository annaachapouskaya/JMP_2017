package com.achapouskaya.company;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employees-beans.xml");
		
		System.out.println(context.getBean("juniorJavaDev"));
		System.out.println(context.getBean("bigManager"));
		System.out.println(context.getBean("employeeStatistic"));
		
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
		//((ClassPathXmlApplicationContext) context).close();
	}

}
