package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;



public class CheckUNandPWMenu implements Menu {
private static Logger log=Logger.getLogger(CheckUNandPWMenu.class);	
public AccountConfirmService accountConfirmService;
	
	public CheckUNandPWMenu() {
		accountConfirmService= new AccountConfirmService();
		
	}

	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Player Menu");
			log.trace("============");
			log.trace("1.) Back");
			log.trace("2.) Check Balance");
			log.trace("Enter a choice between 1 and 2");
		
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				int accountNumber = getBalanceInput();
				try {
					Withdrawal account = accountConfirmService.getUNandPW(accountNumber);
					log.trace(account);
				} catch (AccountNotFoundException | DatabaseConnectionException e) {
					log.error(e.getMessage());
				}
				
				break;
			default:
				System.out.println("No valid choice entered, try again");
				
			}
		
	} while (choice != 1);
		
		
}

	public int getBalanceInput() {
		int accountNumber;
		
		while (true) {
			try {
				log.trace("Enter an account number you would like the balance for: ");
				accountNumber = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
				log.error("Account number not found, try again");
				continue;
			}
			break;
			
			
		}
		return accountNumber;
	}
	
}




	
	
