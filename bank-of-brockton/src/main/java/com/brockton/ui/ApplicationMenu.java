package com.brockton.ui;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.DatabaseConnectionException;
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
			log.trace("Please fill out the Application Below:");
			log.trace("======================================");
			log.trace("1.) Back");
			log.trace("2.) Complete Application");
			log.trace("Please fill in all neccessary information in Application");
	
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
				try {
					applicationService.createApplication(newApplication);
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (DatabaseConnectionException e) {
			
					e.printStackTrace();
				}
				System.out.println(newApplication);
				break;
				
			default:
				log.trace("Choose Again");
			}
			
		} while (choice !=1);
		
	}
	
	public String getcreateuserNameInput() {
		String userName;
		while(true) {
			log.trace("Enter your User Name: ");
			userName = sc.nextLine();
			return userName;		
		}
	}	
	
	public String getcreatefirstNameInput() {
			String firstName;
			while(true) {
				
				log.trace("Enter your FirstName: ");
				firstName = sc.nextLine();
				return firstName;
			}		
		}
		
	public String getcreatelastNameInput() {
		String lastName;
		while(true) {
			
			log.trace("Enter your LastName: ");
			lastName = sc.nextLine();
			return lastName;
		}
	}
	
	public String getcreateAccountTypeInput() {
		String accountType;
		while(true) {
			
			log.trace("Enter your desired Account Type");
			accountType = Menu.sc.nextLine();
			return accountType;
		}
		
	}
	
	public int getInitialDepositInput() {
		int initialDeposit;
		while (true) {
				try {
					log.trace("Enter an Initial Deposit Amount: ");
					initialDeposit = Integer.parseInt(Menu.sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid input, try again.");
					continue;
				}
				
				return initialDeposit;
			}
			
		}
	
	}
	

		

			