package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.BalanceService;

public class CheckBalanceMenu implements Menu {
	private static Logger log=Logger.getLogger(CheckBalanceMenu.class);
	public AccountConfirmService accountConfirmService;
	public BalanceService balanceService;
	Withdrawal customer = null;
	public CheckBalanceMenu(Withdrawal customer) {
		super ();
		this.customer = customer;
		balanceService = new BalanceService();
		accountConfirmService = new AccountConfirmService();
		
		
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
					System.out.println(customer);
					System.out.println(account);
					
					if (account.equals(customer)) {
					Withdrawal balance = balanceService.getBalance(accountNumber);
					System.out.println(balance);
						
					}
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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




