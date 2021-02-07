package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.services.PullApplicationService;
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
			System.out.println("View Customer Account Menu");
			System.out.println("======================");
			System.out.println("1.) Back");
			System.out.println("2.) View Customer Account");
			
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
					Account account = viewAccountService.viewAccount(customerId);
					System.out.println(account);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			default:
				System.out.println("Choose Again");
			}
		
	} while (choice !=1);



}
	
	public int getCustomerByIdInput() {
		int customerId;
		
		while (true) {
			try {
				System.out.println("Enter the Customer ID to look up an Account");
				customerId = Integer.parseInt(Menu.sc.nextLine());
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, try again");
				continue;
			}
			break;
		}
		return customerId;
		
	}
		
	
}
		
