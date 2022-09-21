package com.main.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ecommerce.database.ConnectionTest;

public class GetSumOfUserPurchase {

	PreparedStatement ps =null;
	Connection con = null;
	
	
	public void getTotal() {
		 try {
			 
			 ConnectionTest ct = new ConnectionTest();
			 con = ct.getConnectionDetails();
			 
			 ps=con.prepareStatement("select sum(total_price)  as sum from cart;");		 
			 ResultSet rs = ps.executeQuery();
		
			 while(rs.next())
			    {
			    	System.out.println("\nYour Total Amount is :: " +rs.getInt(1) + " Rs.");
			
			    }
			
		 } catch (SQLException e) {
			 
			e.printStackTrace();
		
		 }
	}
		
}
	


