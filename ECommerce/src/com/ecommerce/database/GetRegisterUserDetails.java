package com.ecommerce.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class GetRegisterUserDetails {

	
	public void getRegisterUserDetails(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse","root","Jayshree@123");
			
			PreparedStatement ps =con.prepareStatement("select * from customerdetails");
			 
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 System.out.println("Customer Namer ::"+rs.getString(1));
				 System.out.println("Mobile Number ::"+rs.getString(2)); 
				 System.out.println("Email Address ::"+rs.getString(3));
				 System.out.println("Address ::"+rs.getString(4));
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
}

