package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.services.ViewAccountService;

public class ViewMenu implements Menu {
	private static Logger log=Logger.getLogger(ViewMenu.class);

	public ViewAccountService viewAccountService;
	
	public ViewMenu() {
		viewAccountService = new ViewAccountService();
	
	}
	
	@Override
	public void display() {
int choice = 0;
		
		do {
			log.trace("View Customer Account Menu");
			log.trace("======================");
			log.trace("1.) Back");
			log.trace("2.) View Customer Account");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
		
			switch (choice) {
			case 1:
				break;
			case 2:
				int customerId = getCustomerByIdInput();
				try {
					viewAccountService.viewAccount(customerId);
				
				} catch (AccountNotFoundException e) {
					log.error(e.getMessage());
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			default:
				log.trace("Choose Again");
			}
		
	} while (choice !=1);



}
	
	public int getCustomerByIdInput() {
		int customerId;
		
		while (true) {
			try {
				log.trace("Enter the Customer ID to look up an Account");
				customerId = Integer.parseInt(Menu.sc.nextLine());
				
			} catch (NumberFormatException e) {
				log.trace("Invalid Input, try again");
				continue;
			}
			break;
		}
		return customerId;
		
	}
		
	
}
		
