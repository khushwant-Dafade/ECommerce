package com.main.miniproject;


public class UserDriver {
	
	public UserDriver() {
		UserRegistration register = new UserRegistration();
		register.getCustomerdetails();
		
		
		
		//user can but multiple product
		BuyMultipleProduct buy = new BuyMultipleProduct();
		buy.getCustomerChoice();
	}

}
