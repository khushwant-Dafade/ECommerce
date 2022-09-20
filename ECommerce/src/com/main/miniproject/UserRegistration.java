package com.main.miniproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ecommerce.database.ConnectionTest;

public class UserRegistration {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		public void getCustomerdetails(String customer_name,String mobile_number,String email_id,String address)
		{
			try {
				
				
				ConnectionTest connectiontest=new ConnectionTest();
				con=connectiontest.getConnectionDetails();
				
				
				
		    ps=con.prepareStatement("insert into customerdetails(customer_name,mobile_number,email_id,address)values(?,?,?,?)");
		  	ps.setString(1, customer_name);
			ps.setString(2, mobile_number);
			ps.setString(3, email_id);
			ps.setString(4, address);

				
			int i=ps.executeUpdate();
			
			System.out.println("==========================");
			System.err.println("Thank You For Registering");	
			
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			Scanner sc=new Scanner (System.in);
		
			System.err.println("Welcome To Warehouse");
			System.out.println("==============================");
			
			{
			
			System.out.println("Enter Customer Name");
			String cname=sc.next();		
			System.out.println("Enter Mobile Number");
			String cmobnum=sc.next();	
			System.out.println("Enter Email Address");
			String cemail=sc.next();	
			System.out.println("Enter Address");
			String cadd=sc.next();	
			
			UserRegistration rs=new UserRegistration();
			rs.getCustomerdetails(cname,cmobnum,cemail,cadd);
			
			
		}
			sc.close();
		}	
	}













	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
