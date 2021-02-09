package com.brockton.ui;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;


public class CheckUNandPWMenu implements Menu {
	
public AccountConfirmService accountConfirmService;
	
	public CheckUNandPWMenu() {
		accountConfirmService= new AccountConfirmService();
		
	}

	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Player Menu");
			System.out.println("============");
			System.out.println("1.) Back");
			System.out.println("2.) Check Balance");
			System.out.println("Enter a choice between 1 and 2");
		
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
					System.out.println(account);
				} catch (AccountNotFoundException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
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
				System.out.println("Enter an account number you would like the balance for: ");
				accountNumber = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Account number not found, try again");
				continue;
			}
			break;
			
			
		}
		return accountNumber;
	}
	
}




	
	
