package com.achapouskaya.company.dao.impl.spring;

import java.io.IOException;
import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

public class DBUnitConfig extends DBTestCase {
	protected IDatabaseTester tester;
	private Properties prop;
	protected IDataSet beforeData;
	
	@Before
	public void setUp() throws Exception {
		this.tester = new JdbcDatabaseTester(prop.getProperty("jdbc.driverClassName"), 
				prop.getProperty("jdbc.url"),
				prop.getProperty("jdbc.username"),
				prop.getProperty("jdbc.password"));
	}
	
	public DBUnitConfig() {
		super();
		prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("jdbc.driverClassName"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("jdbc.url"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, prop.getProperty("jdbc.username"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, prop.getProperty("jdbc.password"));

	}


	@Override
	protected IDataSet getDataSet() throws Exception {
		return beforeData;
	}
	
	   @Override
	    protected DatabaseOperation getTearDownOperation() throws Exception {
	        return DatabaseOperation.NONE;
	    }
	 
}
