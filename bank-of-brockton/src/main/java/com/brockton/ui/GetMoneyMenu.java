package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Transfer;
import com.brockton.services.CompleteTransferService;

public class GetMoneyMenu implements Menu {
	private static Logger log=Logger.getLogger(GetMoneyMenu.class);
	
	public CompleteTransferService completeTransferService;
	
	public GetMoneyMenu() {
		completeTransferService = new CompleteTransferService();
	}
	

	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Pending Transfer Menu");
			System.out.println("======================================");
			System.out.println("1.) Back");
			System.out.println("2.) Accept Transfer");
			System.out.println("Please fill in all neccessary information in Application");
	
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
	
			switch (choice) {
			case 1:
				break;
			case 2:
				int accountNumber = getCustomerANInput();
				
				try {
					completeTransferService.completeTransfer(accountNumber);
					
				} catch (DatabaseConnectionException e) {
					
					e.printStackTrace();
				}
				
				
			
				break;
				
			default:
				System.out.println("Choose Again");
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
	
}