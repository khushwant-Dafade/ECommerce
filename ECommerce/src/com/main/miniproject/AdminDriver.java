package com.main.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

import com.ecommerce.database.GetRegisterUserDetails;
import com.ecommerce.database.InsertProductDetails;
import com.ecommerce.database.RetriveProductByQuantity;

public class AdminDriver {
	static private Scanner scanner = new Scanner(System.in);
	private String admin_password = "admin@123";
	public AdminDriver() {
		
		System.out.print("\nEnter the Password: ");
		String userpass = scanner.next();
		
		if(admin_password.equals(userpass)) {
			
			System.out.println("\nwelcom Admin..");
			System.out.println("1. List of Registered User's List.");
			System.out.println("2. Retrive Product from Database based on there ID.");
			System.out.println("3. Enter 10 New Products in Database\n");
			System.out.print("Please Enter Your Choice: ");
			int userChoice = scanner.nextInt();
			
			if(userChoice == 1) {
				GetRegisterUserDetails abc = new GetRegisterUserDetails();
				abc.getRegisterUserDetails();
			}else if(userChoice == 2) {
				RetriveProductByQuantity rt = new RetriveProductByQuantity();
				try {
					rt.insertProductDetails();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(userChoice == 3) {
					new InsertProductDetails();
			
			}else {
				System.out.println("Please provide Valid input.!");
				new AdminDriver();
			}
			
			
		}else {
			
			System.out.println("Invalid password. Please try again.");
		}
			
	}

}
