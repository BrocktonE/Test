package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.services.PullApplicationService;
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
			System.out.println("View Transactions Log");
			System.out.println("======================");
			System.out.println("1.) Back");
			System.out.println("2.) Pull all Transactions");
			
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
				System.out.println("Choose Again");
			}
		
	} while (choice !=1);



}
}