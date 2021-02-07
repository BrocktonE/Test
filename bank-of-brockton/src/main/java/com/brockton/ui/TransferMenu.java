package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.model.Application;
import com.brockton.model.Transfer;
import com.brockton.services.ApplicationService;
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
			System.out.println("Please Complete the Transfer Form Below");
			System.out.println("======================================");
			System.out.println("1.) Back");
			System.out.println("2.) Complete Transfer Form");
			System.out.println("Please fill in all neccessary information in Application");
	
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
				
				
				
				Transfer newTransfer = new Transfer(amount, accountNumber, toAccount);
				transferService.transfer(newTransfer);
				break;
				
			default:
				System.out.println("Choose Again");
			}
			
		} while (choice !=1);
		

	
		}
	public int getAmountInput() {
		int amount;
		while(true) {
			try {
			System.out.println("Enter the amount you would like to transfer: ");
			amount = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, try again");
				continue;
			}
			return amount;		
			}
			
		}
	
	
		
	
	public int getAccountNumberInput() {
			int accountNumber;
			while(true) {
				try {
				System.out.println("Enter the account you would like to take money from: ");
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
		System.out.println("Enter the Account you would like to give money to: ");
		toAccount = Integer.parseInt(Menu.sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input, try again");
			continue;
		}
		return toAccount;	
		
			

			}
			
		}
	
	}
	
		
	
