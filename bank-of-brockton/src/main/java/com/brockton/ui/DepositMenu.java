package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.DepositService;

public class DepositMenu implements Menu {
	private static Logger log=Logger.getLogger(DepositMenu.class);
	public AccountConfirmService accountConfirmService;
	public DepositService depositService;
	Withdrawal customer = null;
	public DepositMenu(Withdrawal customer) {
		super ();
		this.customer = customer;
		depositService = new DepositService();
		accountConfirmService = new AccountConfirmService();
		


	}
	
//	Customer customer = null;
//	public DepositMenu(Customer customer) {
//		super ();
//		this.customer = customer;
	
//	}



	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Deposit Menu");
			System.out.println("===============");
			System.out.println("1.) Back");
			System.out.println("2.) Make Deposit");
			System.out.println("3.) Print UN");
			System.out.println("4.) Get UN and PW");
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
				try {
					Withdrawal account = accountConfirmService.getUNandPW(accountNumber);
					System.out.println(customer);
					System.out.println(account);
					
					if (account.equals(customer)) {
						depositService.makeDeposit(accountNumber, deposit);
						
					}
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				break;
			case 3:
				System.out.println("try again");
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
	