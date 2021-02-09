package com.brockton.ui;

import org.apache.log4j.Logger;

public class MainMenu implements Menu {
	private static Logger log=Logger.getLogger(MainMenu.class);
	
	public MainMenu() {
		super();
	}

	@Override
	public void display() {
		System.out.println("Welcome to the Bank of Brockton!");
		System.out.println("====================================");
		
		int choice = 0;
		do {
			System.out.println("MAIN MENU");
			System.out.println("==========");
			System.out.println("1.) Exit Application");
			System.out.println("2.) Create Customer UN and PW");
			System.out.println("3.) Create Employee UN and PW");
			System.out.println("4.) Employee Login");
			System.out.println("5.) Customer Login");
			System.out.println("Enter a choice between 1 and 5");
			
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
				System.out.println("Not valid, choose again");
		}
			
		} while (choice != 1);
		
		sc.close();
	}
	
	
	

}
