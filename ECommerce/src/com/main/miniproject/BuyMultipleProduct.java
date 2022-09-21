
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
	private static Scanner takeInput = new Scanner(System.in);
	
	
	private int customerChoiceProduct;
	private int customerChoiceQuantity;
	int userChoice = 1;
	
	public void getCustomerChoice() {
		while(userChoice != 0) {
			
			GetProduct getproduct = new GetProduct();
			getproduct.getProductDetails();
		
			System.out.print("Enter the Product Number : ");
			customerChoiceProduct = takeInput.nextInt();
			
			System.out.print("Enter the Product Quantity : ");
			customerChoiceQuantity = takeInput.nextInt();
			
			try {
				checkDatabase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("=============================================================================");
			System.out.print("\nEnter '0' (zero) to Exit the Program OR Enter '1' (One) to Continue Shoping.");
			System.out.print("\nEnter Your Choice: ");
			userChoice = takeInput.nextInt();
			System.out.println();
			
			if(userChoice == 0) {
				GetSumOfUserPurchase g = new GetSumOfUserPurchase();
				g.getTotal();
			}
		
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
    		   int remainingQuantity = (currentQuantity - customerChoiceQuantity);
    		   System.out.println("\nAdded to cart Successfully...\n");
    		   
    		   
    		   new UpdateDatabaseProduct(remainingQuantity, customerChoiceProduct);
    		   
    		   new UserCart(customerChoiceProduct,customerChoiceQuantity);
    		   
    	   }

    	  }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	}
}
