package com.ecommerce.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class GetRegisterUserDetails {

	private String userName = "root";
	private String pass = "8830650130Pooja";
	private String msg = "Registered User's List: ";
	
	public void getRegisterUserDetails(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse",userName, pass);
			
			PreparedStatement ps =con.prepareStatement("SELECT distinct * from customerdetails;");
			 System.out.println("\n" + msg.toUpperCase());
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 System.out.println("\nCustomer Namer ::"+rs.getString(1));
				 System.out.println("Mobile Number ::"+rs.getString(2)); 
				 System.out.println("Email Address ::"+rs.getString(3));
				 System.out.println("Address ::"+rs.getString(4));
				 System.out.println("========================================\n");
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
}

