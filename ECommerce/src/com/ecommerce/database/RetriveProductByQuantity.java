package com.ecommerce.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetriveProductByQuantity {

		PreparedStatement ps =null;
		Connection con = null;
		
		
		public void insertProductDetails() throws SQLException {
	
		try {
			ConnectionTest ct = new ConnectionTest();
			con = ct.getConnectionDetails();
			
			
			Scanner takeInput = new Scanner(System.in);
			
			System.out.println("Please Enter the Id : ");
			int product_id = takeInput.nextInt();
			
			
			
			ps = con.prepareStatement("SELECT quantity  FROM product WHERE product_id = (?)");
			ps.setInt(1, product_id);
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("Quantity of given Product id is : " + resultSet.getInt(1));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}		
		
}