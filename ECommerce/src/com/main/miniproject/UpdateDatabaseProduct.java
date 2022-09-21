
package com.main.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.database.*;

public class UpdateDatabaseProduct {

	PreparedStatement ps =null;
	Connection con = null;
	
	public  UpdateDatabaseProduct(int quantity, int id) {
		
		 ConnectionTest ct = new ConnectionTest();
		 con = ct.getConnectionDetails();
		 
		 try {
			 
			 ps=con.prepareStatement("UPDATE product set quantity = ? where product_id = ?");
			 ps.setInt(1, quantity);
			 ps.setInt(2, id);
			 
			 ps.executeUpdate();
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		
	}

	
}
