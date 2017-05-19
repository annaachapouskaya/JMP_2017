package com.achapouskaya.company.dao.impl.spring;

import java.io.InputStream;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.achapouskaya.company.dao.EmployeeDAO;
import com.achapouskaya.company.staff.Employee;


@RunWith(JUnit4.class)
public class TestEmployeeDAO extends DBUnitConfig {
	
	private EmployeeDAO<Employee> employeeDAO;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-beans.xml");
		this.employeeDAO = (EmployeeDAO<Employee>)context.getBean("employeeDAO");

		beforeData = new FlatXmlDataSetBuilder().build(Thread.currentThread()
				.getContextClassLoader().getResource("test-data.xml"));
		tester.setDataSet(beforeData);
		//tester.onSetup();
	}
	
	@Test
	public void testGetAll() throws Exception {
		System.out.println("Assertion begin!");

		List<Employee> employees = employeeDAO.getAll();
		
		InputStream str = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test-data.xml");
		
		IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                 Thread.currentThread().getContextClassLoader()
                 .getResourceAsStream("test-data.xml"));
		IDataSet actualData = tester.getConnection().createDataSet();
		System.out.println("Actual Data: " + expectedData);
	    Assertion.assertEquals(expectedData, actualData);
	    Assert.assertEquals(expectedData.getTable("employee").getRowCount(),employees.size());
		System.out.println("Assertion done!");
	}
	

}
