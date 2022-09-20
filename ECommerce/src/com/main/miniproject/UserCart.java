package com.main.miniproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.database.ConnectionTest;


public class UserCart {
	
	PreparedStatement ps =null;
	Connection con = null;

	public UserCart(int id, int quntity) {
	
		 try {
				
			 ConnectionTest ct = new ConnectionTest();
			 con = ct.getConnectionDetails();
			 ps=con.prepareStatement("select * from product where  product_id =(?)");
			 ps.setInt(1,id);
			 
			 ResultSet resultSet = ps.executeQuery();
			 
			 String description = resultSet.getString(2);
			 int price = resultSet.getInt(3);
			 
			 System.out.println(description);
			 System.out.println(price);
		
			 
			 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	
}
