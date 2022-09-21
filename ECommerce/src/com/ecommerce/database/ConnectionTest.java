package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	private String userName = "root";
	private String pass = "8390309081";
	
	Connection con = null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", userName, pass);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
}

