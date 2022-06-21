package com.javatraining.util;
import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionFactory {
	
	public  static Connection getPostgresConnection()  {
		Connection con=null;
		ResourceBundle labels =ResourceBundle.getBundle("application");
		try {
			String url =labels.getString("datasource.postgres.url");
			String username=labels.getString("datasource.postgres.username");
			String password=labels.getString("datasource.postgres.password");
			String driverClass =labels.getString("datasource.postgres.driverclass");
			Class.forName(driverClass);
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return con;
		
	}
}
