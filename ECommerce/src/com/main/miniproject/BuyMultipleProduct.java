
package com.main.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.ecommerce.database.*;

public class BuyMultipleProduct {

	PreparedStatement ps =null;
	Connection con = null;
	
	
	
	private int customerChoiceProduct;
	private int customerChoiceQuantity;
	
	public void getCustomerChoice() {
			
		Scanner takeInput = new Scanner(System.in);
		System.out.println("Enter the Product Number : ");
		customerChoiceProduct = takeInput.nextInt();
		
		if(customerChoiceProduct == 0) {
			System.out.println("Thank You, Visit again....");
			System.exit(1);
		}
		
		System.out.println("Enter the Product Quantity : ");
		customerChoiceQuantity = takeInput.nextInt();
		try {
			checkDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void checkDatabase() throws SQLException {
		
	 try {
		 ConnectionTest ct = new ConnectionTest();
		 con = ct.getConnectionDetails();
		 ps=con.prepareStatement("select quantity from product where  product_id =(?)");
		 ps.setInt(1,customerChoiceProduct);
		 
       ResultSet rs= ps.executeQuery();
       while(rs.next()) {
    	   int currentQuantity = rs.getInt(1);
    	   if(currentQuantity < customerChoiceQuantity) {
    		   System.out.println("This much quantity is not available...");
    		   
    	   }else {
    		   System.out.println("Added to cart Successfully...");
    		   System.out.println("Remaining Devices: " + (currentQuantity - customerChoiceQuantity));
    	//	   update database & shoping card
    		   new UpdateDatabaseProduct((currentQuantity - customerChoiceQuantity), customerChoiceProduct);
    		   
    		   UserCart obj =  new UserCart(currentQuantity,customerChoiceQuantity);
    		 // UserCart(currentQuantity, customerChoiceQuantity);
    		   
    	   }

    	  }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	}
}
