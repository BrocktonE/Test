package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.model.Account;
import com.brockton.services.TransferService;

public class TransferMenu implements Menu {
	private static Logger log=Logger.getLogger(TransferMenu.class);
	
	public TransferService transferService;
	
	public TransferMenu() {
		transferService = new TransferService();
	
	}
	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Please Complete the Transfer Form Below");
			log.trace("======================================");
			log.trace("1.) Back");
			log.trace("2.) Complete Transfer Form");
			log.trace("Please fill in all neccessary information in Application");
	
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
	
			switch (choice) {
			case 1:
				break;
			case 2:
				int amount = getAmountInput();
				int accountNumber = getAccountNumberInput();
				int toAccount = getToAccountInput();
				
				
				
				Account account = new Account(amount, accountNumber, toAccount);
				transferService.transfer(account);
				break;
				
			default:
				log.trace("Choose Again");
			}
			
		} while (choice !=1);
		

	
		}
	public int getAmountInput() {
		int amount;
		while(true) {
			try {
				log.trace("Enter the amount you would like to transfer: ");
			amount = Integer.parseInt(Menu.sc.nextLine());
			if (amount < 0) {
				log.trace("Input must be positive");
				amount = 0;
			} else
				return amount;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, try again");
				continue;
			}
				
			}
			
		}
	
	
		
	
	public int getAccountNumberInput() {
			int accountNumber;
			while(true) {
				try {
					log.trace("Enter the account you would like to take money from: ");
				accountNumber = Integer.parseInt(Menu.sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input, try again");
					continue;
				}
				return accountNumber;		
			}		
		}
	


public int getToAccountInput() {
	int toAccount;
	while(true) {
		try {
			log.trace("Enter the Account you would like to give money to: ");
		toAccount = Integer.parseInt(Menu.sc.nextLine());
		} catch (NumberFormatException e) {
			log.trace("Invalid Input, try again");
			continue;
		}
		return toAccount;	
		
			

			}
			
		}
	
	}
	
		
	
