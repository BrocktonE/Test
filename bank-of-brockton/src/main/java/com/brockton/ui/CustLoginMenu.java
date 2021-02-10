package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.CustomerNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;

import com.brockton.model.Withdrawal;
import com.brockton.services.CustLoginService;

public class CustLoginMenu implements Menu {
	private static Logger log=Logger.getLogger(CustLoginMenu.class);
	
	public CustLoginService customerLoginService;
	
	public CustLoginMenu () {
		
		customerLoginService = new CustLoginService();
		
	}


	@Override
	public void display()  {
		int choice = 0;
		
		do {
			log.trace("Customer Login");
			log.trace("==============");
			log.trace("1.) Back");
			log.trace("2.) Login");
			
		try {
			choice = Integer.parseInt(Menu.sc.nextLine());
		} catch (NumberFormatException e) {
		}
		
		switch (choice) {
		case 1:
			break;
		case 2:
			String userName = getcreateCustomerUNInput();
			String passWord = getcreateCustomerPWInput();
			try {
				Withdrawal customer = customerLoginService.lookforUNandPW(userName, passWord);
		//		System.out.println(customer);
			
				if (customer != null) {
				    System.out.println("Success you have logged in");
				   Menu accountMenu = new AccountMenu(customer);
				   accountMenu.display();
				    
				} else {
				//	log.error("login credentials not found");
				}
				
				
				
			} catch (CustomerNotFoundException e) {
				log.error(e.getMessage());
			} catch (DatabaseConnectionException e) {
				log.error(e.getStackTrace());
			}

			break;
		default:
				log.trace("No valid choice entered");

		}

	} while (choice != 1);

}
	
	public String getcreateCustomerUNInput() {
		String userName;
		while (true) {
			
			log.trace("Enter userName: ");
			userName = Menu.sc.nextLine();
			
			return userName;
		}
	}
	
	public String getcreateCustomerPWInput() {
		String passWord;
		while (true) {
			
			log.trace("Enter your Password: ");
			passWord = sc.nextLine();
			return passWord;
		}
		
	}
		
	}



