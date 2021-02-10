package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.services.ViewTransactionsService;

public class ViewTransactionsMenu implements Menu {
	private static Logger log=Logger.getLogger(ViewTransactionsMenu.class);
	
	public ViewTransactionsService viewTransactionsService;
	
	public ViewTransactionsMenu() {
		viewTransactionsService = new ViewTransactionsService();
		
	}


	@Override
	public void display() {
		int choice = 0;
		
		do {
			log.trace("View Transactions Log");
			log.trace("======================");
			log.trace("1.) Back");
			log.trace("2.) Pull all Transactions");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
		
			switch (choice) {
			case 1:
				break;
			case 2:
				
				try {
					viewTransactionsService.viewTransactions();
					
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			default:
				log.trace("Choose Again");
			}
		
	} while (choice !=1);



}
}