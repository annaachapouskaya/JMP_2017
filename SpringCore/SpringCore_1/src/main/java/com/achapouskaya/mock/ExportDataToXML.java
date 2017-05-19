package com.achapouskaya.mock;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class ExportDataToXML {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:epbyminw0993";
	private static String user = "SPRING_COMPANY";
	private static String password = "SPRING_COMPANY";
		
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void exportDatabase() throws Exception
    {
        // database connection
        Class driverClass = Class.forName(driverName);
        Connection jdbcConnection = DriverManager.getConnection(
                URL, user, password);
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("EMPLOYEE", "SELECT * FROM EMPLOYEE");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));
        
        
    }

}
