package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	
	Connection con = null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse","root","8390309081");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}

