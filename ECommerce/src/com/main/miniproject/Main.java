package com.main.miniproject;
import java.sql.SQLException;
import java.util.Scanner;
import com.ecommerce.database.TruncateTheCart;

public class Main {

		static private Scanner scanner = new Scanner(System.in);
	

		public static void main(String[] args) throws SQLException {
			
			//make the cart ready for new user
			new TruncateTheCart();
			
			
			System.out.println(" 1. for User");
			System.out.println(" 2. for Admin Login");
			System.out.print("Please enter your choice: ");
			int firstChoice = scanner.nextInt();
			
			
			switch(firstChoice) {
			case 1:
				new UserDriver();
				break;
				
			case 2:
				new AdminDriver();
				break;
			}
			

		}

		
	}
	
