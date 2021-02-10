package com.brockton.ui;

import org.apache.log4j.Logger;

public class MainMenu implements Menu {
	private static Logger log=Logger.getLogger(MainMenu.class);
	
	public MainMenu() {
		super();
	}

	@Override
	public void display() {
		log.trace("Welcome to the Bank of Brockton!");
		log.trace("====================================");
		
		int choice = 0;
		do {
			log.trace("MAIN MENU");
			log.trace("==========");
			log.trace("1.) Exit Application");
			log.trace("2.) Create Customer UN and PW");
			log.trace("3.) Create Employee UN and PW");
			log.trace("4.) Employee Login");
			log.trace("5.) Customer Login");
			log.trace("Enter a choice between 1 and 5");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				Menu customerMenu = new CustomerMenu();
				customerMenu.display();
				break;
			case 3:
				Menu employeeMenu = new EmployeeMenu();
				employeeMenu.display();
				break;
			case 4:
				Menu employeeLoginMenu= new EmployeeLoginMenu();
				employeeLoginMenu.display();
				break;
			case 5:
				Menu customerLoginMenu = new CustLoginMenu();
				customerLoginMenu.display();
			default:
				log.trace("Not valid, choose again");
		}
			
		} while (choice != 1);
		
		sc.close();
	}
	
	
	

}
