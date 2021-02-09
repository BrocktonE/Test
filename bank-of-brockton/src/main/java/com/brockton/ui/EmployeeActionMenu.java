package com.brockton.ui;

import org.apache.log4j.Logger;



public class EmployeeActionMenu implements Menu {
	private static Logger log=Logger.getLogger(EmployeeActionMenu.class);


	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Account Menu");
			System.out.println("=============");
			System.out.println("1.) Back");
			System.out.println("2.) Pull Applications");
			System.out.println("3.) Approve/Reject Customer Application");
			System.out.println("4.) View Customer Account");
			System.out.println("5.) Create Customer Account");
			System.out.println("6.) View All Transactions");
			
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
				System.out.println("Choice 5");
				break;
			case 6:
				Menu viewTransactionsMenu = new ViewTransactionsMenu();
				viewTransactionsMenu.display();
				break;
			default:
				System.out.println("Choose Again");
				break;				
			}
					
		} while (choice !=1);
		
	}


}
