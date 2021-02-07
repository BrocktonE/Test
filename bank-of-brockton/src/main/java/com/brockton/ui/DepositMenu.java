package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.services.DepositService;

public class DepositMenu implements Menu {
	private static Logger log=Logger.getLogger(DepositMenu.class);

	public DepositService depositService;
	
	public DepositMenu() {
		depositService = new DepositService();
	}
	
	
	
	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Deposit Menu");
			System.out.println("===============");
			System.out.println("1.) Back");
			System.out.println("2.) Make Deposit");
			System.out.println("Enter a choice between 1 and 2");
		
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:					
				int accountNumber = getCustomerANInput();
				int deposit = getCustomerWDInput();	
				depositService.makeWithdrawal(accountNumber, deposit);
				
				
			break;
		default:
			System.out.println("No valid choice entered");
		
		}	
	} while (choice !=1);
	
}
	public int getCustomerANInput() {
		int accountNumber;
		while (true) {
			
			System.out.println("Enter Account Number: ");
			accountNumber = Integer.parseInt(Menu.sc.nextLine());
			
			return accountNumber;
			
		}
	
	}	
	
	public int getCustomerWDInput() {
	int deposit;
	while (true) {
		
		System.out.println("Enter your Deposit Ammount:");
		deposit = Integer.parseInt(Menu.sc.nextLine());
		
		return deposit;
	}	 
	}
	}
	