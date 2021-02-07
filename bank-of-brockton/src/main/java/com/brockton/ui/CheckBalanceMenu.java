package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.BalanceService;

public class CheckBalanceMenu implements Menu {
	private static Logger log=Logger.getLogger(CheckBalanceMenu.class);

	public BalanceService balanceService;
	
	public CheckBalanceMenu() {
		balanceService= new BalanceService();
		
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
					Withdrawal balance = balanceService.getBalance(accountNumber);
					System.out.println(balance);
				} catch (AccountNotFoundException | DatabaseConnectionException e) {
					log.trace(e.getMessage());
				}
				
				break;
			default:
				System.out.println("No valid choice entered, try again");
				
			}
		
	} while (choice != 1);
		
		
}

	public int getBalanceInput() {
		int balance;
		
		while (true) {
			try {
				System.out.println("Enter an account number you would like the balance for: ");
				balance = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Account number not found, try again");
				continue;
			}
			break;
			
			
		}
		return balance;
	}
	
}




