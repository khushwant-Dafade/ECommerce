package com.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetProduct{
	
	PreparedStatement ps =null;
	Connection con = null;
	
	public void getProductDetails() {
		 try {
	

			 System.out.println("\nAvailable Products & there details.\n");
			 
			 ConnectionTest ct = new ConnectionTest();
			 con = ct.getConnectionDetails();
			 ps=con.prepareStatement("SELECT * FROM product ORDER BY price ASC");
			 ResultSet resultSet = ps.executeQuery();
	
			 
			 
			 
			 while(resultSet.next())
			 {
				 	
					System.out.println("Description ="+resultSet.getString(2));
					System.out.println("Price ="+resultSet.getString(3));
					System.out.println("Name ="+resultSet.getString(4));
					System.out.println("Quantity ="+resultSet.getString(5));
					System.out.println("Enter "  + resultSet.getInt(1) + " to select this product :");
					System.out.println("=====================================\n");
				
			 }
			 
			 
			 con.close();
			 ps.close();
			 resultSet.close();
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
}