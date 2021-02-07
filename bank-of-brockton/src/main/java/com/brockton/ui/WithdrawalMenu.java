package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.model.Account;
import com.brockton.model.Withdrawal;
import com.brockton.services.WithdrawalService;

public class WithdrawalMenu implements Menu {
	private static Logger log=Logger.getLogger(WithdrawalMenu.class);

	public WithdrawalService withdrawalService;
	
	public WithdrawalMenu() {
		withdrawalService = new WithdrawalService();
	}
	
	

	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Withdrawal Menu");
			System.out.println("============");
			System.out.println("1.) Back");
			System.out.println("2.) Make Withdrawal");
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
				int withdrawal = getCustomerWDInput();	
				withdrawalService.makeWithdrawal(accountNumber, withdrawal);
				
				
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
	int withdrawal;
	while (true) {
		
		System.out.println("Enter your Withdrawal Ammount:");
		withdrawal = Integer.parseInt(Menu.sc.nextLine());
		
		return withdrawal;
	}	 
	}
	}
	
	


	
