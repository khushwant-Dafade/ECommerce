package com.main.miniproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ecommerce.database.ConnectionTest;

public class UserRegistration {
		Connection con=null;
		PreparedStatement ps=null;
		private static Scanner scanner = new Scanner(System.in);
		
		public void getCustomerdetails()
		{
			try {
				
				
				ConnectionTest connectiontest=new ConnectionTest();
				con=connectiontest.getConnectionDetails();
				ps=con.prepareStatement("insert into customerdetails(customer_name,mobile_number,email_id,address)values(?,?,?,?)");
				
				System.out.println("==================================");
				
				System.out.print("Enter Your Name: ");
				ps.setString(1, scanner.next());
			    
				System.out.print("Enter Your Mobile Number: ");
				ps.setString(2, scanner.next());
				
				System.out.print("Enter Your Email Id: ");
				ps.setString(3, scanner.next());
				
				System.out.print("Enter Your Address: ");
				ps.setString(4, scanner.next());

				
				ps.executeUpdate();
			
				System.out.println("====================================\n");
				System.err.println("Thank You For Registering.");	
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
			
}













	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
