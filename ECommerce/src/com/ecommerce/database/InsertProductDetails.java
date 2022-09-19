package com.ecommerce.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertProductDetails {
 
	PreparedStatement ps =null;
	Connection con = null;
	
	public void insertProductDetails(int product_id, String description, int price, String name,  int quantity) {
	 try {
		 ConnectionTest ct = new ConnectionTest();
		 con = ct.getConnectionDetails();
		 ps=con.prepareStatement("insert into product(product_id,description,price,name,quantity)values(?,?,?,?,?)");
		 ps.setInt(1, product_id);
		 ps.setString(2, description);
		 ps.setInt(3, price);
		 ps.setString(4, name);
		 ps.setInt(5, quantity);
       int i= ps.executeUpdate();
		System.out.println("Insert successfully"+i); 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	
}
	public static void main(String[] args) {
		
		InsertProductDetails insertdetail = new InsertProductDetails();
		insertdetail.insertProductDetails(1,"samsung -M13" , 20000, "Mobile" , 10);
		insertdetail.insertProductDetails(2,"Nokia" , 30000, "Mobile " , 10);
		insertdetail.insertProductDetails(3," Apple" , 54000, "Mobile" , 10);
		insertdetail.insertProductDetails(4,"Redmi" , 14500, "Mobile" , 10);
		insertdetail.insertProductDetails(5,"Realme" , 16000, "Mobile" , 10);
		insertdetail.insertProductDetails(6,"One+" , 20000, "Mobile" , 10);
		insertdetail.insertProductDetails(7,"Oppo" , 15000, "Mobile" , 10);
		insertdetail.insertProductDetails(8,"Vivo" , 18000, "Mobile" , 10);
		insertdetail.insertProductDetails(9,"Nothing" , 31500, "Mobile" , 10);
		insertdetail.insertProductDetails(10,"Poco" , 17000, "Mobile" , 10);

	}
	
	
}
