package com.achapouskaya.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employees-beans.xml");
		System.out.println(context.getBean("simpleEmployee"));
	}

}
