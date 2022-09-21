package com.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertProductDetails {
	private static Scanner scanner = new Scanner(System.in);
	PreparedStatement ps =null;
	Connection con = null;
	
	public  InsertProductDetails() {
	 try {
		 ConnectionTest ct = new ConnectionTest();
		 con = ct.getConnectionDetails();
		 int defaultProductQuantity = 10;
		 int id = 1;
		 
		 ps = con.prepareStatement("TRUNCATE TABLE product");
		 ps.execute();

		 for(int i = 1; i <= 10; i++) {
		 
			 ps=con.prepareStatement("insert into product(product_id,description,price,name,quantity)values(?,?,?,?,?)");
			 System.out.println("\nFor Product Number : " + i);
			 
			 System.out.println("The Product Id (Automatically Generated) is : " + id);
			 ps.setInt(1,id);
			 id = id + 1;
			 
			 System.out.print("Enter the Product Description : ");
			 ps.setString(2,scanner.next());
			 
			 System.out.print("Enter the Product Price: ");
			 ps.setInt(3,scanner.nextInt());
			 
			 System.out.print("Enter the Product Name: ");
			 ps.setString(4,scanner.next());
			 
			 System.out.println("By Default Product Quantity is: 10");
			 ps.setInt(5, defaultProductQuantity);
			 
			 ps.executeUpdate();
			 System.out.println("===================================\n");
		 }
		 System.out.println("Database Updated Successfully.");
	 
	 }catch(Exception e) {
		 
		 e.printStackTrace();
	 }
	 
	
   }		

}
