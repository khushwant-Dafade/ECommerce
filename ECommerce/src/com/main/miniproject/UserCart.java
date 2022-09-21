package com.main.miniproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.database.ConnectionTest;


public class UserCart {
	
	PreparedStatement ps =null;
	Connection con = null;

	public UserCart(int id, int quantity) {
	
		 try {
				
			 ConnectionTest ct = new ConnectionTest();
			 con = ct.getConnectionDetails();
			 ps=con.prepareStatement("select * from product where  product_id =(?)");
			 ps.setInt(1,id);
			 
			 ResultSet resultSet = ps.executeQuery();
			 String description="";
			 int price=0;
			 while(resultSet.next())
			 {
				 
				 description = resultSet.getString(2);
			     price = resultSet.getInt(3);

			 }
			 
			 ps=con.prepareStatement("Insert into cart values (?,?,?,?,?)");
			 int total_price = (price * quantity);
			 
			 ps.setInt(1,id); 
			 ps.setString(2, description);
			 ps.setInt(3, price);
			 ps.setInt(4,quantity);
			 ps.setInt (5, total_price );
			 
			 ps.execute();
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	
}
