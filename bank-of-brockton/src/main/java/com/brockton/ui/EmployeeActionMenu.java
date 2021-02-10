package com.brockton.ui;

import org.apache.log4j.Logger;



public class EmployeeActionMenu implements Menu {
	private static Logger log=Logger.getLogger(EmployeeActionMenu.class);


	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Account Menu");
			log.trace("=============");
			log.trace("1.) Back");
			log.trace("2.) Pull Applications");
			log.trace("3.) Approve/Reject Customer Application");
			log.trace("4.) View Customer Account");
			log.trace("5.) Create Customer Account");
			log.trace("6.) View All Transactions");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				Menu pullApplicationMenu = new PullApplicationMenu();
				pullApplicationMenu.display();
				break;
			case 3:
				Menu ApproveMenu = new ApproveMenu();
				ApproveMenu.display();
				break;
			case 4:
				Menu ViewMenu = new ViewMenu();
				ViewMenu.display();
				
				break;
			case 5:
				log.trace("Choice 5");
				break;
			case 6:
				Menu viewTransactionsMenu = new ViewTransactionsMenu();
				viewTransactionsMenu.display();
				break;
			default:
				log.trace("Choose Again");
				break;				
			}
					
		} while (choice !=1);
		
	}


}
