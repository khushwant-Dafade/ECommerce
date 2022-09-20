package com.main.miniproject;
import java.sql.SQLException;
import com.ecommerce.database.*;
import com.main.miniproject.*;
//import com.database.miniproject.RetriveProductByQuantity;
//import com.database.miniproject.RetriveProductByQuantity;

public class Main {

	
	

		public static void main(String[] args) throws SQLException {
			
			
			UserRegistration register = new UserRegistration();
			register.getCustomerdetails( "pooja","8830650130","morepooja@gmail.com","bharati vidyapeeth");
			
			GetProduct getproduct = new GetProduct();
			getproduct.getProductDetails();
			

//			RetriveProductByQuantity rt = new RetriveProductByQuantity();
//			rt.insertProductDetails();
			
			
			//user can but multiple product
			BuyMultipleProduct buy = new BuyMultipleProduct();
			buy.getCustomerChoice();
			
		

		}

		
	}
	
