package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.WithdrawalService;

public class WithdrawalMenu implements Menu {
	private static Logger log=Logger.getLogger(DepositMenu.class);
	public AccountConfirmService accountConfirmService;
	public WithdrawalService withdrawalService;
	Withdrawal customer = null;
	public WithdrawalMenu(Withdrawal customer) {
		super ();
		this.customer = customer;
		withdrawalService = new WithdrawalService();
		accountConfirmService = new AccountConfirmService();
		
	}
	
	

	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Withdrawal Menu");
			log.trace("============");
			log.trace("1.) Back");
			log.trace("2.) Make Withdrawal");
			log.trace("Enter a choice between 1 and 2");
		
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
				try {
					Withdrawal account = accountConfirmService.getUNandPW(accountNumber);
					System.out.println(customer);
					System.out.println(account);
					
					if (account.equals(customer)) {
						withdrawalService.makeWithdrawal(accountNumber, withdrawal);
						
					}
					
					else {
						throw new AccountNotFoundException();
						
					}
					
				} catch (AccountNotFoundException e) {
					log.error("Please enter an Account Number you currently own");
					log.error(e.getMessage());
				} catch (DatabaseConnectionException e) {
					log.error("Connection Failed");
					log.error(e.getMessage());
				}
			break;
		default:
			log.trace("No valid choice entered");
		
		}	
	} while (choice !=1);
	
}
	public int getCustomerANInput() {
		int accountNumber;
		while (true) {
			
			log.trace("Enter Account Number: ");
			accountNumber = Integer.parseInt(Menu.sc.nextLine());
			
			return accountNumber;
			
		}
	
	}	
	
	public int getCustomerWDInput() {
	int withdrawal;
	while (true) {
		
		log.trace("Enter your Withdrawal Ammount:");
		withdrawal = Integer.parseInt(Menu.sc.nextLine());
		if (withdrawal < 0) {
			log.trace("Input must be positive");
			withdrawal = 0;
		} else
		
		return withdrawal;
	}	 
	}
	}
	
	


	
