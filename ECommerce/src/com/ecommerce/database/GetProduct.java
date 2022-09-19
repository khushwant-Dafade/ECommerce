package com.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetProduct{
	
	PreparedStatement ps =null;
	Connection con = null;
	
	public void getProductDetails() {
		 try {
			
			 ConnectionTest ct = new ConnectionTest();
			 con = ct.getConnectionDetails();
			 ps=con.prepareStatement("SELECT * FROM product ORDER BY price ASC");
			 ResultSet resultSet = ps.executeQuery();
	
			 System.err.println("\nWelcome to ___ Shop");
			 System.out.println("Available Products & there details.\n");
			 
			 
			 
			 while(resultSet.next())
			 {
				 	
					System.out.println("Description ="+resultSet.getString(2));
					System.out.println("Price ="+resultSet.getString(3));
					System.out.println("Name ="+resultSet.getString(4));
					System.out.println("Quantity ="+resultSet.getString(5));
					System.out.println("Enter "  + resultSet.getInt(1) + " to select this product :");
					System.out.println("=====================================\n");
				
			 }
			 System.out.println("Enter 0 to Terminate(In product Id): ");
			 
			 con.close();
			 ps.close();
			 resultSet.close();
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
}