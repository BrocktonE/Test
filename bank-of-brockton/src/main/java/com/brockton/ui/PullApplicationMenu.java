package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.services.PullApplicationService;

public class PullApplicationMenu implements Menu {
	private static Logger log=Logger.getLogger(PullApplicationMenu.class);

		public PullApplicationService pullApplicationService;
		
		public PullApplicationMenu() {
			pullApplicationService = new PullApplicationService();
			
		}
	
	
	
	@Override
	public void display() {
		int choice = 0;
		
		do {
			log.trace("Pull All Applications");
			log.trace("======================");
			log.trace("1.) Back");
			log.trace("2.) Pull all Applications");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
		
			switch (choice) {
			case 1:
				break;
			case 2:
				
				try {
					pullApplicationService.getApplications();
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