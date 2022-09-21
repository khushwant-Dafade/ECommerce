package com.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TruncateTheCart {

	PreparedStatement ps =null;
	Connection con = null;
	
	public TruncateTheCart() {
		try {
			
			ConnectionTest ct = new ConnectionTest();
			con = ct.getConnectionDetails();
			
			ps=con.prepareStatement("truncate table cart;");		 
			ps.executeUpdate();
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
