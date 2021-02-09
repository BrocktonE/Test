package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.model.Application;
import com.brockton.services.ApplicationService;

public class ApplicationMenu implements Menu {
	private static Logger log=Logger.getLogger(ApplicationMenu.class);
	
		public ApplicationService applicationService;
		
		public ApplicationMenu() {
			applicationService = new ApplicationService();
	}

	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Please fill out the Application Below:");
			System.out.println("======================================");
			System.out.println("1.) Back");
			System.out.println("2.) Complete Application");
			System.out.println("Please fill in all neccessary information in Application");
	
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
	
			switch (choice) {
			case 1:
				break;
			case 2:
				String userName = getcreateuserNameInput();
				String firstName = getcreatefirstNameInput();
				String lastName = getcreatelastNameInput();
				String accountType = getcreateAccountTypeInput();
				int initialDeposit = getInitialDepositInput();
				
				Application newApplication = new Application(userName, firstName, lastName, accountType, initialDeposit);
				applicationService.createApplication(newApplication);
				break;
				
			default:
				System.out.println("Choose Again");
			}
			
		} while (choice !=1);
		
	}
	
	public String getcreateuserNameInput() {
		String userName;
		while(true) {
			System.out.println("Enter your User Name: ");
			userName = sc.nextLine();
			return userName;		
		}
	}	
	
	public String getcreatefirstNameInput() {
			String firstName;
			while(true) {
				
				System.out.println("Enter your FirstName: ");
				firstName = sc.nextLine();
				return firstName;
			}		
		}
		
	public String getcreatelastNameInput() {
		String lastName;
		while(true) {
			
			System.out.println("Enter your LastName: ");
			lastName = sc.nextLine();
			return lastName;
		}
	}
	
	public String getcreateAccountTypeInput() {
		String accountType;
		while(true) {
			
			System.out.println("Enter your desired Account Type");
			accountType = Menu.sc.nextLine();
			return accountType;
		}
		
	}
	
	public int getInitialDepositInput() {
		int initialDeposit;
		while (true) {
				try {
					System.out.println("Enter an Initial Deposit Amount: ");
					initialDeposit = Integer.parseInt(Menu.sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid input, try again.");
					continue;
				}
				
				return initialDeposit;
			}
			
		}
	
	}
	

		

			