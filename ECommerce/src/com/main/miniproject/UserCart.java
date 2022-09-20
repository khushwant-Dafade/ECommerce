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

			     System.out.println(description);
				 System.out.println(price);
				 
			 }
			 
			 
			 
			 
			 ps=con.prepareStatement("Insert into cart values (?,?,?,?,?)");
			 ps.setInt(1,id);
			 ps.setString(2, description);
			 ps.setInt(3, price);
			 ps.setInt(4,quantity);
			 ps.setInt (5,(price*quantity));
			 
			 boolean rs=ps.execute();
			 System.out.println(rs);
			 
					 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	
}
